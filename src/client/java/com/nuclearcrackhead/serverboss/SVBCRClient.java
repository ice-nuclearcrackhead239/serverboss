package com.nuclearcrackhead.serverboss;

import com.nuclearcrackhead.serverboss.registry.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SVBCRClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModBlockEntityRenderers.init();
		ModItemGroups.init();
		ModBlockRenderMap.init();
		ModEntityRenderers.init();
		ModColorProviders.init();
		ModParticleFactories.init();
		ModScreens.init();
	}

}
