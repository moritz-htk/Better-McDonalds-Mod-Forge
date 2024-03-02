// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;

import java.util.List;

// Class for registering configured features
public class ModConfiguredFeatures {
    // Define a ResourceKey for the salt block configured feature
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALT_BLOCK = registerKey("salt_block");

    // Bootstrap method to initialize and register configured features
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // Register the salt block configured feature
        register(context, SALT_BLOCK, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SALT_BLOCK.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.SAND)), UniformInt.of(2, 3), 1));
    }

    // Method to create a ResourceKey for a configured feature
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, name));
    }

    // Method to register a configured feature
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}