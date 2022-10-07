package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.config.DishesConfig;

public class CropInit {
    public static void init() {
        if (DishesConfig.tomatoes) {
            TomatoInit.init();
        }
        if (DishesConfig.lettuce) {
            LettuceInit.init();
        }
    }
}
