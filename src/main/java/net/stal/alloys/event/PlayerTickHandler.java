package net.stal.alloys.event;

import java.util.Random;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.stal.alloys.util.ExamplePersistantData;
import net.stal.alloys.util.IEntityDataSaver;

public class PlayerTickHandler implements ServerTickEvents.StartTick {
  @Override
  public void onStartTick(MinecraftServer server) {
    for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
      // if (new Random().nextFloat() <= 0.005F) {
      //   IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);

      //   ExamplePersistantData.removeData(dataPlayer, 1);
      //   // player.sendMessage(Text.literal("Remove -> amount = 1").fillStyle(Style.EMPTY.withColor(Formatting.GRAY)));
      //   player.sendMessage(Text.literal("Example Data: " + dataPlayer.getPersistantData().getInt(ExamplePersistantData.DATA_ID)).fillStyle(Style.EMPTY.withColor(Formatting.GOLD)), true);
      // }
    }
  }
  
}
