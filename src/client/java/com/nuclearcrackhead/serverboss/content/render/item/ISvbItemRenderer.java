package com.nuclearcrackhead.serverboss.content.render.item;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.item.ItemStack;	
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;

/**
 * Controls how items are rendered.
 *
 * @author Finxx
 */
public interface ISvbItemRenderer {
	/**
	 * Called when the item needs to be rendered.
	 *
	 * @param matrices the matrix stack
	 * @param vertexConsumers the vertices
	 * @param player the player
	 * @param item the held item
	 * @param swingProgress the progress of the swing, from 0.0 to 1.0
	 * @param equipProgress the progress of equipping, from 0.0 to 1.0
	 * @param hand the hand to render the item in (left or right)
	 * @param light the light level
	 */
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, AbstractClientPlayerEntity player, ItemStack item, float swingProgress, float equipProgress, Hand hand, int light);
}
