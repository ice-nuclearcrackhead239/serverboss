package com.nuclearcrackhead.serverboss.content.entity;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.math.Box;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.server.world.ServerWorld;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModEntities;
import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;

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
		this.setPosition(owner.getEyePos().add(0, ((double) -2 / 16), 0));
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
		setVelocity(vel);
	}

	public BulletEntity setDamage(int damage) {
		this.damage = damage;
		return this;
	}

	public void onBlockCollision(BlockPos blockPos, BlockState blockState) {
		discard();
	}

	public void onEntityCollision(EntityHitResult result) {
		if (getWorld() instanceof ServerWorld serverWorld) {
			if (result.getEntity() instanceof LivingEntity livingEntity) {
				livingEntity.damage(serverWorld, livingEntity.getDamageSources().create(ModDamageTypes.BULLET_DAMAGE, this), damage);
			}
		}
	}

	@Override
	public void tick() {
		World world = getWorld();
		BlockPos blockPos = getBlockPos();
		BlockState blockState = world.getBlockState(blockPos);
		VoxelShape collisionShape = blockState.getCollisionShape(world, blockPos);
		Vec3d bulletPos = getPos();
		Vec3d velocity = getVelocity();
		if (!blockState.isAir() && !collisionShape.isEmpty()) {
			for (Box box : collisionShape.getBoundingBoxes()) {
				if (box.offset(blockPos).contains(bulletPos)) {
					onBlockCollision(blockPos, blockState);
				}
			}
		}

		EntityHitResult result = ProjectileUtil.getEntityCollision(world, this, bulletPos, bulletPos.add(velocity), getBoundingBox().stretch(getVelocity()).expand(1.0), this::canHit);
		if (result != null) {
			onEntityCollision(result);
		}

		setPosition(bulletPos.add(velocity));
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
	}
}
