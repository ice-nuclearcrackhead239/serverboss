package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.content.block.BlackstonePedestalEntityRenderer;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRenderers {
	public static void init() {
		BlockEntityRendererFactories.register(ModBlockEntityTypes.BLACKSTONE_PEDESTAL, BlackstonePedestalEntityRenderer::new);
		//BlockEntityRendererFactories.register(ModBlockEntityTypes.SKYBOX_HUB, SkyboxHubEntityRenderer::new);
	}
}
