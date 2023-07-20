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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESE.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(ModTagProvider.Items.SALT)
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET.asItem()))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHEESE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BEEF_PATTY.get(), 2)
                .requires(ModItems.KNIFE.get())
                .requires(Items.BEEF.asItem())
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BEEF.asItem()), has(Items.BEEF.asItem()))
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

        /*
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_BACON.get(), 2)
                .requires(ModItems.KNIFE.get())
                .requires(Items.PORKCHOP.asItem())
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.PORKCHOP.asItem()), has(Items.PORKCHOP.asItem()))
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
         */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MAYONNAISE.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(Items.EGG.asItem())
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG.asItem()), has(Items.EGG.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MAYONNAISE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_SOUR_SAUCE.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.HONEY_BOTTLE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.HONEY_BOTTLE.asItem()), has(Items.HONEY_BOTTLE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.SWEET_SOUR_SAUCE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KETCHUP.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.RED_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.RED_DYE.asItem()), has(Items.RED_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.KETCHUP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HAMBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.HAMBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESEBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.CHEESE.get())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHEESEBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BIG_MAC.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get(), 2)
                .requires(ModItems.CHEESE.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.BIG_MAC.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKENBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(Items.COOKED_CHICKEN.asItem())
                .requires(ModItems.KETCHUP.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .unlockedBy(getHasName(ModItems.KETCHUP.get()), has(ModItems.KETCHUP.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHICKENBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCCHICKEN.get())
                .requires(Items.BREAD.asItem())
                .requires(Items.COOKED_CHICKEN.asItem())
                .requires(ModItems.MAYONNAISE.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .unlockedBy(getHasName(ModItems.MAYONNAISE.get()), has(ModItems.MAYONNAISE.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCCHICKEN.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FILET_O_FISH.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.CHEESE.get())
                .requires(Items.COOKED_SALMON.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.COOKED_SALMON.asItem()), has(Items.COOKED_SALMON.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FILET_O_FISH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKEN_MCNUGGETS.get())
                .requires(ModItems.KNIFE.get())
                .requires(Items.COOKED_CHICKEN.asItem())
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.CHICKEN_MCNUGGETS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRIES.get())
                .requires(ModItems.KNIFE.get())
                .requires(Items.BAKED_POTATO.asItem())
                .requires(ModTagProvider.Items.SALT)
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BAKED_POTATO.asItem()), has(Items.BAKED_POTATO))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FRIES.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HAPPY_MEAL.get())
                .requires(ModTagProvider.Items.BURGERS)
                .requires(ModTagProvider.Items.DRINKS)
                .requires(ModTagProvider.Items.SIDE_DISHES)
                .requires(Items.APPLE.asItem())
                .unlockedBy("has_burger", has(ModTagProvider.Items.BURGERS))
                .unlockedBy("has_drink", has(ModTagProvider.Items.DRINKS))
                .unlockedBy("has_side_dish", has(ModTagProvider.Items.SIDE_DISHES))
                .unlockedBy(getHasName(Items.APPLE.asItem()), has(Items.APPLE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.HAPPY_MEAL.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COCA_COLA.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.BROWN_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.BROWN_DYE.asItem()), has(Items.BROWN_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.COCA_COLA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FANTA.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.YELLOW_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.YELLOW_DYE.asItem()), has(Items.YELLOW_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.FANTA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SPRITE.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.GREEN_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.GREEN_DYE.asItem()), has(Items.GREEN_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.SPRITE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.LIPTON_ICE_TEA_PEACH.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModTagProvider.Items.SALT)
                .requires(Items.PINK_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.PINK_DYE.asItem()), has(Items.PINK_DYE))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.LIPTON_ICE_TEA_PEACH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MCFLURRY.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(Items.SNOWBALL.asItem())
                .requires(Items.SUGAR.asItem())
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SNOWBALL.asItem()), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.MCFLURRY.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KNIFE.get())
                .define('I', Items.IRON_INGOT.asItem())
                .define('S', Items.STICK.asItem())
                .pattern(" I ")
                .pattern(" S ")
                .unlockedBy(getHasName(Items.IRON_INGOT.asItem()), has(Items.IRON_INGOT.asItem()))
                .unlockedBy(getHasName(Items.STICK.asItem()), has(Items.STICK))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(ModItems.KNIFE.get())));
    }
}