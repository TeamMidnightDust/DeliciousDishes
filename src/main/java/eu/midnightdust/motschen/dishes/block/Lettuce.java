package eu.midnightdust.motschen.dishes.block;

import eu.midnightdust.motschen.dishes.init.LettuceInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class Lettuce extends CropBlock {

    public Lettuce() {
        super(AbstractBlock.Settings.copy(Blocks.CARROTS));
    }

    @Override
    @Environment(EnvType.CLIENT)
    protected ItemConvertible getSeedsItem() {
        return LettuceInit.LettuceBush;
    }
}

