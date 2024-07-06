package eu.midnightdust.motschen.dishes.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class DishesConfig extends MidnightConfig {
    public static final String FEATURES = "features";
    @Entry(category = FEATURES) public static boolean spawnTrader = true;
    @Entry(category = FEATURES) public static boolean tomatoes = true;
    @Entry(category = FEATURES) public static boolean lettuce = true;
    @Entry(category = FEATURES) public static boolean saltOre = true;
    @Entry(category = FEATURES) public static boolean customLoot = true;
    @Entry(category = FEATURES) public static boolean enableMeatDishes = true;
}
