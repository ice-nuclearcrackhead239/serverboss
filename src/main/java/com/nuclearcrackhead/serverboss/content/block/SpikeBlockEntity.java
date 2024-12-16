package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.server.world.ServerWorld;
import java.util.Random;

public class SpikeBlockEntity extends BlockEntity {
	public SpikeBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SPIKE_BLOCK, pos, state);
	}
	
	protected int spikeTimer = 0;
	
	public void spawnSpike(World world, Entity entity) {
		if (spikeTimer == 0) {
			SVBCR.LOGGER.info("spawned");
		}
		spikeTimer = 40;
	}
	
	public static void tick(World world, BlockPos pos, BlockState state, SpikeBlockEntity blockEntity) {
		if (blockEntity.spikeTimer > 0) {
			blockEntity.spikeTimer--;
			if (blockEntity.spikeTimer == 0) {
				SVBCR.LOGGER.info("despawned");
			}
		}
	}
}