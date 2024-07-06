package eu.midnightdust.motschen.dishes.entities;

import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.Heightmap;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.poi.PointOfInterestStorage;

import java.util.Iterator;
import java.util.Optional;

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
            Optional<BlockPos> optional = pointOfInterestStorage.getPosition(RegistryEntry::hasKeyAndValue, (blockPosX) -> true, blockPos, 48, PointOfInterestStorage.OccupationStatus.ANY);
            BlockPos blockPos2 = optional.orElse(blockPos);
            BlockPos blockPos3 = getLlamaSpawnPosition(serverWorld, blockPos2, 48);
            if (blockPos3 != null && wontSuffocateAt(serverWorld, blockPos3)) {
                IceCreamTraderEntity traderEntity = IceCreamTraderInit.ICE_CREAM_TRADER.spawn(serverWorld, blockPos3, SpawnReason.EVENT);
                if (traderEntity != null) {
                    serverWorldProperties.setWanderingTraderId(traderEntity.getUuid());
                    traderEntity.setDespawnDelay(32000);
                    traderEntity.setWanderTarget(blockPos2);
                    traderEntity.setPositionTarget(blockPos2, 16);
                }
            }
        }
    }

    private static BlockPos getLlamaSpawnPosition(ServerWorld worldView, BlockPos blockPos, int i) {
        Random random = worldView.random;
        BlockPos blockPos2 = null;
        for (int j = 0; j < 10; ++j) {
            int k = blockPos.getX() + random.nextInt(i * 2) - i;
            int l = blockPos.getZ() + random.nextInt(i * 2) - i;
            int m = worldView.getTopY(Heightmap.Type.WORLD_SURFACE, k, l);
            BlockPos blockPos3 = new BlockPos(k, m, l);
            if (SpawnRestriction.canSpawn(IceCreamTraderInit.ICE_CREAM_TRADER, worldView, SpawnReason.EVENT, blockPos3, random)) {
                blockPos2 = blockPos3;
                break;
            }
        }
        return blockPos2;
    }


    private static boolean wontSuffocateAt(ServerWorld blockView, BlockPos blockPos) {
        Iterator<BlockPos> var3 = BlockPos.iterate(blockPos, blockPos.add(1, 2, 1)).iterator();
        BlockPos blockPos2;
        do {
            if (!var3.hasNext()) {
                return true;
            }
            blockPos2 = var3.next();
        } while (blockView.getBlockState(blockPos2).getCollisionShape(blockView, blockPos2).isEmpty());
        return false;
    }


}
