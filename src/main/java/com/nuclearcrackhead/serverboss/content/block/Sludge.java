package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import com.nuclearcrackhead.serverboss.registry.ModBlocks;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Sludge extends TranslucentBlock {
    public static final MapCodec<Sludge> CODEC = createCodec(Sludge::new);
    private static final double field_31101 = 0.13;
    private static final double field_31102 = 0.08;
    private static final double field_31103 = 0.05;
    private static final int TICKS_PER_SECOND = 20;
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)15.0F, (double)15.0F);
    protected static final VoxelShape LINESHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public MapCodec<Sludge> getCodec() {
        return CODEC;
    }

    public Sludge(AbstractBlock.Settings settings) {
        super(settings);
    }

    private static boolean hasSludgeEffects(Entity entity) {
        return entity instanceof LivingEntity || entity instanceof AbstractMinecartEntity || entity instanceof TntEntity || entity instanceof AbstractBoatEntity;
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LINESHAPE;
    }

    /*public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
        if (!world.isClient) {
            world.sendEntityStatus(entity, (byte)54);
        }

        if (entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall())) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }

    } */

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (this.isSliding(pos, entity)) {
            this.triggerAdvancement(entity, pos);
            this.updateSlidingVelocity(entity);
            this.addCollisionEffects(world, entity);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    private static double method_65067(double d) {
        return d / (double)0.98F + 0.08;
    }

    private static double method_65068(double d) {
        return (d - 0.08) * (double)0.98F;
    }

    private boolean isSliding(BlockPos pos, Entity entity) {
        if (entity.isOnGround()) {
            return false;
        } else if (entity.getY() > (double)pos.getY() + (double)0.9375F - 1.0E-7) {
            return false;
        } else if (method_65067(entity.getVelocity().y) >= -0.08) {
            return false;
        } else {
            double d = Math.abs((double)pos.getX() + (double)0.5F - entity.getX());
            double e = Math.abs((double)pos.getZ() + (double)0.5F - entity.getZ());
            double f = (double)0.4375F + (double)(entity.getWidth() / 2.0F);
            return d + 1.0E-7 > f || e + 1.0E-7 > f;
        }
    }

    private void triggerAdvancement(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity && entity.getWorld().getTime() % 20L == 0L) {
            Criteria.SLIDE_DOWN_BLOCK.trigger((ServerPlayerEntity)entity, entity.getWorld().getBlockState(pos));
        }

    }

    private void updateSlidingVelocity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (method_65067(entity.getVelocity().y) < -0.13) {
            double d = -0.05 / method_65067(entity.getVelocity().y);
            entity.setVelocity(new Vec3d(vec3d.x * d, method_65068(-0.05), vec3d.z * d));
        } else {
            entity.setVelocity(new Vec3d(vec3d.x, method_65068(-0.05), vec3d.z));
        }

        entity.onLanding();
    }

    private void addCollisionEffects(World world, Entity entity) {
        if (hasSludgeEffects(entity)) {
            if (world.random.nextInt(5) == 0) {
                entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
            }

            if (!world.isClient && world.random.nextInt(5) == 0) {
                world.sendEntityStatus(entity, (byte)53);
            }
        }

    }

    public static void addRegularParticles(Entity entity) {
        addParticles(entity, 5);
    }

    public static void addRichParticles(Entity entity) {
        addParticles(entity, 10);
    }

    private static void addParticles(Entity entity, int count) {
        if (entity.getWorld().isClient) {
            BlockState blockState = ModBlocks.SLUDGE.getDefaultState();

            for(int i = 0; i < count; ++i) {
                entity.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), entity.getX(), entity.getY(), entity.getZ(), (double)0.0F, (double)0.0F, (double)0.0F);
            }

        }
    }
}
