package net.stal.alloys.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.stal.alloys.block.StalAlloysBlocks;
import net.stal.alloys.item.StalAlloysItems;

public class StalAlloysLootTableGenerator extends FabricBlockLootTableProvider {

  public StalAlloysLootTableGenerator(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    addDrop(StalAlloysBlocks.ALLOY_SMELTER, nameableContainerDrops(StalAlloysBlocks.ALLOY_SMELTER));

    addDrop(StalAlloysBlocks.NICKEL_BLOCK);
    addDrop(StalAlloysBlocks.CUT_NICKEL);
    addDrop(StalAlloysBlocks.CUT_NICKEL_SLAB);
    addDrop(StalAlloysBlocks.CUT_NICKEL_STAIRS);
    addDrop(StalAlloysBlocks.NICKEL_ORE, oreDrops(StalAlloysBlocks.NICKEL_ORE, StalAlloysItems.RAW_NICKEL));
    addDrop(StalAlloysBlocks.DEEPSLATE_NICKEL_ORE, oreDrops(StalAlloysBlocks.DEEPSLATE_NICKEL_ORE, StalAlloysItems.RAW_NICKEL));
    addDrop(StalAlloysBlocks.NETHERRACK_NICKEL_ORE, oreDrops(StalAlloysBlocks.NETHERRACK_NICKEL_ORE, StalAlloysItems.RAW_NICKEL));

    addDrop(StalAlloysBlocks.CHROMIUM_BLOCK);
    addDrop(StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE, oreDrops(StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE, StalAlloysItems.RAW_CHROMIUM));

    addDrop(StalAlloysBlocks.ZINC_BLOCK);
    addDrop(StalAlloysBlocks.ZINC_ORE, oreDrops(StalAlloysBlocks.ZINC_ORE, StalAlloysItems.RAW_ZINC));
    addDrop(StalAlloysBlocks.DEEPSLATE_ZINC_ORE, oreDrops(StalAlloysBlocks.DEEPSLATE_ZINC_ORE, StalAlloysItems.RAW_ZINC));

    addDrop(StalAlloysBlocks.TIN_ORE, oreDrops(StalAlloysBlocks.TIN_ORE, StalAlloysItems.RAW_TIN));
    addDrop(StalAlloysBlocks.DEEPSLATE_TIN_ORE, oreDrops(StalAlloysBlocks.DEEPSLATE_TIN_ORE, StalAlloysItems.RAW_TIN));

    addDrop(StalAlloysBlocks.DEEPSLATE_CARBON_ORE, oreDrops(StalAlloysBlocks.DEEPSLATE_CARBON_ORE, StalAlloysItems.RAW_CARBON));
  }
}
