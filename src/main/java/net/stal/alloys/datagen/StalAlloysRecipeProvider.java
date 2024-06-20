package net.stal.alloys.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;
import net.stal.alloys.item.StalAlloysItems;

public class StalAlloysRecipeProvider extends FabricRecipeProvider{

  public static final List<ItemConvertible> CHROMIUM_SMELTABLES = List.of(StalAlloysItems.RAW_CHROMIUM, StalAlloysBlocks.CHROMIUM_ORE, StalAlloysBlocks.DEEPSLATE_CHROMIUM_ORE, StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE);
  public static final List<ItemConvertible> NICKEL_SMELTABLES = List.of(StalAlloysItems.RAW_NICKEL, StalAlloysBlocks.NICKEL_ORE, StalAlloysBlocks.DEEPSLATE_NICKEL_ORE, StalAlloysBlocks.NETHERRACK_NICKEL_ORE);
  public static final List<ItemConvertible> TIN_SMELTABLES = List.of(StalAlloysItems.RAW_TIN, StalAlloysBlocks.TIN_ORE, StalAlloysBlocks.DEEPSLATE_TIN_ORE);
  public static final List<ItemConvertible> ZINC_SMELTABLES = List.of(StalAlloysItems.RAW_ZINC, StalAlloysBlocks.ZINC_ORE, StalAlloysBlocks.DEEPSLATE_ZINC_ORE);

  public StalAlloysRecipeProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generate(Consumer<RecipeJsonProvider> exporter) {
    // Smelting recipes
    offerSmelting(exporter, CHROMIUM_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.CHROMIUM_INGOT, 1.0F, 360, "chromium_ingot");
    offerSmelting(exporter, NICKEL_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.NICKEL_INGOT, 1.0F, 200, "nickel_ingot");
    offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.TIN_INGOT, 1.0F, 140, "tin_ingot");
    offerSmelting(exporter, ZINC_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.ZINC_INGOT, 1.0F, 180, "zinc_ingot");

    // Blasting recipes
    offerBlasting(exporter, CHROMIUM_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.CHROMIUM_INGOT, 1.0F, 200, "chromium_ingot");
    offerBlasting(exporter, NICKEL_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.NICKEL_INGOT, 1.0F, 160, "nickel_ingot");
    offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.TIN_INGOT, 1.0F, 100, "tin_ingot");
    offerBlasting(exporter, ZINC_SMELTABLES, RecipeCategory.MISC, StalAlloysItems.ZINC_INGOT, 1.0F, 100, "zinc_ingot");

    // Reversible Block to Ingot conversion recipes
    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, StalAlloysItems.CHROMIUM_INGOT, RecipeCategory.DECORATIONS, StalAlloysBlocks.CHROMIUM_BLOCK);
    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, StalAlloysItems.NICKEL_INGOT, RecipeCategory.DECORATIONS, StalAlloysBlocks.NICKEL_BLOCK);
    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, StalAlloysItems.ZINC_INGOT, RecipeCategory.DECORATIONS, StalAlloysBlocks.ZINC_BLOCK);
    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, StalAlloysItems.STEEL_INGOT, RecipeCategory.DECORATIONS, StalAlloysBlocks.STEEL_BLOCK);

    // Stone cutting recipes
    offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, StalAlloysBlocks.CUT_NICKEL, StalAlloysBlocks.NICKEL_BLOCK, 4);
    offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, StalAlloysBlocks.CUT_NICKEL_SLAB, StalAlloysBlocks.NICKEL_BLOCK, 8);
    offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, StalAlloysBlocks.CUT_NICKEL_STAIRS, StalAlloysBlocks.NICKEL_BLOCK, 4);

    // Shaped and Shapeless recipes
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, StalAlloysBlocks.ALLOY_SMELTER, 1)
      .pattern("###")
      .pattern("#F#")
      .pattern("CCC")
      .input('#', Items.DEEPSLATE_TILES)
      .input('F', Items.FURNACE)
      .input('C', Items.COBBLED_DEEPSLATE)
      .criterion(hasItem(Items.DEEPSLATE), conditionsFromItem(Items.DEEPSLATE))
      .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "alloy_smelter"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRASS_BOOTS, 1)
      .pattern("# #")
      .pattern("# #")
      .pattern("   ")
      .input('#', StalAlloysItems.BRASS_INGOT)
      .criterion(hasItem(StalAlloysItems.BRASS_INGOT), conditionsFromItem(StalAlloysItems.BRASS_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "brass_boots"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRASS_CHESTPLATE, 1)
      .pattern("# #")
      .pattern("###")
      .pattern("###")
      .input('#', StalAlloysItems.BRASS_INGOT)
      .criterion(hasItem(StalAlloysItems.BRASS_INGOT), conditionsFromItem(StalAlloysItems.BRASS_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "brass_chestplate"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRASS_HELMET, 1)
      .pattern("###")
      .pattern("# #")
      .pattern("   ")
      .input('#', StalAlloysItems.BRASS_INGOT)
      .criterion(hasItem(StalAlloysItems.BRASS_INGOT), conditionsFromItem(StalAlloysItems.BRASS_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "brass_helmet"));
  
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRASS_LEGGINGS, 1)
      .pattern("###")
      .pattern("# #")
      .pattern("# #")
      .input('#', StalAlloysItems.BRASS_INGOT)
      .criterion(hasItem(StalAlloysItems.BRASS_INGOT), conditionsFromItem(StalAlloysItems.BRASS_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "brass_leggings"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.BRONZE_AXE, 1)
      .pattern("## ")
      .pattern("#S ")
      .pattern(" S ")
      .input('#', StalAlloysItems.BRONZE_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.BRONZE_INGOT), conditionsFromItem(StalAlloysItems.BRONZE_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "bronze_axe"));
    
    ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRONZE_DAGGER, 1)
      .input(StalAlloysItems.BRONZE_INGOT, 1)
      .input(Items.STICK, 1)
      .criterion(hasItem(StalAlloysItems.BRONZE_INGOT), conditionsFromItem(StalAlloysItems.BRONZE_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "bronze_dagger"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRONZE_DIRK, 1)
      .pattern("  #")
      .pattern(" # ")
      .pattern("S  ")
      .input('#', StalAlloysItems.BRONZE_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.BRONZE_INGOT), conditionsFromItem(StalAlloysItems.BRONZE_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "bronze_dirk"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.BRONZE_SWORD, 1)
      .pattern(" # ")
      .pattern(" # ")
      .pattern(" S ")
      .input('#', StalAlloysItems.BRONZE_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.BRONZE_INGOT), conditionsFromItem(StalAlloysItems.BRONZE_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "bronze_sword"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, StalAlloysItems.CARBON_PLATE, 1)
      .pattern("   ")
      .pattern("CCC")
      .pattern("CCC")
      .input('C', StalAlloysItems.RAW_CARBON)
      .criterion(hasItem(StalAlloysItems.RAW_CARBON), conditionsFromItem(StalAlloysItems.RAW_CARBON))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "carbon_plate"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.COPPER_AXE, 1)
      .pattern("## ")
      .pattern("#S ")
      .pattern(" S ")
      .input('#', Items.COPPER_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "copper_axe"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.COPPER_HOE, 1)
      .pattern("## ")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', Items.COPPER_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "copper_hoe"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.COPPER_PICKAXE, 1)
      .pattern("###")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', Items.COPPER_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "copper_pickaxe"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.COPPER_SHOVEL, 1)
      .pattern(" # ")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', Items.COPPER_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "copper_shovel"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, StalAlloysItems.COPPER_SWORD, 1)
      .pattern(" # ")
      .pattern(" # ")
      .pattern(" S ")
      .input('#', Items.COPPER_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "copper_sword"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.STEEL_AXE, 1)
      .pattern("## ")
      .pattern("#S ")
      .pattern(" S ")
      .input('#', StalAlloysItems.STEEL_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.STEEL_INGOT), conditionsFromItem(StalAlloysItems.STEEL_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "steel_axe"));

    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.STEEL_HOE, 1)
      .pattern("## ")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', StalAlloysItems.STEEL_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.STEEL_INGOT), conditionsFromItem(StalAlloysItems.STEEL_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "steel_hoe"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.STEEL_PICKAXE, 1)
      .pattern("###")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', StalAlloysItems.STEEL_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.STEEL_INGOT), conditionsFromItem(StalAlloysItems.STEEL_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "steel_pickaxe"));
    
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, StalAlloysItems.STEEL_SHOVEL, 1)
      .pattern(" # ")
      .pattern(" S ")
      .pattern(" S ")
      .input('#', StalAlloysItems.STEEL_INGOT)
      .input('S', Items.STICK)
      .criterion(hasItem(StalAlloysItems.STEEL_INGOT), conditionsFromItem(StalAlloysItems.STEEL_INGOT))
      .offerTo(exporter, new Identifier(StalAlloys.MOD_ID, "steel_shovel"));
  }
  
}
