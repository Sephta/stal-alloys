package net.stal.alloys.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.stal.alloys.world.StalAlloysPlacedFeatures;

public class StalAlloysOreGeneration {
  public static void generateOres() {
    // Steel
    // BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.STEEL_ORE_PLACED.getKey().get()); 
    // BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHER_STEEL_ORE_PLACED.getKey().get()); 
    // BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.END_STEEL_ORE_PLACED.getKey().get());

    // Nickel
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NICKEL_ORE_PLACED.getKey().get()); 
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHER_NICKEL_ORE_PLACED.getKey().get()); 

    // Chromium
    // BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.CHROMIUM_ORE_PLACED.getKey().get()); 
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.NETHER_CHROMIUM_ORE_PLACED.getKey().get()); 

    // Carbon
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.CARBON_ORE_PLACED.getKey().get()); 

    // Zinc
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.ZINC_ORE_PLACED.getKey().get()); 

    // Tin
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StalAlloysPlacedFeatures.TIN_ORE_PLACED.getKey().get()); 
  }
}
