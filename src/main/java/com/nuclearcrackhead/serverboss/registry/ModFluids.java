package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.RadioactiveFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModFluids {

    public static void init() {}

    public static FlowableFluid RADIOACTIVE_STILL = (FlowableFluid) register("radioactive_still", new RadioactiveFluid.Still());
    public static FlowableFluid RADIOACTIVE_FLOWING = (FlowableFluid) register("radioactive_flowing", new RadioactiveFluid.Flowing());

    public static Fluid register(String path, Fluid fluid) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Fluid> key = RegistryKey.of(RegistryKeys.FLUID, id);
        return Registry.register(Registries.FLUID, key, fluid);
    }
/*
    FluidRenderHandlerRegistry.INSTANCE.register(RADIOACTIVE_STILL, RADIOACTIVE_FLOWING, new SimpleFluidRenderHandler(
        new void Identifier("minecraft:block/water_still"),
        new void Identifier("minecraft:block/water_flow"),
        0x4CC248
    ));
    BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RADIOACTIVE_STILL, RADIOACTIVE_FLOWING);
*/

}
