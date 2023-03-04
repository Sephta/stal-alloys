package net.stal.alloys.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class AlloySmelterRecipe implements Recipe<SimpleInventory> {

  private final Identifier mID;
  private final ItemStack mOutput;
  private final int mCookingTime;
  private final int mExperience;
  private final DefaultedList<Ingredient> mRecipeItems;

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
  private static final int mNumberOfOutputs = 1;

  public AlloySmelterRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems, int cookingtime, int experience) {
    mID = id;
    mOutput = output;
    mRecipeItems = recipeItems;
    mCookingTime = cookingtime;
    mExperience = experience;
  }

  @Override
  public boolean matches(SimpleInventory inventory, World world) {
    if (world.isClient()) return false;

    return mRecipeItems.get(0).test(inventory.getStack(0 /* 0 is the first slot */)) && 
           mRecipeItems.get(1).test(inventory.getStack(1 /* 1 is the second slot */));
  }

  @Override
  public ItemStack craft(SimpleInventory inventory) {
    return mOutput;
  }

  @Override
  public boolean fits(int width, int height) {
    return true;
  }

  @Override
  public ItemStack getOutput() {
    return mOutput.copy();
  }

  public int getCookingTime() {
    return mCookingTime;
  }

  public int getExperience() {
    return mExperience;
  }

  @Override
  public Identifier getId() {
    return mID;
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

    @Override
    public AlloySmelterRecipe read(Identifier id, JsonObject json) {
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(mNumberOfInputs, Ingredient.EMPTY);
      ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, AlloySmelterRecipeAttributes.RESULT.value));
      JsonArray ingredients = JsonHelper.getArray(json, AlloySmelterRecipeAttributes.INGREDIENTS.value);
      int cookingtime = JsonHelper.getInt(json, AlloySmelterRecipeAttributes.COOKINGTIME.value);
      int experience = JsonHelper.getInt(json, AlloySmelterRecipeAttributes.EXPERIENCE.value);

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
      }

      return new AlloySmelterRecipe(id, output, inputs, cookingtime, experience);
    }

    @Override
    public AlloySmelterRecipe read(Identifier id, PacketByteBuf buf) {
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
      int cookingtime = buf.readInt();
      int experience = buf.readInt();

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.fromPacket(buf));
      }

      return new AlloySmelterRecipe(id, /* output --> */ buf.readItemStack(), inputs, cookingtime, experience);
    }

    @Override
    public void write(PacketByteBuf buf, AlloySmelterRecipe recipe) {
      buf.writeInt(recipe.getIngredients().size());

      for (Ingredient ingredient : recipe.getIngredients()) {
        ingredient.write(buf);
      }

      buf.writeItemStack(recipe.getOutput());

      buf.writeInt(recipe.getCookingTime());
      buf.writeInt(recipe.getExperience());
    }

    
  }
}
