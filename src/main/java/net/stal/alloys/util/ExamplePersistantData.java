package net.stal.alloys.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.stal.alloys.networking.StalAlloysMessages;

public class ExamplePersistantData {
  public static final String DATA_ID = "example_data";
  
  public static int addData(IEntityDataSaver player, int amount) {
    NbtCompound nbt = player.getPersistantData();

    // Get and mutate the data (add)
    int data = nbt.getInt(DATA_ID);

    if (data + amount > 10) {
      data = 10;
    } else {
      data += amount;
    }

    nbt.putInt(DATA_ID, data);

    syncExamplePersistantData(data, ((ServerPlayerEntity) player));

    return data;
  }

  public static int removeData(IEntityDataSaver player, int amount) {
    NbtCompound nbt = player.getPersistantData();

    // Get and mutate the data (remove)
    int data = nbt.getInt(DATA_ID);
    
    if (data - amount < 0) {
      data = 0;
    } else {
      data -= amount;
    }

    nbt.putInt(DATA_ID, data);

    syncExamplePersistantData(data, ((ServerPlayerEntity) player));

    return data;
  }

  public static void syncExamplePersistantData(int data, ServerPlayerEntity player) {
    PacketByteBuf buf = PacketByteBufs.create();

    buf.writeInt(data);

    ServerPlayNetworking.send(player, StalAlloysMessages.S2C_EXAMPLE_ID, buf);
  }
}
