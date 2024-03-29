// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.item.ModItems;

// Custom item model provider for defining item models and textures
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Initialize the item model provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Register models and textures for each item in the mod
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.TOMATO_SEEDS);
        simpleItem(ModItems.LETTUCE);
        simpleItem(ModItems.LETTUCE_SEEDS);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.TORTILLA);
        simpleItem(ModItems.BEEF_PATTY);
        simpleItem(ModItems.COOKED_BEEF_PATTY);
        simpleItem(ModItems.RAW_BACON);
        simpleItem(ModItems.COOKED_BACON);
        simpleItem(ModItems.MAYONNAISE);
        simpleItem(ModItems.SWEET_SOUR_SAUCE);
        simpleItem(ModItems.KETCHUP);
        simpleItem(ModItems.MUSTARD);
        simpleItem(ModItems.HAMBURGER);
        simpleItem(ModItems.CHEESEBURGER);
        simpleItem(ModItems.MCBACON);
        simpleItem(ModItems.BIG_MAC);
        simpleItem(ModItems.CHICKENBURGER);
        simpleItem(ModItems.MCCHICKEN);
        simpleItem(ModItems.FILET_O_FISH);
        simpleItem(ModItems.MCWRAP);
        simpleItem(ModItems.SNACK_SALAD);
        simpleItem(ModItems.CHICKEN_MCNUGGETS);
        simpleItem(ModItems.FRIES);
        simpleItem(ModItems.HAPPY_MEAL);
        simpleItem(ModItems.COCA_COLA);
        simpleItem(ModItems.FANTA);
        simpleItem(ModItems.SPRITE);
        simpleItem(ModItems.LIPTON_ICE_TEA_PEACH);
        simpleItem(ModItems.MCFLURRY);

        // Register model and texture for handheld item (knife)
        handheldItem();
    }

    // Register a simple item model and texture
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    // Register a handheld item model and texture
    private void handheldItem() {
        withExistingParent(ModItems.KNIFE.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + ModItems.KNIFE.getId().getPath()));
    }
}