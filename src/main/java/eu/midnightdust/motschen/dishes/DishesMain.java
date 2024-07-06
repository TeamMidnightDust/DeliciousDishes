package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.block.Bowl;
import eu.midnightdust.motschen.dishes.block.Dish;
import eu.midnightdust.motschen.dishes.block.Pizza;
import eu.midnightdust.motschen.dishes.block.Plate;
import eu.midnightdust.motschen.dishes.block.Soup;
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
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static final Item PotatoSlice = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).snack().build()));
    public static final Item RawFries = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.75f).snack().build()));
    public static final Item Fries = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).snack().build()));
    public static final Block SaltOre = new Block(AbstractBlock.Settings.copy(Blocks.COAL_ORE));
    public static final Item Salt = new Item(new Item.Settings());
    public static final Item Flour = new Item(new Item.Settings());
    public static final Item RawSpaghetti = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build()));
    public static final Item Spaghetti = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.75f).snack().build()));
    public static final Item Salami = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(1f).snack().build()));
    public static final Item RawBacon = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build()));
    public static final Item Bacon = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.75f).build()));
    public static final Item CheeseRoll = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).build()));
    public static final Item CheeseSlice = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).snack().build()));

    public static final Item IceCreamVanilla = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamChocolate = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamWhiteChocolate = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamStrawberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamBanana = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamPear = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamSweetberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamBlueberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamBubblegum = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));
    public static final Item IceCreamGlowberry = new IceCreamItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build()));

    @Override
    public void onInitialize() {
        DishesConfig.init("dishes", DishesConfig.class);

        new DishBites();

        // General //
        registerBlockWithItem(id("salt_ore"), SaltOre, DishGroup.MAIN);
        registerItem(id("salt"), Salt, DishGroup.MAIN);
        registerItem(id("flour"), Flour, DishGroup.MAIN);
        registerItem(id("knife"), Knife, DishGroup.MAIN);
        registerItem(id("potato_slice"), PotatoSlice, DishGroup.MAIN);
        registerItem(id("raw_fries"), RawFries, DishGroup.MAIN);
        registerItem(id("fries"), Fries, DishGroup.MAIN);
        registerItem(id("raw_spaghetti"), RawSpaghetti, DishGroup.MAIN);
        registerItem(id("spaghetti"), Spaghetti, DishGroup.MAIN);
        registerItem(id("salami"), Salami, DishGroup.MAIN);
        registerItem(id("raw_bacon"), RawBacon, DishGroup.MAIN);
        registerItem(id("bacon"), Bacon, DishGroup.MAIN);
        registerItem(id("cheese_roll"), CheeseRoll, DishGroup.MAIN);
        registerItem(id("cheese_slice"), CheeseSlice, DishGroup.MAIN);
        CropInit.init();

        // Dishes //
        registerBlockWithItem(id("plate"), Plate, DishGroup.DISHES);
        registerBlockWithItem(id("bowl"), Bowl, DishGroup.DISHES);
        registerDishWithItem(id("potatoeswithcurdcheese"), PotatoesWithCurdCheese, DishGroup.DISHES, 10, 1f);

        if (FabricLoader.getInstance().isModLoaded("lil_tater") | FabricLoader.getInstance().isModLoaded("liltater") | FabricLoader.getInstance().isModLoaded("ltr"))
            registerDishWithItem(id("tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese, DishGroup.DISHES, 10, 1f);
        else
            registerDishWithItem(id("tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese, DishGroup.NONE, 10, 1f);

        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(id("schnitzel"), Schnitzel, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(id("spaghetti_bolognese"), SpaghettiBolognese, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(id("steak"), Steak, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(id("hamburger"), Hamburger, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(id("chickenburger"), Chickenburger, DishGroup.DISHES, 10, 1f);
            registerDishWithItem(id("cheeseburger"), Cheeseburger, DishGroup.DISHES, 10, 1f);

            if (FabricLoader.getInstance().isModLoaded("ad_astra"))
                registerDishWithItem(id("spaceburger"), Spaceburger, DishGroup.DISHES, 10, 1f);
            else
                registerDishWithItem(id("spaceburger"), Spaceburger, DishGroup.NONE, 10, 1f);

        }
        registerDishWithItem(id("potatoburger"), Potatoburger, DishGroup.DISHES, 10, 1f);
        registerDishWithItem(id("beetrootburger"), Beetrootburger, DishGroup.DISHES, 10, 1f);
        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(id("fishandchips"), FishAndChips, DishGroup.DISHES, 10, 1f);
        }
        registerDishWithItem(id("borscht"), Borscht, DishGroup.DISHES, 10, 1f);

        // Pizza //
        registerBlockWithItem(id("pizzabox"), PizzaBox, DishGroup.PIZZA);
        registerDishWithItem(id("pizzamargherita"), PizzaMargherita, DishGroup.PIZZA, 10, 1f);
        registerDishWithItem(id("pizzafungi"), PizzaFungi, DishGroup.PIZZA, 10, 1f);
        if (DishesConfig.enableMeatDishes) {
            registerDishWithItem(id("pizzasalami"), PizzaSalami, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(id("pizzaham"), PizzaHam, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(id("pizzatuna"), PizzaTuna, DishGroup.PIZZA, 10, 1f);
            registerDishWithItem(id("pizzabacon"), PizzaBacon, DishGroup.PIZZA, 10, 1f);
        }

        // Ice Cream //
        registerItem(id("ice_cream_vanilla"), IceCreamVanilla, DishGroup.SWEETS);
        registerItem(id("ice_cream_chocolate"), IceCreamChocolate, DishGroup.SWEETS);
        registerItem(id("ice_cream_white_chocolate"), IceCreamWhiteChocolate, DishGroup.SWEETS);
        registerItem(id("ice_cream_strawberry"), IceCreamStrawberry, DishGroup.SWEETS);
        registerItem(id("ice_cream_banana"), IceCreamBanana, DishGroup.SWEETS);
        registerItem(id("ice_cream_pear"), IceCreamPear, DishGroup.SWEETS);
        registerItem(id("ice_cream_sweetberry"), IceCreamSweetberry, DishGroup.SWEETS);
        registerItem(id("ice_cream_blueberry"), IceCreamBlueberry, DishGroup.SWEETS);
        registerItem(id("ice_cream_bubblegum"), IceCreamBubblegum, DishGroup.SWEETS);
        registerItem(id("ice_cream_glowberry"), IceCreamGlowberry, DishGroup.SWEETS);

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
        Registry.register(Registries.ITEM_GROUP, id("main"), MainGroup);
        Registry.register(Registries.ITEM_GROUP, id("dishes"), DishesGroup);
        Registry.register(Registries.ITEM_GROUP, id("pizza"), PizzaGroup);
        Registry.register(Registries.ITEM_GROUP, id("sweets"), SweetsGroup);
        CookingGuide = LavenderBookItem.registerForBook(id("cooking_guide"), new Item.Settings());
    }
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
