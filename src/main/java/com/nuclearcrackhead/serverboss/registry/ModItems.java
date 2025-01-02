package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.item.dev.*;
import com.nuclearcrackhead.serverboss.content.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.BiFunction;
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
    public static final Item CRIMSON_STALKS = register("crimson_stalks", settings -> new TallBlockItem(ModBlocks.CRIMSON_STALKS, settings), new Item.Settings());
    public static final Item WARPED_STALKS = register("warped_stalks", settings -> new TallBlockItem(ModBlocks.WARPED_STALKS, settings), new Item.Settings());
    public static final Item DEMONIC_GATE = register("demonic_gate", settings -> new TallBlockItem(ModBlocks.DEMONIC_GATE, settings), new Item.Settings());

    public static final Item PROP_TRASH = register("prop_trash", settings -> new BlockItem(ModBlocks.TRASH, settings), new Item.Settings());
    public static final Item PROP_TRASH_SPREAD = register("prop_trash_spread", settings -> new BlockItem(ModBlocks.TRASH_SPREAD, settings), new Item.Settings());
    public static final Item PROP_DRIFTWOOD = register("prop_driftwood", settings -> new BlockItem(ModBlocks.DRIFTWOOD, settings), new Item.Settings());
    public static final Item PROP_DUST = register("prop_dust", settings -> new BlockItem(ModBlocks.DUST, settings), new Item.Settings());
    public static final Item PROP_PUDDLE = register("prop_puddle", settings -> new BlockItem(ModBlocks.PUDDLE, settings), new Item.Settings());
    public static final Item PROP_GRAVEL_PATCH = register("prop_gravel_patch", settings -> new BlockItem(ModBlocks.GRAVEL_PATCH, settings), new Item.Settings());
    public static final Item PROP_PEBBLES = register("prop_pebbles", settings -> new BlockItem(ModBlocks.PEBBLES, settings), new Item.Settings());
    public static final Item HUB_TORCH = register(ModBlocks.HUB_TORCH, ((block, settings) -> new VerticallyAttachableBlockItem( block, ModBlocks.HUB_WALL_TORCH, Direction.DOWN, settings)));

    public static final Item GLOWING_MUSHROOMS = register("glowing_mushrooms", settings -> new BlockItem(ModBlocks.GLOWING_MUSHROOMS, settings), new Item.Settings());

    public static final Item MYCELIA = register("mycelia", settings -> new BlockItem(ModBlocks.MYCELIA, settings), new Item.Settings());
    public static final Item MYCELIAL_EYE = register("mycelial_eye", settings -> new BlockItem(ModBlocks.MYCELIAL_EYE, settings), new Item.Settings());
    public static final Item MYCELIA_BLOOM = register("mycelia_bloom", settings -> new BlockItem(ModBlocks.MYCELIA_BLOOM, settings), new Item.Settings());
    public static final Item MYCELIA_STALKS = register("mycelia_stalks", settings -> new BlockItem(ModBlocks.MYCELIA_STALKS, settings), new Item.Settings());

    // dev tool items -mikii/adenator
    public static final Item DEV_WRENCH = register("wrench", WrenchItem::new, new Item.Settings().maxCount(1));
    public static final Item DEV_FORCEFIELD_BELL = register("forcefield_bell", ForcefieldBellItem::new, new Item.Settings().maxCount(1).useCooldown(2.0F));

    // GUNS YEE HAW
    public static final Item PISTOL = register("pistol", Pistol::new, new Item.Settings());

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return register(block, factory, new Item.Settings());
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register((RegistryKey)keyOf(block.getRegistryEntry().registryKey()), (Function)((itemSettings) -> (Item)factory.apply(block, (Item.Settings) itemSettings)), settings.useBlockPrefixedTranslationKey());
    }

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = (Item)factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registries.ITEM, key, item);
    }

    public static Item register(String path, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings = settings.registryKey(key);
        return Registry.register(Registries.ITEM, key, function.apply(settings));
    }

}
