package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;

public class RoomBlock extends BlockWithEntity {
	public RoomBlock(Settings settings) {
		super(settings);
	}

	public static final MapCodec<RoomBlock> CODEC = createCodec(RoomBlock::new);
	
	public MapCodec<? extends RoomBlock> getCodec() {
		return CODEC;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new RoomBlockEntity(pos, state);
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
		tooltip.add(Text.translatable("block.svbcr.room_block.tooltip").formatted(Formatting.GRAY));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient && player.isCreativeLevelTwoOp()) {
			NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

			if (screenHandlerFactory != null) {
				player.openHandledScreen(screenHandlerFactory);
			}
			return ActionResult.SUCCESS;
		}
		return player.isCreativeLevelTwoOp() ? ActionResult.SUCCESS : ActionResult.PASS;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		if (world.isClient()) return null;
		return validateTicker(type, ModBlockEntityTypes.ROOM_BLOCK, RoomBlockEntity::tick);
	}
}
