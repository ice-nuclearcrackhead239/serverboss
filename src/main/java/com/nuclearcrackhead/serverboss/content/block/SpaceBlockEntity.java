package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class SpaceBlockEntity extends BlockEntity{
	public static final int field_31348 = 0;
	public static final int field_31349 = 1;
	public static final int field_31350 = 0;
	public static final int field_31351 = 1;


	public SpaceBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SPACE_BLOCK_ENTITY, pos, state);
	}
}

