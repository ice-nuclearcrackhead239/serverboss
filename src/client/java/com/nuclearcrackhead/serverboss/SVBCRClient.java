package com.nuclearcrackhead.serverboss;

import com.nuclearcrackhead.serverboss.registry.ModBlockRenderMap;
import com.nuclearcrackhead.serverboss.registry.ModBlocks;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import com.nuclearcrackhead.serverboss.registry.ModItemGroups;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_FLOWING;
import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;

@Environment(EnvType.CLIENT)
public class SVBCRClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ModItemGroups.init();
		ModBlockRenderMap.init();
		ModEntityRenderers.init();
	}

}