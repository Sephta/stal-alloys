package net.stal;

import java.nio.file.Path;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.GameVersion;

import net.minecraft.data.DataGenerator;

import net.stal.data.*;

public class StalAlloysDataGenerator extends DataGenerator {
  public StalAlloysDataGenerator(Path outputPath, GameVersion gameVersion, boolean ignoreCache) {
    super(outputPath, gameVersion, ignoreCache);
  }

  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(StalAlloysLootTableGenerator::new);
    pack.addProvider(StalAlloysRecipeGenerator::new);
    pack.addProvider(StalAlloysModelProvider::new);
  }
}
