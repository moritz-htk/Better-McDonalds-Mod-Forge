// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.world;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

// Class for registering biome modifiers
public class ModBiomeModifiers {
    // Define a ResourceKey for the salt block biome modifier
    public static final ResourceKey<BiomeModifier> SALT_BLOCK = registerKey("salt_block");

    // Bootstrap method to initialize and register biome modifiers
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        // Register the salt block biome modifier
        context.register(SALT_BLOCK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomeGetter.getOrThrow(BiomeTags.IS_RIVER), HolderSet.direct(placedFeatureGetter.getOrThrow(ModPlacedFeatures.SALT_BLOCK)), GenerationStep.Decoration.RAW_GENERATION));
    }

    // Method to create a ResourceKey for a biome modifier
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, name));
    }
}