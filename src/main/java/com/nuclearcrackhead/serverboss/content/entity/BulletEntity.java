package com.nuclearcrackhead.serverboss.content.entity;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.data.DataTracker;

import com.nuclearcrackhead.serverboss.registry.ModEntities;

public class BulletEntity extends ProjectileEntity {
	public int damage = 1;

	public BulletEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public BulletEntity(World world, LivingEntity owner) {
		super(ModEntities.BULLET, world);
		this.setOwner(owner);
		this.setPosition(owner.getPos());
	}

	public BulletEntity setDirection(float pitch, float yaw) {
		this.setRotation(yaw, pitch);
		return this;
	}

	public BulletEntity setSpeed(float speed) {
		this.setVelocity(0, speed, 0);
		return this;
	}

	public BulletEntity setDamage(int damage) {
		this.damage = damage;
		return this;
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
	}
}
