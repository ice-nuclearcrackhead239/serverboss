package com.nuclearcrackhead.serverboss.content.item;

import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;

import com.nuclearcrackhead.serverboss.SVBCR;

public class Pistol extends Item implements IAttackItem {
	public Pistol(Settings settings) {
		super(settings);
	}

	public void onPrimaryFire(World world, PlayerEntity user, ItemStack stack) {
//		SVBCR.LOGGER.info("left click!");
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
//		SVBCR.LOGGER.info("right click!");
		return ActionResult.CONSUME;
	}
}
