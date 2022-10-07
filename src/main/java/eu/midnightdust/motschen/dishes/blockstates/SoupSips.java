package eu.midnightdust.motschen.dishes.blockstates;

import net.minecraft.state.property.IntProperty;

public class SoupSips {
    public static final IntProperty SOUP_SIPS;
    static {
        SOUP_SIPS = IntProperty.of("sips", 0, 3);
    }
}
