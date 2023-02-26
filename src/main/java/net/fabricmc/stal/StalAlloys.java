package net.fabricmc.stal;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StalAlloys implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final  Item STEEL_INGOT = Registry.register(
		Registries.ITEM, 
		new Identifier("stal", "steel_ingot"), 
		new Item(new FabricItemSettings())
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello World - STAL ALLOYS!");

	}
}
