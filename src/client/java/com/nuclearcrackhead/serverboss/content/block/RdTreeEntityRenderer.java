package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class RdTreeEntityRenderer implements BlockEntityRenderer<RdTree> {

    private final ModelPart root;


    public static final Identifier TEXTURE = SVBCR.of("textures/block/rd_tree.png");
    public static final EntityModelLayer LAYER = new EntityModelLayer(SVBCR.of("rd_tree"), "main");

    public RdTreeEntityRenderer(BlockEntityRendererFactory.Context context) {
        ModelPart root = context.getLayerModelPart(LAYER);
        this.root = root;
    }

    public void render(RdTree blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        World world = blockEntity.getWorld();

        matrices.translate(0.5F, 1.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));


        VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));

        this.root.render(matrices, vertices, light, overlay);
        matrices.pop();
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(0, -128).cuboid(0.0F, -64.0F, -64.0F, 0.0F, 128.0F, 128.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -64.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(0, -128).cuboid(0.0F, -64.0F, -64.0F, 0.0F, 128.0F, 128.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -64.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
}
