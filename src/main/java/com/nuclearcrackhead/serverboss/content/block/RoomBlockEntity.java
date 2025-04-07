package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.registry.ModParticles;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class RoomBlockEntity extends BlockEntity {
	public RoomBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.ROOM_BLOCK, pos, state);
	}

	public static void tick(World world, BlockPos pos, BlockState state, RoomBlockEntity blockEntity) {
	}
}
