package net.stal.alloys;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.stal.alloys.datagen.*;
import net.stal.alloys.world.StalAlloysConfiguredFeatures;
import net.stal.alloys.world.StalAlloysPlacedFeatures;

public class StalAlloysDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		StalAlloys.LOGGER.debug("Initializing Data Generator for " + StalAlloys.MOD_ID);

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(StalAlloysLootTableGenerator::new);
		pack.addProvider(StalAlloysWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

		// Frustratingly the lambda is necessary here...
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, (context) -> StalAlloysConfiguredFeatures.bootstrap(context));
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, StalAlloysPlacedFeatures::bootstrap);
	}
}
