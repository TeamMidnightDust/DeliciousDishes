package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.block.Lettuce;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LettuceInit {
    public static final Item Lettuce = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.75f).snack().build()));
    public static final Block LettuceBush = new Lettuce();

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("dishes","lettuceseed"), new AliasedBlockItem(LettuceBush, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("dishes","lettuce"), Lettuce);
        Registry.register(Registry.BLOCK, new Identifier("dishes","lettucebush"), LettuceBush);
    }
}
