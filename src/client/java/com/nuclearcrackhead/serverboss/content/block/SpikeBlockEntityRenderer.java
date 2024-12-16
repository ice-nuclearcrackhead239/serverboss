package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.content.block.SpikeBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;

/*
 * FUCKING KILL YOURSELF YOU GOD DAMN STUPID API
 * I HOPE YOU DIE IN A HOUSE FIRE FROM THE ROOF COLLAPSING ON YOU
 */
public class SpikeBlockEntityRenderer implements BlockEntityRenderer<SpikeBlockEntity> {
	//public static final Identifier SPIKE_TEXTURE = Identifier.ofVanilla("dirt");
	//public static final EntityModelLayer SPIKE_MODEL = new EntityModelLayer(Identifier.of("svbcr", "spike"), "main");
	
	public Model model;
	
	public SpikeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
		//ModelPart modelPart = ctx.getLayerRenderDispatcher().getModelPart(SPIKE_MODEL);
		//model = new Model.SinglePartModel(modelPart, RenderLayer::getEntitySolid);
	}
	
	@Override
	public void render(SpikeBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		if (blockEntity.spikeTimer > 0) {
			//matrices.push();
			//SpriteIdentifier spriteIdentifier = new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, SPIKE_TEXTURE);
			//VertexConsumer vertices = spriteIdentifier.getVertexConsumer(vertexConsumers, model::getLayer);
			//model.render(matrices, vertices, light, overlay);
			//matrices.pop();
		}
	}
}