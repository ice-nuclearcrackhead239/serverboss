package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;

public class SpikeBlockEntity extends BlockEntity {
	public SpikeBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SPIKE_BLOCK, pos, state);
	}
	
	protected int a = 0;
	
	public static void tick(World world, BlockPos pos, BlockState state, SpikeBlockEntity blockEntity) {
		SVBCR.LOGGER.info("hi from ", pos.toString());
	}
}