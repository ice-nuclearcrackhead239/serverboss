package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.content.screen.RoomBlockScreenHandler;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockC2SPacket;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Optional;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

public class RoomBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<UpdateRoomBlockS2CPacket> {
	public String roomName = "";
	public String mobList = "";
	public String forceFieldList = "";
	public BlockPos offset = new BlockPos(0, 1, 0);
	public Vec3i size = Vec3i.ZERO;
	public boolean showBoundingBox = false;

	public long activeDuration = 0;
	public ArrayList<UUID> safePlayers = new ArrayList<UUID>();
	public ArrayList<LivingEntity> activeMobs = new ArrayList<LivingEntity>();
	public ArrayList<BlockPos> safeSpots = new ArrayList<BlockPos>();

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
		UpdateRoomBlockS2CPacket payload = new UpdateRoomBlockS2CPacket(this.pos, roomName, mobList, offset, roomSize, showBoundingBox, forceFieldList);
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
		nbt.putString("forceFieldList", forceFieldList);
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
		forceFieldList = new String(nbt.getString("forceFieldList"));
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
		forceFieldList = new String(packet.forceFieldList());
		offset = new BlockPos(packet.roomPos());
		size = new BlockPos(packet.roomSize());
		showBoundingBox = packet.showBounds();
		this.markDirty();

		BlockState state = this.world.getBlockState(packet.targetPos());
		world.updateListeners(packet.targetPos(), state, state, 0);
	}

	public void setForcefield(BlockPos pos, boolean closed) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() instanceof ForcefieldBlock) {
			if (state.get(ForcefieldBlock.OPEN) == !closed) return;
			world.setBlockState(pos, state.with(ForcefieldBlock.OPEN, !closed));
			setForcefield(pos.up(), closed);
			setForcefield(pos.down(), closed);
			setForcefield(pos.north(), closed);
			setForcefield(pos.east(), closed);
			setForcefield(pos.south(), closed);
			setForcefield(pos.west(), closed);
		}
	}

	public void setForcefields(boolean closed) {
		String[] forceFieldArray = forceFieldList.split(",");
		BlockPos[] posArray = new BlockPos[forceFieldArray.length];
		for (int i = 0; i < forceFieldArray.length; i++) {
			String strPos = forceFieldArray[i];
			String[] coords = strPos.split(" ");
			if (coords.length != 3) return;
			BlockPos pos = new BlockPos(parseInt(coords[0]), parseInt(coords[1]), parseInt(coords[2]));
			posArray[i] = pos;
		}
		for (BlockPos pos : posArray) {
			setForcefield(pos, closed);
		}
	}

	public boolean inRoom(Entity entity) {
		Vec3d pos = entity.getPos().subtract(new Vec3d(offset.add(this.pos)));
		if (pos.getX() < 0 || pos.getY() < 0 || pos.getZ() < 0) return false;
		if (pos.getX() > size.getX() || pos.getY() > size.getY() || pos.getZ() > size.getZ()) return false;
		return true;
	}

	public Optional<BlockPos> getSpawnPos() {
		if (safeSpots.size() == 0) {
			return Optional.empty();
		}
		int index = this.world.getRandom().nextInt(safeSpots.size());
		return Optional.of(safeSpots.get(index));
	}

	public void calcSafeSpots() {
		safeSpots.clear();

		int xOff = offset.getX() + this.pos.getX();
		int yOff = offset.getY() + this.pos.getY();
		int zOff = offset.getZ() + this.pos.getZ();

		int xSize = size.getX();
		int ySize = size.getY();
		int zSize = size.getZ();

		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < zSize; j++) {
				BlockPos pos = new BlockPos(i + xOff, yOff, j + zOff);
				for (int k = 0; k < ySize; k++) {
					if (world.isAir(pos)) {
						safeSpots.add(pos);
						continue;
					}
				}
			}
		}
	}

	public void spawnMobs() {
		calcSafeSpots();

		String[] mobArray = mobList.split(",");
		for (String mobId : mobArray) {
			Optional<EntityType<?>> entityTypeOptional = EntityType.get(mobId);
			if (entityTypeOptional.isEmpty()) continue;
			EntityType<?> entityType = entityTypeOptional.get();

			Optional<BlockPos> spawnPosOptional = getSpawnPos();
			if (spawnPosOptional.isEmpty()) return;

			ServerWorld serverWorld = (ServerWorld)this.world;
			Entity entity = entityType.spawn(serverWorld, spawnPosOptional.get(), SpawnReason.MOB_SUMMONED);
			if (entity instanceof LivingEntity livingEntity) {
				activeMobs.add(livingEntity);
			}
		}
	}

	public static void tick(World world, BlockPos pos, BlockState state, RoomBlockEntity blockEntity) {
		for (PlayerEntity player : world.getPlayers()) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
			if (serverPlayer.interactionManager.isSurvivalLike() && !blockEntity.safePlayers.contains(player.getUuid())) {
				if (blockEntity.inRoom(player)) {
					if (blockEntity.activeDuration == 0) {
						blockEntity.setForcefields(true);
						blockEntity.activeDuration = 1;
					}
					blockEntity.safePlayers.add(player.getUuid());
				}
			}
		}
		if (blockEntity.activeDuration > 0) {
			if (blockEntity.activeDuration == 40) {
				blockEntity.spawnMobs();
			} else if (blockEntity.activeDuration > 40) {
				for (int i = 0; i < blockEntity.activeMobs.size(); i++) {
					LivingEntity livingEntity = blockEntity.activeMobs.get(i);
					if (livingEntity.isDead()) {
						blockEntity.activeMobs.remove(i);
						i--;
					}
				}
				if (blockEntity.activeMobs.size() == 0) {
					blockEntity.setForcefields(false);
					blockEntity.activeDuration = 0;
					return;
				}
			}
			blockEntity.activeDuration++;
		}
	}

	private int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}


}
