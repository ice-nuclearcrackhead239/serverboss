package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.content.particle.BounceParticle;
import com.nuclearcrackhead.serverboss.content.particle.SoaringParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SoulParticle;

public class ModParticleFactories {

    public static void init() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.AGONY_SOUL, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SOARING, SoaringParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BOUNCE, BounceParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SPEED_BLAST, BounceParticle.Factory::new);
    }

}
