// Import necessary classes and packages
package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import simon_mc.bettermcdonaldsmod.block.custom.TomatoCropBlock;

import java.util.function.Function;

// Custom block state provider for defining block states and models
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        // Initialize the block state provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Define block states and models for the custom blocks
        simpleBlockWithItem(ModBlocks.SALT_BLOCK.get(), cubeAll(ModBlocks.SALT_BLOCK.get()));
        makeTomatoCrop((TomatoCropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeLettuceCrop((LettuceCropBlock) ModBlocks.LETTUCE_CROP.get(), "lettuce_stage", "lettuce_stage");
    }

    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        // Define block states and models for the tomato crop block
        Function<BlockState, ConfiguredModel[]> function = state -> tomatoCropStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] tomatoCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        // Define configured models for different growth stages of the tomato crop
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()), new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    public void makeLettuceCrop(CropBlock block, String modelName, String textureName) {
        // Define block states and models for the lettuce crop block
        Function<BlockState, ConfiguredModel[]> function = state -> lettuceCropStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lettuceCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        // Define configured models for different growth stages of the lettuce crop
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LettuceCropBlock) block).getAgeProperty()), new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "block/" + textureName + state.getValue(((LettuceCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
}