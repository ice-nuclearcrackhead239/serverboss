package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.WaterSilk;
import com.nuclearcrackhead.serverboss.content.item.ExampleItem;
import com.nuclearcrackhead.serverboss.content.item.GcpDotTestingItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;


public class ModItems {

    public static void init() {
        //Registry.register(Registries.ITEM, SVBCR.of("axemachine_spawn_egg"), AXEMACHINE_SPAWN_EGG);
    }

    public static final Item EXAMPLE_ITEM = register("example_item", ExampleItem::new,
            new Item.Settings()
    );
    public static final Item GCP_DOT_TESTING_ITEM = register("gcp_dot_testing_item", GcpDotTestingItem::new,
            new Item.Settings()
    );
    public static Item RADIOACTIVE_BUCKET = register("radioactive_bucket",
            settings -> new BucketItem(RADIOACTIVE_STILL, settings),
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
    );

    //public static final Item AXEMACHINE_SPAWN_EGG = new SpawnEggItem(ModEntities.AXEMACHINE, 0xff0000, 0x0000ff, new Item.Settings());
    // ↑ dont do that. it will crash t he game on initialization -mikii/adenator
    public static final Item AXEMACHINE_SPAWN_EGG = register("axemachine_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.AXEMACHINE, 0x3a363a, 0x5b0000, settings), new Item.Settings()
    );

    public static Item register(String path, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings = settings.registryKey(key);
        return Registry.register(Registries.ITEM, key, function.apply(settings));
    }

}
