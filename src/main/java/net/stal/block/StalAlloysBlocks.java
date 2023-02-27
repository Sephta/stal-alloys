package net.stal.block;

import net.stal.StalAlloys;
import net.stal.item.StalAlloysItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class StalAlloysBlocks {

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

  private static Block registerBlock(String name, Block block, ItemGroup group) {
    registerBlockItem(name, block, group);

    return Registry.register(Registries.BLOCK, new Identifier(StalAlloys.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group) {
    Item item = Registry.register(
      Registries.ITEM, 
      new Identifier(StalAlloys.MOD_ID, name), 
      new BlockItem(block, new FabricItemSettings())
    );

    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

    return item;
  }

  public static void registerModBlocks() {
    StalAlloys.LOGGER.info("Registering Mod Blocks for " + StalAlloys.MOD_ID);
  }
}
