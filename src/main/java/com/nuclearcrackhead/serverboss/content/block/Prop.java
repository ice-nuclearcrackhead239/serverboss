//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Prop extends PlantBlock {
    public static final MapCodec<Prop> CODEC = createCodec(Prop::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)1.5F, (double)15.0F);

    public MapCodec<Prop> getCodec() {
        return CODEC;
    }

    public Prop(Settings settings) {
        super(settings);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }
}
