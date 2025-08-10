package com.nuclearcrackhead.serverboss.content.packet;

import net.minecraft.util.math.BlockPos;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.RegistryByteBuf;
import com.nuclearcrackhead.serverboss.SVBCR;

public record UpdateRoomBlockS2CPacket(BlockPos targetPos, String name, String mobList, BlockPos roomPos, BlockPos roomSize, boolean showBounds) implements CustomPayload {
	public static final Id<UpdateRoomBlockS2CPacket> PACKET_ID = new Id<>(SVBCR.of("update_room_s2c_packet"));
	public static final PacketCodec<RegistryByteBuf, UpdateRoomBlockS2CPacket> PACKET_CODEC = PacketCodec.tuple(
			BlockPos.PACKET_CODEC, UpdateRoomBlockS2CPacket::targetPos,
			PacketCodecs.STRING, UpdateRoomBlockS2CPacket::name,
			PacketCodecs.STRING, UpdateRoomBlockS2CPacket::mobList,
			BlockPos.PACKET_CODEC, UpdateRoomBlockS2CPacket::roomPos,
			BlockPos.PACKET_CODEC, UpdateRoomBlockS2CPacket::roomSize,
			PacketCodecs.BOOLEAN, UpdateRoomBlockS2CPacket::showBounds,
			UpdateRoomBlockS2CPacket::new);

	public Id<? extends CustomPayload> getId() {
		return PACKET_ID;
	}
}
