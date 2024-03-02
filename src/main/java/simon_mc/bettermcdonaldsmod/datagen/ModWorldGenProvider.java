// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.world.ModBiomeModifiers;
import simon_mc.bettermcdonaldsmod.world.ModConfiguredFeatures;
import simon_mc.bettermcdonaldsmod.world.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

// Definition of the WorldGenProvider class for world generation data
public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    // Definition of a registry set builder for configured and placed features
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap).add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

    // Constructor for the WorldGenProvider class
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        // Calling the constructor of the parent class with relevant parameters
        super(output, registries, BUILDER, Set.of(BetterMcDonaldsMod.MOD_ID));
    }
}