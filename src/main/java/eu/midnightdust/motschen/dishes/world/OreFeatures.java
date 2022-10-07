package eu.midnightdust.motschen.dishes.world;

import eu.midnightdust.motschen.dishes.DishesMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class OreFeatures {
    private static final ConfiguredFeature<?, ?> SALT_ORE_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES, DishesMain.SaltOre.getDefaultState(),4));
    public static PlacedFeature SALT_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(SALT_ORE_FEATURE),
            List.of(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.fixed(120))
            ));
    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DishesMain.MOD_ID, "salt_ore"), SALT_ORE_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DishesMain.MOD_ID, "placed_salt_ore"), SALT_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(biome -> (!biome.hasTag(BiomeTags.IS_NETHER) && !biome.hasTag(BiomeTags.END_CITY_HAS_STRUCTURE)),
                GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(OreFeatures.SALT_ORE_PLACED_FEATURE).get());
    }
}
