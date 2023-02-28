package net.stal.world.feature;

import java.util.List;

import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents.Register;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.stal.StalAlloys;
import net.stal.block.StalAlloysBlocks;

public class StalAlloysConfiguredFeatures {
  public static final RegistryKey<ConfiguredFeature<?,?>> STEEL_ORE_KEY = registerKey("steel_ore");

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

    List<OreFeatureConfig.Target> OVERWORLD_STEEL_ORES = List.of(
      OreFeatureConfig.createTarget(stoneReplaceables, StalAlloysBlocks.STEEL_ORE.getDefaultState())
    );

    register(context, STEEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_STEEL_ORES, 9));
  }


  public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(StalAlloys.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
    Registerable<ConfiguredFeature<?, ?>> context, 
    RegistryKey<ConfiguredFeature<?, ?>> key, 
    F feature, 
    FC configuration
  ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
