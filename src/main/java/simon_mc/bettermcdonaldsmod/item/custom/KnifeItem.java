// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

// Custom class extending SwordItem for knife items
public class KnifeItem extends SwordItem {
    // Constructor for the KnifeItem class
    public KnifeItem(int attackDamage, float attackSpeed, Properties properties) {
        super(
                // Define a custom Tier for the knife using an anonymous class
                new Tier() {
                    @Override
                    public int getUses() {
                        return 125;
                    }

                    @Override
                    public float getSpeed() {
                        return 1.6f;
                    }

                    @Override
                    public float getAttackDamageBonus() {
                        return -2f; // Negative attack damage for a weaker attack
                    }

                    @Override
                    public int getLevel() {
                        return 0;
                    }

                    @Override
                    public int getEnchantmentValue() {
                        return 0;
                    }

                    @Override
                    public Ingredient getRepairIngredient() {
                        return Ingredient.of(new ItemStack(Items.IRON_INGOT.asItem()));
                    }
                }, attackDamage, attackSpeed, properties
        );
    }

    // Method to check if the item has a crafting remaining item
    public boolean hasCraftingRemainingItem(ItemStack itemStack) {
        return true;
    }

    // Method to get the crafting remaining item for the knife
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemStack.getDamageValue() + 1);

        // If the item is damaged beyond repair, return an empty stack
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }
}