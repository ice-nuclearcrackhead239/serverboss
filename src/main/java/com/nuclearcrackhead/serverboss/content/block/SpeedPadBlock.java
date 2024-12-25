package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.MapCodec;
import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

public class SpeedPadBlock extends BlockWithEntity {
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    public static final EnumProperty<Direction> FACING;

    public SpeedPadBlock(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVE, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE).add(FACING);
    }

    public static final MapCodec<SpeedPadBlock> CODEC = createCodec(SpeedPadBlock::new);

    public MapCodec<? extends SpeedPadBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite().getOpposite())
                .with(ACTIVE, true);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SpeedPadBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityTypes.SPEED_PAD, SpeedPadBlockEntity::tick);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.svbcr.speed_pad.tooltip").formatted(Formatting.GRAY));
    }

    public static boolean isHorizontal(BlockState state) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case UP, DOWN -> false;
            case NORTH, EAST, SOUTH, WEST -> true;
        };
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (state.get(ACTIVE) && isHorizontal(state) && blockEntity instanceof SpeedPadBlockEntity speedPadEntity) {
            speedPadEntity.tryBounce(world, pos, state, entity);
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (isHorizontal(state)) {
            entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
        } else {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        }
    }

    static {
        FACING = Properties.FACING;
    }

}
