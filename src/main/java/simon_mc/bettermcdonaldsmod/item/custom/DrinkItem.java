package simon_mc.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import simon_mc.bettermcdonaldsmod.item.ModItems;

public class DrinkItem extends Item {
    public DrinkItem(Properties properties) {
        super(properties.food(ModItems.registerFoodValues(3, 1.5f).build()));
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }
}