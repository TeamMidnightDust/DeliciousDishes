package eu.midnightdust.motschen.dishes.entities;

import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

public class IceCreamTraderSpawn {
    public static void tick(ServerWorld serverWorld) {

            if (serverWorld.getGameRules().getBoolean(GameRules.DO_TRADER_SPAWNING)) {
                if (serverWorld.getTimeOfDay() % (24000 * 3) == 1500) {
                    if (serverWorld.getRandom().nextInt(100) < 10) {
                        spawnTrader(serverWorld);
                    }
                }
            }
    }

    private static void spawnTrader(ServerWorld serverWorld) {
        PlayerEntity playerentity = serverWorld.getRandomAlivePlayer();
        ServerWorldProperties serverWorldProperties = serverWorld.getServer().getSaveProperties().getMainWorldProperties();
        if (playerentity != null) {
            BlockPos blockPos = playerentity.getBlockPos();
            PointOfInterestStorage pointOfInterestStorage = serverWorld.getPointOfInterestStorage();
            Optional<BlockPos> optional = pointOfInterestStorage.getPosition(PointOfInterestType.MEETING.getCompletionCondition(), (blockPosX) -> true, blockPos, 48, PointOfInterestStorage.OccupationStatus.ANY);
            BlockPos blockPos2 = optional.orElse(blockPos);
            BlockPos blockPos3 = getLlamaSpawnPosition(serverWorld, blockPos2, 48);
            if (blockPos3 != null && wontSuffocateAt(serverWorld, blockPos3)) {
                IceCreamTraderEntity traderEntity = IceCreamTraderInit.ICE_CREAM_TRADER.spawn(serverWorld, (CompoundTag) null, (Text) null, (PlayerEntity) null, blockPos3, SpawnReason.EVENT, false, false);
                if (traderEntity != null) {
                    serverWorldProperties.setWanderingTraderId(traderEntity.getUuid());
                    traderEntity.setDespawnDelay(32000);
                    traderEntity.setWanderTarget(blockPos2);
                    traderEntity.setPositionTarget(blockPos2, 16);
                }
            }
        }
    }

    private static BlockPos getLlamaSpawnPosition(WorldView worldView, BlockPos blockPos, int i) {
        Random random = new Random();
        BlockPos blockPos2 = null;
        for (int j = 0; j < 10; ++j) {
            int k = blockPos.getX() + random.nextInt(i * 2) - i;
            int l = blockPos.getZ() + random.nextInt(i * 2) - i;
            int m = worldView.getTopY(Heightmap.Type.WORLD_SURFACE, k, l);
            BlockPos blockPos3 = new BlockPos(k, m, l);
            if (SpawnHelper.canSpawn(SpawnRestriction.Location.ON_GROUND, worldView, blockPos3, EntityType.WANDERING_TRADER)) {
                blockPos2 = blockPos3;
                break;
            }
        }
        return blockPos2;
    }


    private static boolean wontSuffocateAt(BlockView blockView, BlockPos blockPos) {
        Iterator var3 = BlockPos.iterate(blockPos, blockPos.add(1, 2, 1)).iterator();
        BlockPos blockPos2;
        do {
            if (!var3.hasNext()) {
                return true;
            }
            blockPos2 = (BlockPos) var3.next();
        } while (blockView.getBlockState(blockPos2).getCollisionShape(blockView, blockPos2).isEmpty());
        return false;
    }


}
