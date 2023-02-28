package net.stal.alloys;

import net.fabricmc.api.ModInitializer;
import net.stal.alloys.item.StalAlloysItems;
import net.stal.alloys.world.StalAlloysConfiguredFeatures;
import net.stal.alloys.world.gen.StalAlloysOreGeneration;
import net.stal.alloys.block.StalAlloysBlocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StalAlloys implements ModInitializer {
	public static final String MOD_ID = "stal-alloys";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.debug("Initializing mod: " + MOD_ID);

		// Registries
		
		// Must be called first
		StalAlloysConfiguredFeatures.registerConfiguredFeatures();

		StalAlloysItems.registerModItems();
		StalAlloysBlocks.registerModBlocks();

		StalAlloysOreGeneration.generateOres();

		// Other stuff...
	}
}