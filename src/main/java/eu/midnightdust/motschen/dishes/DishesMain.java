package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.block.*;
import eu.midnightdust.motschen.dishes.blockstates.DishBites;
import eu.midnightdust.motschen.dishes.compat.CookingGuideItem;
import eu.midnightdust.motschen.dishes.compat.Flags;
import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.init.CropInit;
import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import eu.midnightdust.motschen.dishes.init.WorldGenInit;
import eu.midnightdust.motschen.dishes.item.DishItem;
import eu.midnightdust.motschen.dishes.item.IceCreamItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DishesMain implements ModInitializer {
    public static final String MOD_ID = "dishes";

    public static final ItemGroup MainGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"), () -> new ItemStack(DishesMain.CheeseRoll));
    public static final ItemGroup DishesGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "dishes"), () -> new ItemStack(DishesMain.FishAndChips));
    public static final ItemGroup PizzaGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "pizza"), () -> new ItemStack(DishesMain.PizzaSalami));
    public static final ItemGroup SweetsGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "sweets"), () -> new ItemStack(DishesMain.IceCreamVanilla));
    public static final Item CookingGuide = new CookingGuideItem(new Item.Settings().maxCount(1));
    public static final Block Plate = new Plate();
    public static final Block Bowl = new Bowl();
    public static final Block PizzaBox = new Plate();
    public static final Block PotatoesWithCurdCheese = new Dish();
    public static final Block TinyPotatoesWithCurdCheese = new Dish();
    public static final Block Schnitzel = new Dish();
    public static final Block PizzaMargherita = new Pizza();
    public static final Block PizzaSalami = new Pizza();
    public static final Block PizzaHam = new Pizza();
    public static final Block PizzaTuna = new Pizza();
    public static final Block PizzaBacon = new Pizza();
    public static final Block SpaghettiBolognese = new Dish();
    public static final Block Steak = new Dish();
    public static final Block Hamburger = new Dish();
    public static final Block Chickenburger = new Dish();
    public static final Block Cheeseburger = new Dish();
    public static final Block Spaceburger = new Dish();
    public static final Block FishAndChips = new Dish();
    public static final Block Borscht = new Soup();
    public static final Item Knife = new Item(new Item.Settings().group(DishesMain.MainGroup).recipeRemainder(DishesMain.Knife).maxCount(1));
    public static final Item PotatoSlice = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).snack().build()));
    public static final Item RawFries = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build()));
    public static final Item Fries = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).snack().build()));
    public static final Block SaltOre = new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE));
    public static final Item Salt = new Item(new Item.Settings().group(DishesMain.MainGroup));
    public static final Item Flour = new Item(new Item.Settings().group(DishesMain.MainGroup));
    public static final Item RawSpaghetti = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item Spaghetti = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build()));
    public static final Item Salami = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(1f).snack().build()));
    public static final Item RawBacon = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item Bacon = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).build()));
    public static final Item CheeseRoll = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build()));
    public static final Item CheeseSlice = new Item(new Item.Settings().group(DishesMain.MainGroup).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.5f).snack().build()));

    public static final Item IceCreamVanilla = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamChocolate = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamWhiteChocolate = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamStrawberry = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBanana = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamPear = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamSweetberry = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBlueberry = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBubblegum = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamGlowberry = new IceCreamItem(new Item.Settings().group(DishesMain.SweetsGroup).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));

    @Override
    public void onInitialize() {
        DishesConfig.init("dishes", DishesConfig.class);

        new DishBites();

        // General //
        Registry.register(Registry.ITEM, new Identifier("dishes","salt_ore"), new BlockItem(SaltOre, new Item.Settings().group(DishesMain.MainGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","salt_ore"), SaltOre);
        Registry.register(Registry.ITEM, new Identifier("dishes","salt"), Salt);
        Registry.register(Registry.ITEM, new Identifier("dishes","flour"), Flour);
        Registry.register(Registry.ITEM, new Identifier("dishes","knife"), Knife);
        Registry.register(Registry.ITEM, new Identifier("dishes","potato_slice"), PotatoSlice);
        Registry.register(Registry.ITEM, new Identifier("dishes","raw_fries"), RawFries);
        Registry.register(Registry.ITEM, new Identifier("dishes","fries"), Fries);
        Registry.register(Registry.ITEM, new Identifier("dishes","raw_spaghetti"), RawSpaghetti);
        Registry.register(Registry.ITEM, new Identifier("dishes","spaghetti"), Spaghetti);
        Registry.register(Registry.ITEM, new Identifier("dishes","salami"), Salami);
        Registry.register(Registry.ITEM, new Identifier("dishes","raw_bacon"), RawBacon);
        Registry.register(Registry.ITEM, new Identifier("dishes","bacon"), Bacon);
        Registry.register(Registry.ITEM, new Identifier("dishes","cheese_roll"), CheeseRoll);
        Registry.register(Registry.ITEM, new Identifier("dishes","cheese_slice"), CheeseSlice);
        CropInit.init();

        // Dishes //
        Registry.register(Registry.ITEM, new Identifier("dishes","plate"), new DishItem(Plate, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","plate"), Plate);
        Registry.register(Registry.ITEM, new Identifier("dishes","bowl"), new DishItem(Bowl, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","bowl"), Bowl);
        Registry.register(Registry.ITEM, new Identifier("dishes","potatoeswithcurdcheese"), new DishItem(PotatoesWithCurdCheese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","potatoeswithcurdcheese"), PotatoesWithCurdCheese);

        if (FabricLoader.getInstance().isModLoaded("lil_tater") | FabricLoader.getInstance().isModLoaded("liltater") | FabricLoader.getInstance().isModLoaded("ltr"))
            Registry.register(Registry.ITEM, new Identifier("dishes","tinypotatoeswithcurdcheese"), new DishItem(TinyPotatoesWithCurdCheese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        else
            Registry.register(Registry.ITEM, new Identifier("dishes","tinypotatoeswithcurdcheese"), new DishItem(TinyPotatoesWithCurdCheese, new Item.Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));

        Registry.register(Registry.BLOCK, new Identifier("dishes","tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese);

        Registry.register(Registry.ITEM, new Identifier("dishes","schnitzel"), new DishItem(Schnitzel, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","schnitzel"), Schnitzel);
        Registry.register(Registry.ITEM, new Identifier("dishes","spaghetti_bolognese"), new DishItem(SpaghettiBolognese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","spaghetti_bolognese"), SpaghettiBolognese);
        Registry.register(Registry.ITEM, new Identifier("dishes","steak"), new DishItem(Steak, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","steak"), Steak);
        Registry.register(Registry.ITEM, new Identifier("dishes","hamburger"), new DishItem(Hamburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","hamburger"), Hamburger);
        Registry.register(Registry.ITEM, new Identifier("dishes","chickenburger"), new DishItem(Chickenburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","chickenburger"), Chickenburger);
        Registry.register(Registry.ITEM, new Identifier("dishes","cheeseburger"), new DishItem(Cheeseburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","cheeseburger"), Cheeseburger);

        if (FabricLoader.getInstance().isModLoaded("ad_astra"))
            Registry.register(Registry.ITEM, new Identifier("dishes", "spaceburger"), new DishItem(Spaceburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        else
            Registry.register(Registry.ITEM, new Identifier("dishes", "spaceburger"), new DishItem(Spaceburger, new Item.Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));

        Registry.register(Registry.BLOCK, new Identifier("dishes", "spaceburger"), Spaceburger);

        Registry.register(Registry.ITEM, new Identifier("dishes","fishandchips"), new DishItem(FishAndChips, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","fishandchips"), FishAndChips);
        Registry.register(Registry.ITEM, new Identifier("dishes","borscht"), new DishItem(Borscht, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","borscht"), Borscht);

        // Pizza //
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzabox"), new DishItem(PizzaBox, new Item.Settings().group(DishesMain.PizzaGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzabox"), PizzaBox);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzamargherita"), new DishItem(PizzaMargherita, new Item.Settings().group(DishesMain.PizzaGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzamargherita"), PizzaMargherita);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzasalami"), new DishItem(PizzaSalami, new Item.Settings().group(DishesMain.PizzaGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzasalami"), PizzaSalami);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzaham"), new DishItem(PizzaHam, new Item.Settings().group(DishesMain.PizzaGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzaham"), PizzaHam);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzatuna"), new DishItem(PizzaTuna, new Item.Settings().group(DishesMain.PizzaGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzatuna"), PizzaTuna);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzabacon"), new DishItem(PizzaBacon, new Item.Settings().group(DishesMain.PizzaGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzabacon"), PizzaBacon);

        // Ice Cream //
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_vanilla"), IceCreamVanilla);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_chocolate"), IceCreamChocolate);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_white_chocolate"), IceCreamWhiteChocolate);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_strawberry"), IceCreamStrawberry);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_banana"), IceCreamBanana);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_pear"), IceCreamPear);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_sweetberry"), IceCreamSweetberry);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_blueberry"), IceCreamBlueberry);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_bubblegum"), IceCreamBubblegum);
        Registry.register(Registry.ITEM, new Identifier("dishes","ice_cream_glowberry"), IceCreamGlowberry);

        Registry.register(Registry.ITEM, new Identifier("dishes","cooking_guide"), CookingGuide);
        // Compat //
        if (FabricLoader.getInstance().isModLoaded("patchouli")) {
            Flags.init();
        }
        IceCreamTraderInit.init();
        WorldGenInit.init();
    }
}
