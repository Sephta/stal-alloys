package net.stal.alloys.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.stal.alloys.block.StalAlloysBlocks;

public class StalAlloysBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public StalAlloysBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
      .add(
        StalAlloysBlocks.STEEL_BLOCK,
        StalAlloysBlocks.NICKEL_ORE,
        StalAlloysBlocks.DEEPSLATE_NICKEL_ORE,
        StalAlloysBlocks.NETHERRACK_NICKEL_ORE,
        StalAlloysBlocks.CHROMIUM_ORE,
        StalAlloysBlocks.DEEPSLATE_CHROMIUM_ORE,
        StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE,
        StalAlloysBlocks.ZINC_ORE,
        StalAlloysBlocks.DEEPSLATE_ZINC_ORE,
        StalAlloysBlocks.TIN_ORE,
        StalAlloysBlocks.DEEPSLATE_TIN_ORE,
        StalAlloysBlocks.CARBON_ORE,
        StalAlloysBlocks.DEEPSLATE_CARBON_ORE,
        StalAlloysBlocks.NICKEL_BLOCK,
        StalAlloysBlocks.CUT_NICKEL,
        StalAlloysBlocks.CUT_NICKEL_SLAB,
        StalAlloysBlocks.CUT_NICKEL_STAIRS,
        StalAlloysBlocks.ZINC_BLOCK,
        StalAlloysBlocks.CHROMIUM_BLOCK,
        StalAlloysBlocks.ALLOY_SMELTER
      );

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
      .add(
        StalAlloysBlocks.STEEL_BLOCK,
        StalAlloysBlocks.NICKEL_ORE,
        StalAlloysBlocks.DEEPSLATE_NICKEL_ORE,
        StalAlloysBlocks.NETHERRACK_NICKEL_ORE,
        StalAlloysBlocks.CHROMIUM_ORE,
        StalAlloysBlocks.DEEPSLATE_CHROMIUM_ORE,
        StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE,
        StalAlloysBlocks.ZINC_ORE,
        StalAlloysBlocks.DEEPSLATE_ZINC_ORE,
        StalAlloysBlocks.TIN_ORE,
        StalAlloysBlocks.DEEPSLATE_TIN_ORE,
        StalAlloysBlocks.CARBON_ORE,
        StalAlloysBlocks.DEEPSLATE_CARBON_ORE,
        StalAlloysBlocks.NICKEL_BLOCK,
        StalAlloysBlocks.CUT_NICKEL,
        StalAlloysBlocks.CUT_NICKEL_SLAB,
        StalAlloysBlocks.CUT_NICKEL_STAIRS,
        StalAlloysBlocks.ZINC_BLOCK,
        StalAlloysBlocks.CHROMIUM_BLOCK
      );

    getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
      .add(
        StalAlloysBlocks.ALLOY_SMELTER
      );
  }
  
}
