package net.stal.alloys.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

public class StalAlloysItemGroup {

  public static ItemGroup STAL_ALLOYS;

  public static void registerItemGroup() {
    STAL_ALLOYS = FabricItemGroup.builder(new Identifier(StalAlloys.MOD_ID, "stal_alloys"))
                    .displayName(Text.translatable("itemGroup" + "." + StalAlloys.MOD_ID))
                    .icon(() -> new ItemStack(StalAlloysBlocks.ALLOY_SMELTER)).build();
  }
}
