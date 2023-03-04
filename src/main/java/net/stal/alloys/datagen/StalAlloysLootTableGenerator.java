package net.stal.alloys.datagen;

import java.util.function.BiConsumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.context.*;
import net.minecraft.loot.provider.number.*;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;
import net.stal.alloys.item.StalAlloysItems;

public class StalAlloysLootTableGenerator extends SimpleFabricLootTableProvider {
  public StalAlloysLootTableGenerator(FabricDataGenerator dataGenerator) {
    super(dataGenerator, LootContextTypes.BLOCK);
  }

  @Override
  public void accept(BiConsumer<Identifier, Builder> biConsumer) {
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/steel_block"), BlockLootTableGenerator.drops(StalAlloysBlocks.STEEL_BLOCK, ConstantLootNumberProvider.create(1.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/steel_ore"), BlockLootTableGenerator.drops(StalAlloysItems.RAW_STEEL, UniformLootNumberProvider.create(1.0F, 4.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_steel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.STEEL_BLOCK, UniformLootNumberProvider.create(1.0F, 4.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/netherrack_steel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.STEEL_BLOCK, UniformLootNumberProvider.create(1.0F, 4.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/endstone_steel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.STEEL_BLOCK, UniformLootNumberProvider.create(1.0F, 4.0F)));
  }
  
}
