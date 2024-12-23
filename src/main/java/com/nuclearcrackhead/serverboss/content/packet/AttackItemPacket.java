package com.nuclearcrackhead.serverboss.content.packet;

import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.CustomPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.RegistryByteBuf;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.item.IAttackItem;

public record AttackItemPacket(ItemStack stack) implements CustomPayload {
	public static final Codec<AttackItemPacket> CODEC = RecordCodecBuilder.create(instance -> instance.group(ItemStack.CODEC.fieldOf("stack").forGetter(AttackItemPacket::stack)).apply(instance, AttackItemPacket::new));
	public static final CustomPayload.Id<AttackItemPacket> PACKET_ID = new CustomPayload.Id<>(SVBCR.of("attack_packet"));
	public static final PacketCodec<RegistryByteBuf, AttackItemPacket> PACKET_CODEC = PacketCodec.tuple(ItemStack.PACKET_CODEC, AttackItemPacket::stack, AttackItemPacket::new);

	@Override
	public Id<? extends CustomPayload> getId() {
		return PACKET_ID;
	}

	public void recieve(ServerPlayNetworking.Context context) {
		IAttackItem attackItem = (IAttackItem)context.player().getMainHandStack().getItem();
		attackItem.onPrimaryFire(context.player().getWorld(), context.player(), context.player().getMainHandStack());
	}
}
