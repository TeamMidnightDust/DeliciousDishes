package eu.midnightdust.motschen.dishes.entities.client;

import eu.midnightdust.motschen.dishes.entities.IceCreamTraderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IceCreamTraderRenderer extends MobEntityRenderer<IceCreamTraderEntity, VillagerResemblingModel<IceCreamTraderEntity>> {

    public IceCreamTraderRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new VillagerResemblingModel<>(0.0f), 0.5F);
    }

    @Override
    public Identifier getTexture(IceCreamTraderEntity entity) {
        return new Identifier("dishes", "textures/entity/ice_cream_seller.png");
    }
}
