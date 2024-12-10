package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.fabricmc.fabric.api.resource.*;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.nuclearcrackhead.serverboss.SVBCR.MOD_ID;

public class ExtraPacks {

    public static void init() {
        ModContainer svbcr = FabricLoader.getInstance().getModContainer(SVBCR.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("hi where's the mod container"));
        Identifier packId = Identifier.of(MOD_ID, "reworks");
        Text packName = Text.literal("SVB:CR: Vanilla Reworks");
        ResourceManagerHelper.registerBuiltinResourcePack(packId, svbcr, packName, ResourcePackActivationType.NORMAL);
    }

}
