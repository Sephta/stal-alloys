package net.stal.alloys.compat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.recipe.RecipeEntry;
import net.stal.alloys.recipe.AlloySmelterRecipe;

public class AlloySmelterDisplay extends BasicDisplay {

  public AlloySmelterDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
    super(inputs, outputs);
  }

  public AlloySmelterDisplay(RecipeEntry<AlloySmelterRecipe> recipe) {
    super(getInputList(recipe.value()), getOutputList(recipe.value()));
  }

  private static List<EntryIngredient> getInputList(AlloySmelterRecipe recipe) {
    if (recipe == null) return Collections.emptyList();

    List<EntryIngredient> ingredients = new ArrayList<>();
    ingredients.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
    ingredients.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(1)));

    return ingredients;
  }

  private static List<EntryIngredient> getOutputList(AlloySmelterRecipe recipe) {
    if (recipe == null) return Collections.emptyList();

    List<EntryIngredient> outputs = new ArrayList<>();
    outputs.add(EntryIngredients.of(recipe.getResult(null)));

    return outputs;
  }

  @Override
  public CategoryIdentifier<AlloySmelterDisplay> getCategoryIdentifier() {
    return AlloySmelterCategory.ALLOY_SMELTER;
  }
  
}
