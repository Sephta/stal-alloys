package net.stal.alloys.screen;

import net.minecraft.screen.ScreenHandlerType;
import net.stal.alloys.StalAlloys;

public class StalAlloysScreenHandlers {
  public static ScreenHandlerType<AlloySmelterScreenHandler> ALLOY_SMELTER_SCREEN_HANDLER;

  public static void registerModScreenHandlers() {
    StalAlloys.LOGGER.debug("Registering screen handlers for " + StalAlloys.MOD_ID);

    ALLOY_SMELTER_SCREEN_HANDLER = new ScreenHandlerType<>(AlloySmelterScreenHandler::new);
  }
}
