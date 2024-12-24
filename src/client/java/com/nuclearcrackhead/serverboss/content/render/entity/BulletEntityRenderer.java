package com.nuclearcrackhead.serverboss.content.render.entity;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.Identifier;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.entity.BulletEntity;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BulletEntityRenderState;
import com.nuclearcrackhead.serverboss.content.model.entity.BulletEntityModel;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;

public class BulletEntityRenderer extends EntityRenderer<BulletEntity, BulletEntityRenderState> {
	public final BulletEntityModel model;

	public BulletEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		model = new BulletEntityModel(context.getPart(ModEntityRenderers.MODEL_BULLET_LAYER));
	}

	public BulletEntityRenderState createRenderState() {
		return new BulletEntityRenderState();
	}

	public Identifier getTexture() {
		return SVBCR.of("textures/entity/bullet.png");
	}

	public void render(BulletEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		matrices.push();
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(getTexture()));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
		matrices.pop();
		super.render(state, matrices, vertexConsumers, light);
	}
}
