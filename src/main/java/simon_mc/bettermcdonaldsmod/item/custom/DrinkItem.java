// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import simon_mc.bettermcdonaldsmod.item.ModItems;

// Custom class extending Item for drinkable items
public class DrinkItem extends Item {
    // Constructor for the DrinkItem class
    public DrinkItem(Properties properties) {
        super(properties.food(ModItems.registerFoodValues(3, 0.4f).build()));
    }

    // Method to determine the use animation for the item
    public UseAnim getUseAnimation(ItemStack itemStack) {
        // Return UseAnim.DRINK if the item is edible, else UseAnim.NONE
        return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }
}