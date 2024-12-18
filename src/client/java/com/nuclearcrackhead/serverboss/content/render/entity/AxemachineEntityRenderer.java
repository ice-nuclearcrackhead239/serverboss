package com.nuclearcrackhead.serverboss.content.render.entity;

import com.nuclearcrackhead.serverboss.SVBCRClient;
import com.nuclearcrackhead.serverboss.content.entity.AxemachineEntity;
import com.nuclearcrackhead.serverboss.content.model.entity.AxemachineEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.state.AxemachineEntityRenderState;
import com.nuclearcrackhead.serverboss.registry.ModEntityRenderers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class AxemachineEntityRenderer extends BipedEntityRenderer<AxemachineEntity, AxemachineEntityRenderState, AxemachineEntityModel> {

    public AxemachineEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AxemachineEntityModel(context.getPart(ModEntityRenderers.MODEL_AXEMACHINE_LAYER)), 0.5f);
    }

    @Override
    public AxemachineEntityRenderState createRenderState() {
        return new AxemachineEntityRenderState();
    }

    @Override
    public Identifier getTexture(AxemachineEntityRenderState state) {
        return Identifier.of("svbcr", "textures/entity/axemachine.png");
    }

}
