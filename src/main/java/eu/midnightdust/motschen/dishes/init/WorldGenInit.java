package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.entities.IceCreamTraderSpawn;
import eu.midnightdust.motschen.dishes.world.LootModifier;
import eu.midnightdust.motschen.dishes.world.OreFeatureInjector;
import eu.midnightdust.motschen.dishes.world.OreFeatures;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

public class WorldGenInit {
    private static final DishesConfig config = AutoConfig.getConfigHolder(DishesConfig.class).getConfig();

    public static void init() {
        if (config.trader.enabled == true) {
            IceCreamTraderInit.init();
        }
        if (config.worldgen.loot == true) { LootModifier.init(); }
        if (config.worldgen.salt_ore == true) {
            OreFeatures.init();
            OreFeatureInjector.init();
        }

        if (config.trader.enabled == true && config.trader.spawntrader == true) {
            ServerTickEvents.END_SERVER_TICK.register(minecraftServer -> {
                ServerWorld world = minecraftServer.getOverworld();
                IceCreamTraderSpawn.tick(world);
            });
        }
    }
}
