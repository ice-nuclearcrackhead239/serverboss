package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.CachedMapper;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.Map;

public class PipeBlock extends Block {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;
    public static final BooleanProperty EAST = Properties.EAST;
    public static final BooleanProperty WEST = Properties.WEST;

    public static final Map<Direction, BooleanProperty> DIRECTION_PROPERTIES = Map.of(
            Direction.NORTH, Properties.NORTH,
            Direction.SOUTH, Properties.SOUTH,
            Direction.EAST, Properties.EAST,
            Direction.WEST, Properties.WEST,
            Direction.UP, Properties.UP,
            Direction.DOWN, Properties.DOWN
    );

    public static final VoxelShape CONNECTOR_SHAPE = Block.createCuboidShape(5, 5, 5, 11, 11, 11);

    public static final Map<Direction, VoxelShape> DIRECTION_SHAPES = Map.of(
            Direction.NORTH, Block.createCuboidShape(5, 5, 0, 11, 11, 8),
            Direction.SOUTH, Block.createCuboidShape(5, 5, 8, 11, 11, 16),
            Direction.EAST, Block.createCuboidShape(8, 5, 5, 16, 11, 11),
            Direction.WEST, Block.createCuboidShape(0, 5, 5, 8, 11, 11),
            Direction.UP, Block.createCuboidShape(5, 8, 5, 11, 16, 11),
            Direction.DOWN, Block.createCuboidShape(5, 0, 5, 11, 8, 11)
    );

    public static final CachedMapper<BlockState, VoxelShape> SHAPE_CACHE = Util.cachedMapper(PipeBlock::generateShape);

    public static VoxelShape generateShape(BlockState state) {
        VoxelShape shape = VoxelShapes.empty();
        int connections = 0;

        for (Direction direction : Direction.values()) {
            BooleanProperty property = DIRECTION_PROPERTIES.get(direction);
            if (state.get(property)) {
                shape = VoxelShapes.union(shape, DIRECTION_SHAPES.get(direction));
                connections++;
            }
        }
        if (connections == 0 || connections > 1) shape = VoxelShapes.union(shape, CONNECTOR_SHAPE);

        return shape;
    }

    public PipeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(SOUTH, false)
                .with(EAST, false)
                .with(WEST, false)
                .with(UP, false)
                .with(DOWN, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getConnectionState(ctx.getWorld(), ctx.getBlockPos());
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return this.getConnectionState((World)world, pos);
    }

    private BlockState getConnectionState(World world, BlockPos pos) {
        BlockState state = this.getDefaultState();

        for (Direction direction : Direction.values()) {
            BooleanProperty property = DIRECTION_PROPERTIES.get(direction);
            BlockPos offset = pos.offset(direction);
            if (this.canConnectTo(offset, world)) state = state.with(property, true);
        }

        state = state.with(WATERLOGGED, world.getFluidState(pos).isOf(Fluids.WATER));
        return state;
    }

    private boolean canConnectTo(BlockPos pos, WorldView world) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        if (block instanceof PipeBlock) return true;
        if (!world.getFluidState(pos).isEmpty()) return false;
        return !state.isTransparent();
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(true) : super.getFluidState(state);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_CACHE.map(state);
    }

    @Override
    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected boolean isTransparent(BlockState state) {
        return true;
    }

}
