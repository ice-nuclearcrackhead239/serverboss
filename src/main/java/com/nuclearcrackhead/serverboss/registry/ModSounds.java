package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private ModSounds() {
        //don't instantiate this again
    }

    public static final SoundEvent BLOCK_AGONY_ACTIVATE_FANGSNAP = registerSound("block.agony.activate_fangsnap");
    public static final SoundEvent BLOCK_AGONY_ACTIVATE_ZOMBIESTEP = registerSound("block.agony.activate_zombiestep");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(SVBCR.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init() {
        //wawa
    }

}
