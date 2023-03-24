package net.stal.alloys.world;

import java.util.List;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

public class StalAlloysPlacedFeatures {
  // Steel
  // public static final RegistryEntry<PlacedFeature> STEEL_ORE_PLACED = PlacedFeatures.register("steel_ore_placed",
  //   StalAlloysConfiguredFeatures.STEEL_ORE, modifiersWithCount(9,
  //     HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

  //   public static final RegistryEntry<PlacedFeature> NETHER_STEEL_ORE_PLACED = PlacedFeatures.register("netherrack_steel_ore_placed",
  //     StalAlloysConfiguredFeatures.NETHER_STEEL_ORE, modifiersWithCount(10,
  //       HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

  //   public static final RegistryEntry<PlacedFeature> END_STEEL_ORE_PLACED = PlacedFeatures.register("endstpne_steel_ore_placed",
  //     StalAlloysConfiguredFeatures.END_STEEL_ORE, modifiersWithCount(10,
  //       HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
  
  // Nickel
  public static final RegistryEntry<PlacedFeature> NICKEL_ORE_PLACED = PlacedFeatures.register("nickel_ore_placed",
    StalAlloysConfiguredFeatures.NICKEL_ORE, modifiersWithCount(9,
      HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> NETHER_NICKEL_ORE_PLACED = PlacedFeatures.register("netherrack_nickel_ore_placed",
      StalAlloysConfiguredFeatures.NETHER_NICKEL_ORE, modifiersWithCount(10,
        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

  // Chromium
  // public static final RegistryEntry<PlacedFeature> CHROMIUM_ORE_PLACED = PlacedFeatures.register("chromium_ore_placed",
  //   StalAlloysConfiguredFeatures.CHROMIUM_ORE, modifiersWithCount(9,
  //     HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> NETHER_CHROMIUM_ORE_PLACED = PlacedFeatures.register("netherrack_chromium_ore_placed",
      StalAlloysConfiguredFeatures.NETHER_CHROMIUM_ORE, modifiersWithCount(3,
        HeightRangePlacementModifier.uniform(YOffset.fixed(-15), YOffset.fixed(22))));

  // Carbon
  public static final RegistryEntry<PlacedFeature> CARBON_ORE_PLACED = PlacedFeatures.register("carbon_ore_placed",
    StalAlloysConfiguredFeatures.CARBON_ORE, modifiersWithCount(6,
      HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(0))));

  // Zinc
  public static final RegistryEntry<PlacedFeature> ZINC_ORE_PLACED = PlacedFeatures.register("zinc_ore_placed",
    StalAlloysConfiguredFeatures.ZINC_ORE, modifiersWithCount(9,
      HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

  // Tin
  public static final RegistryEntry<PlacedFeature> TIN_ORE_PLACED = PlacedFeatures.register("tin_ore_placed",
    StalAlloysConfiguredFeatures.TIN_ORE, modifiersWithCount(9,
      HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

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
