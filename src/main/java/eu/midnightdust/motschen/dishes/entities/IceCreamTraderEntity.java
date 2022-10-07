package eu.midnightdust.motschen.dishes.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;

public class IceCreamTraderEntity extends WanderingTraderEntity {
    public IceCreamTraderEntity(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void fillRecipes() {
        TradeOffers.Factory[] factories = IceCreamTraderTradeOffers.ICE_CREAM_TRADER_TRADES.get(1);
        if (factories != null) {
            TradeOfferList traderOfferList = this.getOffers();
            this.fillRecipesFromPool(traderOfferList, factories, factories.length);
        }
    }
}
