package com.nuclearcrackhead.serverboss.content.model.entity;

import com.nuclearcrackhead.serverboss.content.render.entity.state.LithostructDroneEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class LithostructDroneEntityModel extends EntityModel<LithostructDroneEntityRenderState> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart lefthorn;
	private final ModelPart righthorn;
	private final ModelPart leftblade;
	private final ModelPart rightblade;
	public LithostructDroneEntityModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.head = this.root.getChild("head");
		this.lefthorn = this.root.getChild("lefthorn");
		this.righthorn = this.root.getChild("righthorn");
		this.leftblade = this.root.getChild("leftblade");
		this.rightblade = this.root.getChild("rightblade");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -8.0F, -7.0F, 15.0F, 15.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.5F, -0.5F));

		ModelPartData lefthorn = root.addChild("lefthorn", ModelPartBuilder.create().uv(0, 30).cuboid(1.5F, -18.0F, 0.0F, 9.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -3.0F, 0.0F, -0.2618F, 0.0F, -0.2618F));

		ModelPartData righthorn = root.addChild("righthorn", ModelPartBuilder.create().uv(18, 30).cuboid(-10.5F, -18.0F, 0.0F, 9.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -3.0F, 0.0F, -0.2618F, 0.0F, 0.2618F));

		ModelPartData leftblade = root.addChild("leftblade", ModelPartBuilder.create().uv(36, 30).cuboid(1.0F, 2.0F, -2.5F, 4.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 50).cuboid(1.0F, 9.0F, -1.5F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F))
		.uv(12, 50).cuboid(-2.0F, 3.0F, 0.0F, 4.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 7.0F, 0.0F));

		ModelPartData rightblade = root.addChild("rightblade", ModelPartBuilder.create().uv(36, 42).cuboid(-5.0F, 2.0F, -2.5F, 4.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(20, 50).cuboid(-4.0F, 9.0F, -1.5F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F))
		.uv(54, 30).cuboid(-2.0F, 3.0F, 0.0F, 4.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 7.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	/*
	@Override
	public void setAngles(LithostructDroneEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	 */
}