package eu.midnightdust.motschen.dishes.init;

import eu.midnightdust.motschen.dishes.DishesMain;
import eu.midnightdust.motschen.dishes.block.blockentity.BirthdayCakeBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityInit {

    public static BlockEntityType<BirthdayCakeBlockEntity> BirthdayCakeBlockEntity;

    public static void init() {
        BirthdayCakeBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DishesMain.MOD_ID,"birthday_cake_blockentity"), BlockEntityType.Builder.create(BirthdayCakeBlockEntity::new, DishesMain.BirthdayCake).build(null));
    }
}
