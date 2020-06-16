package eu.midnightdust.motschen.dishes;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;

public class Crop extends CropBlock {

    public Crop() {
        super(FabricBlockSettings.copy(Blocks.CARROTS));
    }
}

