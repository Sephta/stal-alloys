package net.stal.alloys.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.block.entity.AlloySmelterEntity;

public class AlloySmelterScreen extends HandledScreen<AlloySmelterScreenHandler> {

  private static final Identifier ALLOY_SMELTER_SCREEN_TEXTURE = new Identifier(StalAlloys.MOD_ID, "textures/gui/container/alloy_smelter.png");

  public AlloySmelterScreen(AlloySmelterScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }

  protected void init() {
    super.init();

    // Centers the title
    titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
  }

  @Override
  protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    RenderSystem.setShaderTexture(0, ALLOY_SMELTER_SCREEN_TEXTURE);

    int x = (width - backgroundWidth) / 2;
    int y = (height - backgroundHeight) / 2;

    drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    renderProgressionArrow(matrices, x, y);
  }

  private void renderProgressionArrow(MatrixStack matrices, int x, int y) {
    final int progressBarXPos = 66;
    final int progressBarYPos = 34;
    
    if (handler.isCrafting()) {
      drawTexture(
        matrices, 
        x + progressBarXPos, 
        y + progressBarYPos, 
        176, 
        0, 
        handler.getScaledProgress(), 
        AlloySmelterEntity.mAlloySmelterProgressBarHeight
      );
    }
  }

  @Override
  public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
    renderBackground(matrices);
    super.render(matrices, mouseX, mouseY, delta);
    drawMouseoverTooltip(matrices, mouseX, mouseY);
  }
}
