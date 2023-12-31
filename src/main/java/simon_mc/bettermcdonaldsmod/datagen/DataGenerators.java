// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

import java.util.concurrent.CompletableFuture;

// Class for gathering data during mod data generation
@Mod.EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    // Method to gather data during data generation
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Obtain required instances from the GatherDataEvent
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Add various data providers to the generator
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModTagProvider.Items(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModTagProvider.Blocks(packOutput, lookupProvider, existingFileHelper));
    }
}