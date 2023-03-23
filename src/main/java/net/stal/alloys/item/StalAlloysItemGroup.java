package net.stal.alloys.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

public class StalAlloysItemGroup {
  public static ItemGroup STAL_ALLOYS = FabricItemGroupBuilder.build(
    new Identifier(StalAlloys.MOD_ID, "stal_alloys"), () -> new ItemStack(StalAlloysBlocks.ALLOY_SMELTER)
  );
}
