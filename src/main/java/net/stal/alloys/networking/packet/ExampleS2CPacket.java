package net.stal.alloys.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.stal.alloys.util.ExamplePersistantData;
import net.stal.alloys.util.IEntityDataSaver;

public class ExampleS2CPacket {
  public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
    ((IEntityDataSaver) client.player).getPersistantData().putInt(ExamplePersistantData.DATA_ID, buf.readInt());
  }
}
