package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.entities.IceCreamTraderSpawn;
import eu.midnightdust.motschen.dishes.world.LootModifier;
import eu.midnightdust.motschen.dishes.world.OreFeatures;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

public class WorldGenInit {
    public static void init() {
        if (DishesConfig.customLoot) {
            LootModifier.init(); }
        if (DishesConfig.saltOre) {
            OreFeatures.init();
        }

        if (DishesConfig.spawnTrader) {
            ServerTickEvents.END_SERVER_TICK.register(minecraftServer -> {
                ServerWorld world = minecraftServer.getOverworld();
                IceCreamTraderSpawn.tick(world);
            });
        }
    }
}
