package com.nuclearcrackhead.serverboss.content.screenhandler;

import com.nuclearcrackhead.serverboss.registry.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public class BouncePadScreenHandler extends ScreenHandler {
    //private final float force;

    public BouncePadScreenHandler(int syncId) {
        this(syncId, 1.5f);
    }

    public BouncePadScreenHandler(int syncId, float screenForce) {
        super(ModScreenHandlers.BOUNCE_PAD_SCREEN_HANDLER, syncId);
    }

    //why are these necessary -mikii/adenator

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        return ItemStack.EMPTY;
    }

}
