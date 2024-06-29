package net.stal.alloys.compat;

import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;

/**
 * A data container housing commonly used information about the recipe widget data for Alloy Smelter recipes used by REI.
 * @see AlloySmelterCategory
 */
public class StalAlloysREIWidgetData {
  public static final Identifier WIDGET_BACKGROUND_TEXTURE = Identifier.of(StalAlloys.MOD_ID, "textures/gui/rei/alloy_smelter_recipe.png");

  public static final int backgroundTextureWidth = 150;
  public static final int backgroundTextureHeight = 51;
}
