package com.nuclearcrackhead.serverboss.content.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ForcefieldBlock extends TransparentBlock implements Waterloggable {
    public static final MapCodec<ForcefieldBlock> CODEC = createCodec(ForcefieldBlock::new);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty OPEN = Properties.OPEN;

    public ForcefieldBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(WATERLOGGED, false)
                .with(OPEN, false)
        );
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.svbcr.forcefield.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("block.svbcr.forcefield.tooltip2").formatted(Formatting.GRAY));
    }

    private VoxelShape getForcefieldShape(Boolean open) {
        return open ? VoxelShapes.empty() : VoxelShapes.fullCube();
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getForcefieldShape(state.get(OPEN));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getForcefieldShape(state.get(OPEN));
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return state.get(OPEN) ? BlockRenderType.INVISIBLE : BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return Objects.requireNonNull(super.getPlacementState(ctx))
                .with(WATERLOGGED, fluidState.isOf(Fluids.WATER))
                .with(OPEN, false);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return (state.get(WATERLOGGED) && state.get(OPEN)) ? Fluids.WATER.getStill(true) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, OPEN);
    }
}
