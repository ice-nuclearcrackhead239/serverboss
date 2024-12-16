package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class SpikeBlock extends BlockWithEntity {
	public SpikeBlock(Settings settings) {
		super(settings);
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
			spikeBlockEntity.spawnSpike(world, entity);
		}

        super.onSteppedOn(world, pos, state, entity);
    }
}
