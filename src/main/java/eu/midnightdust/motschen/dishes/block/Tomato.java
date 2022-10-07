package eu.midnightdust.motschen.dishes.block;

import eu.midnightdust.motschen.dishes.init.TomatoInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class Tomato extends CropBlock {

    public Tomato() {
        super(FabricBlockSettings.copy(Blocks.CARROTS));
    }

    @Override
    @Environment(EnvType.CLIENT)
    protected ItemConvertible getSeedsItem() {
        return TomatoInit.TomatoBush;
    }
}

