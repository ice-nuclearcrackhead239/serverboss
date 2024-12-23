package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

import java.util.List;

public class SpikeBlock extends BlockWithEntity {
	public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
	public static final int SPIKE_DAMAGE = 5;

	public SpikeBlock(Settings settings) {
		super(settings);

		setDefaultState(getDefaultState().with(ACTIVE, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(ACTIVE);
	}
	
	public static final MapCodec<SpikeBlock> CODEC = createCodec(SpikeBlock::new);
	
	public MapCodec<? extends SpikeBlock> getCodec() {
		return CODEC;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new SpikeBlockEntity(pos, state);
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return validateTicker(type, ModBlockEntityTypes.SPIKE_BLOCK, SpikeBlockEntity::tick);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
		tooltip.add(Text.translatable("block.svbcr.spike_block.tooltip").formatted(Formatting.GRAY));
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof SpikeBlockEntity spikeBlockEntity) {
			spikeBlockEntity.spawnSpike(world, pos, state, entity);
		}
		if (state.get(ACTIVE) && entity instanceof LivingEntity livingEntity) {
			if (world instanceof ServerWorld serverWorld) {
				livingEntity.damage(serverWorld, entity.getDamageSources().create(ModDamageTypes.SPIKE_DAMAGE, null), SPIKE_DAMAGE);
			}
		}
		super.onSteppedOn(world, pos, state, entity);
	}
}
