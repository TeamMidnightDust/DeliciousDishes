package eu.midnightdust.motschen.dishes.config;

import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "trader")
public class IceCreamTraderConfig {

    @Comment(value = "\nEnable Ice Cream Trader\nDefault: true")
    public boolean enabled = true;

    @Comment(value = "\nEnable Ice Cream Trader Spawning\nDefault: true")
    public boolean spawntrader = true;
}
