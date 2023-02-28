package net.stal.data;

import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.stal.block.StalAlloysBlocks;
import net.stal.item.StalAlloysItems;

public class StalAlloysLootTableGenerator extends FabricBlockLootTableProvider {
  public StalAlloysLootTableGenerator(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {

    addDrop(StalAlloysBlocks.STEEL_BLOCK);

    addDrop(StalAlloysBlocks.STEEL_ORE, oreDrops(StalAlloysBlocks.STEEL_ORE, StalAlloysItems.RAW_STEEL));
    addDrop(StalAlloysBlocks.DEEPSLATE_STEEL_ORE, oreDrops(StalAlloysBlocks.DEEPSLATE_STEEL_ORE, StalAlloysItems.RAW_STEEL));
  }
}
