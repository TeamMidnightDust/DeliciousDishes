package eu.midnightdust.motschen.dishes.compat;

import eu.midnightdust.motschen.dishes.utils.DishGroup;
import net.minecraft.item.Item;

import static eu.midnightdust.motschen.dishes.DishesMain.id;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerItem;

public class Flags {
    public static Item FlagGermany = new Item(new Item.Settings());
    public static Item FlagItaly = new Item(new Item.Settings());
    public static Item FlagUK = new Item(new Item.Settings());
    public static Item FlagUkraine = new Item(new Item.Settings());
    public static Item FlagUSA = new Item(new Item.Settings());
    public static Item LabelVeggie = new Item(new Item.Settings());
    public static Item LabelVegan = new Item(new Item.Settings());
    public static void init() {
        registerItem(id("flag_germany"), FlagGermany, DishGroup.NONE);
        registerItem(id("flag_italy"), FlagItaly, DishGroup.NONE);
        registerItem(id("flag_uk"), FlagUK, DishGroup.NONE);
        registerItem(id("flag_ukraine"), FlagUkraine, DishGroup.NONE);
        registerItem(id("flag_usa"), FlagUSA, DishGroup.NONE);
        registerItem(id("label_veggie"), LabelVeggie, DishGroup.NONE);
        registerItem(id("label_vegan"), LabelVegan, DishGroup.NONE);
    }
}
