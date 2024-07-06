package eu.midnightdust.motschen.dishes.item;

import eu.midnightdust.motschen.dishes.DishesMain;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceCreamItem extends Item {
    public IceCreamItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (stack.getItem() == DishesMain.IceCreamGlowberry && this.getComponents().contains(DataComponentTypes.FOOD))
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 1));
        return super.finishUsing(stack, world, user);
    }
}
