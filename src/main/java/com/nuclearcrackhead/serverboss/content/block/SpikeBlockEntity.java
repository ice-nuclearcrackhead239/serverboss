package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModSounds;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;

public class SpikeBlockEntity extends BlockEntity {
	public SpikeBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SPIKE_BLOCK, pos, state);
	}
	
	public static final int SPIKE_DELAY = 10; // tick delay between stepping and spawning spikes
	public static final int SPIKE_DURATION = 80; // tick length of time the spike exists
	protected int spikeTimer = 0;
	
	public void spawnSpike(World world, BlockPos pos, BlockState state, Entity entity) {
		if (spikeTimer == 0) {
			world.playSound(null, pos, ModSounds.BLOCK_SPIKE_BLOCK_TRIGGER, SoundCategory.BLOCKS);
			spikeTimer = SPIKE_DELAY + SPIKE_DURATION;
		}
	}
	
	public static void tick(World world, BlockPos pos, BlockState state, SpikeBlockEntity blockEntity) {
		if (blockEntity.spikeTimer > 0) {
			blockEntity.spikeTimer--;
			if (blockEntity.spikeTimer == SPIKE_DURATION) {
				world.playSound(null, pos, ModSounds.BLOCK_SPIKE_BLOCK_UP, SoundCategory.BLOCKS);
				world.setBlockState(pos, state.with(SpikeBlock.ACTIVE, true));
			}
			if (blockEntity.spikeTimer == 0) {
				world.playSound(null, pos, ModSounds.BLOCK_SPIKE_BLOCK_DOWN, SoundCategory.BLOCKS);
				world.setBlockState(pos, state.with(SpikeBlock.ACTIVE, false));
			}
		}
	}
}
