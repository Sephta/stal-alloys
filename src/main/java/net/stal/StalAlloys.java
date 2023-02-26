package net.stal;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StalAlloys implements ModInitializer {
	public static final String MOD_ID = "stal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final  Item STEEL_INGOT = 
	Registry.register(
		Registries.ITEM, 
		new Identifier("stal", "steel_ingot"), 
		new Item(new FabricItemSettings())
	);

	// new SteelIngot(new FabricItemSettings());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initializing mod: " + MOD_ID);

		// Adding items to ItemGroups
		// ItemGroupEvents.modifyEntriesEvent(ItemGroups.)
	}
}
