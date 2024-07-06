package eu.midnightdust.motschen.dishes.item;

import net.minecraft.block.Block;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class DishItem extends BlockItem {
    public DishItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (I18n.hasTranslation(stack.getItem().getTranslationKey()+".tooltip")) {
            for (String str : I18n.translate(stack.getItem().getTranslationKey()+".tooltip").split("\n"))
                tooltip.add(Text.literal(str));
        }
    }
}
