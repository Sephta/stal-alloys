package net.stal;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import net.stal.data.*;
import net.stal.world.feature.*;

public class StalAlloysDataGenerator implements DataGeneratorEntrypoint {
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(StalAlloysLootTableGenerator::new);
    pack.addProvider(StalAlloysRecipeGenerator::new);
    pack.addProvider(StalAlloysModelProvider::new);
    // pack.addProvider(StalAlloysWorldGenerator::new);
  }

  @Override
  public void buildRegistry(RegistryBuilder registryBuilder) {
    // registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, StalAlloysConfiguredFeatures::bootstrap);
    // registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, StalAlloysPlacedFeatures::bootstrap);

    DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
  }
}
