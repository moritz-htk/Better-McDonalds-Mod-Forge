package simon_mc.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class KnifeItem extends SwordItem {
    public KnifeItem(int attackDamage, float attackSpeed, Properties properties) {
        super(new Tier() {
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
                return -2f;
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
        }, attackDamage, attackSpeed, properties);
    }

    public boolean hasCraftingRemainingItem(ItemStack itemStack) {
        return true;
    }

    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemStack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }
}