package net.stal.alloys.block.entity;

import java.util.Collection;
import java.util.Optional;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stal.alloys.screen.AlloySmelterScreenHandler;
import net.stal.alloys.recipe.*;

public class AlloySmelterEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
  public static final int mAlloySmelterProgressBarWidth = 44;
  public static final int mAlloySmelterProgressBarHeight = 17;
  public static final int mAlloySmelterInventorySize = 3;

  private final DefaultedList<ItemStack> mInventory = DefaultedList.ofSize(mAlloySmelterInventorySize, ItemStack.EMPTY);

  protected final PropertyDelegate mPropertyDelegate;
  private int mProgress = 0;
  private int mMaxProgress = 200; // Number of ticks it takes to smelt
  // private int mFuelTime = 0;
  // private int mMaxFuelTime = 0;

  public static enum AlloySmelterInventorySlots {
    FIRST(0),
    SECOND(1),
    THIRD(2);

    private final int value;
    private AlloySmelterInventorySlots(int value) {
      this.value = value;
    }
  }

  public AlloySmelterEntity(BlockPos pos, BlockState state) {
    super(StalAlloysBlockEntities.ALLOY_SMELTER_ENTITY, pos, state);

    mPropertyDelegate = new PropertyDelegate() {
      public int get(int index) {
        switch (index) {
          case 0: return AlloySmelterEntity.this.mProgress;
          case 1: return AlloySmelterEntity.this.mMaxProgress;
          default: return 0;
        }
      }

      public void set(int index, int value) {
        switch (index) {
          case 0: AlloySmelterEntity.this.mProgress = value; break;
          case 1: AlloySmelterEntity.this.mMaxProgress = value; break;
        }
      }

      public int size() {
        return 2;
      }
    };
  }

  private void resetProgress() {
    mProgress = 0;
  }

  @Override
  public DefaultedList<ItemStack> getItems() {
    return mInventory;
  }

  @Override
  public Text getDisplayName() {
    return Text.translatable("alloy_smelter");
  }

  @Override
  public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new AlloySmelterScreenHandler(syncId, playerInventory, this, mPropertyDelegate);
  }

  @Override
  protected void writeNbt(NbtCompound nbt) {
    super.writeNbt(nbt);
    
    Inventories.writeNbt(nbt, mInventory);

    nbt.putInt("alloy_smelter.progress", mProgress);
  }

  @Override
  public void readNbt(NbtCompound nbt) {
    super.readNbt(nbt);

    Inventories.readNbt(nbt, mInventory);

    mProgress = nbt.getInt("alloy_smelter.progress");
  }

  public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, AlloySmelterEntity entity) {
    if (world.isClient()) return;

    if (hasRecipe(entity)) {
      entity.mProgress++;
      markDirty(world, blockPos, blockState);

      if (entity.mProgress >= entity.mMaxProgress) {
        craftItem(entity);
      }
    } else {
      entity.resetProgress();
      markDirty(world, blockPos, blockState);
    }
  }

  private static boolean hasRecipe(AlloySmelterEntity entity) {
    SimpleInventory inventory = new SimpleInventory(entity.size());

    for (int i = 0; i < entity.size(); i++) {
      inventory.setStack(i, entity.getStack(i));
    }
    
    Optional<AlloySmelterRecipe> recipeFromInventory = entity.getWorld()
                                                .getRecipeManager()
                                                .getFirstMatch(AlloySmelterRecipe.Type.INSTANCE, inventory, entity.getWorld());
    
    if (recipeFromInventory.isPresent()) {
      entity.mMaxProgress = recipeFromInventory.get().getCookingTime();
    }

    return recipeFromInventory.isPresent() && 
           canInsertAmountIntoOutputSlot(inventory) && 
           canInsertItemIntoOutputSlot(inventory, recipeFromInventory.get().getOutput().getItem());
  }

  private static void craftItem(AlloySmelterEntity entity) {
    SimpleInventory inventory = new SimpleInventory(entity.size());

    for (int i = 0; i < entity.size(); i++) {
      inventory.setStack(i, entity.getStack(i));
    }

    Optional<AlloySmelterRecipe> recipeFromInventory = entity.getWorld()
                                                .getRecipeManager()
                                                .getFirstMatch(AlloySmelterRecipe.Type.INSTANCE, inventory, entity.getWorld());

    if (hasRecipe(entity)) {
      entity.removeStack(AlloySmelterInventorySlots.FIRST.value, 1);
      entity.removeStack(AlloySmelterInventorySlots.SECOND.value, 1);

      entity.setStack(
        AlloySmelterInventorySlots.THIRD.value, 
        new ItemStack(
          recipeFromInventory.get().getOutput().getItem(), 
          entity.getStack(AlloySmelterInventorySlots.THIRD.value).getCount() + 1
        )
      );

      entity.resetProgress();
    }
  }

  private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
    return inventory.getStack(AlloySmelterInventorySlots.THIRD.value).getItem() == output || 
           inventory.getStack(AlloySmelterInventorySlots.THIRD.value).isEmpty();
  }

  private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
    return inventory.getStack(AlloySmelterInventorySlots.THIRD.value).getMaxCount() > 
           (inventory.getStack(AlloySmelterInventorySlots.THIRD.value).getCount());
  }

}
