package net.stal.alloys.world;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

import java.util.List;

public class StalAlloysConfiguredFeatures {

  public static final List<OreFeatureConfig.Target> OVERWORLD_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.STEEL_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> NETHER_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, StalAlloysBlocks.NETHERRACK_STEEL_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> END_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), StalAlloysBlocks.ENDSTONE_STEEL_ORE.getDefaultState())
  );

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> STEEL_ORE = 
    ConfiguredFeatures.register("steel_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_STEEL_ORES, 9));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_STEEL_ORE = 
    ConfiguredFeatures.register("netherrack_steel_ore", Feature.ORE, new OreFeatureConfig(NETHER_STEEL_ORES, 12));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_STEEL_ORE = 
    ConfiguredFeatures.register("endstone_steel_ore", Feature.ORE, new OreFeatureConfig(END_STEEL_ORES, 12));

  public static void registerConfiguredFeatures() {
    StalAlloys.LOGGER.debug("Registering configured features for " + StalAlloys.MOD_ID);
  }
}
