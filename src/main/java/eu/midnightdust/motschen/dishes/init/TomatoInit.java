package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.block.Tomato;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TomatoInit {
    public static final Item Tomato = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build()));
    public static final Block TomatoBush = new Tomato();

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("dishes","tomatoseed"), new AliasedBlockItem(TomatoBush, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("dishes","tomato"), Tomato);
        Registry.register(Registry.BLOCK, new Identifier("dishes","tomatobush"), TomatoBush);
    }
}
