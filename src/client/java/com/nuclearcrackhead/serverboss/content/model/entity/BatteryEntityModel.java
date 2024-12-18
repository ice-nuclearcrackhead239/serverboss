package com.nuclearcrackhead.serverboss.content.model.entity;

import com.nuclearcrackhead.serverboss.content.entity.BatteryEntity;
import com.nuclearcrackhead.serverboss.content.render.entity.BatteryEntityRenderer;
import com.nuclearcrackhead.serverboss.content.render.entity.state.AxemachineEntityRenderState;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BatteryEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;


public class BatteryEntityModel extends EntityModel<BatteryEntityRenderState> {
	private final ModelPart head;
	private final ModelPart top;
	private final ModelPart rod5;
	private final ModelPart rod6;
	private final ModelPart rod7;
	private final ModelPart rod8;
	private final ModelPart bottom;
	private final ModelPart rod2;
	private final ModelPart rod3;
	private final ModelPart rod4;
	private final ModelPart rod9;
	public BatteryEntityModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.top = root.getChild("top");
		this.rod5 = this.top.getChild("rod5");
		this.rod6 = this.top.getChild("rod6");
		this.rod7 = this.top.getChild("rod7");
		this.rod8 = this.top.getChild("rod8");
		this.bottom = root.getChild("bottom");
		this.rod2 = this.bottom.getChild("rod2");
		this.rod3 = this.bottom.getChild("rod3");
		this.rod4 = this.bottom.getChild("rod4");
		this.rod9 = this.bottom.getChild("rod9");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-8.25F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

		ModelPartData top = modelPartData.addChild("top", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData rod5 = top.addChild("rod5", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(33, 49).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(9.0F, -23.0F, 9.0F));

		ModelPartData rod6 = top.addChild("rod6", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(35, 46).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(-9.0F, -23.0F, 9.0F));

		ModelPartData rod7 = top.addChild("rod7", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 46).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(9.0F, -23.0F, -9.0F));

		ModelPartData rod8 = top.addChild("rod8", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 46).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(-9.0F, -23.0F, -9.0F));

		ModelPartData bottom = modelPartData.addChild("bottom", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData rod2 = bottom.addChild("rod2", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 46).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(9.0F, -11.0F, 9.0F));

		ModelPartData rod3 = bottom.addChild("rod3", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 46).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(-9.0F, -11.0F, 9.0F));

		ModelPartData rod4 = bottom.addChild("rod4", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 44).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(9.0F, -11.0F, -9.0F));

		ModelPartData rod9 = bottom.addChild("rod9", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 44).cuboid(1.0F, 4.0F, 1.0F, -2.0F, -8.0F, -2.0F, new Dilation(-0.25F)), ModelTransform.pivot(-9.0F, -11.0F, -9.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(BatteryEntityRenderState state) {
		super.setAngles(state);

		//args from blockbench: AxemachineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch
	}

	//BatteryEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch
	/*
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		top.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bottom.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}*/
}