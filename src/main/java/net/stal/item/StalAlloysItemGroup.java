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

    STAL_ALLOYS = FabricItemGroup.builder(new Identifier(StalAlloys.MOD_ID, "stal"))
      .displayName(Text.translatable("itemgroup.stal"))
      .icon(() -> new ItemStack(StalAlloysItems.RAW_STEEL))
      .build();
  }
}
