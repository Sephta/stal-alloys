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
  private final DefaultedList<Ingredient> mRecipeItems;

  public AlloySmelterRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
    mID = id;
    mOutput = output;
    mRecipeItems = recipeItems;
  }

  @Override
  public boolean matches(SimpleInventory inventory, World world) {
    if (world.isClient()) return false;

    return mRecipeItems.get(0).test(inventory.getStack(0 /* 0 is the first slot */));
  }

  @Override
  public ItemStack craft(SimpleInventory var1) {
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
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);
      ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
      JsonArray ingredients = JsonHelper.getArray(json, "ingredients");

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
      }

      return new AlloySmelterRecipe(id, output, inputs);
    }

    @Override
    public AlloySmelterRecipe read(Identifier id, PacketByteBuf buf) {
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.fromPacket(buf));
      }

      return new AlloySmelterRecipe(id, /* output --> */ buf.readItemStack(), inputs);
    }

    @Override
    public void write(PacketByteBuf buf, AlloySmelterRecipe recipe) {
      buf.writeInt(recipe.getIngredients().size());

      for (Ingredient ingredient : recipe.getIngredients()) {
        ingredient.write(buf);
      }

      buf.writeItemStack(recipe.getOutput());
    }

    
  }
}
