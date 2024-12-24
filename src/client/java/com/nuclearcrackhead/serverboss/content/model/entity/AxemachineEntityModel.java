package com.nuclearcrackhead.serverboss.content.model.entity;

import com.nuclearcrackhead.serverboss.content.render.entity.state.AxemachineEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AxemachineEntityModel extends BipedEntityModel<AxemachineEntityRenderState> {
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart head;
	public AxemachineEntityModel(ModelPart root) {
		super(root);
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, -2.0F);
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(48, 16).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.0F, 0.0F));
		ModelPartData right_pants = right_leg.addChild("right_pants", ModelPartBuilder.create().uv(48, 34).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.25F)), ModelTransform.NONE);

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(48, 16).mirrored().cuboid(0.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 10.0F, 0.0F));
		ModelPartData left_pants = left_leg.addChild("left_pants", ModelPartBuilder.create().uv(48, 34).mirrored().cuboid(0.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.25F)).mirrored(false), ModelTransform.NONE);

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(24, 16).cuboid(-7.0F, -12.0F, -1.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 10.0F, -1.0F));
		ModelPartData jacket = body.addChild("jacket", ModelPartBuilder.create().uv(24, 32).cuboid(-7.0F, -12.0F, -1.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.NONE);

		ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(8, 16).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));
		ModelPartData right_sleeve = right_arm.addChild("right_sleeve", ModelPartBuilder.create().uv(8, 32).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.NONE);
		ModelPartData cube_r1 = right_arm.addChild("cube_r1", ModelPartBuilder.create().uv(0, 20).cuboid(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -2.3F, 0.0F, 0.0F, 0.0F, 0.0873F));

		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(8, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));
		ModelPartData left_sleeve = left_arm.addChild("left_sleeve", ModelPartBuilder.create().uv(24, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.NONE);

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
		ModelPartData antenna = head.addChild("antenna", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -12.0F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.NONE);
		ModelPartData hat = head.addChild("hat", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.25F)), ModelTransform.NONE);
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(AxemachineEntityRenderState state) {
		super.setAngles(state);

		//args from blockbench: AxemachineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch
	}
	/*
	@Override what do you want from me java
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		right_leg.render(matrices, vertexConsumer, light, overlay);
		left_leg.render(matrices, vertexConsumer, light, overlay);
		body.render(matrices, vertexConsumer, light, overlay);
		right_arm.render(matrices, vertexConsumer, light, overlay);
		left_arm.render(matrices, vertexConsumer, light, overlay);
		head.render(matrices, vertexConsumer, light, overlay);
	}
	*/
}