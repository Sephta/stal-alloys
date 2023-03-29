package net.stal.alloys.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stal.alloys.*;
import net.stal.alloys.item.custom.StalAlloysHoeItem;

public class StalAlloysItems {

  public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));

  public static final Item RAW_NICKEL = registerItem("raw_nickel", new Item(new FabricItemSettings()));
  public static final Item NICKEL_INGOT = registerItem("nickel_ingot", new Item(new FabricItemSettings()));

  public static final Item RAW_CHROMIUM = registerItem("raw_chromium", new Item(new FabricItemSettings()));
  public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot", new Item(new FabricItemSettings()));

  public static final Item RAW_CARBON = registerItem("raw_carbon", new Item(new FabricItemSettings()));
  public static final Item CARBON_PLATE = registerItem("carbon_plate", new Item(new FabricItemSettings()));

  public static final Item RAW_ZINC = registerItem("raw_zinc", new Item(new FabricItemSettings()));
  public static final Item ZINC_INGOT = registerItem("zinc_ingot", new Item(new FabricItemSettings()));

  public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
  public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));

  public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ToolMaterials.IRON, 3, -2.4F, new FabricItemSettings()));
  public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ToolMaterials.IRON, 1, -2.8F, new FabricItemSettings()));
  public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ToolMaterials.IRON, 6.0f, -3.1F, new FabricItemSettings()));
  public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ToolMaterials.IRON, 1.5f, -3.0F, new FabricItemSettings()));
  public static final Item COPPER_HOE = registerItem("copper_hoe", new StalAlloysHoeItem(ToolMaterials.IRON, -2, -1.0F, new FabricItemSettings()));

  public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
  public static final Item BRONZE_SWORD = registerItem("bronze_sword", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 3, -2.0F, new FabricItemSettings()));
  public static final Item BRONZE_AXE = registerItem("bronze_axe", new AxeItem(StalAlloysToolMaterials.BRONZE_ALLOY, 6, -3.0F, new FabricItemSettings()));
  public static final Item BRONZE_DAGGER = registerItem("bronze_dagger", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 2, -1.0F, new FabricItemSettings()));
  public static final Item BRONZE_DIRK = registerItem("bronze_dirk", new SwordItem(StalAlloysToolMaterials.BRONZE_ALLOY, 2, -1.8F, new FabricItemSettings()));
  public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new FabricItemSettings()));

  public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new PickaxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 1, -2.8F, new FabricItemSettings()));
  public static final Item STEEL_AXE = registerItem("steel_axe", new AxeItem(StalAlloysToolMaterials.STEEL_ALLOY, 6, -3.1F, new FabricItemSettings()));
  public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ShovelItem(StalAlloysToolMaterials.STEEL_ALLOY, 1.5F, -3.0F, new FabricItemSettings()));
  public static final Item STEEL_HOE = registerItem("steel_hoe", new StalAlloysHoeItem(StalAlloysToolMaterials.STEEL_ALLOY, 2, -1.0F, new FabricItemSettings()));

  public static final Item BRASS_HELMET = registerItem("brass_helmet", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.HEAD, new FabricItemSettings()));
  public static final Item BRASS_CHESTPLATE = registerItem("brass_chestplate", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.CHEST, new FabricItemSettings()));
  public static final Item BRASS_LEGGINGS = registerItem("brass_leggings", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.LEGS, new FabricItemSettings()));
  public static final Item BRASS_BOOTS = registerItem("brass_boots", new ArmorItem(StalAlloysArmorMaterials.BRASS, EquipmentSlot.FEET, new FabricItemSettings()));
  
  public static final Item STAINLESS_STEEL_INGOT = registerItem("stainless_steel_ingot", new Item(new FabricItemSettings()));

  public static final Item STAINLESS_STEEL_HELMET = registerItem("stainless_steel_helmet", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.HEAD, new FabricItemSettings()));
  public static final Item STAINLESS_STEEL_CHESTPLATE = registerItem("stainless_steel_chestplate", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.CHEST, new FabricItemSettings()));
  public static final Item STAINLESS_STEEL_LEGGINGS = registerItem("stainless_steel_leggings", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.LEGS, new FabricItemSettings()));
  public static final Item STAINLESS_STEEL_BOOTS = registerItem("stainless_steel_boots", new ArmorItem(StalAlloysArmorMaterials.STAINLESS_STEEL, EquipmentSlot.FEET, new FabricItemSettings()));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(StalAlloys.MOD_ID, name), item);
  }

  public static void addToItemGroup(ItemGroup group, Item item) {
    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
  }

  public static void addItemsToItemGroups() {
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_NICKEL);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, NICKEL_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_CHROMIUM);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, CHROMIUM_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_CARBON);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, CARBON_PLATE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_ZINC);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, ZINC_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, RAW_TIN);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, TIN_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, COPPER_SWORD);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, COPPER_PICKAXE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, COPPER_AXE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, COPPER_SHOVEL);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, COPPER_HOE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRONZE_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRONZE_SWORD);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRONZE_AXE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRONZE_DAGGER);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRONZE_DIRK);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRASS_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRASS_HELMET);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRASS_CHESTPLATE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRASS_LEGGINGS);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, BRASS_BOOTS);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_PICKAXE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_AXE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_SHOVEL);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STEEL_HOE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STAINLESS_STEEL_INGOT);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STAINLESS_STEEL_HELMET);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STAINLESS_STEEL_CHESTPLATE);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STAINLESS_STEEL_LEGGINGS);
    addToItemGroup(StalAlloysItemGroup.STAL_ALLOYS, STAINLESS_STEEL_BOOTS);
  }

  public static void registerModItems() {
    StalAlloys.LOGGER.debug("Registering Mod Items for " + StalAlloys.MOD_ID);

    addItemsToItemGroups();
  }
}
