package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class InvertBlock<E extends BlockEntity> extends BlockWithEntity {
    //public static final Direction FACING = NORTH;
    protected final Supplier<BlockEntityType<? extends E>> entityTypeRetriever;

    public InvertBlock(Settings settings, Supplier<BlockEntityType<? extends E>> entityTypeRetriever) {
        super(settings);
        this.entityTypeRetriever = entityTypeRetriever;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new InvertBlockEntity(pos, state);
    }
}
