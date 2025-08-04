package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.block.Blocks;
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
                ModBlocks.CHECKERED_OBSIDIAN,
                ModBlocks.CHISELED_OBSIDIAN,
                ModBlocks.OBSIDIAN_LIGHT_STRIP,
                ModBlocks.RIVERBRICKS,
                ModBlocks.RIVERBRICKLETS,
                ModBlocks.RIVERLAMP,
                ModBlocks.RIVERTILES,
                ModBlocks.RIVEREYES,
                ModBlocks.RIVERSTONE,
                ModBlocks.AGONY_LANTERN,
                ModBlocks.NETHERITE_CHAIN,
                ModBlocks.DEMONIC_GATE,
                ModBlocks.CHISELED_POLISHED_BLACKSTONE_EYES,
                ModBlocks.SPEED_PAD,
                ModBlocks.BOUNCE_PAD,
                ModBlocks.CRIMSON_STALKS,
                ModBlocks.WARPED_STALKS,
                ModBlocks.TRASH,
                ModBlocks.TRASH_SPREAD,
                ModBlocks.FIREBLU,
                ModBlocks.GRAVEL_PATCH,
                ModBlocks.GLOWING_MUSHROOMS,
                ModBlocks.METAL_LADDER,
                ModBlocks.MYCELIA,
                ModBlocks.MYCELIA_BLOOM,
                ModBlocks.MYCELIA_STALKS,
                ModBlocks.MYCELIA_STALKS,
                ModBlocks.MYCELIAL_EYE,
                ModBlocks.HUB_GLASS,
                ModBlocks.HUB_TORCH,
                ModBlocks.LARGE_TORCH,
                ModBlocks.HUB_WALL_TORCH,
                ModBlocks.CRIMSON_VEINS,
                ModBlocks.WARPED_WIREFRAME,
                ModBlocks.IRON_GRATING,
		        ModBlocks.BARBED_WIRE,
                ModBlocks.PORTAL_LEGACY,
                ModBlocks.ELECTRIC,
                ModBlocks.WATER_LILY,
                ModBlocks.OBSTERINE,
                ModBlocks.AXTERIA,
                ModBlocks.BUTTERCUPS,
                ModBlocks.GLASS_PIPE,
                ModBlocks.NETHERITE_BARS,
                ModBlocks.COPPER_BARS,
                ModBlocks.HAZARD_TAPE,
                ModBlocks.FLESH_POLYP,
                ModBlocks.FLESH_PUSTULE,
                ModBlocks.FLESH_CAPILLARIES,
                ModBlocks.ROSE,
                ModBlocks.CRYSTALLINE_GLASS,
                ModBlocks.FUMO_ICE,
                ModBlocks.FUMO_OBI,
                ModBlocks.FUMO_SOUMEH,
                ModBlocks.FUMO_DERZOX,
                ModBlocks.FUMO_HEAPONS,
                ModBlocks.FUMO_JOSE,
                ModBlocks.FUMO_AVARITA,
                ModBlocks.FUMO_MIKII,
                ModBlocks.FUMO_SPEEDER,
                ModBlocks.FUMO_TOBI,
                ModBlocks.FUMO_ISM,
                ModBlocks.FUMO_BERYL,
                ModBlocks.FUMO_ILYA,
                Blocks.MAGMA_BLOCK, //DONT ASK
                ModBlocks.VOID_LAMP //moving to end again simply so i can copypaste without having to worry about removing the last ,
        );

        /*BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getGlintTranslucent(),
                ModBlocks.VOLUMETRIC_LIGHT
        );*/

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                ModBlocks.PORTAL_GLASS_TRANSPARENT,
                ModBlocks.DARK_GLASS,
                ModBlocks.AGONIZED_GLASS,
                ModBlocks.FORCEFIELD,
                ModBlocks.FUMO_RIKA, //glasses
                ModBlocks.FUMO_KAORI,
                ModBlocks.JELLY_TRANSLUCENT,
                //ModBlocks.FORCEFIELD_WATER,
                ModBlocks.PUDDLE,
                ModBlocks.DUST,
                ModBlocks.FLESH_MESH,
                ModBlocks.B_DEV_CLEAR,
                ModBlocks.VOLUMETRIC_LIGHT,
                ModBlocks.WATER_SILK
        );

        /*
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getEndGateway(),
                ModBlocks.SKYBOX_SPACE
        );*/

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RADIOACTIVE_STILL, RADIOACTIVE_FLOWING);
    }

}
