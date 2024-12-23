package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.item.dev.*;
import com.nuclearcrackhead.serverboss.content.item.*;
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
    public static final Item RADIOACTIVE_BUCKET = register("radioactive_bucket",
            settings -> new BucketItem(RADIOACTIVE_STILL, settings),
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
    );

    //public static final Item AXEMACHINE_SPAWN_EGG = new SpawnEggItem(ModEntities.AXEMACHINE, 0xff0000, 0x0000ff, new Item.Settings());
    // ↑ dont do that. it will crash t he game on initialization -mikii/adenator
    public static final Item AXEMACHINE_SPAWN_EGG = register("axemachine_spawn_egg", //original primary 3a363a
            settings -> new SpawnEggItem(ModEntities.AXEMACHINE, 0xffffff, 0x5b0000, settings), new Item.Settings()
    );
    public static final Item BATTERY_SPAWN_EGG = register("battery_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.BATTERY, 0xFFFFFF, 0xFF00FF, settings), new Item.Settings()
    );

    //blocks that don't already have an associated item
    public static final Item WATER_SILK = register("water_silk", settings -> new PlaceableOnWaterItem(ModBlocks.WATER_SILK, settings), new Item.Settings());
    public static final Item DEMONIC_GATE = register("demonic_gate", settings -> new TallBlockItem(ModBlocks.DEMONIC_GATE, settings), new Item.Settings());

    // dev tool items -mikii/adenator
    public static final Item DEV_FORCEFIELD_BELL = register("forcefield_bell", ForcefieldBellItem::new, new Item.Settings().useCooldown(2.0F));

    // GUNS YEE HAW
    public static final Item PISTOL = register("pistol", Pistol::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings = settings.registryKey(key);
        return Registry.register(Registries.ITEM, key, function.apply(settings));
    }

}
