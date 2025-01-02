package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.screenhandler.BouncePadScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {

    public static final ScreenHandlerType<BouncePadScreenHandler> BOUNCE_PAD_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, SVBCR.of("bounce_pad"), new ScreenHandlerType<>(BouncePadScreenHandler::new, FeatureSet.empty()));

    public static void init() {}

}
