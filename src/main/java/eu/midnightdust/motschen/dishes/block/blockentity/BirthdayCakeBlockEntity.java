package eu.midnightdust.motschen.dishes.block.blockentity;

import eu.midnightdust.motschen.dishes.init.BlockEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

public class BirthdayCakeBlockEntity extends BlockEntity implements Tickable {
    private float flame;

    public BirthdayCakeBlockEntity() {
        super(BlockEntityInit.BirthdayCakeBlockEntity);
    }

    @Override
    public void tick() {
        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);
        flame = flame + 0.5f;
        if (flame == 9) {
            flame = 1;
        }

        if (flame == 5 && state.get(Properties.BITES) < 4) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.15, 0, 0, 0);
        }
        if (flame == 1 && state.get(Properties.BITES) < 2) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.25, pos.getY() + 0.8, pos.getZ() + 0.25, 0, 0, 0);
        }
        if (flame == 7 && state.get(Properties.BITES) < 1) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.15, pos.getY() + 0.8, pos.getZ() + 0.5, 0, 0, 0);
        }
        if (flame == 3 && state.get(Properties.BITES) < 2) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.25, pos.getY() + 0.8, pos.getZ() + 0.75, 0, 0, 0);
        }
        if (flame == 4 && state.get(Properties.BITES) < 4) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.85, 0, 0, 0);
        }
        if (flame == 8 && state.get(Properties.BITES) < 6) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.75, pos.getY() + 0.8, pos.getZ() + 0.75, 0, 0, 0);
        }
        if (flame == 2) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.85, pos.getY() + 0.8, pos.getZ() + 0.5, 0, 0, 0);
        }
        if (flame == 6 && state.get(Properties.BITES) < 6) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.75, pos.getY() + 0.8, pos.getZ() + 0.25, 0, 0, 0);
        }
    }
}
