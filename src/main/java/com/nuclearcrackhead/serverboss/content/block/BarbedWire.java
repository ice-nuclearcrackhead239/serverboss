package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.FacingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.Direction;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import com.mojang.serialization.MapCodec;

import java.util.List;

import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;

public class BarbedWire extends FacingBlock {
	public static final VoxelShape X_SHAPE = Block.createCuboidShape(2.0, 0.0, 0.0, 12.0, 11.3, 16.0);
	public static final VoxelShape Z_SHAPE = Block.createCuboidShape(0.0, 0.0, 2.0, 16.0, 11.3, 12.0);
	public static final MapCodec<BarbedWire> CODEC = createCodec(BarbedWire::new);

	@Override
	protected MapCodec<? extends FacingBlock> getCodec() {
		return CODEC;
	}

	public BarbedWire(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		switch (((Direction)state.get(FACING)).getAxis()) {
			case X:
			default:
				return X_SHAPE;
			case Z:
				return Z_SHAPE;
		}
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		Direction direction = ctx.getHorizontalPlayerFacing();
		BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
		return blockState.isOf(this) && blockState.get(FACING) == direction
			? this.getDefaultState().with(FACING, direction.getOpposite())
			: this.getDefaultState().with(FACING, direction);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
		tooltip.add(Text.translatable("block.svbcr.barbed_wire.tooltip").formatted(Formatting.GRAY));
	}

	@Override
	protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity livingEntity) {
			entity.slowMovement(state, new Vec3d(0.8F, 0.75, 0.8F));
			if (world instanceof ServerWorld serverWorld) {
				float speed = (float)new Vec3d(0.0, 0.0, 0.0).distanceTo(entity.getMovement()) * 20.0f;
				livingEntity.damage(serverWorld, entity.getDamageSources().create(ModDamageTypes.BARBED_WIRE_DAMAGE, null), (int)speed);
			}
		}
	}
}
