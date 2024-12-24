package com.nuclearcrackhead.serverboss.content.entity;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModEntities;

public class BulletEntity extends ProjectileEntity {
	public int damage = 1;
	public float speed;
	public float pitch;
	public float yaw;

	public BulletEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public BulletEntity(World world, LivingEntity owner) {
		super(ModEntities.BULLET, world);
		this.setOwner(owner);
		this.setPosition(owner.getPos());
	}

	public BulletEntity setDirection(float pitch, float yaw) {
		this.pitch = pitch;
		this.yaw = yaw;
		fixVelocity();
		return this;
	}

	public BulletEntity setSpeed(float speed) {
		this.speed = speed;
		fixVelocity();
		return this;
	}

	public void fixVelocity() {
		float f = -MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
		float g = -MathHelper.sin(pitch * (float) (Math.PI / 180.0));
		float h = MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
		Vec3d vel = new Vec3d(f, g, h).multiply(speed);
		SVBCR.LOGGER.info("{}", vel);
		setVelocity(vel);
	}

	public void tick() {
		setPosition(getPos().add(getVelocity()));
	}

	public BulletEntity setDamage(int damage) {
		this.damage = damage;
		return this;
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
	}
}
