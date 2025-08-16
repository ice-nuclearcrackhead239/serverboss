package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.util.StringIdentifiable;

public enum RoomBlockMode implements StringIdentifiable {
	NORMAL("normal"),
	SECRET("secret"),
	DROP("drop"),
	WARP("warp"),
	KILL("kill"),
	VKILL("vkill"),
	DENY("deny");

	public final String name;

	private RoomBlockMode(final String name) {
		this.name = name;
	}

	public String asString() {
		return name;
	}
}
