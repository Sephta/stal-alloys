package net.stal.alloys.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.networking.packet.*;

public class StalAlloysMessages {
  public static final Identifier C2S_EXAMPLE_ID = new Identifier(StalAlloys.MOD_ID, "example");
  public static final Identifier S2C_EXAMPLE_ID = new Identifier(StalAlloys.MOD_ID, "example_sync");

  /**
   * Register Client to Server packets
   */
  public static void registerC2SPackets() {
    StalAlloys.LOGGER.debug("Registering Client to Server packets for " + StalAlloys.MOD_ID);

    ServerPlayNetworking.registerGlobalReceiver(C2S_EXAMPLE_ID, ExampleC2SPacket::receive);
  }


  /**
   * Register Server to Client packets
   */
  public static void registerS2CPackets() {
    StalAlloys.LOGGER.debug("Registering Server to Client packets for " + StalAlloys.MOD_ID);

    ClientPlayNetworking.registerGlobalReceiver(S2C_EXAMPLE_ID, ExampleS2CPacket::recieve);
  }
}
