package eu.midnightdust.motschen.dishes.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "dishes")
public class DishesConfig implements ConfigData {

    @ConfigEntry.Category("main")
    @ConfigEntry.Gui.TransitiveObject
    public MainConfig main = new MainConfig();

    @ConfigEntry.Category("worldgen")
    @ConfigEntry.Gui.TransitiveObject
    public WorldGenConfig worldgen = new WorldGenConfig();

    @ConfigEntry.Category("trader")
    @ConfigEntry.Gui.TransitiveObject
    public IceCreamTraderConfig trader = new IceCreamTraderConfig();
}
