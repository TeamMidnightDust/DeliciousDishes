package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.block.Lettuce;
import eu.midnightdust.motschen.dishes.utils.DishGroup;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static eu.midnightdust.motschen.dishes.DishesMain.id;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerItem;

public class LettuceInit {
    public static final Item Lettuce = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.75f).snack().build()));
    public static final Block LettuceBush = new Lettuce();

    public static void init() {
        registerItem(id("lettuceseed"), new AliasedBlockItem(LettuceBush, new Item.Settings()), DishGroup.MAIN);
        registerItem(id("lettuce"), Lettuce, DishGroup.MAIN);
        Registry.register(Registries.BLOCK, id("lettucebush"), LettuceBush);
    }
}
