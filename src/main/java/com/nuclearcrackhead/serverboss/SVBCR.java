package com.nuclearcrackhead.serverboss;

import com.nuclearcrackhead.serverboss.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVBCR implements ModInitializer {

	public static final String MOD_ID = "svbcr";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModItems.init();
		ModFluids.init();
		ModBlocks.init();
		ModDamageTypes.init();
		ModSounds.init();
		ExtraPacks.init();
		ModBlockEntityTypes.init();
		ModEntities.init();
	}
}