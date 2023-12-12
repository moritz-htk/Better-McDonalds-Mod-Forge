// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import simon_mc.bettermcdonaldsmod.block.custom.TomatoCropBlock;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.Set;

// Custom provider for defining block loot tables
public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        // Initialize the provider with an empty set of known blocks and all feature flags
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Define the loot drop for the SALT_BLOCK
        add(ModBlocks.SALT_BLOCK.get(), (block) ->
                // Create an ore drop with the specified items and set item count function
                createOreDrop(ModBlocks.SALT_BLOCK.get(), ModItems.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));

        // Define the loot conditions for fully grown TOMATO_CROP
        LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        // Add loot drops for fully grown TOMATO_CROP
        add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), tomatoConditionBuilder));

        // Define the loot conditions for fully grown LETTUCE_CROP
        LootItemCondition.Builder lettuceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LETTUCE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LettuceCropBlock.AGE, 3));

        // Add loot drops for fully grown LETTUCE_CROP
        add(ModBlocks.LETTUCE_CROP.get(), createCropDrops(ModBlocks.LETTUCE_CROP.get(), ModItems.LETTUCE.get(), ModItems.LETTUCE_SEEDS.get(), lettuceConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Retrieve all blocks registered in the ModBlocks.BLOCKS deferred register
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}