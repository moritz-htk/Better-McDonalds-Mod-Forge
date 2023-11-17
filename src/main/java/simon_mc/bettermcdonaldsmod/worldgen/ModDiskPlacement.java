package simon_mc.bettermcdonaldsmod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModDiskPlacement {
    public static List<PlacementModifier> modifiers(CountPlacement countPlacementModifier, InSquarePlacement squarePlacementModifier, HeightmapPlacement heightmapPlacementModifier, BlockPredicateFilter blockFilterPlacementModifier, BiomeFilter biomePlacementModifier) {
        return List.of(countPlacementModifier, squarePlacementModifier, heightmapPlacementModifier, blockFilterPlacementModifier, biomePlacementModifier);
    }
}