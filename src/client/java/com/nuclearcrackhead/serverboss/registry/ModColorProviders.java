package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;

public class ModColorProviders {

    public static void init() {
        //blocks
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? -14647248 : -9321636,
                ModBlocks.WATER_SILK
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
