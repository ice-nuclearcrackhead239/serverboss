package com.nuclearcrackhead.serverboss.content.status;

import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class FracturedStatusEffect extends StatusEffect {

    public FracturedStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x82a1ff);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 3 == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        int denominator = 2 + amplifier;
        if (entity.getHealth() > entity.getMaxHealth() / denominator) {
            entity.damage(world, entity.getDamageSources().create(ModDamageTypes.FRACTURED), 1);
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

}
