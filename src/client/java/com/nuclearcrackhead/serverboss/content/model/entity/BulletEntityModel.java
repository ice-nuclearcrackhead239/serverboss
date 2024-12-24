package com.nuclearcrackhead.serverboss.content.model.entity;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.*;

import com.nuclearcrackhead.serverboss.content.render.entity.state.BulletEntityRenderState;

public class BulletEntityModel extends EntityModel<BulletEntityRenderState> {
	private final ModelPart bb_main;
	public BulletEntityModel(ModelPart root) {
		super(root);
		this.bb_main = root.getChild("bb_main");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(2, 1).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	// this stuff is from blockbench being dumb (we think, not sure)
	/*
	@Override
	public void setAngles(BulletEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}*/
}
