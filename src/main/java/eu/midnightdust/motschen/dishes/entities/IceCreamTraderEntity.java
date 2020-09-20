package eu.midnightdust.motschen.dishes.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TraderOfferList;
import net.minecraft.world.World;

public class IceCreamTraderEntity extends WanderingTraderEntity {
    public IceCreamTraderEntity(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void fillRecipes() {
        TradeOffers.Factory[] factorys = IceCreamTraderTradeOffers.ICE_CREAM_TRADER_TRADES.get(1);
        if (factorys != null) {
            TraderOfferList traderOfferList = this.getOffers();
            this.fillRecipesFromPool(traderOfferList, factorys, 9);
            int i = this.random.nextInt(factorys.length);
            TradeOffers.Factory factory = factorys[i];
            TradeOffer tradeOffer = factory.create(this, null);
            if (tradeOffer != null) {
                traderOfferList.add(tradeOffer);
            }
        }
    }
}
