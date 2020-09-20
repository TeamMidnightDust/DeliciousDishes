package eu.midnightdust.motschen.dishes.block;

import eu.midnightdust.motschen.dishes.block.blockentity.BirthdayCakeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class Cake extends CakeBlock implements BlockEntityProvider {

    public Cake() {
        super(FabricBlockSettings.copy(Blocks.CAKE).lightLevel(createLightLevelFromBlockState(15)));
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(BITES, 0);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new BirthdayCakeBlockEntity();
    }

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> {
            if (blockState.get(Properties.BITES) == 0) {
                return 15;
            }
            if (blockState.get(Properties.BITES) == 1) {
                return 14;
            }
            else if (blockState.get(Properties.BITES) == 2) {
                return 13;
            }
            else if (blockState.get(Properties.BITES) == 3) {
                return 13;
            }
            else if (blockState.get(Properties.BITES) == 4) {
                return 12;
            }
            else if (blockState.get(Properties.BITES) == 5) {
                return 12;
            }
            else {
                return 11;
            }
        };
    }
}