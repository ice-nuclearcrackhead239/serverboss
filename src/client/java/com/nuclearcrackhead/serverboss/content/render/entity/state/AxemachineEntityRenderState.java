package com.nuclearcrackhead.serverboss.content.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;

@Environment(EnvType.CLIENT)
public class AxemachineEntityRenderState extends BipedEntityRenderState {
    public boolean stunned;
}
