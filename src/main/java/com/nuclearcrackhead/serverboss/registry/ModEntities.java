package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.content.entity.AxemachineEntity;
import com.nuclearcrackhead.serverboss.content.entity.BatteryEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<AxemachineEntity> AXEMACHINE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of("svbcr", "axemachine"),
            EntityType.Builder.create(AxemachineEntity::new, SpawnGroup.MISC).dimensions(0.6f, 2.1f).build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of("svcbr","axemachine")))
    );
    public static final EntityType<BatteryEntity> BATTERY = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of("svbcr", "battery"),
            EntityType.Builder.create(BatteryEntity::new, SpawnGroup.MISC).dimensions(1.2f, 1.6f).build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of("svcbr","battery")))
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(AXEMACHINE, AxemachineEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(BATTERY, AxemachineEntity.createMobAttributes());
    }

}
