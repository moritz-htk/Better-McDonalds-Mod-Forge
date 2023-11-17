package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BLOCK.get(), 1)
                .define('#', ModTagProvider.Items.SALT)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModBlocks.SALT_BLOCK.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS.get(), 2)
                .requires(ModTagProvider.Items.TOMATO)
                .unlockedBy(getHasName(ModItems.TOMATO.get()), has(ModTagProvider.Items.TOMATO))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.TOMATO_SEEDS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.LETTUCE_SEEDS.get(), 2)
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.LETTUCE_SEEDS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(ModTagProvider.Items.SALT)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHEESE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TORTILLA.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.WHEAT, 2)
                .requires(Items.EGG)
                .requires(ModTagProvider.Items.SALT)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.TORTILLA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BEEF_PATTY.get(), 2)
                .requires(ModItems.KNIFE.get())
                .requires(Items.BEEF)
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.BEEF_PATTY.get())));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_smelting"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_smoking"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_campfire_cooking"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_BACON.get(), 2)
                .requires(ModItems.KNIFE.get())
                .requires(Items.PORKCHOP)
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.RAW_BACON.get())));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.RAW_BACON.get()), RecipeCategory.FOOD, ModItems.COOKED_BACON.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE)
                .unlockedBy(getHasName(ModItems.RAW_BACON.get()), has(ModItems.RAW_BACON.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BACON.get()) + "_smelting"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.RAW_BACON.get()), RecipeCategory.FOOD, ModItems.COOKED_BACON.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.RAW_BACON.get()), has(ModItems.RAW_BACON.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BACON.get()) + "_smoking"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.RAW_BACON.get()), RecipeCategory.FOOD, ModItems.COOKED_BACON.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.RAW_BACON.get()), has(ModItems.RAW_BACON.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COOKED_BACON.get()) + "_campfire_cooking"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MAYONNAISE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.EGG)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MAYONNAISE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_SOUR_SAUCE.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.SWEET_SOUR_SAUCE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KETCHUP.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(ModTagProvider.Items.TOMATO)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(ModItems.TOMATO.get()), has(ModTagProvider.Items.TOMATO))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.KETCHUP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MUSTARD.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.PUMPKIN_SEEDS)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.PUMPKIN_SEEDS), has(Items.PUMPKIN_SEEDS))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MUSTARD.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HAMBURGER.get())
                .requires(Items.BREAD)
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.HAMBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESEBURGER.get())
                .requires(Items.BREAD)
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.CHEESE.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHEESEBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCBACON.get())
                .requires(Items.BREAD)
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.CHEESE.get())
                .requires(ModItems.COOKED_BACON.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(ModItems.COOKED_BACON.get()), has(ModItems.COOKED_BACON.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCBACON.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BIG_MAC.get())
                .requires(Items.BREAD)
                .requires(ModItems.COOKED_BEEF_PATTY.get(), 2)
                .requires(ModItems.CHEESE.get())
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.BIG_MAC.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKENBURGER.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.KETCHUP.get())
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(ModItems.KETCHUP.get()), has(ModItems.KETCHUP.get()))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHICKENBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCCHICKEN.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.MAYONNAISE.get())
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(ModItems.MAYONNAISE.get()), has(ModItems.MAYONNAISE.get()))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCCHICKEN.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FILET_O_FISH.get())
                .requires(Items.BREAD)
                .requires(ModItems.CHEESE.get())
                .requires(Items.COOKED_SALMON)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.COOKED_SALMON), has(Items.COOKED_SALMON))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FILET_O_FISH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCWRAP.get())
                .requires(ModItems.TORTILLA.get())
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.MAYONNAISE.get())
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(ModItems.TORTILLA.get()), has(ModItems.TORTILLA.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(ModItems.MAYONNAISE.get()), has(ModItems.MAYONNAISE.get()))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCWRAP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SNACK_SALAD.get())
                .requires(ModTagProvider.Items.TOMATO)
                .requires(ModTagProvider.Items.LETTUCE)
                .unlockedBy(getHasName(ModItems.TOMATO.get()), has(ModTagProvider.Items.TOMATO))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModTagProvider.Items.LETTUCE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.SNACK_SALAD.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKEN_MCNUGGETS.get())
                .requires(ModItems.KNIFE.get())
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHICKEN_MCNUGGETS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRIES.get(), 2)
                .requires(ModItems.KNIFE.get())
                .requires(Items.BAKED_POTATO)
                .requires(ModTagProvider.Items.SALT)
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FRIES.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HAPPY_MEAL.get())
                .requires(ModTagProvider.Items.BURGERS)
                .requires(ModTagProvider.Items.DRINKS)
                .requires(ModTagProvider.Items.SIDE_DISHES)
                .requires(Items.APPLE)
                .unlockedBy("has_burger", has(ModTagProvider.Items.BURGERS))
                .unlockedBy("has_drink", has(ModTagProvider.Items.DRINKS))
                .unlockedBy("has_side_dish", has(ModTagProvider.Items.SIDE_DISHES))
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.HAPPY_MEAL.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COCA_COLA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.BROWN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.BROWN_DYE), has(Items.BROWN_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COCA_COLA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FANTA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.YELLOW_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FANTA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPRITE.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.GREEN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.SPRITE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.LIPTON_ICE_TEA_PEACH.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.PINK_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.LIPTON_ICE_TEA_PEACH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCFLURRY.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCFLURRY.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KNIFE.get())
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .pattern(" I ")
                .pattern(" S ")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.KNIFE.get())));
    }
}