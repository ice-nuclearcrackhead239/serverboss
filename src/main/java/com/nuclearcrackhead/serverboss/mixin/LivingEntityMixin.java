package com.nuclearcrackhead.serverboss.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.nuclearcrackhead.serverboss.content.entity.ILivingEntityMixin;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements ILivingEntityMixin {
	private boolean fallImmune = false;

	@Override
	public void setFallImmune(boolean fallImmune) {
		this.fallImmune = fallImmune;
	}

	@Inject(method = "handleFallDamage(FFLnet/minecraft/entity/damage/DamageSource;)Z", at = @At("HEAD"), cancellable = true)
	public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource source, CallbackInfoReturnable<Boolean> ci) {
		if (fallImmune) {
			ci.setReturnValue(true);
		}
	}
}

