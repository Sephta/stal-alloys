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
    // Nickel
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/nickel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.NICKEL_ORE, StalAlloysItems.RAW_NICKEL, ConstantLootNumberProvider.create(1.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_nickel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.DEEPSLATE_NICKEL_ORE, StalAlloysItems.RAW_NICKEL, ConstantLootNumberProvider.create(1.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/netherrack_nickel_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.NETHERRACK_NICKEL_ORE, StalAlloysItems.RAW_NICKEL, ConstantLootNumberProvider.create(1.0F)));

    // Chromium
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/chromium_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.CHROMIUM_ORE, StalAlloysItems.RAW_CHROMIUM, ConstantLootNumberProvider.create(1.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_chromium_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.DEEPSLATE_CHROMIUM_ORE, StalAlloysItems.RAW_CHROMIUM, ConstantLootNumberProvider.create(1.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/netherrack_chromium_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE, StalAlloysItems.RAW_CHROMIUM, ConstantLootNumberProvider.create(1.0F)));

    // Zinc
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/zinc_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.ZINC_ORE, StalAlloysItems.RAW_ZINC, UniformLootNumberProvider.create(1.0F, 2.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_zinc_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.DEEPSLATE_ZINC_ORE, StalAlloysItems.RAW_ZINC, UniformLootNumberProvider.create(1.0F, 2.0F)));

    // Tin
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/tin_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.TIN_ORE, StalAlloysItems.RAW_TIN, UniformLootNumberProvider.create(1.0F, 3.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_tin_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.DEEPSLATE_TIN_ORE, StalAlloysItems.RAW_TIN, UniformLootNumberProvider.create(1.0F, 3.0F)));

    // Carbon
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/carbon_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.CARBON_ORE, StalAlloysItems.RAW_CARBON, UniformLootNumberProvider.create(1.0F, 2.0F)));
    biConsumer.accept(new Identifier(StalAlloys.MOD_ID, "blocks/deepslate_carbon_ore"), BlockLootTableGenerator.drops(StalAlloysBlocks.DEEPSLATE_CARBON_ORE, StalAlloysItems.RAW_CARBON, UniformLootNumberProvider.create(1.0F, 2.0F)));
  }
  
}
