package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.content.entity.BatteryEntity;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.BatteryEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BatteryEntityRenderer extends MobEntityRenderer<BatteryEntity, BatteryEntityRenderState, BatteryEntityModel> {

    public BatteryEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BatteryEntityModel(context.getPart(ModEntityRenderers.MODEL_BATTERY_LAYER)), 0.5f);
    }

    @Override
    public BatteryEntityRenderState createRenderState() {
        return new BatteryEntityRenderState();
    }

    @Override
    public Identifier getTexture(BatteryEntityRenderState state) {
        return Identifier.of("svbcr", "textures/entity/battery.png");
    }

}
