package eu.midnightdust.motschen.dishes;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import static net.minecraft.state.property.Properties.BITES;

public class Dish extends HorizontalFacingBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public Dish() {
        super(FabricBlockSettings.copy(Blocks.CAKE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(BITES, 0));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getHungerManager().isNotFull()) {
            switch (state.get(BITES)) {
                case 0: world.setBlockState(pos, state.with(BITES, 1));
                        player.getHungerManager().add(2, 4);
                        return ActionResult.SUCCESS;
                case 1: world.setBlockState(pos, state.with(BITES, 2));
                        player.getHungerManager().add(2, 4);
                        return ActionResult.SUCCESS;
                case 2: world.setBlockState(pos, state.with(BITES, 3));
                        player.getHungerManager().add(2, 4);
                        return ActionResult.SUCCESS;
                case 3: world.setBlockState(pos, state.with(BITES, 4));
                        player.getHungerManager().add(2, 4);
                        return ActionResult.SUCCESS;
                case 4: world.setBlockState(pos,DishesMain.Plate.getDefaultState());
                        player.getHungerManager().add(2, 1);
                        return ActionResult.SUCCESS;
            }
            return ActionResult.SUCCESS;
        }
        else {
            return ActionResult.FAIL;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(FACING, itemPlacementContext.getPlayerFacing().getOpposite())
                .with(BITES, 0);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(BITES);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH: return NORTH_SHAPE;
            case EAST: return EAST_SHAPE;
            case SOUTH: return SOUTH_SHAPE;
            case WEST: return WEST_SHAPE;
            default: return super.getOutlineShape(state, view, pos, context);
        }
    }
    static {
        VoxelShape shape = createCuboidShape(0, 0, 0, 16, 5, 16);

        EAST_SHAPE = shape;
        NORTH_SHAPE = shape;
        SOUTH_SHAPE = shape;
        WEST_SHAPE = shape;
    }
    private static VoxelShape rotate(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };

        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }
    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

}
