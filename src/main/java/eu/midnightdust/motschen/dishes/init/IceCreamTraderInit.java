package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.entities.IceCreamTraderEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IceCreamTraderInit {
    public static final EntityType<IceCreamTraderEntity> ICE_CREAM_TRADER =
            Registry.register(Registry.ENTITY_TYPE,new Identifier(DishesMain.MOD_ID,"ice_cream_trader"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IceCreamTraderEntity::new).dimensions(EntityDimensions.fixed(1f,2f)).trackRangeBlocks(100).trackedUpdateRate(4).build());

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(DishesMain.MOD_ID,"ice_cream_trader_spawn_egg"), new SpawnEggItem(ICE_CREAM_TRADER,5349438,15377456, new Item.Settings().group(ItemGroup.MISC)));
        FabricDefaultAttributeRegistry.register(ICE_CREAM_TRADER, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D));
    }
}
