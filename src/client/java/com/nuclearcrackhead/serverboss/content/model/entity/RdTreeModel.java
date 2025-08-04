package com.nuclearcrackhead.serverboss.content.model.entity;

import com.nuclearcrackhead.serverboss.content.render.entity.state.RdTreeRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RdTreeModel extends EntityModel<RdTreeRenderState> {
	private final ModelPart bb_main;
	public RdTreeModel(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(0, -128).cuboid(0.0F, -64.0F, -64.0F, 0.0F, 128.0F, 128.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -64.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(0, -128).cuboid(0.0F, -64.0F, -64.0F, 0.0F, 128.0F, 128.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -64.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay);
	}
}