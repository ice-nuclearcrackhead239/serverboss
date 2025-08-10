package com.nuclearcrackhead.serverboss.registry;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import com.nuclearcrackhead.serverboss.registry.ModScreenHandlers;
import com.nuclearcrackhead.serverboss.content.screen.*;

public class ModScreens {
	public static void init() {
		HandledScreens.register(ModScreenHandlers.ROOM_BLOCK_SCREEN_HANDLER, RoomBlockScreen::new);
	}
}
