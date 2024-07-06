package eu.midnightdust.motschen.dishes.world;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.utils.RegistryUtils;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OreFeatures {
    public static ConfiguredFeature<?, ?> SALT_ORE_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), DishesMain.SaltOre.getDefaultState(), 9));
    public static PlacedFeature SALT_ORE_PLACED_FEATURE = new PlacedFeature(RegistryEntry.of(SALT_ORE_FEATURE), List.of(CountPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.fixed(120)), BiomePlacementModifier.of()));

    public static void initConfigured(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryUtils.register(context, "salt_ore", SALT_ORE_FEATURE);
    }
    public static void initPlaced(Registerable<PlacedFeature> context) {
        RegistryUtils.register(context, "salt_ore", SALT_ORE_PLACED_FEATURE);
    }
    public static void init() {
        BiomeModifications.addFeature(biome -> (!biome.hasTag(BiomeTags.IS_NETHER) && !biome.hasTag(BiomeTags.END_CITY_HAS_STRUCTURE)),
                GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DishesMain.MOD_ID, "salt_ore")));
    }
}
