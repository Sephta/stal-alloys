package net.stal.alloys.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stal.alloys.*;
import net.stal.alloys.item.custom.StalAlloysHoeItem;

public class StalAlloysItems {

  // public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
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

  public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ToolMaterials.IRON, 3, -2.4F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ToolMaterials.IRON, 1, -2.8F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ToolMaterials.IRON, 6.0f, -3.1F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ToolMaterials.IRON, 1.5f, -3.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item COPPER_HOE = registerItem("copper_hoe", new StalAlloysHoeItem(ToolMaterials.IRON, -2, -1.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRONZE_SWORD = registerItem("bronze_sword", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 3, -2.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRONZE_AXE = registerItem("bronze_axe", new AxeItem(StalAlloysToolMaterials.BRONZE_ALLOY, 6, -3.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRONZE_DAGGER = registerItem("bronze_dagger", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 2, -1.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRONZE_DIRK = registerItem("bronze_dirk", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 2, -1.8F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new PickaxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 1, -2.8F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_AXE = registerItem("steel_axe", new AxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 6, -3.1F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ShovelItem(StalAlloysToolMaterials.STEEL_ALLOY, 1.5F, -3.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STEEL_HOE = registerItem("steel_hoe", new StalAlloysHoeItem(StalAlloysToolMaterials.STEEL_ALLOY, 2, -1.0F, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item BRASS_HELMET = registerItem("brass_helmet", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.HEAD, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRASS_CHESTPLATE = registerItem("brass_chestplate", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.CHEST, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRASS_LEGGINGS = registerItem("brass_leggings", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.LEGS, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item BRASS_BOOTS = registerItem("brass_boots", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.FEET, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  
  public static final Item STAINLESS_STEEL_INGOT = registerItem("stainless_steel_ingot", new Item(new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  public static final Item STAINLESS_STEEL_HELMET = registerItem("stainless_steel_helmet", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.HEAD, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STAINLESS_STEEL_CHESTPLATE = registerItem("stainless_steel_chestplate", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.CHEST, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STAINLESS_STEEL_LEGGINGS = registerItem("stainless_steel_leggings", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.LEGS, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));
  public static final Item STAINLESS_STEEL_BOOTS = registerItem("stainless_steel_boots", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.FEET, new FabricItemSettings().group(StalAlloysItemGroup.STAL_ALLOYS)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registry.ITEM, new Identifier(StalAlloys.MOD_ID, name), item);
  }

  public static void registerModItems() {
    StalAlloys.LOGGER.debug("Registering Mod Items for " + StalAlloys.MOD_ID);
  }
}
