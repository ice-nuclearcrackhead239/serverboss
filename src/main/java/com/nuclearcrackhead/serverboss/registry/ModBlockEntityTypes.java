package com.nuclearcrackhead.serverboss.registry;

import net.minecraft.block.entity.BlockEntityType;
import com.nuclearcrackhead.serverboss.content.block.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class ModBlockEntityTypes {
	public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("svbcr", path), blockEntityType);
	}
	
	public static final BlockEntityType<SpikeBlockEntity> SPIKE_BLOCK = register("spike_block", FabricBlockEntityTypeBuilder.create(SpikeBlockEntity::new, ModBlocks.SPIKE_BLOCK).build());
	public static final BlockEntityType<BlackstonePedestalEntity> BLACKSTONE_PEDESTAL = register("blackstone_pedestal", FabricBlockEntityTypeBuilder.create(BlackstonePedestalEntity::new, ModBlocks.BLACKSTONE_PEDESTAL).build());
	public static final BlockEntityType<BouncePadBlockEntity> BOUNCE_PAD = register("bounce_pad", FabricBlockEntityTypeBuilder.create(BouncePadBlockEntity::new, ModBlocks.BOUNCE_PAD).build());
	
	public static void init() {}
}
