package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

import static com.nuclearcrackhead.serverboss.registry.ModBlocks.*;
import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_FLOWING;
import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;
import static com.nuclearcrackhead.serverboss.registry.ModItems.RADIOACTIVE_BUCKET;

public abstract class RadioactiveFluid extends Radioactive {
    @Override
    public Fluid getStill() {
        return RADIOACTIVE_STILL;
    }

    @Override
    public Fluid getFlowing() {
        return RADIOACTIVE_FLOWING;
    }

    @Override
    public Item getBucketItem() {
        return RADIOACTIVE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return RADIOACTIVE.getDefaultState().with(Properties.LEVEL_15, RADIOACTIVE_STILL.getBlockStateLevel(fluidState));
    }

    public static class Flowing extends RadioactiveFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        protected boolean isInfinite(ServerWorld world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends RadioactiveFluid {
        @Override
        protected boolean isInfinite(ServerWorld world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}