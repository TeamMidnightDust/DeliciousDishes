package eu.midnightdust.motschen.dishes.world;

import eu.midnightdust.motschen.dishes.DishesMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreFeatures {
    public static final ConfiguredFeature<?, ?> SALT_ORE_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DishesMain.SaltOre.getDefaultState(), 4)).method_30377(120).spreadHorizontally().repeat(20);

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DishesMain.MOD_ID, "salt_ore"), SALT_ORE_FEATURE);

    }
}
