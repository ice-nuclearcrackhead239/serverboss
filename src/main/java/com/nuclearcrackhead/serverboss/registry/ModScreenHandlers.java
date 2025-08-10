package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;
import com.nuclearcrackhead.serverboss.content.screen.*;

public class ModScreenHandlers {
	public static final ScreenHandlerType<RoomBlockScreenHandler> ROOM_BLOCK_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(RoomBlockScreenHandler::new, UpdateRoomBlockS2CPacket.PACKET_CODEC);

	public static void init() {
		Registry.register(Registries.SCREEN_HANDLER, SVBCR.of("room_block"), ROOM_BLOCK_SCREEN_HANDLER);
	}
}

