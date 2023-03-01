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

  // Steel
  public static final List<OreFeatureConfig.Target> OVERWORLD_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.STEEL_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_STEEL_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> NETHER_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, StalAlloysBlocks.NETHERRACK_STEEL_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> END_STEEL_ORES = List.of(
    OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), StalAlloysBlocks.ENDSTONE_STEEL_ORE.getDefaultState())
  );

  // Nickel
  public static final List<OreFeatureConfig.Target> OVERWORLD_NICKEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.NICKEL_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_NICKEL_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> NETHER_NICKEL_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, StalAlloysBlocks.NETHERRACK_NICKEL_ORE.getDefaultState())
  );

  // Chromium
  public static final List<OreFeatureConfig.Target> OVERWORLD_CHROMIUM_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.CHROMIUM_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_CHROMIUM_ORE.getDefaultState())
  );

  public static final List<OreFeatureConfig.Target> NETHER_CHROMIUM_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE.getDefaultState())
  );

  // Carbon
  public static final List<OreFeatureConfig.Target> OVERWORLD_CARBON_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.CARBON_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_CARBON_ORE.getDefaultState())
  );

  // Zinc
  public static final List<OreFeatureConfig.Target> OVERWORLD_ZINC_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.ZINC_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_ZINC_ORE.getDefaultState())
  );

  // Tin
  public static final List<OreFeatureConfig.Target> OVERWORLD_TIN_ORES = List.of(
    OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, StalAlloysBlocks.TIN_ORE.getDefaultState()),
    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, StalAlloysBlocks.DEEPSLATE_TIN_ORE.getDefaultState())
  );

  // Steel Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> STEEL_ORE = 
    ConfiguredFeatures.register("steel_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_STEEL_ORES, 9));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_STEEL_ORE = 
    ConfiguredFeatures.register("netherrack_steel_ore", Feature.ORE, new OreFeatureConfig(NETHER_STEEL_ORES, 12));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_STEEL_ORE = 
    ConfiguredFeatures.register("endstone_steel_ore", Feature.ORE, new OreFeatureConfig(END_STEEL_ORES, 12));

  // Nickel Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NICKEL_ORE = 
    ConfiguredFeatures.register("nickel_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_NICKEL_ORES, 9));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_NICKEL_ORE = 
    ConfiguredFeatures.register("netherrack_nickel_ore", Feature.ORE, new OreFeatureConfig(NETHER_NICKEL_ORES, 12));

  // Chromium Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CHROMIUM_ORE = 
    ConfiguredFeatures.register("chromium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_CHROMIUM_ORES, 9));

  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_CHROMIUM_ORE = 
    ConfiguredFeatures.register("netherrack_chromium_ore", Feature.ORE, new OreFeatureConfig(NETHER_CHROMIUM_ORES, 12));

  // Carbon Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CARBON_ORE = 
    ConfiguredFeatures.register("carbon_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_CARBON_ORES, 9));

  // Zinc Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ZINC_ORE = 
    ConfiguredFeatures.register("zinc_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ZINC_ORES, 9));

  // Tin Registry
  public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TIN_ORE = 
    ConfiguredFeatures.register("tin_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 9));

  public static void registerConfiguredFeatures() {
    StalAlloys.LOGGER.debug("Registering configured features for " + StalAlloys.MOD_ID);
  }
}
