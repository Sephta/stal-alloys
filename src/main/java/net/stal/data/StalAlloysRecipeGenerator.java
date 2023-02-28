package net.stal.data;

import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.stal.StalAlloys;
import net.stal.block.StalAlloysBlocks;
import net.stal.item.StalAlloysItems;

public class StalAlloysRecipeGenerator extends FabricRecipeProvider {
  public StalAlloysRecipeGenerator(FabricDataOutput output) {
		super(output);
	}

  @Override
  public void generate(Consumer<RecipeJsonProvider> exporter) {
    offerSmelting(
      exporter, 
      List.of(StalAlloysItems.RAW_STEEL), 
      RecipeCategory.MISC, 
      StalAlloysItems.STEEL_INGOT,
      0.7F,
      200,
      StalAlloys.MOD_ID
    );

    offerBlasting(
      exporter, 
      List.of(StalAlloysItems.RAW_STEEL), 
      RecipeCategory.MISC, 
      StalAlloysItems.STEEL_INGOT, 
      0.7F, 
      100, 
      StalAlloys.MOD_ID
    );

    offerReversibleCompactingRecipes(
      exporter, 
      RecipeCategory.BUILDING_BLOCKS, 
      StalAlloysItems.STEEL_INGOT, 
      RecipeCategory.DECORATIONS, 
      StalAlloysBlocks.STEEL_BLOCK
    );
  }
}
