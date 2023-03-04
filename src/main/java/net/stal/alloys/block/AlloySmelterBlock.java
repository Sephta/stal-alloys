package net.stal.alloys.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stal.alloys.block.entity.AlloySmelterEntity;
import net.stal.alloys.block.entity.StalAlloysBlockEntities;

public class AlloySmelterBlock extends BlockWithEntity {

  protected AlloySmelterBlock(Settings settings) { super(settings); }


  /* BLOCK ENTITY METHODS/MEMBERS */

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  @Override
  public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    if (state.getBlock() != newState.getBlock()) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof AlloySmelterEntity) {
        ItemScatterer.spawn(world, pos, (AlloySmelterEntity)blockEntity);
        world.updateComparators(pos, this);
      }

      super.onStateReplaced(state, world, pos, newState, moved);
    }
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
      BlockHitResult hit) {

        if (!world.isClient()) {
          NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

          if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
          }
        }

    return ActionResult.SUCCESS;
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new AlloySmelterEntity(pos, state);
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state,
      BlockEntityType<T> type) {
    return checkType(type, StalAlloysBlockEntities.ALLOY_SMELTER_ENTITY, AlloySmelterEntity::tick);
  }
}
