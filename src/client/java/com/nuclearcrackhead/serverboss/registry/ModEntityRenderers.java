package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.content.model.entity.AxemachineEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.AxemachineEntityRenderer;
import com.nuclearcrackhead.serverboss.content.model.entity.BatteryEntityModel;
import com.nuclearcrackhead.serverboss.content.render.entity.BatteryEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityRenderers {

    public static final EntityModelLayer MODEL_AXEMACHINE_LAYER = new EntityModelLayer(Identifier.of("svbcr", "axemachine"), "main");
    public static final EntityModelLayer MODEL_BATTERY_LAYER = new EntityModelLayer(Identifier.of("svbcr", "battery"), "main");


    public static void init() {
        EntityRendererRegistry.register(ModEntities.AXEMACHINE, AxemachineEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_AXEMACHINE_LAYER, AxemachineEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.BATTERY, BatteryEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_BATTERY_LAYER, BatteryEntityModel::getTexturedModelData);
    }
}
