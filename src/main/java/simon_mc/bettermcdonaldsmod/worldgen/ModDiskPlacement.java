// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

// Class for defining and providing placement modifiers for disk features
public class ModDiskPlacement {
    // Method to provide a list of placement modifiers for disk features
    public static List<PlacementModifier> modifiers(CountPlacement countPlacementModifier, InSquarePlacement squarePlacementModifier, HeightmapPlacement heightmapPlacementModifier, BlockPredicateFilter blockFilterPlacementModifier, BiomeFilter biomePlacementModifier) {
        // Return a list containing the provided placement modifiers
        return List.of(countPlacementModifier, squarePlacementModifier, heightmapPlacementModifier, blockFilterPlacementModifier, biomePlacementModifier);
    }
}