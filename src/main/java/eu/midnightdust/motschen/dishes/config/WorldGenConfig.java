package eu.midnightdust.motschen.dishes.config;

import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "trader")
public class WorldGenConfig {

    @Comment(value = "\nEnable Salt Ore\nDefault: true")
    public boolean salt_ore = true;

    @Comment(value = "\nEnable Custom Loot\nDefault: true")
    public boolean loot = true;
}
