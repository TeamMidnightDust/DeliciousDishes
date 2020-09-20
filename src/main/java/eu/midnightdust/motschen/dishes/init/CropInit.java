package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.block.Lettuce;
import eu.midnightdust.motschen.dishes.block.Tomato;
import eu.midnightdust.motschen.dishes.config.DishesConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CropInit {
    private static final DishesConfig config = AutoConfig.getConfigHolder(DishesConfig.class).getConfig();

    public static final Item Tomato = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build()));
    public static final Block TomatoBush = new Tomato();
    public static final Item Lettuce = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.75f).snack().build()));
    public static final Block LettuceBush = new Lettuce();

    public static void init() {
        if (config.main.tomatoes == true) {
            Registry.register(Registry.ITEM, new Identifier("dishes","tomatoseed"), new AliasedBlockItem(TomatoBush, new Item.Settings().group(DishesMain.MainGroup)));
            Registry.register(Registry.ITEM, new Identifier("dishes","tomato"), Tomato);
            Registry.register(Registry.BLOCK, new Identifier("dishes","tomatobush"), TomatoBush);
        }
        if (config.main.lettuce == true) {
            Registry.register(Registry.ITEM, new Identifier("dishes","lettuceseed"), new AliasedBlockItem(LettuceBush, new Item.Settings().group(DishesMain.MainGroup)));
            Registry.register(Registry.ITEM, new Identifier("dishes","lettuce"), Lettuce);
            Registry.register(Registry.BLOCK, new Identifier("dishes","lettucebush"), LettuceBush);
        }
    }
}
