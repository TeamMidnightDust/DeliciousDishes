package eu.midnightdust.motschen.dishes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class DishesMain implements ModInitializer {
    public static final String MOD_ID = "dishes";

    public static final ItemGroup DishesGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "dishes"), () -> new ItemStack(DishesMain.PizzaSalami));
    public static final Block Plate = new Plate();
    public static final Block PizzaBox = new Plate();
    public static final Block PotatoesWithCurdCheese = new Dish();
    public static final Block TinyPotatoesWithCurdCheese = new Dish();
    public static final Block Schnitzel = new Dish();
    public static final Block PizzaSalami = new Pizza();
    public static final Block PizzaHam = new Pizza();
    public static final Block PizzaTuna = new Pizza();
    public static final Block PizzaBacon = new Pizza();
    public static final Block SpaghettiBolognese = new Dish();
    public static final Block Steak = new Dish();
    public static final Block Hamburger = new Dish();
    public static final Block Chickenburger = new Dish();
    public static final Block Cheeseburger = new Dish();
    public static final Block FishAndChips = new Dish();
    public static final Item Knife = new Item(new Item.Settings().group(DishesMain.DishesGroup).recipeRemainder(DishesMain.Knife).maxCount(1));
    public static final Item PotatoSlice = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item RawFries = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).build()));
    public static final Item Fries = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).build()));
    public static final Block SaltOre = new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE));
    public static final Item Salt = new Item(new Item.Settings().group(DishesMain.DishesGroup));
    public static final Item Flour = new Item(new Item.Settings().group(DishesMain.DishesGroup));
    public static final Item RawSpaghetti = new Item(new Item.Settings().group(DishesMain.DishesGroup));
    public static final Item Spaghetti = new Item(new Item.Settings().group(DishesMain.DishesGroup));
    public static final Item Salami = new Item(new Item.Settings().group(DishesMain.DishesGroup));
    public static final Item Tomato = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    public static final Block TomatoBush = new Crop();
    public static final Item Lettuce = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    public static final Block LettuceBush = new Crop();
    public static final Item RawBacon = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    public static final Item Bacon = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    public static final Item CheeseRoll = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    public static final Item CheeseSlice = new Item(new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("dishes","salt_ore"), new BlockItem(SaltOre, new Item.Settings().group(DishesMain.DishesGroup)));
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
        Registry.register(Registry.ITEM, new Identifier("dishes","tomatoseed"), new AliasedBlockItem(TomatoBush, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.ITEM, new Identifier("dishes","tomato"), Tomato);
        Registry.register(Registry.ITEM, new Identifier("dishes","lettuceseed"), new AliasedBlockItem(LettuceBush, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.ITEM, new Identifier("dishes","lettuce"), Lettuce);
        Registry.register(Registry.BLOCK, new Identifier("dishes","tomatobush"), TomatoBush);
        Registry.register(Registry.BLOCK, new Identifier("dishes","lettucebush"), LettuceBush);
        Registry.register(Registry.ITEM, new Identifier("dishes","plate"), new AliasedBlockItem(Plate, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","plate"), Plate);
        Registry.register(Registry.ITEM, new Identifier("dishes","potatoeswithcurdcheese"), new AliasedBlockItem(PotatoesWithCurdCheese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","potatoeswithcurdcheese"), PotatoesWithCurdCheese);
        Registry.register(Registry.ITEM, new Identifier("dishes","tinypotatoeswithcurdcheese"), new AliasedBlockItem(TinyPotatoesWithCurdCheese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","tinypotatoeswithcurdcheese"), TinyPotatoesWithCurdCheese);
        Registry.register(Registry.ITEM, new Identifier("dishes","schnitzel"), new AliasedBlockItem(Schnitzel, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","schnitzel"), Schnitzel);
        Registry.register(Registry.ITEM, new Identifier("dishes","spaghetti_bolognese"), new AliasedBlockItem(SpaghettiBolognese, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","spaghetti_bolognese"), SpaghettiBolognese);
        Registry.register(Registry.ITEM, new Identifier("dishes","steak"), new AliasedBlockItem(Steak, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","steak"), Steak);
        Registry.register(Registry.ITEM, new Identifier("dishes","hamburger"), new AliasedBlockItem(Hamburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","hamburger"), Hamburger);
        Registry.register(Registry.ITEM, new Identifier("dishes","chickenburger"), new AliasedBlockItem(Chickenburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","chickenburger"), Chickenburger);
        Registry.register(Registry.ITEM, new Identifier("dishes","cheeseburger"), new AliasedBlockItem(Cheeseburger, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","cheeseburger"), Cheeseburger);
        Registry.register(Registry.ITEM, new Identifier("dishes","fishandchips"), new AliasedBlockItem(FishAndChips, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","fishandchips"), FishAndChips);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzabox"), new AliasedBlockItem(PizzaBox, new Item.Settings().group(DishesMain.DishesGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzabox"), PizzaBox);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzasalami"), new AliasedBlockItem(PizzaSalami, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzasalami"), PizzaSalami);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzaham"), new AliasedBlockItem(PizzaHam, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzaham"), PizzaHam);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzatuna"), new AliasedBlockItem(PizzaTuna, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzatuna"), PizzaTuna);
        Registry.register(Registry.ITEM, new Identifier("dishes","pizzabacon"), new AliasedBlockItem(PizzaBacon, new Item.Settings().group(DishesMain.DishesGroup).food(new FoodComponent.Builder().hunger(10).saturationModifier(20f).build())));
        Registry.register(Registry.BLOCK, new Identifier("dishes","pizzabacon"), PizzaBacon);

        LootModifier.init();
        Flags.init();
        eu.midnightdust.motschen.dishes.world.SaltOre.initBiomeFeatures();
    }
    public enum Ores implements ItemConvertible {
        SaltOre(4, 20, 40, 120);

        public final String name;
        public final int veinSize;
        public final int veinsPerChunk;
        public final int minY;
        public final int maxY;

        Ores(int veinSize, int veinsPerChunk, int minY, int maxY) {
            name = this.toString().toLowerCase(Locale.ROOT);
            this.veinSize = veinSize;
            this.veinsPerChunk = veinsPerChunk;
            this.minY = minY;
            this.maxY = maxY;
        }

        @Override
        public Item asItem() {
            return SaltOre.asItem();
        }
    }
}
