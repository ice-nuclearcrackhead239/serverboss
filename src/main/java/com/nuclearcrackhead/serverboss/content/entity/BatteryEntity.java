package com.nuclearcrackhead.serverboss.content.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class BatteryEntity extends PathAwareEntity {

    public AnimationState idleAnimationState = new AnimationState();

    public BatteryEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        this.idleAnimationState.startIfNotRunning(this.age);
    }

}
