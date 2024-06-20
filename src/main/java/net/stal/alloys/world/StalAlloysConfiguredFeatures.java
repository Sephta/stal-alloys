package net.stal.alloys.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

import java.util.List;

public class StalAlloysConfiguredFeatures {
  public static final RegistryKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> NICKEL_ORE_SMALL_KEY = registerKey("nickel_ore_small");
  public static final RegistryKey<ConfiguredFeature<?, ?>> NICKEL_ORE_LARGE_KEY = registerKey("nickel_ore_large");
  public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> CHROMIUM_ORE_KEY = registerKey("chromium_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_CARBON_ORE_KEY = registerKey("deepslate_carbon_ore");

  public static final RegistryKey<ConfiguredFeature<?, ?>> NETHERRACK_NICKEL_ORE_KEY = registerKey("netherrack_nickel_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> NETHERRACK_CHROMIUM_ORE_KEY = registerKey("netherrack_chromium_ore");

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

    // Overworld
    List<OreFeatureConfig.Target> overworldZincOres = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.ZINC_ORE.getDefaultState()),
      OreFeatureConfig.createTarget(deepslateReplaceables, StalAlloysBlocks.DEEPSLATE_ZINC_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> overworldCarbonOres = List.of(
      OreFeatureConfig.createTarget(deepslateReplaceables, StalAlloysBlocks.DEEPSLATE_CARBON_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> overworldNickelOresSmall = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.NICKEL_ORE.getDefaultState()),
      OreFeatureConfig.createTarget(deepslateReplaceables, StalAlloysBlocks.DEEPSLATE_NICKEL_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> overworldNickelOresLarge = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.NICKEL_ORE.getDefaultState()),
      OreFeatureConfig.createTarget(deepslateReplaceables, StalAlloysBlocks.DEEPSLATE_NICKEL_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> overworldTinOres = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.TIN_ORE.getDefaultState()),
      OreFeatureConfig.createTarget(deepslateReplaceables, StalAlloysBlocks.DEEPSLATE_TIN_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> overworldChromiumOres = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.CHROMIUM_ORE.getDefaultState())
    );

    // Nether
    List<OreFeatureConfig.Target> netherNickelOres = List.of(
      OreFeatureConfig.createTarget(netherReplaceables, StalAlloysBlocks.NETHERRACK_NICKEL_ORE.getDefaultState())
    );

    List<OreFeatureConfig.Target> netherChromiumOres = List.of(
      OreFeatureConfig.createTarget(netherReplaceables, StalAlloysBlocks.NETHERRACK_CHROMIUM_ORE.getDefaultState())
    );

    // Overworld
    register(context, ZINC_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldZincOres, 8, 0));
    register(context, NICKEL_ORE_SMALL_KEY, Feature.ORE, new OreFeatureConfig(overworldNickelOresSmall, 10, 0.5F));
    register(context, NICKEL_ORE_LARGE_KEY, Feature.ORE, new OreFeatureConfig(overworldNickelOresLarge, 20, 0.5F));
    register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 8, 0));
    register(context, CHROMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldChromiumOres, 3, 0));
    register(context, DEEPSLATE_CARBON_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCarbonOres, 6, 0));

    // Nether
    register(context, NETHERRACK_NICKEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherNickelOres, 12, 0));
    register(context, NETHERRACK_CHROMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherChromiumOres, 4, 0));
  }

  public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(StalAlloys.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }

  public static void registerConfiguredFeatures() {
    StalAlloys.LOGGER.debug("Registering configured features for " + StalAlloys.MOD_ID);
  }
}