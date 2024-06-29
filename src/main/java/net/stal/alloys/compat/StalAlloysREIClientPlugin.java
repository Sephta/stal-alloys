package net.stal.alloys.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.stal.alloys.block.StalAlloysBlocks;
import net.stal.alloys.recipe.AlloySmelterRecipe;
import net.stal.alloys.recipe.AlloySmelterRecipe.AlloySmelterRecipeType;
import net.stal.alloys.screen.AlloySmelterScreen;

public class StalAlloysREIClientPlugin implements REIClientPlugin {

  private static enum ClickableBoundary {
    X(75), 
    Y(30), 
    WIDTH(20), 
    HEIGHT(30); 

    private final int value;
    private ClickableBoundary(int value) {
      this.value = value;
    }
  }

  @Override
  public void registerCategories(CategoryRegistry registry) {
    registry.add(new AlloySmelterCategory());

    registry.addWorkstations(AlloySmelterCategory.ALLOY_SMELTER, EntryStacks.of(StalAlloysBlocks.ALLOY_SMELTER));
  }

  @Override
  public void registerDisplays(DisplayRegistry registry) {
    registry.registerRecipeFiller(AlloySmelterRecipe.class, AlloySmelterRecipeType.INSTANCE, AlloySmelterDisplay::new);
  }

  @Override
  public void registerScreens(ScreenRegistry registry) {
    registry.registerClickArea(
      (screen) -> {
        return new Rectangle(
          ClickableBoundary.X.value, 
          ClickableBoundary.Y.value, 
          ClickableBoundary.WIDTH.value, 
          ClickableBoundary.HEIGHT.value
        );
      }, 
      AlloySmelterScreen.class, AlloySmelterCategory.ALLOY_SMELTER
    );
  }
}
