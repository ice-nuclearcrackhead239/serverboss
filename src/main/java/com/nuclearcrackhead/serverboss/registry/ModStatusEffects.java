package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.status.FracturedStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModStatusEffects {

    public static void init() {}

    public static final StatusEffect FRACTURED_EFFECT = Registry.register(Registries.STATUS_EFFECT, SVBCR.of("fractured"), new FracturedStatusEffect());

}
