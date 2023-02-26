package net.stal.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stal.StalAlloys;

public class StalAlloysItems {
  public static final Item STEEL_INGOT = registerItem("steel_ingot", new SteelIngot(new FabricItemSettings()));
  public static final Item RAW_STEEL = registerItem("raw_steel", new RawSteel(new FabricItemSettings()));


  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(StalAlloys.MOD_ID, name), item);
  }

  public static void addItemsToItemGroup() {
    // Vanilla Item Groups
    addToItemGroup(ItemGroups.INGREDIENTS, STEEL_INGOT);
    addToItemGroup(ItemGroups.INGREDIENTS, RAW_STEEL);

    // Mod Item Groups
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_STEEL);
  }

  public static void addToItemGroup(ItemGroup group, Item item) {
    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
  }

  public static void registerModItems() {
    StalAlloys.LOGGER.info("Registering Mod Items for " + StalAlloys.MOD_ID);

    addItemsToItemGroup();
  }
}
