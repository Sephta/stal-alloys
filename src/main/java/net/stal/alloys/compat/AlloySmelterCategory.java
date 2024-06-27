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
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.StalAlloysBlocks;

public class AlloySmelterCategory implements DisplayCategory<BasicDisplay> {
  public static final Identifier TEXTURE = Identifier.of(StalAlloys.MOD_ID, "textures/gui/container/alloy_smelter.png");
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
    int xOffset = 88;
    int yOffset = 35;
    final Point startPoint = new Point(bounds.getCenterX() - xOffset, bounds.getCenterY() - yOffset);

    List<Widget> widgets = new LinkedList<Widget>();

    widgets.add(
      Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82))
    );

    // Input slot A
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 39, startPoint.y + 19)).entries(display.getInputEntries().get(0)
      )
    );

    // Input slot B
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 39, startPoint.y + 48)).entries(display.getInputEntries().get(1)
      )
    );

    // Output slot
    widgets.add(
      Widgets.createSlot(
        new Point(startPoint.x + 121, startPoint.y + 35)).markOutput().entries(display.getOutputEntries().get(0)
      )
    );

    return widgets;
  }

  @Override
  public int getDisplayHeight() {
    return 90;
  }
  
}
