package com.nuclearcrackhead.serverboss.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracked;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Debug(export = true)
@Mixin(PlayerEntity.class)
public abstract class MoveMixin extends LivingEntity implements DataTracked {

    protected MoveMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Final
    @Shadow private PlayerAbilities abilities;
    @Inject(method = "getVelocityMultiplier()F", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(
                ( !this.isOnGround() ? 1/super.getVelocityMultiplier() : super.getVelocityMultiplier() ) //LivingEntity.getVelocityMultiplier()
        );
    }

}
