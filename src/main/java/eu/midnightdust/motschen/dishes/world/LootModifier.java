package eu.midnightdust.motschen.dishes.world;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.init.LettuceInit;
import eu.midnightdust.motschen.dishes.init.TomatoInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class LootModifier {
    public static void init() {
        if (FabricLoader.getInstance().isModLoaded("ad_astra")) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("ad_astra") && id.getPath().contains("loot_tables") && id.getPath().contains("chests")) {
                    LootPool.Builder spaceburger = LootPool.builder()
                            .rolls(UniformLootNumberProvider.create(0, 2))
                            .conditionally(RandomChanceLootCondition.builder(0.5f).build())
                            .with(ItemEntry.builder(DishesMain.Spaceburger));
                    supplier.pool(spaceburger);
                }
            });
        }
        if (FabricLoader.getInstance().isModLoaded("patchouli")) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    LootPool.Builder patchouli = LootPool.builder()
                            .rolls(UniformLootNumberProvider.create(0, 1))
                            .conditionally(RandomChanceLootCondition.builder(0.5f).build())
                            .with(ItemEntry.builder(DishesMain.CookingGuide));
                    supplier.pool(patchouli);
                }
            });
        }
        if (DishesConfig.tomatoes) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    LootPool.Builder tomato = LootPool.builder()
                            .rolls(UniformLootNumberProvider.create(0, 5))
                            .conditionally(RandomChanceLootCondition.builder(0.5f).build())
                            .with(ItemEntry.builder(TomatoInit.Tomato));
                    supplier.pool(tomato);
                }
            });
        }
        if (DishesConfig.lettuce) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    LootPool.Builder lettuce = LootPool.builder()
                            .rolls(UniformLootNumberProvider.create(0, 5))
                            .conditionally(RandomChanceLootCondition.builder(0.5f).build())
                            .with(ItemEntry.builder(LettuceInit.Lettuce));
                    supplier.pool(lettuce);
                }
            });
        }
    }
}
