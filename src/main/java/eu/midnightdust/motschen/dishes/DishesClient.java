package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.config.DishesConfig;
import eu.midnightdust.motschen.dishes.entities.client.IceCreamTraderRenderer;
import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import eu.midnightdust.motschen.dishes.init.LettuceInit;
import eu.midnightdust.motschen.dishes.init.TomatoInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class DishesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(IceCreamTraderInit.ICE_CREAM_TRADER, IceCreamTraderRenderer::new);
        if (DishesConfig.tomatoes) BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TomatoInit.TomatoBush);
        if (DishesConfig.lettuce) BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LettuceInit.LettuceBush);
    }
}
