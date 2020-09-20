package eu.midnightdust.motschen.dishes.config;

import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "main")
public class MainConfig {

    @Comment(value = "\nEnable Tomatoes\nDefault: true")
    public boolean tomatoes = true;
    @Comment(value = "\nEnable Lettuce\nDefault: true")
    public boolean lettuce = true;
}
