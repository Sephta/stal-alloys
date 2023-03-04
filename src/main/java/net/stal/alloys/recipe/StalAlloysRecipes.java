package net.stal.alloys.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stal.alloys.StalAlloys;

public class StalAlloysRecipes {
  public static void registerRecipes() {
    StalAlloys.LOGGER.debug("Registering recipes for " + StalAlloys.MOD_ID);

    // Alloy Smelter Serializer
    Registry.register(
      Registry.RECIPE_SERIALIZER, 
      new Identifier(StalAlloys.MOD_ID, AlloySmelterRecipe.Serializer.ID), 
      AlloySmelterRecipe.Serializer.INSTANCE
    );

    // Alloy Smelter Type
    Registry.register(
      Registry.RECIPE_TYPE, 
      new Identifier(StalAlloys.MOD_ID, AlloySmelterRecipe.Type.ID), 
      AlloySmelterRecipe.Type.INSTANCE
    );
  }
}
