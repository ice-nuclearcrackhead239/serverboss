package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticles {

    public static final SimpleParticleType AGONY_SOUL = FabricParticleTypes.simple();
    public static final SimpleParticleType SOARING = FabricParticleTypes.simple();
    public static final SimpleParticleType BOUNCE = FabricParticleTypes.simple();
    public static final SimpleParticleType SPEED_BLAST = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registries.PARTICLE_TYPE, SVBCR.of("agony_soul"), AGONY_SOUL);
        Registry.register(Registries.PARTICLE_TYPE, SVBCR.of("soaring"), SOARING);
        Registry.register(Registries.PARTICLE_TYPE, SVBCR.of("bounce"), BOUNCE);
        Registry.register(Registries.PARTICLE_TYPE, SVBCR.of("speedpad"), SPEED_BLAST);
    }

}
