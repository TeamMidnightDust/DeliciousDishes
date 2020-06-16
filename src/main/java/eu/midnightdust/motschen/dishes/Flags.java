package eu.midnightdust.motschen.dishes;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Flags {
    public static Item FlagGermany = new Item(new Item.Settings());
    public static Item FlagItaly = new Item(new Item.Settings());
    public static Item FlagBritain = new Item(new Item.Settings());
    public static Item FlagUSA = new Item(new Item.Settings());
    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("dishes","flag_germany"), FlagGermany);
        Registry.register(Registry.ITEM, new Identifier("dishes","flag_italy"), FlagItaly);
        Registry.register(Registry.ITEM, new Identifier("dishes","flag_britain"), FlagBritain);
        Registry.register(Registry.ITEM, new Identifier("dishes","flag_america"), FlagUSA);
    }
}
