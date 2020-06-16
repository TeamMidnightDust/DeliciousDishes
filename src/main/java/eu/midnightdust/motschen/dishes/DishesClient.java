package eu.midnightdust.motschen.dishes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class DishesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DishesMain.TomatoBush);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DishesMain.LettuceBush);
    }
}
