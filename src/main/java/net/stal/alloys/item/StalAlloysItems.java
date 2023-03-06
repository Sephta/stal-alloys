package net.stal.alloys.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stal.alloys.*;
import net.stal.alloys.item.custom.SteelHoeItem;

public class StalAlloysItems {

  public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item RAW_NICKEL = registerItem("raw_nickel", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item NICKEL_INGOT = registerItem("nickel_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item RAW_CHROMIUM = registerItem("raw_chromium", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item RAW_CARBON = registerItem("raw_carbon", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item CARBON_PLATE = registerItem("carbon_plate", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item RAW_ZINC = registerItem("raw_zinc", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item ZINC_INGOT = registerItem("zinc_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  // TODO add Brass Ingot (update recipe)
  // TODO add Bronze Ingot (update recipe)

  public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new PickaxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 1, -2.8F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_AXE = registerItem("steel_axe", new AxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 6, -3.1F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ShovelItem(StalAlloysToolMaterials.STEEL_ALLOY, 1.5F, -3.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_HOE = registerItem("steel_hoe", new SteelHoeItem(StalAlloysToolMaterials.STEEL_ALLOY, 2, -1.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registry.ITEM, new Identifier(StalAlloys.MOD_ID, name), item);
  }

  public static void registerModItems() {
    StalAlloys.LOGGER.debug("Registering Mod Items for " + StalAlloys.MOD_ID);
  }
}
