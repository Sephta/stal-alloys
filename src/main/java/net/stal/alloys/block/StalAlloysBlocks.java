package net.stal.alloys.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.item.StalAlloysItemGroup;

public class StalAlloysBlocks {

  // Block: Steel
  public static final Block STEEL_ORE = registerBlock(
    "steel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.STONE)
        .strength(3.0F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(3, 8)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block DEEPSLATE_STEEL_ORE = registerBlock(
    "deepslate_steel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.DEEPSLATE)
        .strength(4.5F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block NETHERRACK_STEEL_ORE = registerBlock(
    "netherrack_steel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.NETHERRACK)
        .strength(0.4F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block ENDSTONE_STEEL_ORE = registerBlock(
    "endstone_steel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.STONE)
        .strength(3.0F, 9.0F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block STEEL_BLOCK = registerBlock(
    "steel_block", 
    new Block(
      FabricBlockSettings
        .of(Material.METAL)
        .sounds(BlockSoundGroup.METAL)
        .strength(5.0F, 8.0F)
        .requiresTool()
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  // Block: Nickel
  public static final Block NICKEL_ORE = registerBlock(
    "nickel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.STONE)
        .strength(3.0F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(3, 8)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block DEEPSLATE_NICKEL_ORE = registerBlock(
    "deepslate_nickel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.DEEPSLATE)
        .strength(4.5F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block NETHERRACK_NICKEL_ORE = registerBlock(
    "netherrack_nickel_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.NETHERRACK)
        .strength(0.4F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  // Block: Chromium
  public static final Block CHROMIUM_ORE = registerBlock(
    "chromium_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.STONE)
        .strength(3.0F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(3, 8)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block DEEPSLATE_CHROMIUM_ORE = registerBlock(
    "deepslate_chromium_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.DEEPSLATE)
        .strength(4.5F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block NETHERRACK_CHROMIUM_ORE = registerBlock(
    "netherrack_chromium_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.NETHERRACK)
        .strength(0.4F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  // Block: Carbon
  public static final Block CARBON_ORE = registerBlock(
    "carbon_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.STONE)
        .strength(3.0F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(3, 8)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  public static final Block DEEPSLATE_CARBON_ORE = registerBlock(
    "deepslate_carbon_ore", 
    new OreBlock(
      FabricBlockSettings
        .of(Material.STONE)
        .sounds(BlockSoundGroup.DEEPSLATE)
        .strength(4.5F, 8.0F)
        .requiresTool(),
      UniformIntProvider.create(4, 9)
    ),
    StalAlloysItemGroup.STAL_ALLOYS
  );

  private static Block registerBlock(String name, Block block, ItemGroup group) {
    registerBlockItem(name, block, group);

    return Registry.register(Registry.BLOCK, new Identifier(StalAlloys.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group) {
    return Registry.register(Registry.ITEM, new Identifier(StalAlloys.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
  }

  public static void registerModBlocks() {
    StalAlloys.LOGGER.debug("Registering Blocks for " + StalAlloys.MOD_ID);
  }
}
