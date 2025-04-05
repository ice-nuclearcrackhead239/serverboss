package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GrassColors;

public class ModColorProviders {

    public static final int DEFAULT_SKY_COLOR = 7907327;

    public static int getSkyColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {
        if (view == null || pos == null) return Colors.WHITE;
        RegistryEntry<Biome> biomeEntry = view.getBiomeFabric(pos);
        if (biomeEntry == null) return DEFAULT_SKY_COLOR;
        return biomeEntry.value().getSkyColor();
    }

    public static void init() {
        //blocks
        ColorProviderRegistry.BLOCK.register(
                ModColorProviders::getSkyColor,
                ModBlocks.B_DEV_SKY,
                ModBlocks.VOLUMETRIC_LIGHT
        );
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : Colors.WHITE,
                ModBlocks.WATER_SILK,
                Blocks.SEAGRASS,
                Blocks.TALL_SEAGRASS
        );
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getWaterColor(view, pos) : Colors.WHITE,
                ModBlocks.PUDDLE
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
