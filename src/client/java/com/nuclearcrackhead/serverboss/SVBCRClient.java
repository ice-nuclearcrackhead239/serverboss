package com.nuclearcrackhead.serverboss;

import com.nuclearcrackhead.serverboss.registry.*;
import com.nuclearcrackhead.serverboss.content.block.SpikeBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
//import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.texture.SpriteAtlasTexture;

import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_FLOWING;
import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;

@Environment(EnvType.CLIENT)
public class SVBCRClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		/*ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
		    //registry.register(Identifier.of("svbcr:block/radioactive_still"));
		    //registry.register(Identifier.of("svbcr:block/radioactive_flowing"));
			registry.register(Identifier.of("svbcr", "block/spikeblock_spikes"));
		});*/ // fuck fuck fuck fuck fuck -finxx
		
		BlockEntityRendererFactories.register(ModBlockEntityTypes.SPIKE_BLOCK, SpikeBlockEntityRenderer::new);

		ModItemGroups.init();
		ModBlockRenderMap.init();
		ModEntityRenderers.init();
		ModColorProviders.init();
	}

}