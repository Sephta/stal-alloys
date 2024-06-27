package net.stal.alloys.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.recipe.RecipeSerializer;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.recipe.*;
import net.minecraft.world.World;
import net.minecraft.util.collection.DefaultedList;

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

  public AlloySmelterRecipe( int cookingtime, int experience, List<Ingredient> recipeItems, ItemStack output) {
    mCookingTime = cookingtime;
    mExperience = experience;
    mRecipeItems = recipeItems;
    mOutput = output;
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
  public ItemStack craft(SimpleInventory inventory, WrapperLookup lookup) {
    return mOutput;
  }

  @Override
  public boolean fits(int width, int height) {
    return true;
  }

  @Override
  public DefaultedList<Ingredient> getIngredients() {
    DefaultedList<Ingredient> list = DefaultedList.ofSize(this.mRecipeItems.size());
    list.addAll(mRecipeItems);
    return list;
  }

  @Override
  public ItemStack getResult(WrapperLookup registriesLookup) {
    return mOutput.copy();
  }

  public int getCookingTime() {
    return mCookingTime;
  }

  public int getExperience() {
    return mExperience;
  }

  @Override
  public RecipeSerializer<AlloySmelterRecipe> getSerializer() {
    return AlloySmelterRecipeSerializer.INSTANCE;
  }

  @Override
  public RecipeType<AlloySmelterRecipe> getType() {
    return AlloySmelterRecipeType.INSTANCE;
  }

  public static class AlloySmelterRecipeType implements RecipeType<AlloySmelterRecipe> {
    private AlloySmelterRecipeType() {}
    public static final AlloySmelterRecipeType INSTANCE = new AlloySmelterRecipeType();
    public static final String ID = "alloy_smelter";
  }

  public static class AlloySmelterRecipeSerializer implements RecipeSerializer<AlloySmelterRecipe> {
    public AlloySmelterRecipeSerializer() {}
    public static final AlloySmelterRecipeSerializer INSTANCE = new AlloySmelterRecipeSerializer();
    public static final String ID = "alloy_smelter"; // name given in the json file

    public static final MapCodec<AlloySmelterRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
      Codec.INT.fieldOf(AlloySmelterRecipeAttributes.COOKINGTIME.value).forGetter(AlloySmelterRecipe::getCookingTime), // Cooking Time
      Codec.INT.fieldOf(AlloySmelterRecipeAttributes.EXPERIENCE.value).forGetter(AlloySmelterRecipe::getExperience), // Experience
      validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, mNumberOfInputs)
        .fieldOf(AlloySmelterRecipeAttributes.INGREDIENTS.value)
        .forGetter(AlloySmelterRecipe::getIngredients), // Ingrediants
      ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf(AlloySmelterRecipeAttributes.RESULT.value).forGetter(r -> r.mOutput) // Result (output)
      ).apply(instance, AlloySmelterRecipe::new));

    public static final PacketCodec<RegistryByteBuf, AlloySmelterRecipe> PACKET_CODEC = 
      PacketCodec.ofStatic(AlloySmelterRecipeSerializer::write, AlloySmelterRecipeSerializer::read);

    private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
      Codec<List<Ingredient>> validatedResult = Ingredient.DISALLOW_EMPTY_CODEC.listOf().flatXmap(
        (ingredients) -> {
          Ingredient[] copyOfIngredients = (Ingredient[])ingredients.stream().filter(ingredient -> {
            return !ingredient.isEmpty();
          }).toArray((i) -> {
            return new Ingredient[i];
          });
          
          if (copyOfIngredients.length == 0) {
            return DataResult.error(() -> {
                return "No ingredients for shapeless recipe";
            });
          } else {
            return copyOfIngredients.length > max ? DataResult.error(() -> {
                return "Too many ingredients for shapeless recipe";
            }) : DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, copyOfIngredients));
          }
        }, 
        DataResult::success
      );

      return validatedResult;
    }

    @Override
    public MapCodec<AlloySmelterRecipe> codec() {
      return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, AlloySmelterRecipe> packetCodec() {
      return PACKET_CODEC;
    }

    private static AlloySmelterRecipe read(RegistryByteBuf buf) {
      int cookingtime = buf.readInt();
      int experience = buf.readInt();
      DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

      for (int i = 0; i < inputs.size(); i++) {
        inputs.set(i, Ingredient.PACKET_CODEC.decode(buf));
      }

      return new AlloySmelterRecipe(cookingtime, experience, inputs, /* output --> */ ItemStack.PACKET_CODEC.decode(buf));
    }

    private static void write(RegistryByteBuf buf, AlloySmelterRecipe recipe) {
      buf.writeInt(recipe.getCookingTime());
      buf.writeInt(recipe.getExperience());
      buf.writeInt(recipe.getIngredients().size());

      for (Ingredient ingredient : recipe.getIngredients()) {
        Ingredient.PACKET_CODEC.encode(buf, ingredient);
      }

      ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
    }
  }
}
