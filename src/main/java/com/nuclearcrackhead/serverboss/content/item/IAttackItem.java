package com.nuclearcrackhead.serverboss.content.item;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface IAttackItem {
	public void onPrimaryFire(World world, PlayerEntity player, ItemStack stack);
}
