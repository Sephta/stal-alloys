package net.stal;

import net.fabricmc.api.ModInitializer;
import net.stal.block.StalAlloysBlocks;
import net.stal.item.StalAlloysItemGroup;
import net.stal.item.StalAlloysItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StalAlloys implements ModInitializer {
	public static final String MOD_ID = "stal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod: " + MOD_ID);
		StalAlloysItemGroup.registerModItemGroups();
		StalAlloysItems.registerModItems();
		StalAlloysBlocks.registerModBlocks();
	}
}
