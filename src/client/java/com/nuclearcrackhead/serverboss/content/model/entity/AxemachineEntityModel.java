package com.nuclearcrackhead.serverboss.content.model.entity;

import com.nuclearcrackhead.serverboss.content.entity.AxemachineEntity;
import com.nuclearcrackhead.serverboss.content.render.entity.state.AxemachineEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AxemachineEntityModel extends EntityModel<AxemachineEntityRenderState> {
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart head;
	public AxemachineEntityModel(ModelPart root) {
		super(root);
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData rightleg = modelPartData.addChild("rightleg", ModelPartBuilder.create().uv(48, 16).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F))
		.uv(48, 34).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

		ModelPartData leftleg = modelPartData.addChild("leftleg", ModelPartBuilder.create().uv(48, 16).mirrored().cuboid(0.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(48, 34).mirrored().cuboid(0.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.25F)).mirrored(false), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(24, 16).cuboid(-7.0F, -12.0F, -1.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 32).cuboid(-7.0F, -12.0F, -1.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(3.0F, 10.0F, -1.0F));

		ModelPartData rightarm = modelPartData.addChild("rightarm", ModelPartBuilder.create().uv(8, 16).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 32).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = rightarm.addChild("cube_r1", ModelPartBuilder.create().uv(0, 20).cuboid(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -2.3F, 0.0F, 0.0F, 0.0F, 0.0873F));

		ModelPartData leftarm = modelPartData.addChild("leftarm", ModelPartBuilder.create().uv(8, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -12.0F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
		.uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(AxemachineEntityRenderState state) {
		//figure out what the hell to do with this later
		//args from blockbench: AxemachineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch
	}
	/*
	@Override what do you want from me java
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		rightleg.render(matrices, vertexConsumer, light, overlay);
		leftleg.render(matrices, vertexConsumer, light, overlay);
		body.render(matrices, vertexConsumer, light, overlay);
		rightarm.render(matrices, vertexConsumer, light, overlay);
		leftarm.render(matrices, vertexConsumer, light, overlay);
		head.render(matrices, vertexConsumer, light, overlay);
	}
	*/
}