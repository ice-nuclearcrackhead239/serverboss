package com.nuclearcrackhead.serverboss.registry;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import com.nuclearcrackhead.serverboss.content.packet.*;

public class ModPackets {
	public static void init() {
		PayloadTypeRegistry.playC2S().register(AttackItemPacket.PACKET_ID, AttackItemPacket.PACKET_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(AttackItemPacket.PACKET_ID, AttackItemPacket::recieve);
	}
}
