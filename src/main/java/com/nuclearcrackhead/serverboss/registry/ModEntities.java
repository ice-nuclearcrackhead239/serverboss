package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModEntities {

	public static final EntityType<AxemachineEntity> AXEMACHINE = Registry.register(
			Registries.ENTITY_TYPE, SVBCR.of("axemachine"),
			EntityType.Builder.create(AxemachineEntity::new, SpawnGroup.MISC).dimensions(0.6f, 2.1f).build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), SVBCR.of("axemachine")))
	);
	public static final EntityType<BatteryEntity> BATTERY = Registry.register(
			Registries.ENTITY_TYPE, SVBCR.of("battery"),
			EntityType.Builder.create(BatteryEntity::new, SpawnGroup.MISC).dimensions(1.2f, 1.6f).build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), SVBCR.of("battery")))
	);
	public static final EntityType<BulletEntity> BULLET = Registry.register(
			Registries.ENTITY_TYPE, SVBCR.of("bullet"),
			EntityType.Builder.<BulletEntity>create(BulletEntity::new, SpawnGroup.MISC).dimensions(0.25f, 0.25f).build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), SVBCR.of("bullet")))
	);

	public static void init() {
		FabricDefaultAttributeRegistry.register(AXEMACHINE, AxemachineEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(BATTERY, AxemachineEntity.createMobAttributes());
	}

}
