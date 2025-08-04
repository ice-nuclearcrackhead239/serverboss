package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityMainModel;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityOutlineModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BatteryEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BatteryOutlineRenderer extends FeatureRenderer<BatteryEntityRenderState, BatteryEntityMainModel> {

    private final EntityModel<BatteryEntityRenderState> outlineModel;

    public BatteryOutlineRenderer(FeatureRendererContext<BatteryEntityRenderState, BatteryEntityMainModel> context, LoadedEntityModels loader) {
        super(context);
        this.outlineModel = new BatteryEntityOutlineModel(loader.getModelPart(ModEntityRenderers.MODEL_BATTERY_LAYER));
    }

    public Identifier getTexture() {
        return Identifier.of("svbcr", "textures/entity/battery.png");
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, BatteryEntityRenderState state, float limbAngle, float limbDistance) {
        RenderLayer layer = RenderLayer.getEntityCutoutNoCull(this.getTexture());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(layer);
        this.outlineModel.render(matrices, vertexConsumer, 240, OverlayTexture.DEFAULT_UV);
    }

}
