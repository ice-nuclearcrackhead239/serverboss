package com.nuclearcrackhead.serverboss.content.render.entity.state;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class LithostructDroneEntityRenderState extends LivingEntityRenderState {
    public boolean fractured;
    public boolean dead;
    public final AnimationState spawningAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState swipeRightAnimationState = new AnimationState();
    public final AnimationState swipeLeftAnimationState = new AnimationState();
    public final AnimationState shootAnimationState = new AnimationState();
    public final AnimationState deathAnimationState = new AnimationState();

    public LithostructDroneEntityRenderState () {}
}
