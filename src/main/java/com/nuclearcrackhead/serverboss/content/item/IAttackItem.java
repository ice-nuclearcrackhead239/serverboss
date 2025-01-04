package com.nuclearcrackhead.serverboss.content.item;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

/**
 * Allows an item to recieve the onPrimaryFire event.
 *
 * @author Finxx
 */
public interface IAttackItem {
	/**
	 * Sent to the item when a player has used primary fire while holding
	 * the item (defaulting to left click).
	 *
	 * This function is called on both the client and the server.
	 *
	 * @param world the world
	 * @param player the player
	 * @param stack the held item stack
	 */
	public void onPrimaryFire(World world, PlayerEntity player, ItemStack stack);
}
