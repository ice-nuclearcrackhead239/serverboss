package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_FLOWING;
import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;

public class ModBlockRenderMap {

    public static void init() {
        /*ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
		    registry.register(Identifier.of("svbcr:block/radioactive_still"));
		    registry.register(Identifier.of("svbcr:block/radioactive_flowing"));
		});*/

        FluidRenderHandlerRegistry.INSTANCE.register(RADIOACTIVE_STILL, RADIOACTIVE_FLOWING, new SimpleFluidRenderHandler(
                Identifier.of("svbcr:block/radioactive_still"),
                Identifier.of("svbcr:block/radioactive_flowing"),
                0xFFFFFF
        ));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.SLUDGE,
                ModBlocks.CHECKERED_OBSIDIAN,
                ModBlocks.CHISELED_OBSIDIAN,
                ModBlocks.OBSIDIAN_LIGHT_STRIP,
                ModBlocks.VOID_LAMP
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                ModBlocks.PORTAL_GLASS_TRANSPARENT,
                ModBlocks.WATER_SILK
        );

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RADIOACTIVE_STILL, RADIOACTIVE_FLOWING);
    }

}
