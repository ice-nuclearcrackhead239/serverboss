package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.content.block.BlackstonePedestalEntityRenderer;
import com.nuclearcrackhead.serverboss.content.block.InvertBlockEntityRenderer;
import com.nuclearcrackhead.serverboss.content.block.RdTreeEntityRenderer;
import com.nuclearcrackhead.serverboss.content.block.SpaceBlockEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRenderers {
	public static void init() {
		BlockEntityRendererFactories.register(ModBlockEntityTypes.BLACKSTONE_PEDESTAL, BlackstonePedestalEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntityTypes.RD_TREE, RdTreeEntityRenderer::new);

		BlockEntityRendererFactories.register(ModBlockEntityTypes.SPACE_BLOCK_ENTITY, SpaceBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntityTypes.INVERT_BLOCK_ENTITY, InvertBlockEntityRenderer::new);


		EntityModelLayerRegistry.registerModelLayer(RdTreeEntityRenderer.LAYER, RdTreeEntityRenderer::getTexturedModelData);

		EntityModelLayerRegistry.registerModelLayer(SpaceBlockEntityRenderer.LAYER, SpaceBlockEntityRenderer::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(InvertBlockEntityRenderer.LAYER, InvertBlockEntityRenderer::getTexturedModelData);
	}
}
