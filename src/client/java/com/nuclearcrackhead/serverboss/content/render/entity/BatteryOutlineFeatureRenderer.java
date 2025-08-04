package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityMainModel;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityModel;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityOutlineModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BatteryEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BreezeEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BreezeEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BatteryOutlineFeatureRenderer extends FeatureRenderer<BatteryEntityRenderState, BatteryEntityModel> {

    private static final RenderLayer TEXTURE = RenderLayer.getEntityTranslucentEmissiveNoOutline(SVBCR.of("textures/entity/battery_outline.png"));

    public BatteryOutlineFeatureRenderer(FeatureRendererContext<BatteryEntityRenderState, BatteryEntityModel> context, LoadedEntityModels loader) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, BatteryEntityRenderState state, float limbAngle, float limbDistance) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(TEXTURE);
        BatteryEntityModel batteryEntityModel = this.getContextModel();
        batteryEntityModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
    }

}
