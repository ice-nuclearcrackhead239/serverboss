package com.nuclearcrackhead.serverboss.registry;

import com.nuclearcrackhead.serverboss.SVBCR;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
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
        developer tools
    */

    public static final ItemGroup SVBCR_GROUP_FUNCBLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.AGONY))
            .displayName(Text.translatable("itemGroup.svbcr.functional_blocks"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.AGONY);
                entries.add(ModBlocks.SLUDGE);
				entries.add(ModBlocks.SPIKE_BLOCK);
            })
            .build();

    public static final ItemGroup SVBCR_GROUP_DECOBLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.EXAMPLE_BLOCK))
            .displayName(Text.translatable("itemGroup.svbcr.decorational_blocks"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.EXAMPLE_BLOCK);
                entries.add(ModBlocks.WASTEBARREL);
                entries.add(ModBlocks.WHITE);
                entries.add(ModBlocks.BLACK);
                entries.add(ModBlocks.CHECKERED_OBSIDIAN);
                entries.add(ModBlocks.CHISELED_OBSIDIAN);
                entries.add(ModBlocks.OBSIDIAN_LIGHT_STRIP);
                entries.add(ModBlocks.PORTAL_GLASS_OPAQUE);
                entries.add(ModBlocks.PORTAL_GLASS_TRANSPARENT);
                entries.add(ModBlocks.VOID_LAMP);
                entries.add(ModBlocks.SMOOTH_STONE_STAIRS);
            })
            .build();


    public static void init() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "funcblocks"), SVBCR_GROUP_FUNCBLOCKS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SVBCR.MOD_ID, "decoblocks"), SVBCR_GROUP_DECOBLOCKS);

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
            entries.add(ModItems.RADIOACTIVE_BUCKET);
            entries.add(ModItems.EXAMPLE_ITEM);
        });
    }

}
