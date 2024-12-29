package com.nuclearcrackhead.serverboss.registry;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class ModSoundGroups {
    public static final BlockSoundGroup PUDDLE;
    public static final BlockSoundGroup METAL_LADDER;

    static {
        PUDDLE = new BlockSoundGroup(1.0F, 1.0F, SoundEvents.ENTITY_GENERIC_SPLASH, SoundEvents.ENTITY_GENERIC_SWIM, SoundEvents.ENTITY_GENERIC_SPLASH, SoundEvents.ENTITY_GENERIC_SWIM, SoundEvents.ENTITY_GENERIC_SPLASH);
        METAL_LADDER = new BlockSoundGroup(1.0F, 1.0F, SoundEvents.BLOCK_METAL_BREAK, ModSounds.BLOCK_METAL_LADDER_STEP, SoundEvents.BLOCK_METAL_PLACE, ModSounds.BLOCK_METAL_LADDER_STEP, ModSounds.BLOCK_METAL_LADDER_STEP);

    }
}
