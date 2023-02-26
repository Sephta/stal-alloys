package net.stal.data;

import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.stal.StalAlloys;
import net.stal.block.StalAlloysBlocks;
import net.stal.item.StalAlloysItems;

public class StalAlloysModelProvider extends FabricModelProvider {
  public StalAlloysModelProvider(FabricDataOutput output) {
		super(output);
	}

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerCubeAllModelTexturePool(StalAlloysBlocks.STEEL_BLOCK);
    blockStateModelGenerator.registerCubeAllModelTexturePool(StalAlloysBlocks.DEEPSLATE_STEEL_ORE);
    blockStateModelGenerator.registerCubeAllModelTexturePool(StalAlloysBlocks.STEEL_ORE);
  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(StalAlloysItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(StalAlloysItems.RAW_STEEL, Models.GENERATED);
  }


  @Override
  public String getName() { return StalAlloys.MOD_ID; }
}
