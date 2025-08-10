package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModSounds;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.content.screen.RoomBlockScreenHandler;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockC2SPacket;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

public class RoomBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<UpdateRoomBlockS2CPacket> {
	public String roomName = "";
	public String mobList = "";
	public BlockPos offset = new BlockPos(0, 1, 0);
	public Vec3i size = Vec3i.ZERO;
	public boolean showBoundingBox = false;

	public RoomBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.ROOM_BLOCK, pos, state);
	}

	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new RoomBlockScreenHandler(syncId);
	}

	@Override
	public UpdateRoomBlockS2CPacket getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
		BlockPos roomSize = new BlockPos(size);
		UpdateRoomBlockS2CPacket payload = new UpdateRoomBlockS2CPacket(this.pos, roomName, mobList, offset, roomSize, showBoundingBox);
		return payload;
	}

	@Override
	public Text getDisplayName() {
		return Text.translatable(getCachedState().getBlock().getTranslationKey());
	}


	@Override
	public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
		super.writeNbt(nbt, registries);
		nbt.putString("roomName", roomName);
		nbt.putString("mobList", mobList);
		nbt.putInt("posX", offset.getX());
		nbt.putInt("posY", offset.getY());
		nbt.putInt("posZ", offset.getZ());
		nbt.putInt("sizeX", size.getX());
		nbt.putInt("sizeY", size.getY());
		nbt.putInt("sizeZ", size.getZ());
		nbt.putBoolean("showBoundingBox", showBoundingBox);
	}

	@Override
	public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
		super.readNbt(nbt, registries);
		roomName = new String(nbt.getString("roomName"));
		mobList = new String(nbt.getString("mobList"));
		offset = new BlockPos(nbt.getInt("posX"), nbt.getInt("posY"), nbt.getInt("posZ"));
		size = new Vec3i(nbt.getInt("sizeX"), nbt.getInt("sizeY"), nbt.getInt("sizeZ"));
		showBoundingBox = nbt.getBoolean("showBoundingBox");
	}

	@Override
	@Nullable
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
		return createNbt(registries);
	}

	public void update(UpdateRoomBlockC2SPacket packet) {
		roomName = new String(packet.name());
		mobList = new String(packet.mobList());
		offset = new BlockPos(packet.roomPos());
		size = new BlockPos(packet.roomSize());
		showBoundingBox = packet.showBounds();
		this.markDirty();

		BlockState state = this.world.getBlockState(packet.targetPos());
		world.updateListeners(packet.targetPos(), state, state, 0);
	}
}
