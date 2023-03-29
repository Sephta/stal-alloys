package net.stal.alloys.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;

public class StalAlloysRecipes {
  public static void registerRecipes() {
    StalAlloys.LOGGER.debug("Registering recipes for " + StalAlloys.MOD_ID);

    // Alloy Smelter Serializer
    Registry.register(
      Registries.RECIPE_SERIALIZER, 
      new Identifier(StalAlloys.MOD_ID, AlloySmelterRecipe.Serializer.ID), 
      AlloySmelterRecipe.Serializer.INSTANCE
    );

    // Alloy Smelter Type
    Registry.register(
      Registries.RECIPE_TYPE, 
      new Identifier(StalAlloys.MOD_ID, AlloySmelterRecipe.Type.ID), 
      AlloySmelterRecipe.Type.INSTANCE
    );
  }
}
