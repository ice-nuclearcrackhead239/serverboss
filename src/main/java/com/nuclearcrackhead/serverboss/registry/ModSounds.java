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
    public static final SoundEvent BLOCK_SLUDGE_SLIDE = registerSound("block.sludge.slide");
    public static final SoundEvent BLOCK_SPIKE_BLOCK_TRIGGER = registerSound("block.spike_block.trigger");
    public static final SoundEvent BLOCK_SPIKE_BLOCK_UP = registerSound("block.spike_block.up");
    public static final SoundEvent BLOCK_SPIKE_BLOCK_DOWN = registerSound("block.spike_block.down");
    public static final SoundEvent BLOCK_BOUNCE_PAD = registerSound("block.bounce_pad.launch");
    public static final SoundEvent BLOCK_SPEED_PAD = registerSound("block.speed_pad.launch");
    public static final SoundEvent BLOCK_METAL_LADDER_STEP = registerSound("block.metal_ladder.step");
    public static final SoundEvent BLOCK_FUMO_PLACE = registerSound("block.fumo.place");
    public static final SoundEvent BLOCK_FUMO_BREAK = registerSound("block.fumo.break");
    
    public static final SoundEvent MISC_ERROR = registerSound("misc.error");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(SVBCR.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init() {
        //wawa
    }

}
