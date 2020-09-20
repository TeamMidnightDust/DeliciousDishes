package eu.midnightdust.motschen.dishes.blockstates;

import net.minecraft.state.property.IntProperty;

public class DishBites {
    public static final IntProperty DISH_BITES;
    static {
        DISH_BITES = IntProperty.of("bites", 0, 4);
    }
}
