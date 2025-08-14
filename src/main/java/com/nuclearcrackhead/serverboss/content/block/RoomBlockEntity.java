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
import net.minecraft.util.math.Box;
import net.minecraft.util.TypeFilter;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import com.nuclearcrackhead.serverboss.content.screen.RoomBlockScreenHandler;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockC2SPacket;
import com.nuclearcrackhead.serverboss.content.entity.ILivingEntityMixin;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
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

	public void playEnterSound(PlayerEntity player) {
		player.playSoundToPlayer(SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO.value(), SoundCategory.AMBIENT, 2, 0);
		player.playSoundToPlayer(ModSounds.MISC_ERROR, SoundCategory.AMBIENT, 2, 0);
	}

	public void playOverSound(PlayerEntity player) {
		player.playSoundToPlayer(SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.AMBIENT, 2, 0);
		player.playSoundToPlayer(SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.AMBIENT, 2, 1);
		player.playSoundToPlayer(SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.AMBIENT, 2, 2);
		player.playSoundToPlayer(SoundEvents.BLOCK_BELL_USE, SoundCategory.AMBIENT, 2, 0);
		player.playSoundToPlayer(SoundEvents.BLOCK_BELL_USE, SoundCategory.AMBIENT, 2, 1);
		player.playSoundToPlayer(SoundEvents.BLOCK_BELL_USE, SoundCategory.AMBIENT, 2, 2);
		player.playSoundToPlayer(SoundEvents.ENTITY_WITHER_AMBIENT, SoundCategory.AMBIENT, 2, 0);
	}

	public void playSecretSound(PlayerEntity player) {
		//player.playSoundToPlayer(ModSounds.MISC_SECRET, SoundCategory.AMBIENT, 2, 1);
	}

	public static void tick(World world, BlockPos pos, BlockState state, RoomBlockEntity blockEntity) {
		int underscoreIndex = blockEntity.roomName.indexOf("_");
		if (underscoreIndex == -1) {
			blockEntity.roomTick(world, pos, state);
			return;
		}
		String roomType = blockEntity.roomName.substring(0, underscoreIndex);
		switch (roomType) {
			case "room":
				blockEntity.roomTick(world, pos, state);
				break;
			case "kill":
				blockEntity.killTick(world, pos, state);
				break;
			case "deny":
				blockEntity.denyTick(world, pos, state);
				break;
			case "secret":
				blockEntity.secretTick(world, pos, state);
				break;
			case "warp":
				blockEntity.warpTick(world, pos, state);
				break;
			case "vkill":
				blockEntity.vkillTick(world, pos, state);
				break;
			case "drop":
				blockEntity.dropTick(world, pos, state);
		}
	}

	public void roomTick(World world, BlockPos pos, BlockState state) {
		for (PlayerEntity player : world.getPlayers()) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
			if (serverPlayer.interactionManager.isSurvivalLike() && !safePlayers.contains(player.getUuid())) {
				if (inRoom(player)) {
					if (activeDuration == 0) {
						setForcefields(true);
						activeDuration = 1;
						playEnterSound(player);
					}
					safePlayers.add(player.getUuid());
				}
			}
		}
		if (activeDuration > 0) {
			if (activeDuration == 40) {
				spawnMobs();
			} else if (activeDuration > 40) {
				for (int i = 0; i < activeMobs.size(); i++) {
					LivingEntity livingEntity = activeMobs.get(i);
					if (livingEntity.isDead()) {
						activeMobs.remove(i);
						i--;
					}
				}
				if (activeMobs.size() == 0) {
					setForcefields(false);
					activeDuration = 0;
					for (PlayerEntity player : world.getPlayers()) {
						if (inRoom(player)) {
							playOverSound(player);
						}
					}
					return;
				}
			}
			activeDuration++;
		}
	}

	public void killTick(World world, BlockPos pos, BlockState state) {
		for (PlayerEntity player : world.getPlayers()) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
			if (inRoom(player) && player.isAlive() && serverPlayer.interactionManager.isSurvivalLike()) {
				player.kill((ServerWorld)world);
			}
		}
	}

	public void denyTick(World world, BlockPos pos, BlockState state) {
		//TODO
	}

	public void secretTick(World world, BlockPos pos, BlockState state) {
		for (PlayerEntity player : world.getPlayers()) {
			if (inRoom(player) && !safePlayers.contains(player.getUuid())) {
				playSecretSound(player);
			}
		}
	}

	public void warpTick(World world, BlockPos pos, BlockState state) {
		String[] coords = mobList.split(" ");
		if (coords.length != 3) return;
		for (PlayerEntity player : world.getPlayers()) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
			if (inRoom(player) && serverPlayer.interactionManager.isSurvivalLike()) {
				player.teleport(parseDouble(coords[0]), parseDouble(coords[1]), parseDouble(coords[2]), false);
			}
		}
	}

	public void vkillTick(World world, BlockPos pos, BlockState state) {
		Box box = new Box(new Vec3d(offset.add(pos)), new Vec3d(offset.add(pos).add(size)));
		List<LivingEntity> entities = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), box, EntityPredicates.VALID_LIVING_ENTITY);
		for (LivingEntity entity : entities) {
			if (!entity.isPlayer()) {
				entity.kill((ServerWorld)world);
			}
		}
	}

	public void dropTick(World world, BlockPos pos, BlockState state) {
		for (int i = 0; i < safePlayers.size(); i++) {
			PlayerEntity player = world.getPlayerByUuid(safePlayers.get(i));
			if (!inRoom(player)) {
				safePlayers.remove(i);

				ILivingEntityMixin livingEntity = (ILivingEntityMixin)(Object)player;
				livingEntity.setFallImmune(false);
			}
		}
		for (PlayerEntity player : world.getPlayers()) {
			if (inRoom(player)) {
				ILivingEntityMixin livingEntity = (ILivingEntityMixin)(Object)player;
				livingEntity.setFallImmune(true);

				safePlayers.add(player.getUuid());
			}
		}
	}

	public int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public double parseDouble(String string) {
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
