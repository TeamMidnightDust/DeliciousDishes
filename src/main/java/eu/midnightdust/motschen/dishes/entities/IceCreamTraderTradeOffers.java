package eu.midnightdust.motschen.dishes.entities;

import com.google.common.collect.ImmutableMap;
import eu.midnightdust.motschen.dishes.DishesMain;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;

public class IceCreamTraderTradeOffers {
    public static final Int2ObjectMap<TradeOffers.Factory[]> ICE_CREAM_TRADER_TRADES;

    private static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    static {
        ICE_CREAM_TRADER_TRADES = copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]
                {
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamVanilla, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamChocolate, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamWhiteChocolate, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamStrawberry, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamBanana, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamPear, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamSweetberry, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamBlueberry, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamBubblegum, 1, 1, 10, 3),
                        new IceCreamTraderTradeOffers.SellItemFactory(DishesMain.IceCreamGlowberry, 1, 1, 10, 3)
                }));
    }

    static class SellItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellItemFactory(Item item, int price, int count, int maxUses, int experience) {
            this(new ItemStack(item), price, count, maxUses, experience);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience) {
            this(stack, price, count, maxUses, experience, 0.05F);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new TradedItem(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
        }
    }
}
