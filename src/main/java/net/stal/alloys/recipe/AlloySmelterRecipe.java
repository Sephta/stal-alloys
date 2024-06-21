package net.stal.alloys.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.recipe.*;
import net.minecraft.world.World;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;

import java.util.List;

public class AlloySmelterRecipe implements Recipe<SimpleInventory> {

  private final ItemStack mOutput;
  private final int mCookingTime;
  private final int mExperience;
  private final List<Ingredient> mRecipeItems;

  private enum AlloySmelterRecipeAttributes {
    INGREDIENTS("ingredients"),
    COOKINGTIME("cookingtime"),
    EXPERIENCE("experience"),
    RESULT("result");

    private String value;
    private AlloySmelterRecipeAttributes(String value) {
      this.value = value;
    }
  }

  private static final int mNumberOfInputs = 2;
  // private static final int mNumberOfOutputs = 1;

  public AlloySmelterRecipe(ItemStack output, List<Ingredient> recipeItems, int cookingtime, int experience) {
    mOutput = output;
    mRecipeItems = recipeItems;
    mCookingTime = cookingtime;
    mExperience = experience;
  }

  @Override
  public boolean matches(SimpleInventory inventory, World world) {
    if (world.isClient()) return false;

    boolean matchA = mRecipeItems.get(0).test(inventory.getStack(0 /* 0 is the first slot */)) && 
                     mRecipeItems.get(1).test(inventory.getStack(1 /* 1 is the second slot */));

    // This is here because the inputs are slot agnostic
    boolean matchB = mRecipeItems.get(1).test(inventory.getStack(0 /* 0 is the first slot */)) && 
                     mRecipeItems.get(0).test(inventory.getStack(1 /* 1 is the second slot */));

    return matchA || matchB;
  }

  @Override
  public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager dynamicRegistryManager) {
    return mOutput;
  }

  @Override
  public boolean fits(int width, int height) {
    return true;
  }

  @Override
  public ItemStack getResult(DynamicRegistryManager dynamicRegistryManager) {
    return mOutput.copy();
  }

  public int getCookingTime() {
    return mCookingTime;
  }

  public int getExperience() {
    return mExperience;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return Serializer.INSTANCE;
  }

  @Override
  public RecipeType<?> getType() {
    return Type.INSTANCE;
  }

  public static class Type implements RecipeType<AlloySmelterRecipe> {
    private Type() { }
    public static final Type INSTANCE = new Type();
    public static final String ID = "alloy_smelter";
  }

  public static class Serializer implements RecipeSerializer<AlloySmelterRecipe> {
    public static final Serializer INSTANCE = new Serializer();
    public static final String ID = "alloy_smelter"; // name given in the json file

    public static final Codec<AlloySmelterRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
      ItemStack.RECIPE_RESULT_CODEC.fieldOf(AlloySmelterRecipeAttributes.RESULT.value).forGetter(r -> r.mOutput),
      validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, mNumberOfInputs).fieldOf(AlloySmelterRecipeAttributes.INGREDIENTS.value).forGetter(AlloySmelterRecipe::getIngredients),
      Codecs.NONNEGATIVE_INT.fieldOf(AlloySmelterRecipeAttributes.COOKINGTIME.value).forGetter(AlloySmelterRecipe::getCookingTime),
      Codecs.NONNEGATIVE_INT.fieldOf(AlloySmelterRecipeAttributes.EXPERIENCE.value).forGetter(AlloySmelterRecipe::getExperience)
    ).apply(in, AlloySmelterRecipe::new));

    private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
      return Codecs.validate(Codecs.validate(
              delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
      ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
    }

    @Override
    public AlloySmelterRecipe read(PacketByteBuf buf) {
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
      int cookingtime = buf.readInt();
      int experience = buf.readInt();

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.fromPacket(buf));
      }

      return new AlloySmelterRecipe(/* output --> */ buf.readItemStack(), inputs, cookingtime, experience);
    }

    @Override
    public void write(PacketByteBuf buf, AlloySmelterRecipe recipe) {
      buf.writeInt(recipe.getIngredients().size());

      for (Ingredient ingredient : recipe.getIngredients()) {
        ingredient.write(buf);
      }

      buf.writeItemStack(recipe.getResult(null));

      buf.writeInt(recipe.getCookingTime());
      buf.writeInt(recipe.getExperience());
    }

    @Override
    public Codec<AlloySmelterRecipe> codec() {
      return CODEC;
    }
  }
}
