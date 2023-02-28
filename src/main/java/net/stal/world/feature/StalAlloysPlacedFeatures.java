package net.stal.world.feature;

import net.stal.StalAlloys;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class StalAlloysPlacedFeatures {
  public static final RegistryKey<PlacedFeature> STEEL_ORE_PLACED_KEY = registerKey("steel_ore_placed");

  public static RegistryKey<PlacedFeature> registerKey(String name) {
      return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(StalAlloys.MOD_ID, name));
  }

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(
      context, 
      STEEL_ORE_PLACED_KEY, 
      configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.STEEL_ORE_KEY), 
      modifiersWithCount(
        16 /* VeinsPerChunk */, 
        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
      )
    );
  }

  private static void register(
    Registerable<PlacedFeature> context, 
    RegistryKey<PlacedFeature> key, 
    RegistryEntry<ConfiguredFeature<?, ?>> configuration, 
    List<PlacementModifier> modifiers
  ) {
      context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }

  // private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
  //   Registerable<PlacedFeature> context, 
  //   RegistryKey<PlacedFeature> key, 
  //   RegistryEntry<ConfiguredFeature<?, ?>> configuration, 
  //   PlacementModifier... modifiers
  // ) {
  //     register(context, key, configuration, List.of(modifiers));
  // }

  private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
      return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
  }
  private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
      return modifiers(CountPlacementModifier.of(count), heightModifier);
  }
  // private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
  //     return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
  // }
}
