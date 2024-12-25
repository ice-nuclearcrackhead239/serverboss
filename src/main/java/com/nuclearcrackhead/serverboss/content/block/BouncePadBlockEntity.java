package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BouncePadBlockEntity extends BlockEntity {
    public BouncePadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BOUNCE_PAD, pos, state);
    }

    public static final int BOUNCE_COOLDOWN = 10; //tick amount to make the bounce pad not bounce again for
    protected int cooldown = 0;

    public void tryBounce(World world, BlockPos pos, BlockState state, Entity entity) {
        if (cooldown == 0) {
            entity.setVelocity(entity.getVelocity().add(0, 1, 0));
            if (entity instanceof LivingEntity livingEntity && !world.isClient()) {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BOUNCE_BOOST, 60, 0));
            }
            world.setBlockState(pos, state.with(BouncePadBlock.ACTIVE, false));
            cooldown = BOUNCE_COOLDOWN;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, BouncePadBlockEntity blockEntity) {
        if (blockEntity.cooldown > 0) {
            blockEntity.cooldown--;
            if (blockEntity.cooldown == 0) {
                world.setBlockState(pos, state.with(BouncePadBlock.ACTIVE, true));
            }
        }
    }
}
