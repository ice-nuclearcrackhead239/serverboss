package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.model.entity.*;
import com.nuclearcrackhead.serverboss.content.render.entity.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ModEntityRenderers {

	public static final EntityModelLayer MODEL_AXEMACHINE_LAYER = new EntityModelLayer(SVBCR.of("axemachine"), "main");
	public static final EntityModelLayer MODEL_BATTERY_LAYER = new EntityModelLayer(SVBCR.of("battery"), "main");
	public static final EntityModelLayer MODEL_BATTERY_OUTLINE_LAYER = new EntityModelLayer(SVBCR.of("battery"), "outline");
	public static final EntityModelLayer MODEL_LITHOSTRUCT_DRONE_LAYER = new EntityModelLayer(SVBCR.of("lithostruct_drone"), "main");
	public static final EntityModelLayer MODEL_BULLET_LAYER = new EntityModelLayer(SVBCR.of("bullet"), "main");

	public static void init() {
		EntityRendererRegistry.register(ModEntities.AXEMACHINE, AxemachineEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_AXEMACHINE_LAYER, AxemachineEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.BATTERY, BatteryEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_BATTERY_LAYER, BatteryEntityMainModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LITHOSTRUCT_DRONE, LithostructDroneEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_LITHOSTRUCT_DRONE_LAYER, LithostructDroneEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MODEL_BULLET_LAYER, BulletEntityModel::getTexturedModelData);
	}
}
