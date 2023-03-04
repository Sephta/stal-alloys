package net.stal.alloys;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.stal.alloys.datagen.StalAlloysLootTableGenerator;

public class StalAlloysDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		StalAlloys.LOGGER.debug("Initializing Data Generator for " + StalAlloys.MOD_ID);

		fabricDataGenerator.addProvider(StalAlloysLootTableGenerator::new);
	}
}
