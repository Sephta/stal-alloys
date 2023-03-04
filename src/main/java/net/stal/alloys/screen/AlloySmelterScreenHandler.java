package net.stal.alloys.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.stal.alloys.block.entity.AlloySmelterEntity;

public class AlloySmelterScreenHandler extends ScreenHandler {

  private final Inventory mInventory;
  private final PropertyDelegate mPropertyDelegate;

  public AlloySmelterScreenHandler(int syncId, PlayerInventory playerInventory) {
    this(
      syncId, 
      playerInventory, 
      new SimpleInventory(AlloySmelterEntity.mAlloySmelterInventorySize), 
      new ArrayPropertyDelegate(2)
    );
  }

  public AlloySmelterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
    super(StalAlloysScreenHandlers.ALLOY_SMELTER_SCREEN_HANDLER, syncId);

    checkSize(inventory, AlloySmelterEntity.mAlloySmelterInventorySize);
    this.mInventory = inventory;
    inventory.onOpen(playerInventory.player);
    this.mPropertyDelegate = delegate;

    // Add Custom Alloy Smelter Slots
    addSlot(new Slot(inventory, 0, 39, 19));
    addSlot(new Slot(inventory, 1, 39, 48));
    addSlot(new Slot(inventory, 2, 121, 35));

    addPlayerInventory(playerInventory);
    addPlayerHotBar(playerInventory);
    addProperties(delegate);
  }

  @Override
  public ItemStack transferSlot(PlayerEntity player, int inventorySlot) {
    ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(inventorySlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (inventorySlot < this.mInventory.size()) {
                if (!this.insertItem(originalStack, this.mInventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.mInventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
  }

  @Override
  public boolean canUse(PlayerEntity player) {
    return this.mInventory.canPlayerUse(player);
  }

  public boolean isCrafting() {
    return mPropertyDelegate.get(0) > 0;
  }

  /**
   * @return the scaled width of the progress bar based on how much "progress" the alloy smelter has made thus far.
   */
  public int getScaledProgress() {
    int result = 0;
    int currentProgress = mPropertyDelegate.get(0);
    int maxProgress = mPropertyDelegate.get(1);

    // As long as the current and max progress are non-zero scale the
    // progress bar texture according to how much progress was made
    if (maxProgress != 0 && currentProgress != 0) {
      result = currentProgress * AlloySmelterEntity.mAlloySmelterProgressBarWidth / maxProgress;
    }

    return  result;
  }

  private void addPlayerInventory(PlayerInventory playerInventory) {
    final int topLeftCornerOfInventory_Y = 84;
    final int slotCellSize = 18;

    final int inventoryRowCount = 3;
    final int inventoryColCount = 9;

    for (int i = 0; i < inventoryRowCount; ++i) {
      for (int l = 0; l < inventoryColCount; ++l) {
          this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * slotCellSize, topLeftCornerOfInventory_Y + i * slotCellSize));
      }
    }
  }

  private void addPlayerHotBar(PlayerInventory playerInventory) {
    final int topLeftCornerOfHotBar_Y = 142;
    final int slotCellSize = 18;

    final int hotBarColCount = 9;

    for (int i = 0; i < hotBarColCount; ++i) {
      this.addSlot(new Slot(playerInventory, i, 8 + i * slotCellSize, topLeftCornerOfHotBar_Y));
    }
  }
}
