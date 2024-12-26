package com.nuclearcrackhead.serverboss.content.render.item;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.item.ItemStack;	
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.util.Hand;
import net.minecraft.client.MinecraftClient;

public class PistolItemRenderer implements ISvbItemRenderer {
	public ItemRenderer itemRenderer;

	public PistolItemRenderer() {
		this.itemRenderer = MinecraftClient.getInstance().getItemRenderer();
	}

	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, AbstractClientPlayerEntity player, ItemStack item, float swingProgress, float equipProgress, Hand hand, int light) {
		float milestone = 0.2f;
		matrices.translate(1.0f, 0, 0);
		if (swingProgress < milestone) {
			float sectionProgress = swingProgress * (1f/milestone);
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(sectionProgress * 45));
		} else {
			float sectionProgress = (swingProgress - milestone) * (1f/(1f-milestone));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees((1 - sectionProgress) * 45));
		}
		matrices.translate(-0.5, -0.5, -0.5);
		itemRenderer.renderItem(player, item, ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, false, matrices, vertexConsumers, player.getWorld(), light, OverlayTexture.DEFAULT_UV, 2);
	}
}
