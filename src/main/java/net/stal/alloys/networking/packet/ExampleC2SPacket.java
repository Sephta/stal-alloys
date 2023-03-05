package net.stal.alloys.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.stal.alloys.util.ExamplePersistantData;
import net.stal.alloys.util.IEntityDataSaver;

public class ExampleC2SPacket {
  public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, 
                            PacketByteBuf buf, PacketSender responseSender) {
    // Everything here happens on the server
    ExamplePersistantData.addData(((IEntityDataSaver) player), 1);

    // player.sendMessage(Text.literal("Add -> amount = 1").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)));
    player.sendMessage(Text.literal("Example Data: " + ((IEntityDataSaver) player).getPersistantData().getInt(ExamplePersistantData.DATA_ID)).fillStyle(Style.EMPTY.withColor(Formatting.GOLD)), true);

    // Sync data with server
    ExamplePersistantData.syncExamplePersistantData(((IEntityDataSaver) player).getPersistantData().getInt(ExamplePersistantData.DATA_ID), player);
  }
}
