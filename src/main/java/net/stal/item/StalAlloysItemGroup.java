package net.stal.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stal.StalAlloys;

public class StalAlloysItemGroup {
  public static ItemGroup STAL_ALLOYS;

  public static void registerModItemGroups() {
    StalAlloys.LOGGER.info("Registering Mod Item Groups for " + StalAlloys.MOD_ID);

    STAL_ALLOYS = FabricItemGroup.builder(new Identifier(StalAlloys.MOD_ID, StalAlloys.MOD_ID))
      .displayName(Text.translatable("itemgroup." + StalAlloys.MOD_ID))
      .icon(() -> new ItemStack(StalAlloysItems.RAW_STEEL))
      .build();
  }
}
