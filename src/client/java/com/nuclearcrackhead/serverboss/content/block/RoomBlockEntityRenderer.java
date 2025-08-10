package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexRendering;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class RoomBlockEntityRenderer implements BlockEntityRenderer<RoomBlockEntity> {
	public RoomBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}
	
	@Override
	public void render(RoomBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		if (!MinecraftClient.getInstance().player.isCreativeLevelTwoOp()) {
			return;
		}

		if (!blockEntity.showBoundingBox) {
			return;
		}

		Vec3d pos1 = new Vec3d(blockEntity.offset);
		Vec3d pos2 = pos1.add(new Vec3d(blockEntity.size));
		VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getLines());
		VertexRendering.drawBox(matrices, consumer, pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ(), 0.9F, 0.9F, 0.9F, 1.0F, 0.5F, 0.5F, 0.5F);
	}
}
