package simon_mc.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class DrinkItem extends Item {
    public DrinkItem(Properties properties) {
        super(properties);
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }
}