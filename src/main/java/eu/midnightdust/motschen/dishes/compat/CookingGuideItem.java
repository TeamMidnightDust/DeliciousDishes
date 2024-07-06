package eu.midnightdust.motschen.dishes.compat;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Optional;

public class CookingGuideItem extends Item {
    public CookingGuideItem(Item.Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        Optional<Item> item = Registries.ITEM.getOrEmpty(new Identifier("patchouli", "guide_book"));
        ItemStack stack = new ItemStack(item.get());
        stack.getOrCreateNbt().putString("patchouli:book", "dishes:cooking_guide");

        user.setStackInHand(hand, stack);
        return TypedActionResult.pass(itemStack);
    }
}