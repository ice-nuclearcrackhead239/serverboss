package com.nuclearcrackhead.serverboss.registry;

import net.minecraft.item.Item;
import net.minecraft.client.MinecraftClient;
import java.util.Map;
import java.util.HashMap;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.item.*;
import com.nuclearcrackhead.serverboss.content.render.item.*;

public class ModItemRenderers {
	public static Map<Class<?>, ISvbItemRenderer> renderers = new HashMap<Class<?>, ISvbItemRenderer>();
	
	public static void init() {
		add(Pistol.class, new PistolItemRenderer());
	}

	public static ISvbItemRenderer get(Item item) {
		return renderers.get(item.getClass());
	}

	public static void add(Class<?> item, ISvbItemRenderer renderer) {
		renderers.put(item, renderer);
	}
}

