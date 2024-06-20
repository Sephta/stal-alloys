package net.stal.alloys.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;
import net.stal.alloys.item.StalAlloysItems;

public class StalAlloysItemTagProvider extends FabricTagProvider.ItemTagProvider {

  public StalAlloysItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void configure(WrapperLookup arg) {
    getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
      .add(
        StalAlloysItems.STAINLESS_STEEL_HELMET, 
        StalAlloysItems.STAINLESS_STEEL_CHESTPLATE, 
        StalAlloysItems.STAINLESS_STEEL_LEGGINGS, 
        StalAlloysItems.STAINLESS_STEEL_BOOTS,
        StalAlloysItems.BRASS_HELMET,
        StalAlloysItems.BRASS_CHESTPLATE,
        StalAlloysItems.BRASS_LEGGINGS,
        StalAlloysItems.BRASS_BOOTS
      );
  }
  
}
