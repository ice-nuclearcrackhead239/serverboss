package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    /*TODO:: add these groups:
        DECORATED items
        UNIQUE items
        STRANGE items
        GENUINE items
        VINTAGE items
        COMMUNITY items
        COLLECTOR'S items
        HAUNTED items
        UNUSUAL items
        CRACKED items
    */

    public static final ItemGroup SVBCR_GROUP_FUNCBLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.AGONY))
            .displayName(Text.translatable("itemGroup.svbcr.functional_blocks"))
            .entries((context, entries) -> {
                //entries.add(Blocks.END_GATEWAY); // :[
                entries.add(ModBlocks.AGONY);
                entries.add(ModBlocks.SLUDGE);
				entries.add(ModBlocks.SPIKE_BLOCK);
                entries.add(ModBlocks.FORCEFIELD);
                entries.add(ModBlocks.SPEED_PAD);
                entries.add(ModBlocks.BOUNCE_PAD);
            })
            .build();

    public static final ItemGroup SVBCR_GROUP_DECOBLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.EXAMPLE_BLOCK))
            .displayName(Text.translatable("itemGroup.svbcr.decorational_blocks"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.ASPHALT);
                entries.add(ModBlocks.LOAM);
                entries.add(ModBlocks.SILT);
                entries.add(ModBlocks.ROPE);
                entries.add(ModItems.LARGE_TORCH);
                entries.add(ModBlocks.BUTTERCUPS);
                entries.add(ModBlocks.OBSTERINE);
                entries.add(ModBlocks.AXTERIA);
                entries.add(ModItems.WATER_SILK);
                entries.add(ModItems.PROP_DRIFTWOOD);
                entries.add(ModItems.PROP_PUDDLE);
                entries.add(ModItems.PROP_DUST);
                entries.add(ModItems.PROP_GRAVEL_PATCH);
                entries.add(ModItems.PROP_TRASH);
                entries.add(ModItems.PROP_TRASH_SPREAD);
                entries.add(ModItems.PROP_PEBBLES);
                entries.add(ModBlocks.LOPER_BRICKS);
                entries.add(ModBlocks.B_DEV_ORANGE);
                entries.add(ModBlocks.B_DEV_ASH);
                entries.add(ModBlocks.B_DEV_WHITE);
                entries.add(ModBlocks.B_DEV_CLEAR);
                entries.add(ModBlocks.B_DEV_SKY);
                entries.add(ModBlocks.CHECKERBOARD);
                entries.add(ModItems.GLOWING_MUSHROOMS);
                entries.add(ModBlocks.GLOWING_MUSHROOM_BLOCK);
                entries.add(ModBlocks.GLOWING_MUSHROOM_STEM);
                entries.add(ModItems.MYCELIA);
                entries.add(ModItems.MYCELIA_BLOOM);
                entries.add(ModItems.MYCELIA_STALKS);
                entries.add(ModItems.MYCELIAL_EYE);
                entries.add(ModBlocks.BLOCK_TRASH);
                entries.add(ModBlocks.RUST);
                entries.add(ModBlocks.WASTEBARREL);
                entries.add(ModBlocks.RADIOACTIVE_PIPE);
                entries.add(ModBlocks.HAZARD_MARKER);
                entries.add(ModBlocks.HAZARD_MARKER_SLAB);
                entries.add(ModBlocks.HAZARD_MARKER_STAIRS);
                entries.add(ModBlocks.HAZARD_TAPE);
                entries.add(ModBlocks.METAL_LADDER);
                entries.add(ModBlocks.IRON_PLATING);
                entries.add(ModBlocks.IRON_PLATING_SLAB);
                entries.add(ModBlocks.IRON_PLATING_STAIRS);
                entries.add(ModBlocks.IRON_GRATING);
                entries.add(ModBlocks.IRON_PIPE);
                entries.add(ModBlocks.COPPER_PIPE);
                entries.add(ModBlocks.COPPER_BARS);
                entries.add(ModBlocks.GLASS_PIPE);
                entries.add(ModBlocks.GEARBOX);
                entries.add(ModBlocks.MOTHERBOARD);
                entries.add(ModBlocks.CIRCUITS);
                entries.add(ModBlocks.CABLE);
                //entries.add(ModBlocks.ELECTRIC); later ^2
                //entries.add(ModBlocks.IRON_FENCE); later
                entries.add(ModBlocks.CORRUGATED_IRON);
                entries.add(ModBlocks.CORRUGATED_IRON_BLOCK);
                entries.add(ModBlocks.SMOOTH_IRON);
                entries.add(ModBlocks.TILED_IRON);
                entries.add(ModBlocks.BARBED_WIRE);
                entries.add(ModBlocks.WHITE);
                entries.add(ModBlocks.BLACK);
                entries.add(ModBlocks.PORTAL_LEGACY);
                entries.add(ModBlocks.CRYSTALLINE_DIAMOND);
                entries.add(ModBlocks.CHECKERED_OBSIDIAN);
                entries.add(ModBlocks.CHISELED_OBSIDIAN);
                entries.add(ModBlocks.OBSIDIAN_LIGHT_STRIP);
                entries.add(ModBlocks.PORTAL_GLASS_OPAQUE);
                entries.add(ModBlocks.PORTAL_GLASS_TRANSPARENT);
                entries.add(ModBlocks.JELLY);
                entries.add(ModBlocks.JELLY_TRANSLUCENT);
                entries.add(ModBlocks.DARK_GLASS);
                entries.add(ModBlocks.VOID_LAMP);
                entries.add(ModBlocks.SMOOTH_STONE_STAIRS);
                entries.add(ModBlocks.SMOOTH_STONE_BRICKS);
                entries.add(ModBlocks.SMOOTH_STONE_BRICKLETS);
                entries.add(ModBlocks.IRRADIATED_SMOOTH_STONE_BRICKS);
                entries.add(ModBlocks.CRACKED_SMOOTH_STONE_BRICKS);
                entries.add(ModBlocks.SMOOTH_STONE_TILES);
                entries.add(ModBlocks.SMOOTH_STONE_QUADS);
                entries.add(ModBlocks.POLISHED_SMOOTH_STONE);
                entries.add(ModBlocks.SMOOTH_STONE_PILLAR);
                entries.add(ModBlocks.CHISELED_SMOOTH_STONE);
                entries.add(ModBlocks.STONE_PATHWAY);
                entries.add(ModBlocks.ASH);
                entries.add(ModBlocks.RIVERTILES);
                entries.add(ModBlocks.RIVEREYES);
                entries.add(ModBlocks.RIVERLAMP);
                entries.add(ModBlocks.RIVERBRICKS);
                entries.add(ModBlocks.RIVERBRICKLETS);
                entries.add(ModBlocks.RIVERSTONE);
                entries.add(ModBlocks.AGONY_LANTERN);
                entries.add(ModBlocks.NETHERITE_CHAIN);
                entries.add(ModBlocks.SMOOTH_BLACKSTONE);
                entries.add(ModBlocks.CHISELED_POLISHED_BLACKSTONE_EYES);
                entries.add(ModBlocks.POLISHED_BLACKSTONE_BRICKLETS);
                entries.add(ModBlocks.POLISHED_BLACKSTONE_BRICKLETS_SLAB);
                entries.add(ModBlocks.POLISHED_BLACKSTONE_BRICKLETS_STAIRS);
                entries.add(ModBlocks.POLISHED_BLACKSTONE_PILLAR);
                entries.add(ModBlocks.INDENTED_POLISHED_BLACKSTONE);
                entries.add(ModBlocks.DEMONIC_BOOKSHELF);
                entries.add(ModBlocks.DEMONIC_POLISHED_CHISELED_BLACKSTONE);
                entries.add(ModItems.DEMONIC_GATE);
                entries.add(ModBlocks.BLACKSTONE_PEDESTAL);
                entries.add(ModBlocks.AGONIZED_GLASS);
                entries.add(ModBlocks.CHISELED_NETHERITE);
                entries.add(ModBlocks.POLISHED_NETHERITE);
                entries.add(ModBlocks.NETHERITE_PIPE);
                entries.add(ModBlocks.NETHERITE_BARS);
                entries.add(ModItems.CRIMSON_STALKS);
                entries.add(ModBlocks.CRIMSON_VEINS);
                entries.add(ModItems.WARPED_STALKS);
                entries.add(ModBlocks.WARPED_WIREFRAME);
                entries.add(ModBlocks.FLESH);
                entries.add(ModBlocks.FLESH_EYES);
                entries.add(ModBlocks.FLESH_GUTS);
                entries.add(ModBlocks.FLESH_GUTS_ROTTEN);
                entries.add(ModBlocks.FLESH_HOLES);
                entries.add(ModBlocks.FLESH_MESH);
                entries.add(ModBlocks.FLESH_SPINE);
                entries.add(ModBlocks.FLESH_TOOTH);
                entries.add(ModItems.FLESH_POLYP);
                entries.add(ModItems.FLESH_PUSTULE);
                entries.add(ModItems.FLESH_CAPILLARIES);
                entries.add(ModBlocks.WHITE_WALLPAPER);
                entries.add(ModBlocks.SILVER_WALLPAPER);
                entries.add(ModBlocks.ASH_WALLPAPER);
                entries.add(ModBlocks.BLACK_WALLPAPER);
                entries.add(ModBlocks.BROWN_WALLPAPER);
                entries.add(ModBlocks.RED_WALLPAPER);
                entries.add(ModBlocks.ORANGE_WALLPAPER);
                entries.add(ModBlocks.YELLOW_WALLPAPER);
                entries.add(ModBlocks.LIME_WALLPAPER);
                entries.add(ModBlocks.GREEN_WALLPAPER);
                entries.add(ModBlocks.CYAN_WALLPAPER);
                entries.add(ModBlocks.BLUE_WALLPAPER);
                entries.add(ModBlocks.NAVY_WALLPAPER);
                entries.add(ModBlocks.PURPLE_WALLPAPER);
                entries.add(ModBlocks.MAGENTA_WALLPAPER);
                entries.add(ModBlocks.PINK_WALLPAPER);
                entries.add(ModBlocks.FIREBLU);
                entries.add(ModBlocks.CORRU);
                entries.add(ModBlocks.PALE_CORRU);
                entries.add(ModItems.WATER_LILY);
                entries.add(ModBlocks.HUB_BRICKS_4);
                entries.add(ModBlocks.HUB_BRICKS_3);
                entries.add(ModBlocks.HUB_BRICKS_2);
                entries.add(ModBlocks.HUB_BRICKS_1);
                entries.add(ModBlocks.HUB_TILES);
                entries.add(ModBlocks.HUB_TILE_YELLOW);
                entries.add(ModBlocks.HUB_TILE_BLUE);
                entries.add(ModBlocks.HUB_GLASS);
                entries.add(ModItems.HUB_TORCH);
                entries.add(ModBlocks.VOLUMETRIC_LIGHT);
                entries.add(ModBlocks.EXAMPLE_BLOCK);
            })
            .build();

    public static final ItemGroup SVBCR_GROUP_DEVTOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.DEBUG_STICK))
            .displayName(Text.translatable("itemGroup.svbcr.devtools"))
            .entries((context, entries) -> {
                entries.add(ModItems.DEV_FORCEFIELD_BELL);
            })
            .build();

    public static final ItemGroup SVBCR_FUMOS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.FUMO_ICE))
            .displayName(Text.translatable("itemGroup.svbcr.fumos"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.FUMO_ISM);
                entries.add(ModBlocks.FUMO_RIKA);
                entries.add(ModBlocks.FUMO_SPEEDER);
                entries.add(ModBlocks.FUMO_ILYA);
                entries.add(ModBlocks.FUMO_BERYL);
                entries.add(ModBlocks.FUMO_TOBI);
                entries.add(ModBlocks.FUMO_HEAPONS);
                entries.add(ModBlocks.FUMO_SOUMEH);
                entries.add(ModBlocks.FUMO_ICE);
                entries.add(ModBlocks.FUMO_FRESHLY);
                entries.add(ModBlocks.FUMO_JOSE);
                entries.add(ModBlocks.FUMO_OBI);
                entries.add(ModBlocks.FUMO_AVARITA);
                entries.add(ModBlocks.FUMO_DERZOX);
                entries.add(ModBlocks.FUMO_MIKII);
                entries.add(ModBlocks.FUMO_KAORI);
            })
            .build();


    public static void init() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "funcblocks"), SVBCR_GROUP_FUNCBLOCKS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "decoblocks"), SVBCR_GROUP_DECOBLOCKS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "devtools"), SVBCR_GROUP_DEVTOOLS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "fumos"), SVBCR_FUMOS);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.EXAMPLE_BLOCK);
            entries.add(ModBlocks.AGONY);
        });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.SPIKE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModBlocks.WASTEBARREL);
            entries.add(ModBlocks.SLUDGE);
            entries.add(ModBlocks.WATER_SILK);
            entries.add(ModItems.RADIOACTIVE_BUCKET);
            entries.add(ModItems.EXAMPLE_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ModItems.AXEMACHINE_SPAWN_EGG);
            entries.add(ModItems.BATTERY_SPAWN_EGG);
        });
    }

}
