package net.stal.alloys;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.stal.alloys.screen.AlloySmelterScreen;
import net.stal.alloys.screen.StalAlloysScreenHandlers;

public class StalAlloysClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    HandledScreens.register(StalAlloysScreenHandlers.ALLOY_SMELTER_SCREEN_HANDLER, AlloySmelterScreen::new);
  }
  
}
