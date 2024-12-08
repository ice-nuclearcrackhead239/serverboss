package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.item.ExampleItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nuclearcrackhead.serverboss.registry.ModFluids.RADIOACTIVE_STILL;


public class ModItems {

    public static void init() {}


    public static final Item EXAMPLE_ITEM = register("example_item", ExampleItem::new,
            new Item.Settings()
    );
    public static Item RADIOACTIVE_BUCKET = register("radioactive_bucket",
            settings -> new BucketItem(RADIOACTIVE_STILL, settings),
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
    );

    public static Item register(String path, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings = settings.registryKey(key);
        return Registry.register(Registries.ITEM, key, function.apply(settings));
    }

}
