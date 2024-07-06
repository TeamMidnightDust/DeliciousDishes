package eu.midnightdust.motschen.dishes.block;

import com.mojang.serialization.MapCodec;
import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.blockstates.DishBites;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialFinder;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class Dish extends HorizontalFacingBlock {

    public static final IntProperty DISH_BITES = DishBites.DISH_BITES;
    private static final VoxelShape SHAPE;

    public Dish() {
        super(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(DISH_BITES, 0));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getHungerManager().isNotFull()) {
            if (state.get(DISH_BITES) == 4) {
                world.setBlockState(pos, DishesMain.Plate.getDefaultState());
                player.getHungerManager().add(2, 1);
                return ActionResult.SUCCESS;
            }
            world.setBlockState(pos, state.with(DISH_BITES, state.get(DISH_BITES) + 1));
            player.getHungerManager().add(2, 4);
            return ActionResult.SUCCESS;
        }
        else {
            return ActionResult.FAIL;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(FACING, itemPlacementContext.getHorizontalPlayerFacing().getOpposite())
                .with(DISH_BITES, 0);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, DISH_BITES);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        SHAPE = createCuboidShape(0, 0, 0, 16, 5, 16);
    }
    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
