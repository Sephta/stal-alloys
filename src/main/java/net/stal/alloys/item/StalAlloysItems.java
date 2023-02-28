package net.stal.alloys.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stal.alloys.*;

public class StalAlloysItems {

  public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registry.ITEM, new Identifier(StalAlloys.MOD_ID, name), item);
  }

  public static void registerModItems() {
    StalAlloys.LOGGER.debug("Registering Mod Items for " + StalAlloys.MOD_ID);
  }
}
