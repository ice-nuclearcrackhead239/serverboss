package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.Agony;
import com.nuclearcrackhead.serverboss.content.block.ExampleBlock;
import com.nuclearcrackhead.serverboss.content.block.RadioactiveFluid;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.Function;

public class ModFluids {

    public static void init() {}

    public static FlowableFluid RADIOACTIVE_STILL = register("radioactive_still", new RadioactiveFluid.Still());
    public static FlowableFluid RADIOACTIVE_FLOWING = register("radioactive_flowing", new RadioactiveFluid.Flowing());

    public static Fluid register(String path, Fluid fluid) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Fluid> key = RegistryKey.of(RegistryKeys.FLUID, id);
        return Registry.register(Registries.FLUID, key, fluid);
    }

}
