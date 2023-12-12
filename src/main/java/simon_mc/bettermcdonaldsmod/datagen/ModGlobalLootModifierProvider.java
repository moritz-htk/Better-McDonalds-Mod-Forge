// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.item.ModItems;
import simon_mc.bettermcdonaldsmod.loot.AddItemModifier;

// Custom global loot modifier provider for generating loot modifiers
public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        // Initialize the global loot modifier provider with the mod's output and ID
        super(output, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void start() {
        // Define loot modifiers for seeds obtained from grass and fern blocks
        addLootModifier("tomato_seeds_from_grass", Blocks.GRASS, ModItems.TOMATO_SEEDS.get());
        addLootModifier("tomato_seeds_from_fern", Blocks.FERN, ModItems.TOMATO_SEEDS.get());
        addLootModifier("lettuce_seeds_from_grass", Blocks.GRASS, ModItems.LETTUCE_SEEDS.get());
        addLootModifier("lettuce_seeds_from_fern", Blocks.FERN, ModItems.LETTUCE_SEEDS.get());
    }

    private void addLootModifier(String name, Block block, Item item) {
        // Define loot conditions to trigger the loot modifier
        LootItemCondition[] conditions = new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        };

        // Define loot conditions to trigger the loot modifier
        add(name, new AddItemModifier(conditions, item));
    }
}