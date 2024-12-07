package com.nuclearcrackhead.serverboss;

import com.nuclearcrackhead.serverboss.registry.ModItemGroups;
import net.fabricmc.api.ClientModInitializer;

public class SVBCRClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ModItemGroups.init();
	}

}