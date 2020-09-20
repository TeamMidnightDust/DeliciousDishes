package eu.midnightdust.motschen.dishes;

import eu.midnightdust.motschen.dishes.entities.client.IceCreamTraderRenderer;
import eu.midnightdust.motschen.dishes.init.CropInit;
import eu.midnightdust.motschen.dishes.init.IceCreamTraderInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class DishesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(IceCreamTraderInit.ICE_CREAM_TRADER, (dispatcher, context) -> new IceCreamTraderRenderer(dispatcher));
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),CropInit.TomatoBush);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),CropInit.LettuceBush);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DishesMain.BirthdayCake);
    }
}
