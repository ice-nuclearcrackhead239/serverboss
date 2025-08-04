package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class InvertBlockEntityRenderer implements BlockEntityRenderer<InvertBlockEntity> {

    private final ModelPart root;


    public static final Identifier TEXTURE = SVBCR.of("textures/block/wht.png");
    public static final EntityModelLayer LAYER = new EntityModelLayer(SVBCR.of("shader_invert"), "main");

    public InvertBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        ModelPart root = context.getLayerModelPart(LAYER);
        this.root = root;
    }

    public void render(InvertBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        World world = blockEntity.getWorld();

        matrices.translate(0.5F, 1.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));


        //VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getEndGateway());
        VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getCrosshair(TEXTURE));

        this.root.render(matrices, vertices, light, overlay);
        matrices.pop();
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }
}
