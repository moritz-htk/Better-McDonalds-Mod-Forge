// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

import java.util.List;

// Class for registering placed features
public class ModPlacedFeatures {
    // Define a ResourceKey for the placed salt block feature
    public static final ResourceKey<PlacedFeature> SALT_BLOCK = registerKey("salt_block");

    // Bootstrap method to initialize and register placed features
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register the placed salt block feature with specified modifiers
        register(context, SALT_BLOCK, configuredFeatures.getOrThrow(ModConfiguredFeatures.SALT_BLOCK), ModDiskPlacement.modifiers(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome()));
    }

    // Method to create a ResourceKey for a placed feature
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, name));
    }

    // Method to register a placed feature with specified configuration and modifiers
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}