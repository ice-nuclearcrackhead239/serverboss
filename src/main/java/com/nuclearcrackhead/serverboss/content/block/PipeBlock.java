package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.Objects;

public class PipeBlock extends Block {

    public PipeBlock(Settings settings) {
        super(settings);
    }

    public static final BooleanProperty WATERLOGGED;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty NORTH;
    public static final BooleanProperty UP;
    public static final BooleanProperty DOWN;
    public static final BooleanProperty EAST;
    public static final BooleanProperty WEST;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        builder.add(SOUTH);
        builder.add(NORTH);
        builder.add(UP);
        builder.add(DOWN);
        builder.add(EAST);
        builder.add(WEST);
    }

    private boolean shouldConnectTo(BlockPos bpos, WorldView world) {
        Block block = world.getBlockState(bpos).getBlock();
        boolean bl =
                //block instanceof PipeBlock;
                block instanceof PipeBlock || !(block instanceof AirBlock || world.getFluidState(bpos).isOf(Fluids.WATER) || world.getBlockState(bpos).isTransparent());
        return bl;
    }

    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }
    protected boolean isTransparent(BlockState state) {
        return true;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        FluidState fluidState = world.getFluidState(pos);
        BlockPos blockPos = pos;
        state = state.with(UP, shouldConnectTo(blockPos.add(0, 1, 0), world));
        state = state.with(DOWN, shouldConnectTo(blockPos.add(0, -1, 0), world));
        state = state.with(SOUTH, shouldConnectTo(blockPos.add(0, 0, 1), world));
        state = state.with(NORTH, shouldConnectTo(blockPos.add(0, 0, -1), world));
        state = state.with(EAST, shouldConnectTo(blockPos.add(1, 0, 0), world));
        state = state.with(WEST, shouldConnectTo(blockPos.add(-1, 0, 0), world));
        state = state.with(WATERLOGGED, world.getFluidState(blockPos).isOf(Fluids.WATER));
        return state;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        BlockState state = this.getDefaultState();
        state = state.with(UP, shouldConnectTo(blockPos.add(0, 1, 0), world));
        state = state.with(DOWN, shouldConnectTo(blockPos.add(0, -1, 0), world));
        state = state.with(SOUTH, shouldConnectTo(blockPos.add(0, 0, 1), world));
        state = state.with(NORTH, shouldConnectTo(blockPos.add(0, 0, -1), world));
        state = state.with(EAST, shouldConnectTo(blockPos.add(1, 0, 0), world));
        state = state.with(WEST, shouldConnectTo(blockPos.add(-1, 0, 0), world));
        state = state.with(WATERLOGGED, world.getFluidState(blockPos).isOf(Fluids.WATER));
        return state;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(true) : super.getFluidState(state);
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        NORTH = Properties.NORTH;
        SOUTH = Properties.SOUTH;
        EAST = Properties.EAST;
        WEST = Properties.WEST;
        UP = Properties.UP;
        DOWN = Properties.DOWN;
    }


}
