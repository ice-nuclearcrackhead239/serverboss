package com.nuclearcrackhead.serverboss.content.item;

import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.server.world.ServerWorld;

import com.nuclearcrackhead.serverboss.content.entity.BulletEntity;
import com.nuclearcrackhead.serverboss.SVBCR;

public class Pistol extends Item implements IAttackItem {
	public Pistol(Settings settings) {
		super(settings);
	}

	public void onPrimaryFire(World world, PlayerEntity user, ItemStack stack) {
		if (world instanceof ServerWorld serverWorld) {
			BulletEntity bulletEntity = new BulletEntity(world, user).setDirection(user.getPitch(), user.getYaw()).setDamage(2).setSpeed(2);
			serverWorld.spawnEntity(bulletEntity);
			SVBCR.LOGGER.info("spawned");
		}
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
//		SVBCR.LOGGER.info("right click!");
		return ActionResult.CONSUME;
	}
}
