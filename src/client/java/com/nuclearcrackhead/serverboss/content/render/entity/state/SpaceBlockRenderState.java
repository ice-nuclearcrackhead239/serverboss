package com.nuclearcrackhead.serverboss.content.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class SpaceBlockRenderState extends EntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();

    public SpaceBlockRenderState() {}
}
