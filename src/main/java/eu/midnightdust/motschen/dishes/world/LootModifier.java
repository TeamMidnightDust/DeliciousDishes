package eu.midnightdust.motschen.dishes.world;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.init.CropInit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class LootModifier {
    private static final DishesConfig config = AutoConfig.getConfigHolder(DishesConfig.class).getConfig();

    public static void init() {
        if (FabricLoader.getInstance().isModLoaded("galacticraft-rewoven")) {
            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("galacticraft-rewoven") && id.getPath().contains("loot_tables") && id.getPath().contains("chests")) {
                    FabricLootPoolBuilder spaceburger = FabricLootPoolBuilder.builder()
                            .rolls(UniformLootTableRange.between(0, 2))
                            .withCondition(RandomChanceLootCondition.builder(1.0f).build())
                            .with(ItemEntry.builder(DishesMain.Spaceburger));
                    supplier.pool(spaceburger);
                }
            });
        }
        if (FabricLoader.getInstance().isModLoaded("patchouli")) {
            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    FabricLootPoolBuilder patchouli = FabricLootPoolBuilder.builder()
                            .rolls(UniformLootTableRange.between(0, 1))
                            .withCondition(RandomChanceLootCondition.builder(1.0f).build())
                            .with(ItemEntry.builder(DishesMain.CookingGuide));
                    supplier.pool(patchouli);
                }
            });
        }
        if (config.main.tomatoes == true) {
            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    FabricLootPoolBuilder tomato = FabricLootPoolBuilder.builder()
                            .rolls(UniformLootTableRange.between(0, 5))
                            .withCondition(RandomChanceLootCondition.builder(1.0f).build())
                            .with(ItemEntry.builder(CropInit.Tomato));
                    supplier.pool(tomato);
                }
            });
        }
        if (config.main.lettuce == true) {
            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.getPath().contains("chests") && id.getPath().contains("village")) {
                    FabricLootPoolBuilder lettuce = FabricLootPoolBuilder.builder()
                            .rolls(UniformLootTableRange.between(0, 5))
                            .withCondition(RandomChanceLootCondition.builder(1.0f).build())
                            .with(ItemEntry.builder(CropInit.Lettuce));
                    supplier.pool(lettuce);
                }
            });
        }
    }
}
