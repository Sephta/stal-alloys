package net.stal.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.stal.StalAlloys;

public class StalAlloysWorldGenerator extends FabricDynamicRegistryProvider {

  public StalAlloysWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
  
  @Override
  protected void configure(WrapperLookup registries, Entries entries) {
    entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
    entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
  }

  @Override
  public String getName() { return StalAlloys.MOD_ID; }
}
