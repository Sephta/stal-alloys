package net.stal.alloys.event;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.networking.StalAlloysMessages;

public class KeyInputHandler {
  public static final String KEY_CATEGORY_EXAMPLE = "key.category." + StalAlloys.MOD_ID + ".example";
  public static final String KEY_EXAMPLE = "key." + StalAlloys.MOD_ID + ".example";

  public static KeyBinding exampleKey;

  public static void registerKeyInputs() {
    StalAlloys.LOGGER.debug("Registering key inputs for " + StalAlloys.MOD_ID);

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      if (exampleKey.wasPressed()) {
        ClientPlayNetworking.send(StalAlloysMessages.C2S_EXAMPLE_ID, PacketByteBufs.create());
      }
    });
  }

  public static void registerKeyBindings() {
    exampleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      KEY_EXAMPLE,           // Translatable Key Name
      InputUtil.Type.KEYSYM, // Key Type
      GLFW.GLFW_KEY_O,       // Default Key Literal (i.e. the "o" key on the keyboard)
      KEY_CATEGORY_EXAMPLE   // Key Category 
    ));

    registerKeyInputs();
  }
}
