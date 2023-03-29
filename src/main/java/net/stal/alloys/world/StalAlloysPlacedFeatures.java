package net.stal.alloys.world;

import java.util.List;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import net.stal.alloys.StalAlloys;

public class StalAlloysPlacedFeatures {
  public static final RegistryKey<PlacedFeature> NICKEL_ORE_PLACED_KEY = registerKey("nickel_ore_placed");
  public static final RegistryKey<PlacedFeature> NETHERRACK_NICKEL_ORE_PLACED_KEY = registerKey("netherrack_nickel_ore_placed");
  public static final RegistryKey<PlacedFeature> NETHERRACK_CHROMIUM_ORE_PLACED_KEY = registerKey("netherrack_chromium_ore_placed");
  public static final RegistryKey<PlacedFeature> DEEPSLATE_CARBON_ORE_PLACED_KEY = registerKey("deepslate_carbon_ore_placed");
  public static final RegistryKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
  public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
  

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, NICKEL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.NICKEL_ORE_KEY), 
              modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    register(context, NETHERRACK_NICKEL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.NETHERRACK_NICKEL_ORE_KEY), 
              modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    register(context, NETHERRACK_CHROMIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.NETHERRACK_CHROMIUM_ORE_KEY), 
              modifiersWithCount(3, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-15), YOffset.aboveBottom(22))));
    register(context, DEEPSLATE_CARBON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.DEEPSLATE_CARBON_ORE_KEY), 
              modifiersWithCount(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    register(context, ZINC_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.ZINC_ORE_KEY), 
              modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    register(context, TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(StalAlloysConfiguredFeatures.TIN_ORE_KEY), 
              modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
  }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
      return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(StalAlloys.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
      context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
    //                                                                                RegistryEntry<ConfiguredFeature<?, ?>> configuration,
    //                                                                                PlacementModifier... modifiers) {
    //   register(context, key, configuration, List.of(modifiers));
    // }

  private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
    return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
  }
  private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
    return modifiers(CountPlacementModifier.of(count), heightModifier);
  }
  // private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
  //   return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
  // }
}
