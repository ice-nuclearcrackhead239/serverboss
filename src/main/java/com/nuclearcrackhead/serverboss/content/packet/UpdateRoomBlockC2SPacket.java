package com.nuclearcrackhead.serverboss.content.packet;

import net.minecraft.network.packet.CustomPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.util.math.BlockPos;

import com.nuclearcrackhead.serverboss.content.block.RoomBlockEntity;
import com.nuclearcrackhead.serverboss.SVBCR;

public record UpdateRoomBlockC2SPacket(BlockPos targetPos, String name, String mobList, BlockPos roomPos, BlockPos roomSize, boolean showBounds, String forceFieldList) implements CustomPayload {
	public static final CustomPayload.Id<UpdateRoomBlockC2SPacket> PACKET_ID = new CustomPayload.Id<>(SVBCR.of("update_room_packet"));
	public static final PacketCodec<RegistryByteBuf, UpdateRoomBlockC2SPacket> PACKET_CODEC = PacketCodec.tuple(
			BlockPos.PACKET_CODEC, UpdateRoomBlockC2SPacket::targetPos,
			PacketCodecs.STRING, UpdateRoomBlockC2SPacket::name,
			PacketCodecs.STRING, UpdateRoomBlockC2SPacket::mobList,
			BlockPos.PACKET_CODEC, UpdateRoomBlockC2SPacket::roomPos,
			BlockPos.PACKET_CODEC, UpdateRoomBlockC2SPacket::roomSize,
			PacketCodecs.BOOLEAN, UpdateRoomBlockC2SPacket::showBounds,
			PacketCodecs.STRING, UpdateRoomBlockC2SPacket::forceFieldList,
			UpdateRoomBlockC2SPacket::new);
	@Override
	public CustomPayload.Id<? extends CustomPayload> getId() {
		return PACKET_ID;
	}

	public void recieve(ServerPlayNetworking.Context context) {
		if (context.player().getWorld().getBlockEntity(targetPos()) instanceof RoomBlockEntity roomBlockEntity) {
			roomBlockEntity.update(this);
		}
	}
}
