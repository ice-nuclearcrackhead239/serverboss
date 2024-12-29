//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PropFloating extends Prop {
    public static final MapCodec<PropFloating> CODEC = createCodec(PropFloating::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)1.5F, (double)15.0F);

    public static final BooleanProperty FLOATING = BooleanProperty.of("floating");
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FLOATING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        boolean ret = world.getFluidState(blockPos.add(0,-1,0)).isOf(Fluids.WATER);
        return this.getDefaultState().with(FLOATING, ret);
    }

    public PropFloating(Settings settings) {
        super(settings);
    }


}
