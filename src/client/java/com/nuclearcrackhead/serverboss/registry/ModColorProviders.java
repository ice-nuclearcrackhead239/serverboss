package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Colors;
import net.minecraft.world.biome.GrassColors;

public class ModColorProviders {


    public static void init() {
        //blocks
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? view.getBiomeFabric(pos).value().getSkyColor() : Colors.WHITE,
                ModBlocks.B_DEV_SKY
        );
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? view.getBiomeFabric(pos).value().getSkyColor() : Colors.WHITE,
                ModBlocks.VOLUMETRIC_LIGHT
        );

        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : Colors.WHITE,
                ModBlocks.WATER_SILK
        );
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getWaterColor(view, pos) : Colors.WHITE,
                ModBlocks.PUDDLE
        );


        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : Colors.WHITE,
                Blocks.SEAGRASS
        );


        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : Colors.WHITE,
                Blocks.TALL_SEAGRASS
        );

        //items
        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> {
                    BlockState blockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                    BlockColorProvider blockColorProvider = (BlockColorProvider) ColorProviderRegistry.BLOCK.get(blockState.getBlock());
                    return blockColorProvider == null ? -1 : blockColorProvider.getColor(blockState, null, null, tintIndex);
                },
                ModItems.WATER_SILK
        );
    }

}
