package net.stal.alloys.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.stal.alloys.world.StalAlloysPlacedFeatures;

public class StalAlloysOreGeneration {
  public static void generateOres() {
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.STEEL_ORE_PLACED.getKey().get()); 
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHER_TANZANITE_ORE_PLACED.getKey().get()); 
    BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.END_TANZANITE_ORE_PLACED.getKey().get()); 
  }
}
