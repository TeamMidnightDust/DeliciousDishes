package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.block.Lettuce;
import eu.midnightdust.motschen.dishes.utils.DishGroup;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.dishes.DishesMain.MOD_ID;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerItem;

public class LettuceInit {
    public static final Item Lettuce = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.75f).snack().build()));
    public static final Block LettuceBush = new Lettuce();

    public static void init() {
        registerItem(new Identifier(MOD_ID,"lettuceseed"), new AliasedBlockItem(LettuceBush, new Item.Settings()), DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"lettuce"), Lettuce, DishGroup.MAIN);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID,"lettucebush"), LettuceBush);
    }
}
