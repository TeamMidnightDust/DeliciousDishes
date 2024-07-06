package eu.midnightdust.motschen.dishes.utils;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.item.DishItem;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

import static eu.midnightdust.motschen.dishes.DishesMain.id;

public class RegistryUtils {
    public static void registerBlockWithItem(Identifier id, Block block, DishGroup group) {
        Registry.register(Registries.BLOCK, id, block);
        registerItem(id, new BlockItem(block, new Item.Settings()), group);
    }
    public static void registerDishWithItem(Identifier id, Block block, DishGroup group, int hunger, float saturation) {
        Registry.register(Registries.BLOCK, id, block);
        registerItem(id, new DishItem(block, new Item.Settings().food(new FoodComponent.Builder().nutrition(hunger).saturationModifier(saturation).build())), group);
    }
    public static void registerItem(Identifier id, Item item, DishGroup group) {
        Registry.register(Registries.ITEM, id, item);
        List<ItemStack> groupItems = DishesMain.itemGroupMap.containsKey(group) ? DishesMain.itemGroupMap.get(group) : Lists.newArrayList();
        groupItems.add(new ItemStack(item));
        DishesMain.itemGroupMap.put(group, groupItems);
    }
    public static void register(Registerable<ConfiguredFeature<?, ?>> context, String name, ConfiguredFeature<?, ?> feature) {
        context.register(RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, id(name)), feature);
    }
    public static void register(Registerable<PlacedFeature> context, String name, PlacedFeature feature) {
        context.register(RegistryKey.of(RegistryKeys.PLACED_FEATURE, id(name)), feature);
    }
}
