package com.nuclearcrackhead.serverboss.content.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class BatteryEntityRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();

    public BatteryEntityRenderState() {}
}
