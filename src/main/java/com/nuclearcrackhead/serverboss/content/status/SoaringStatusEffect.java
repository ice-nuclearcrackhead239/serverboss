package com.nuclearcrackhead.serverboss.content.status;

import com.nuclearcrackhead.serverboss.registry.ModBlocks;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class SoaringStatusEffect extends StatusEffect {

    public SoaringStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x3ac0ff);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.isOnGround() && world.getBlockState(entity.getBlockPos().add(0,-1,0)).getBlock() != ModBlocks.BOUNCE_PAD) {
            entity.removeStatusEffect(ModStatusEffects.SOARING);
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
