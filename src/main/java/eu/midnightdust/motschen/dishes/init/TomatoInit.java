package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.block.Tomato;
import eu.midnightdust.motschen.dishes.utils.DishGroup;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static eu.midnightdust.motschen.dishes.DishesMain.id;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerItem;

public class TomatoInit {
    public static final Item Tomato = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(1f).snack().build()));
    public static final Block TomatoBush = new Tomato();

    public static void init() {
        registerItem(id("tomatoseed"), new AliasedBlockItem(TomatoBush, new Item.Settings()), DishGroup.MAIN);
        registerItem(id("tomato"), Tomato, DishGroup.MAIN);
        Registry.register(Registries.BLOCK, id("tomatobush"), TomatoBush);
    }
}
