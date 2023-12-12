// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.custom.DrinkItem;
import simon_mc.bettermcdonaldsmod.item.custom.KnifeItem;

// Class for registering custom items using DeferredRegister
public class ModItems {
    // Create a DeferredRegister for Item instances
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterMcDonaldsMod.MOD_ID);

    // Register each custom item using a RegistryObject
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(ModBlocks.LETTUCE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().food(registerFoodValues(2, 0.4f).build())));
    public static final RegistryObject<Item> TORTILLA = ITEMS.register("tortilla", () -> new Item(new Item.Properties().food(registerFoodValues(2, 0.4f).build())));
    public static final RegistryObject<Item> BEEF_PATTY = ITEMS.register("beef_patty", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).meat().build())));
    public static final RegistryObject<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).meat().build())));
    public static final RegistryObject<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(new Item.Properties().food(registerFoodValues(3, 0.4f).meat().build())));
    public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).meat().build())));
    public static final RegistryObject<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> MUSTARD = ITEMS.register("mustard", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.5f).build())));
    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final RegistryObject<Item> MCBACON = ITEMS.register("mcbacon", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final RegistryObject<Item> BIG_MAC = ITEMS.register("big_mac", () -> new Item(new Item.Properties().food(registerFoodValues(10, 0.5f).build())));
    public static final RegistryObject<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new Item(new Item.Properties().food(registerFoodValues(7, 0.5f).build())));
    public static final RegistryObject<Item> MCCHICKEN = ITEMS.register("mcchicken", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final RegistryObject<Item> FILET_O_FISH = ITEMS.register("filet_o_fish", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.5f).build())));
    public static final RegistryObject<Item> MCWRAP = ITEMS.register("mcwrap", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).build())));
    public static final RegistryObject<Item> SNACK_SALAD = ITEMS.register("snack_salad", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).build())));
    public static final RegistryObject<Item> CHICKEN_MCNUGGETS = ITEMS.register("chicken_mcnuggets", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).build())));
    public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).build())));
    public static final RegistryObject<Item> HAPPY_MEAL = ITEMS.register("happy_meal", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f).build())));
    public static final RegistryObject<Item> COCA_COLA = ITEMS.register("coca_cola", () -> new DrinkItem(new Item.Properties()));
    public static final RegistryObject<Item> FANTA = ITEMS.register("fanta", () -> new DrinkItem(new Item.Properties()));
    public static final RegistryObject<Item> SPRITE = ITEMS.register("sprite", () -> new DrinkItem(new Item.Properties()));
    public static final RegistryObject<Item> LIPTON_ICE_TEA_PEACH = ITEMS.register("lipton_ice_tea_peach", () -> new DrinkItem(new Item.Properties()));
    public static final RegistryObject<Item> MCFLURRY = ITEMS.register("mcflurry", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.4f).build())));

    // Register a KnifeItem with custom properties using a RegistryObject
    public static final RegistryObject<SwordItem> KNIFE = ITEMS.register("knife", () -> new KnifeItem(3, -3f, new Item.Properties()));

    // Method to create a FoodProperties.Builder with given nutrition and saturation values
    public static FoodProperties.Builder registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation);
    }

    // Method to register the items to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}