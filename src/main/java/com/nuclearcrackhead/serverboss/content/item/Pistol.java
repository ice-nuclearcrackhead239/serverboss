package com.nuclearcrackhead.serverboss.content.item;

import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;

import com.nuclearcrackhead.serverboss.content.entity.*;

/**
 * The base gun.
 *
 * This is the base implementation for a gun.
 *
 * @author Finxx
 * @see com.nuclearcrackhead.serverboss.content.render.item.PistolItemRenderer
 */
public class Pistol extends Item implements IAttackItem {
	public Pistol(Settings settings) {
		super(settings);
	}

	/**
	 * Spawns a bullet.
	 *
	 * @param world the world
	 * @param user the player
	 * @param stack the item stack
	 * @see IAttackItem#onPrimaryFire
	 */
	public void onPrimaryFire(World world, PlayerEntity user, ItemStack stack) {
		if (!world.isClient) {
			BulletEntity bulletEntity = new BulletEntity(world, user).setDirection(user.getPitch(), user.getYaw()).setDamage(5).setSpeed(2);
			world.spawnEntity(bulletEntity);
		}
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
//		SVBCR.LOGGER.info("right click!");
		return ActionResult.CONSUME;
	}
}
