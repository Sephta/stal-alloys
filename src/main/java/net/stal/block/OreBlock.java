package net.stal.block;

import java.util.List;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;

public class OreBlock extends ExperienceDroppingBlock {
  public OreBlock(Settings settings, UniformIntProvider uIntProvider) {
    super(settings, uIntProvider);
  }

  @Override
  public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
    if (Screen.hasShiftDown()) {
      tooltip.add(Text.literal("This is a STAL Ore Block.").formatted(Formatting.LIGHT_PURPLE));
    } else {
      tooltip.add(Text.literal("Press SHIFT for more info.").formatted(Formatting.ITALIC));
    }
    
    super.appendTooltip(stack, world, tooltip, options);
  }
}
