package com.nuclearcrackhead.serverboss.content.render.item;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.item.ItemStack;	
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;

public interface ISvbItemRenderer {
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, AbstractClientPlayerEntity player, ItemStack item, float swingProgress, float equipProgress, Hand hand, int light);
}
