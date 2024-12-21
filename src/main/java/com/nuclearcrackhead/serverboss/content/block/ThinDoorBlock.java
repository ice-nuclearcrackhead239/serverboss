package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ThinDoorBlock extends DoorBlock {
    public static final MapCodec<ThinDoorBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(ThinDoorBlock::getBlockSetType), createSettingsCodec())
                    .apply(instance, ThinDoorBlock::new)
    );
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 0.5);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.5, 16.0, 16.0, 16.0);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(15.5, 0.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 0.5, 16.0, 16.0);

    @Override
    public MapCodec<? extends ThinDoorBlock> getCodec() {
        return CODEC;
    }

    public ThinDoorBlock(BlockSetType type, AbstractBlock.Settings settings) {
        super(type, settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean bl = !(Boolean)state.get(OPEN);
        boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;

        return switch (direction) {
            case SOUTH -> bl ? NORTH_SHAPE : (bl2 ? WEST_SHAPE : EAST_SHAPE);
            case WEST -> bl ? EAST_SHAPE : (bl2 ? NORTH_SHAPE : SOUTH_SHAPE);
            case NORTH -> bl ? SOUTH_SHAPE : (bl2 ? EAST_SHAPE : WEST_SHAPE);
            default -> bl ? WEST_SHAPE : (bl2 ? SOUTH_SHAPE : NORTH_SHAPE);
        };
    }

}
