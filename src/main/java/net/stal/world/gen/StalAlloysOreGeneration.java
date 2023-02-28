package net.stal.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.stal.world.feature.StalAlloysPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class StalAlloysOreGeneration {
  public static void generateOres() {
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.STEEL_ORE_PLACED_KEY);
  }
}
