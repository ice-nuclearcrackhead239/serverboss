package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.registry.ModParticles;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SpeedPadBlockEntity extends BlockEntity {
    public SpeedPadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SPEED_PAD, pos, state);
    }

    public static final int SPEED_COOLDOWN = 15; //tick amount to make the speed pad not launch again for
    protected int cooldown = 0;

    public void tryBounce(World world, BlockPos pos, BlockState state, Entity entity) {
        //horizontal check as an emergency back out if this block is vertical -mikii/adenator
        if (cooldown == 0 && SpeedPadBlock.isHorizontal(state)) {
            Vec3d dirForce = new Vec3d(0,0,0);
            Direction dir = state.get(SpeedPadBlock.FACING);
            switch (dir) {
                case NORTH:
                    dirForce = new Vec3d(0,0,-2);
                    break;
                case EAST:
                    dirForce = new Vec3d(2,0,0);
                    break;
                case SOUTH:
                    dirForce = new Vec3d(0,0,2);
                    break;
                case WEST:
                    dirForce = new Vec3d(-2,0,0);
            }
            entity.setVelocity(entity.getVelocity().add(dirForce).add(0, 0.35, 0));
            world.playSound(null, pos, ModSounds.BLOCK_SPEED_PAD, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (world instanceof ServerWorld serverWorld) {
                Vec3d center = pos.toCenterPos();
                serverWorld.spawnParticles(ModParticles.SPEED_BLAST, center.getX(), center.getY() + 0.5, center.getZ(), 1, 0, 0, 0, 0);
            }
            world.setBlockState(pos, state.with(SpeedPadBlock.ACTIVE, false));
            cooldown = SPEED_COOLDOWN;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, SpeedPadBlockEntity blockEntity) {
        if (blockEntity.cooldown > 0) {
            blockEntity.cooldown--;
            if (blockEntity.cooldown == 0) {
                world.setBlockState(pos, state.with(SpeedPadBlock.ACTIVE, true));
            }
        }
    }
}
