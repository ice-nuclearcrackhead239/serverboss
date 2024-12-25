package com.nuclearcrackhead.serverboss.content.status;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModParticles;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.DustColorTransitionParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ColorHelper;

public class SoaringStatusEffect extends StatusEffect {

    private int safeticks;

    public SoaringStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x3ac0ff, ModParticles.SOARING);
        this.safeticks = 0;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration < 198;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (this.safeticks > 0) {
            this.safeticks++;
            if (this.safeticks == 3) {
                this.safeticks = 0;
                entity.removeStatusEffect(ModStatusEffects.SOARING);
                return false;
            }
        }

        if (entity.isOnGround() && amplifier == 0 && this.safeticks == 0) { //only Soaring I will disable itself, not II or above -mikii/adenator
            //old bounce pad check: world.getBlockState(entity.getBlockPos().add(0,-1,0)).getBlock() != ModBlocks.BOUNCE_PAD
            world.spawnParticles(new DustColorTransitionParticleEffect(0xffffff, 0x3ac0ff, 2), entity.getPos().getX(), entity.getPos().getY(), entity.getPos().getZ(), 5, 0.5, 0, 0.5, 0);
            this.safeticks = 1;
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
