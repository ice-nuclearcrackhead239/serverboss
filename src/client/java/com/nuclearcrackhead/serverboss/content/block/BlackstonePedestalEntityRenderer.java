package com.nuclearcrackhead.serverboss.content.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public class BlackstonePedestalEntityRenderer implements BlockEntityRenderer<BlackstonePedestalEntity> {
	private final BookModel book;

	public BlackstonePedestalEntityRenderer(BlockEntityRendererFactory.Context ctx) {
		this.book = new BookModel(ctx.getLayerModelPart(EntityModelLayers.BOOK));
	}

	public void render(BlackstonePedestalEntity lecternBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
		BlockState blockState = lecternBlockEntity.getCachedState();
		if ((Boolean)blockState.get(BlackstonePedestal.HAS_BOOK)) {
			matrixStack.push();
			matrixStack.translate(0.5F, 1.0625F, 0.5F);
			float g = ((Direction)blockState.get(BlackstonePedestal.FACING)).rotateYClockwise().asRotation();
			matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-g));
			matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(67.5F));
			matrixStack.translate(0.0F, -0.125F, 0.0F);
			this.book.setPageAngles(0.0F, 0.1F, 0.9F, 1.2F);
			VertexConsumer vertexConsumer = EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid);
			this.book.render(matrixStack, vertexConsumer, i, j);
			matrixStack.pop();
		}
	}
}
