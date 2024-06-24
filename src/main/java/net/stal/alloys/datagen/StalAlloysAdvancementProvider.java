package net.stal.alloys.datagen;

import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;
import net.stal.alloys.item.StalAlloysItems;

public class StalAlloysAdvancementProvider extends FabricAdvancementProvider {

  public StalAlloysAdvancementProvider(FabricDataOutput output) {
    super(output);
  }

  @SuppressWarnings("unused")
  @Override
  public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
    AdvancementEntry alloySmelterRoot = Advancement.Builder.create()
      .display(
        StalAlloysBlocks.ALLOY_SMELTER,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_root_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_root_description_text"),
        new Identifier("textures/gui/advancements/backgrounds/stone.png"),
        AdvancementFrame.TASK,
        true,
        true,
        false
      )
      .criterion("alloy_smelter_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysBlocks.ALLOY_SMELTER))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloy-smelter-root");

    AdvancementEntry alloysTin = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.RAW_TIN,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_tin_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_tin_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("raw_tin_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.RAW_TIN))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-tin");
    
    AdvancementEntry alloysBronze = Advancement.Builder.create().parent(alloysTin)
      .display(
        StalAlloysItems.BRONZE_INGOT,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_bronze_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_bronze_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("bronze_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRONZE_INGOT))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-bronze");

    AdvancementEntry alloysZinc = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.RAW_ZINC,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_zinc_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_zinc_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("raw_zinc_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.RAW_ZINC))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-zinc");
    
    AdvancementEntry alloysBrass = Advancement.Builder.create().parent(alloysZinc)
      .display(
        StalAlloysItems.BRASS_INGOT,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_brass_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_brass_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("brass_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRASS_INGOT))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-brass");

    AdvancementEntry alloysNickel = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.RAW_NICKEL,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_nickel_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_nickel_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("raw_nickel_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.RAW_NICKEL))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-nickel");

    AdvancementEntry alloysChromium = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.RAW_CHROMIUM,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_chromium_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_chromium_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("raw_chromium_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.RAW_CHROMIUM))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-chromium");

    AdvancementEntry alloysStainlessSteel = Advancement.Builder.create().parent(alloysChromium)
      .display(
        StalAlloysItems.STAINLESS_STEEL_INGOT,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_stainless_steel_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_stainless_steel_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("chromium_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.CHROMIUM_INGOT))
      .criterion("steel_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_INGOT))
      .criterion("stainless_steel_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STAINLESS_STEEL_INGOT))
      .rewards(AdvancementRewards.Builder.experience(15))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-stainless-steel");
    
    AdvancementEntry alloysCarbon = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.RAW_CARBON,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_carbon_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_carbon_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("raw_carbon_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.RAW_CARBON))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-carbon");
    
    AdvancementEntry carbonPlates = Advancement.Builder.create().parent(alloysCarbon)
      .display(
        StalAlloysItems.CARBON_PLATE,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_carbon_plate_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_carbon_plate_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("carbon_plate_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.CARBON_PLATE))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/carbon-plate");

    AdvancementEntry alloysSteel = Advancement.Builder.create().parent(carbonPlates)
      .display(
        StalAlloysItems.STEEL_INGOT,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_steel_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_alloys_steel_description_text"),
        null,
        AdvancementFrame.TASK,
        true,
        true,
        false        
      )
      .criterion("steel_ingot_acquired", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_INGOT))
      .rewards(AdvancementRewards.Builder.experience(10))
      .build(consumer, StalAlloys.MOD_ID + "/alloys-steel");

    AdvancementEntry nickelDecorativeBlocks = Advancement.Builder.create().parent(alloysNickel)
      .display(
        StalAlloysBlocks.CUT_NICKEL,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_nickel_decor_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_nickel_decor_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("cut_nickel_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysBlocks.CUT_NICKEL))
      .criterion("cut_nickel_slab_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysBlocks.CUT_NICKEL_SLAB))
      .criterion("cut_nickel_stairs_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysBlocks.CUT_NICKEL_STAIRS))
      .rewards(AdvancementRewards.Builder.experience(20))
      .build(consumer, StalAlloys.MOD_ID + "/nickel-decorative-blocks");

    AdvancementEntry copperTools = Advancement.Builder.create().parent(alloySmelterRoot)
      .display(
        StalAlloysItems.COPPER_PICKAXE,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_copper_tools_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_copper_tools_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("copper_sword_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.COPPER_SWORD))
      .criterion("copper_pickaxe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.COPPER_PICKAXE))
      .criterion("copper_axe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.COPPER_AXE))
      .criterion("copper_shovel_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.COPPER_SHOVEL))
      .criterion("copper_hoe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.COPPER_HOE))
      .rewards(AdvancementRewards.Builder.experience(20))
      .build(consumer, StalAlloys.MOD_ID + "/copper-tools");

    
    AdvancementEntry steelTools = Advancement.Builder.create().parent(alloysSteel)
      .display(
        StalAlloysItems.STEEL_PICKAXE,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_steel_tools_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_steel_tools_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("steel_pickaxe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_PICKAXE))
      .criterion("steel_axe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_AXE))
      .criterion("steel_shovel_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_SHOVEL))
      .criterion("steel_hoe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STEEL_HOE))
      .rewards(AdvancementRewards.Builder.experience(20))
      .build(consumer, StalAlloys.MOD_ID + "/steel-tools");
    
    AdvancementEntry bronzeWeapons = Advancement.Builder.create().parent(alloysBronze)
      .display(
        StalAlloysItems.BRONZE_SWORD,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_bronze_weapons_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_bronze_weapons_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("bronze_axe_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRONZE_AXE))
      .criterion("bronze_dagger_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRONZE_DAGGER))
      .criterion("bronze_dirk_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRONZE_DIRK))
      .criterion("bronze_sword_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRONZE_SWORD))
      .rewards(AdvancementRewards.Builder.experience(20))
      .build(consumer, StalAlloys.MOD_ID + "/bronze-weapons");

    
    AdvancementEntry brassArmor = Advancement.Builder.create().parent(alloysBrass)
      .display(
        StalAlloysItems.BRASS_CHESTPLATE,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_brass_armor_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_brass_armor_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("brass_helment_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRASS_HELMET))
      .criterion("brass_chestplate_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRASS_CHESTPLATE))
      .criterion("brass_leggings_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRASS_LEGGINGS))
      .criterion("brass_boots_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.BRASS_BOOTS))
      .rewards(AdvancementRewards.Builder.experience(18))
      .build(consumer, StalAlloys.MOD_ID + "/brass-armor");

    AdvancementEntry stainlessSteelArmor = Advancement.Builder.create().parent(alloysStainlessSteel)
      .display(
        StalAlloysItems.STAINLESS_STEEL_CHESTPLATE,
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_stainless_steel_armor_title_text"),
        Text.translatable(StalAlloys.MOD_ID + ":" + "advancement_stainless_steel_armor_description_text"),
        null,
        AdvancementFrame.GOAL,
        true,
        true,
        false        
      )
      .criterion("stainless_steel_helment_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STAINLESS_STEEL_HELMET))
      .criterion("stainless_steel_chestplate_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STAINLESS_STEEL_CHESTPLATE))
      .criterion("stainless_steel_leggings_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STAINLESS_STEEL_LEGGINGS))
      .criterion("stainless_steel_boots_crafted", InventoryChangedCriterion.Conditions.items(StalAlloysItems.STAINLESS_STEEL_BOOTS))
      .rewards(AdvancementRewards.Builder.experience(35))
      .build(consumer, StalAlloys.MOD_ID + "/stainless-steel-armor");
  }
}