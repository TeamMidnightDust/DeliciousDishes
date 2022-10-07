package eu.midnightdust.motschen.dishes.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DishItem extends BlockItem {
    public DishItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (I18n.hasTranslation(stack.getItem().getTranslationKey()+".tooltip")) {
            for (String str : I18n.translate(stack.getItem().getTranslationKey()+".tooltip").split("\n"))
                tooltip.add(Text.literal(str));
        }
    }
}
