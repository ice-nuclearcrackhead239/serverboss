package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.content.entity.BatteryEntity;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityMainModel;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BatteryEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.BreezeEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BatteryEntityRenderer extends MobEntityRenderer<BatteryEntity, BatteryEntityRenderState, BatteryEntityModel> {

    public BatteryEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BatteryEntityModel(context.getPart(ModEntityRenderers.MODEL_BATTERY_LAYER)), 0.5f);
        this.addFeature(new BatteryOutlineFeatureRenderer(this, context.getEntityModels()));
    }

    @Override
    public BatteryEntityRenderState createRenderState() {
        return new BatteryEntityRenderState();
    }

    @Override
    public Identifier getTexture(BatteryEntityRenderState state) {
        return Identifier.of("svbcr", "textures/entity/battery_base.png");
    }

}
