package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.entity.LithostructDroneEntity;
import com.nuclearcrackhead.serverboss.content.model.entity.LithostructDroneEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.AxemachineEntityRenderState;
import com.nuclearcrackhead.serverboss.content.render.entity.state.LithostructDroneEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class LithostructDroneEntityRenderer extends LivingEntityRenderer<LithostructDroneEntity, LithostructDroneEntityRenderState, LithostructDroneEntityModel> {

    public LithostructDroneEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LithostructDroneEntityModel(context.getPart(ModEntityRenderers.MODEL_LITHOSTRUCT_DRONE_LAYER)), 0.5f);
    }

    @Override
    public LithostructDroneEntityRenderState createRenderState() {
        return new LithostructDroneEntityRenderState();
    }

    @Override
    public Identifier getTexture(LithostructDroneEntityRenderState state) {
        if (state.fractured) {
            return SVBCR.of("textures/entity/lithostruct_drone_fracture.png");
        } else {
            return SVBCR.of("textures/entity/lithostruct_drone.png");
        }
    }

}
