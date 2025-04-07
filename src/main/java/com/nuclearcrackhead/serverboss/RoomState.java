package com.nuclearcrackhead.serverboss;

import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;

public class RoomState extends PersistentState {
	public static RoomState createFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
		RoomState state = new RoomState();
		return state;
	}
 
	public static RoomState createNew() {
		RoomState state = new RoomState();
		return state;
	}

	@Override
	public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
		return nbt;
	}

	public static Type<RoomState> type = new Type<>(
		RoomState::createNew,
		RoomState::createFromNbt,
		null
	);

	public static RoomState getState(World world) {
		ServerWorld serverWorld = (ServerWorld)world;
		assert(world instanceof ServerWorld);

		return (RoomState)serverWorld.getPersistentStateManager().getOrCreate(type, SVBCR.MOD_ID);
	}
}
