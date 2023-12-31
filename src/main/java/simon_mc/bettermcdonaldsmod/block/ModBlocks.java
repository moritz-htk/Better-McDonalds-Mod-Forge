// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import simon_mc.bettermcdonaldsmod.block.custom.TomatoCropBlock;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.function.Supplier;

// Class for registering custom blocks using DeferredRegister
public class ModBlocks {
    // Class for registering custom blocks using DeferredRegister
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMcDonaldsMod.MOD_ID);

    // Register each custom block using a RegistryObject
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock(() -> new FallingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)) {
        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return null;
        }
    });
    public static final RegistryObject<Block> TOMATO_CROP = registerCropBlock("tomato_crop", () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> LETTUCE_CROP = registerCropBlock("lettuce_crop", () -> new LettuceCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().noOcclusion()));

    // Method to register a custom block and its associated BlockItem
    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register("salt_block", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    // Method to register a BlockItem for a custom block
    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {
        ModItems.ITEMS.register("salt_block", () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Method to register a custom crop block
    private static <T extends Block> RegistryObject<T> registerCropBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    // Method to register the blocks to the event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}