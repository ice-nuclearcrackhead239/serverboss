package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {

    public static void init() {}

    public static final RegistryKey<DamageType> AGONY_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, SVBCR.of("agony"));
    public static final RegistryKey<DamageType> SPIKE_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, SVBCR.of("spike"));
    public static final RegistryKey<DamageType> FRACTURED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, SVBCR.of("fractured"));

}
