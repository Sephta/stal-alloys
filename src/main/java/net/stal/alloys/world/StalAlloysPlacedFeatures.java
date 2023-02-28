package net.stal.alloys.world;

import java.util.List;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

public class StalAlloysPlacedFeatures {
  public static final RegistryEntry<PlacedFeature> STEEL_ORE_PLACED = PlacedFeatures.register("steel_ore_placed",
    StalAlloysConfiguredFeatures.STEEL_ORE, modifiersWithCount(9,
      HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> NETHER_TANZANITE_ORE_PLACED = PlacedFeatures.register("netherrack_steel_ore_placed",
      StalAlloysConfiguredFeatures.NETHER_STEEL_ORE, modifiersWithCount(10,
        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> END_TANZANITE_ORE_PLACED = PlacedFeatures.register("endstpne_steel_ore_placed",
      StalAlloysConfiguredFeatures.END_STEEL_ORE, modifiersWithCount(10,
        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

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
