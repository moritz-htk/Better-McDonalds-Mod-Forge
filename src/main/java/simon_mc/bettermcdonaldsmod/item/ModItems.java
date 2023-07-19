package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterMcDonaldsMod.MOD_ID);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> BEEF_PATTY = ITEMS.register("beef_patty", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(2).saturationMod(1f).meat().build())));
    public static final RegistryObject<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).meat().build())));
    // public static final RegistryObject<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).meat().build())));
    // public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(2).saturationMod(1f).meat().build())));
    public static final RegistryObject<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));
    public static final RegistryObject<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));
    public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build())));
    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(9).saturationMod(4.5f).build())));
    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(10).saturationMod(5f).build())));
    public static final RegistryObject<Item> BIG_MAC = ITEMS.register("big_mac", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(14).saturationMod(7f).build())));
    public static final RegistryObject<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(12).saturationMod(6f).build())));
    public static final RegistryObject<Item> MCCHICKEN = ITEMS.register("mcchicken", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(13).saturationMod(6.5f).build())));
    public static final RegistryObject<Item> FILET_O_FISH = ITEMS.register("filet_o_fish", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(11).saturationMod(5.5f).build())));
    public static final RegistryObject<Item> CHICKEN_MCNUGGETS = ITEMS.register("chicken_mcnuggets", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(8).saturationMod(4f).build())));
    public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(7).saturationMod(3.5f).build())));
    public static final RegistryObject<Item> HAPPY_MEAL = ITEMS.register("happy_meal", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(new FoodProperties.Builder().nutrition(20).saturationMod(10f).build())));
    public static final RegistryObject<Item> COCA_COLA = ITEMS.register("coca_cola", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).build())) {
                public UseAnim getUseAnimation(ItemStack itemStack) {
                    return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
                }
            });
    public static final RegistryObject<Item> FANTA = ITEMS.register("fanta", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).build())) {
                public UseAnim getUseAnimation(ItemStack itemStack) {
                    return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
                }
            });
    public static final RegistryObject<Item> SPRITE = ITEMS.register("sprite", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).build())) {
                public UseAnim getUseAnimation(ItemStack itemStack) {
                    return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
                }
            });
    public static final RegistryObject<Item> LIPTON_ICE_TEA_PEACH = ITEMS.register("lipton_ice_tea_peach", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.5f).build())) {
                public UseAnim getUseAnimation(ItemStack itemStack) {
                    return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
                }
            });
    public static final RegistryObject<Item> MCFLURRY = ITEMS.register("mcflurry", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder().nutrition(5).saturationMod(2.5f).build())));
    public static final RegistryObject<SwordItem> KNIFE = ITEMS.register("knife", () -> new SwordItem(new Tier() {
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
            }, 3, -3f, new Item.Properties().rarity(Rarity.COMMON)) {
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
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
