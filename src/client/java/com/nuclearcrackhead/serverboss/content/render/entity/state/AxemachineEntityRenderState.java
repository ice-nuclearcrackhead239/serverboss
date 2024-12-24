package com.nuclearcrackhead.serverboss.content.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class AxemachineEntityRenderState extends BipedEntityRenderState {
    public boolean stunned;
    public final AnimationState swingAnimationState = new AnimationState();
    public final AnimationState bowStartAnimationState = new AnimationState();
    public final AnimationState bowAnimationState = new AnimationState();
    public final AnimationState bowEndAnimationState = new AnimationState();
    public final AnimationState spinnyStartAnimationState = new AnimationState();
    public final AnimationState spinnyAnimationState = new AnimationState();
    public final AnimationState spinnyEndAnimationState = new AnimationState();

    public AxemachineEntityRenderState() {}
}
