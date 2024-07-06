package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.block.*;
import eu.midnightdust.motschen.dishes.blockstates.DishBites;
import eu.midnightdust.motschen.dishes.compat.Flags;
import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.init.CropInit;
import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import eu.midnightdust.motschen.dishes.init.WorldGenInit;
import eu.midnightdust.motschen.dishes.item.IceCreamItem;
import eu.midnightdust.motschen.dishes.utils.DishGroup;
import io.wispforest.lavender.book.LavenderBookItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.*;

import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerItem;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerBlockWithItem;
import static eu.midnightdust.motschen.dishes.utils.RegistryUtils.registerDishWithItem;

public class DishesMain implements ModInitializer {
    public static final String MOD_ID = "dishes";
    public static final Map<DishGroup, List<ItemStack>> itemGroupMap = new HashMap<>();
    public static ItemGroup MainGroup;
    public static ItemGroup DishesGroup;
    public static ItemGroup PizzaGroup;
    public static ItemGroup SweetsGroup;
    public static Item CookingGuide;// = new CookingGuideItem(new Item.Settings().maxCount(1));
    public static final Block Plate = new Plate();
    public static final Block Bowl = new Bowl();
    public static final Block PizzaBox = new Plate();
    public static final Block PotatoesWithCurdCheese = new Dish();
    public static final Block TinyPotatoesWithCurdCheese = new Dish();
    public static final Block Schnitzel = new Dish();
    public static final Block PizzaMargherita = new Pizza();
    public static final Block PizzaFungi = new Pizza();
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
    public static final Block Potatoburger = new Dish();
    public static final Block Beetrootburger = new Dish();
    public static final Block FishAndChips = new Dish();
    public static final Block Borscht = new Soup();
    public static final Item Knife = new Item(new Item.Settings().recipeRemainder(DishesMain.Knife).maxCount(1));
    public static final Item PotatoSlice = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).snack().build()));
    public static final Item RawFries = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build()));
    public static final Item Fries = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).snack().build()));
    public static final Block SaltOre = new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE));
    public static final Item Salt = new Item(new Item.Settings());
    public static final Item Flour = new Item(new Item.Settings());
    public static final Item RawSpaghetti = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item Spaghetti = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build()));
    public static final Item Salami = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(1f).snack().build()));
    public static final Item RawBacon = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item Bacon = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).build()));
    public static final Item CheeseRoll = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build()));
    public static final Item CheeseSlice = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.5f).snack().build()));

    public static final Item IceCreamVanilla = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamChocolate = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamWhiteChocolate = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamStrawberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBanana = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamPear = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamSweetberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBlueberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamBubblegum = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));
    public static final Item IceCreamGlowberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build()));

    @Override
    public void onInitialize() {
        DishesConfig.init("dishes", DishesConfig.class);

        new DishBites();

        // General //
        registerBlockWithItem(new Identifier(MOD_ID,"salt_ore"), SaltOre, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"salt"), Salt, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"flour"), Flour, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"knife"), Knife, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"potato_slice"), PotatoSlice, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"raw_fries"), RawFries, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"fries"), Fries, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"raw_spaghetti"), RawSpaghetti, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"spaghetti"), Spaghetti, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"salami"), Salami, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"raw_bacon"), RawBacon, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"bacon"), Bacon, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"cheese_roll"), CheeseRoll, DishGroup.MAIN);
        registerItem(new Identifier(MOD_ID,"cheese_slice"), CheeseSlice, DishGroup.MAIN);
        CropInit.init();

        // Dishes //
        registerBlockWithItem(new Identifier(MOD_ID,"plate"), Plate, DishGroup.DISHES);
        registerBlockWithItem(new Identifier(MOD_ID,"bowl"), Bowl, DishGroup.DISHES);
        registerDishWithItem(new Identifier(MOD_ID,"potatoeswithcurdcheese"), PotatoesWithCurdCheese, DishGroup.DISHES, 10, 1f);

        if (FabricLoader.getInstance().isModLoaded("lil_tater") | FabricLoader.getInstance().isModLoaded("liltater") | FabricLoader.getInstance().isModLoaded("ltr"))
            registerDishWithItem(new Identifier(MOD_ID,"tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese, DishGroup.DISHES, 10, 1f);
        else
            registerDishWithItem(new Identifier(MOD_ID,"tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese, DishGroup.NONE, 10, 1f);

        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(new Identifier(MOD_ID, "schnitzel"), Schnitzel, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "spaghetti_bolognese"), SpaghettiBolognese, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "steak"), Steak, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "hamburger"), Hamburger, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "chickenburger"), Chickenburger, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "cheeseburger"), Cheeseburger, DishGroup.DISHES, 10, 1f);

            if (FabricLoader.getInstance().isModLoaded("ad_astra"))
                registerDishWithItem(new Identifier(MOD_ID, "spaceburger"), Spaceburger, DishGroup.DISHES, 10, 1f);
            else
                registerDishWithItem(new Identifier(MOD_ID, "spaceburger"), Spaceburger, DishGroup.NONE, 10, 1f);

        }
        registerDishWithItem(new Identifier(MOD_ID, "potatoburger"), Potatoburger, DishGroup.DISHES, 10, 1f);
        registerDishWithItem(new Identifier(MOD_ID, "beetrootburger"), Beetrootburger, DishGroup.DISHES, 10, 1f);
        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(new Identifier(MOD_ID, "fishandchips"), FishAndChips, DishGroup.DISHES, 10, 1f);
        }
        registerDishWithItem(new Identifier(MOD_ID,"borscht"), Borscht, DishGroup.DISHES, 10, 1f);

        // Pizza //
        registerBlockWithItem(new Identifier(MOD_ID,"pizzabox"), PizzaBox, DishGroup.PIZZA);
        registerDishWithItem(new Identifier(MOD_ID,"pizzamargherita"), PizzaMargherita, DishGroup.PIZZA, 10, 1f);
        registerDishWithItem(new Identifier(MOD_ID,"pizzafungi"), PizzaFungi, DishGroup.PIZZA, 10, 1f);
        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(new Identifier(MOD_ID, "pizzasalami"), PizzaSalami, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "pizzaham"), PizzaHam, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "pizzatuna"), PizzaTuna, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(new Identifier(MOD_ID, "pizzabacon"), PizzaBacon, DishGroup.PIZZA, 10, 1f);
        }

        // Ice Cream //
        registerItem(new Identifier(MOD_ID,"ice_cream_vanilla"), IceCreamVanilla, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_chocolate"), IceCreamChocolate, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_white_chocolate"), IceCreamWhiteChocolate, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_strawberry"), IceCreamStrawberry, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_banana"), IceCreamBanana, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_pear"), IceCreamPear, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_sweetberry"), IceCreamSweetberry, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_blueberry"), IceCreamBlueberry, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_bubblegum"), IceCreamBubblegum, DishGroup.SWEETS);
        registerItem(new Identifier(MOD_ID,"ice_cream_glowberry"), IceCreamGlowberry, DishGroup.SWEETS);

        // Compat //
        if (FabricLoader.getInstance().isModLoaded("lavender")) {
            Flags.init();
        }
        IceCreamTraderInit.init();
        WorldGenInit.init();
        MainGroup = FabricItemGroup.builder().displayName(Text.translatable("itemGroup.dishes.main")).icon(() -> new ItemStack(DishesMain.CheeseRoll)).entries(((displayContext, entries) -> entries.addAll((itemGroupMap.get(DishGroup.MAIN))))).build();
        DishesGroup = FabricItemGroup.builder().displayName(Text.translatable("itemGroup.dishes.dishes")).icon(() -> new ItemStack(DishesMain.PotatoesWithCurdCheese)).entries(((displayContext, entries) -> entries.addAll((itemGroupMap.get(DishGroup.DISHES))))).build();
        PizzaGroup = FabricItemGroup.builder().displayName(Text.translatable("itemGroup.dishes.pizza")).icon(() -> new ItemStack(DishesMain.PizzaSalami)).entries(((displayContext, entries) -> entries.addAll((itemGroupMap.get(DishGroup.PIZZA))))).build();
        SweetsGroup = FabricItemGroup.builder().displayName(Text.translatable("itemGroup.dishes.sweets")).icon(() -> new ItemStack(DishesMain.IceCreamVanilla)).entries(((displayContext, entries) -> entries.addAll((itemGroupMap.get(DishGroup.SWEETS))))).build();
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "main"), MainGroup);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "dishes"), DishesGroup);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "pizza"), PizzaGroup);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "sweets"), SweetsGroup);
        CookingGuide = LavenderBookItem.registerForBook(new Identifier(MOD_ID, "cooking_guide"), new Item.Settings());
    }
}
