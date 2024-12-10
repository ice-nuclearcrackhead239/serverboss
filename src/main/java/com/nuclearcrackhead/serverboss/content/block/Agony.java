package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Agony extends Block {
    public static final MapCodec<Agony> CODEC = createCodec(Agony::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)16.0F, (double)15.0F, (double)16.0F);

    public MapCodec<Agony> getCodec() {
        return CODEC;
    }

    public Agony(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity livingEntity) {
            livingEntity.serverDamage(entity.getDamageSources().create(ModDamageTypes.AGONY_DAMAGE, null), livingEntity.getMaxHealth() / 7);
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(new DustParticleEffect(ColorHelper.fromFloats(1, 1, 0, 0), 2), livingEntity.getPos().getX(), livingEntity.getPos().getY(), livingEntity.getPos().getZ(), 4, 0.2, 0, 0.2, 0);
            }
            if (!world.isClient && (livingEntity.hurtTime == 10)) {
                world.playSound(null, pos, ModSounds.BLOCK_AGONY_ACTIVATE_FANGSNAP, SoundCategory.BLOCKS);
                world.playSound(null, pos, ModSounds.BLOCK_AGONY_ACTIVATE_ZOMBIESTEP, SoundCategory.BLOCKS);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
