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

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancements()));
    }

    private static class ModAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement ROOT = createRootAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.HAPPY_MEAL.get().getDefaultInstance(), "root");

            Advancement GET_SALT = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.SALT.get().getDefaultInstance(), "get_salt", ROOT);
            createAdvancement(consumer, existingFileHelper, FrameType.GOAL, ModItems.COCA_COLA.get().getDefaultInstance(), "craft_drink", GET_SALT);

            Advancement CRAFT_KNIFE = createAdvancement(consumer, existingFileHelper, FrameType.TASK, ModItems.KNIFE.get().getDefaultInstance(), "craft_knife", ROOT);
            createAdvancement(consumer, existingFileHelper, FrameType.GOAL, ModItems.HAMBURGER.get().getDefaultInstance(), "craft_burger", CRAFT_KNIFE);
        }
    }

    public static Advancement createRootAdvancement(Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper, FrameType frame, ItemStack item, String titleKey) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.literal("Better McDonald's Mod"),
                        titleKey, frame, false, false))
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    public static Advancement createAdvancement(Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper, FrameType frame, ItemStack item, String titleKey, Advancement parent) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".title"),
                        titleKey, frame, true, true))
                .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(item.getItem()))
                .parent(parent)
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    public static DisplayInfo createAdvancementDisplay(ItemStack item, Component component, String titleKey, FrameType frame, boolean showToast, boolean announceToChat) {
        return new DisplayInfo(item, component,
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".description"),
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                frame, showToast, announceToChat, false);
    }
}