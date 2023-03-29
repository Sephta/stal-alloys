package net.stal.alloys.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;

public class StalAlloysScreenHandlers {
  public static ScreenHandlerType<AlloySmelterScreenHandler> ALLOY_SMELTER_SCREEN_HANDLER;

  static {
    ALLOY_SMELTER_SCREEN_HANDLER = new ScreenHandlerType<>(AlloySmelterScreenHandler::new);
  }

  public static void registerModScreenHandlers() {
    StalAlloys.LOGGER.debug("Registering screen handlers for " + StalAlloys.MOD_ID);

    Registry.register(Registries.SCREEN_HANDLER, new Identifier(StalAlloys.MOD_ID, "alloy_smelter"), ALLOY_SMELTER_SCREEN_HANDLER);
  }
}
