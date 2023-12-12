// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import simon_mc.bettermcdonaldsmod.loot.ModBlockLootTables;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    // Create a method to create a LootTableProvider instance
    public static LootTableProvider create(PackOutput output) {
        // Return a new instance of LootTableProvider with defined subproviders
        return new LootTableProvider(
                output, // Pack output location
                Set.of(), // A set of namespace prefixes
                List.of(new LootTableProvider.SubProviderEntry(
                        ModBlockLootTables::new, // The subprovider class for block loot tables
                        LootContextParamSets.BLOCK // The context parameter set (in this case, for blocks)
                        )));
    }
}