package net.stal.alloys.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.stal.alloys.world.StalAlloysPlacedFeatures;

public class StalAlloysOreGeneration {
  public static void generateOres() {
    // Nickel
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NICKEL_ORE_PLACED_KEY); 
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHERRACK_NICKEL_ORE_PLACED_KEY); 

    // Chromium
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHERRACK_CHROMIUM_ORE_PLACED_KEY); 

    // Carbon
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.DEEPSLATE_CARBON_ORE_PLACED_KEY); 

    // Zinc
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.ZINC_ORE_PLACED_KEY); 

    // Tin
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.TIN_ORE_PLACED_KEY); 
  }
}
