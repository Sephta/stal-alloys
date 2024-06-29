package net.stal.alloys.compat;

import java.util.LinkedList;
import java.util.List;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

public class AlloySmelterCategory implements DisplayCategory<BasicDisplay> {
  public static final CategoryIdentifier<AlloySmelterDisplay> ALLOY_SMELTER = CategoryIdentifier.of(StalAlloys.MOD_ID, "alloy_smelter");
  
  @Override
  public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
    return ALLOY_SMELTER;
  }

  @Override
  public Text getTitle() {
    return Text.translatable("container.stal-alloys.alloy_smelter");
  }

  @Override
  public Renderer getIcon() {
    return EntryStacks.of(StalAlloysBlocks.ALLOY_SMELTER.asItem().getDefaultStack());
  }

  @Override
  public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {

    AlloySmelterDisplay alloySmelterDisplay = (display instanceof AlloySmelterDisplay ? (AlloySmelterDisplay)display : null);

    if (alloySmelterDisplay == null) {
      String errorMessage = "Display object provided to \"setupDisplay\" method in " + AlloySmelterCategory.class.toString() + " is not of type " + AlloySmelterDisplay.class.toString();

      StalAlloys.LOGGER.error(errorMessage);
      throw new NullPointerException(errorMessage);
    }
    final Point startPoint = new Point(
      bounds.getCenterX() - (StalAlloysREIWidgetData.backgroundTextureWidth / 2), 
      bounds.getCenterY() - (StalAlloysREIWidgetData.backgroundTextureHeight / 2)
    );

    List<Widget> widgets = new LinkedList<Widget>();

    widgets.add(
      Widgets.createTexturedWidget(
        StalAlloysREIWidgetData.WIDGET_BACKGROUND_TEXTURE, 
        new Rectangle(
          startPoint.x, 
          startPoint.y, 
          StalAlloysREIWidgetData.backgroundTextureWidth, 
          StalAlloysREIWidgetData.backgroundTextureHeight
        )
      )
    );

    // Input slot A
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 39, startPoint.y + 5)).entries(display.getInputEntries().get(0)
      )
    );

    // Input slot B
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 39, startPoint.y + 28)).entries(display.getInputEntries().get(1)
      )
    );

    // animated progress arrow
    widgets.add(Widgets.createArrow(new Point(startPoint.x + 65, startPoint.y + 20)).animationDurationTicks(alloySmelterDisplay.getCookingTime()));

    // Output slot
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 100, startPoint.y + 20)).markOutput().entries(display.getOutputEntries().get(0)
      )
    );

    // There are 20 ticks in a real life second
    final int cookingTimeInSeconds = alloySmelterDisplay.getCookingTime()/20;

    // Label with recipe info
    widgets.add(
      Widgets.createLabel(
        new Point(startPoint.x + 105, startPoint.y + 5),
        Text.literal(alloySmelterDisplay.getExperience() + " XP in " + cookingTimeInSeconds + " sec")
      )
    );

    return widgets;
  }

  @Override
  public int getDisplayHeight() {
    return StalAlloysREIWidgetData.backgroundTextureHeight;
  }

  @Override
  public int getDisplayWidth(BasicDisplay display) {
    return StalAlloysREIWidgetData.backgroundTextureWidth;
  }
  
}
