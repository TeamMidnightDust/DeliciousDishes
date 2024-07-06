package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.world.OreFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DishesDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WorldGenData::new);
        System.out.println("out");
    }
    @Override
    public String getEffectiveModId() {
        return "dishes";
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        System.out.println("building registry");
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, OreFeatures::initConfigured);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, OreFeatures::initPlaced);

    }
    public static class WorldGenData extends FabricDynamicRegistryProvider {
        public WorldGenData(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
            System.out.println("configure");
            entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
            entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
        }

        @Override
        public String getName() {
            return DishesMain.MOD_ID;
        }
    }
}
