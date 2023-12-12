// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

// Provider class for generating advancements for the mod
public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancements()));
    }

    // Nested class for defining advancement generation logic
    private static class ModAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            // Create the root advancement
            Advancement ROOT = createRootAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.HAPPY_MEAL.get().getDefaultInstance(), "root");

            // Create child advancements and link them to the root
            Advancement GET_SALT = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.SALT.get().getDefaultInstance(), "get_salt", ROOT);
            createAdvancement(consumer, existingFileHelper, FrameType.GOAL, ModItems.COCA_COLA.get().getDefaultInstance(), "craft_drink", GET_SALT);

            Advancement CRAFT_KNIFE = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.KNIFE.get().getDefaultInstance(), "craft_knife", ROOT);
            createAdvancement(consumer, existingFileHelper, FrameType.GOAL, ModItems.HAMBURGER.get().getDefaultInstance(), "craft_burger", CRAFT_KNIFE);

            Advancement GET_SEEDS = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.LETTUCE_SEEDS.get().getDefaultInstance(), "get_seeds", ROOT);
            Advancement HARVEST_LETTUCE = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.LETTUCE.get().getDefaultInstance(), "harvest_lettuce", GET_SEEDS);
            createAdvancement(consumer, existingFileHelper, FrameType.GOAL, ModItems.SNACK_SALAD.get().getDefaultInstance(), "craft_snack_salad", HARVEST_LETTUCE);
        }
    }

    // Method to create the root advancement
    public static Advancement createRootAdvancement(Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper, FrameType frame, ItemStack item, String titleKey) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.literal("Better McDonald's Mod"),
                        titleKey, frame, false, false))
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    // Method to create advancements with a parent
    public static Advancement createAdvancement(Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper, FrameType frame, ItemStack item, String titleKey, Advancement parent) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".title"),
                        titleKey, frame, true, true))
                .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(item.getItem()))
                .parent(parent)
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    // Method to create display information for advancements
    public static DisplayInfo createAdvancementDisplay(ItemStack item, Component component, String titleKey, FrameType frame, boolean showToast, boolean announceToChat) {
        return new DisplayInfo(item, component,
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".description"),
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                frame, showToast, announceToChat, false);
    }
}