package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.status.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class ModStatusEffects {

    public static void init() {}

    public static final RegistryEntry<StatusEffect> FRACTURED = Registry.registerReference(Registries.STATUS_EFFECT, SVBCR.of("fractured"), new FracturedStatusEffect());
    public static final RegistryEntry<StatusEffect> SOARING = Registry.registerReference(Registries.STATUS_EFFECT, SVBCR.of("soaring"), new SoaringStatusEffect().addAttributeModifier(EntityAttributes.FALL_DAMAGE_MULTIPLIER, SVBCR.of("effect.soaring"), -1.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

}
