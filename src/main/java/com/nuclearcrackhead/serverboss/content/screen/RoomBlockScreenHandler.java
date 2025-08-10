package com.nuclearcrackhead.serverboss.content.screen;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import com.nuclearcrackhead.serverboss.registry.ModScreenHandlers;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;

public class RoomBlockScreenHandler extends ScreenHandler {
	private UpdateRoomBlockS2CPacket payload;

	public RoomBlockScreenHandler(int syncId, PlayerInventory inventory, UpdateRoomBlockS2CPacket payload) {
		this(syncId);
		this.payload = payload;
	}

	public RoomBlockScreenHandler(int syncId) {
		super(ModScreenHandlers.ROOM_BLOCK_SCREEN_HANDLER, syncId);
	}

	@Override
	public ItemStack quickMove(PlayerEntity player, int invSlot) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return true;
	}

	public UpdateRoomBlockS2CPacket getPayload() {
		return payload;
	}
}
