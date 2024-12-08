package com.nuclearcrackhead.serverboss.registry;
import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.ExampleBlock;
import com.nuclearcrackhead.serverboss.content.block.Agony;
import com.nuclearcrackhead.serverboss.content.block.WasteBarrel;
import com.nuclearcrackhead.serverboss.content.block.Sludge;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.Function;

public class ModBlocks {

    public static void init() {}

    public static Block RADIOACTIVE = register("radioactive",
            settings -> new FluidBlock(ModFluids.RADIOACTIVE_STILL, settings),
            AbstractBlock.Settings.copy(Blocks.WATER).emissiveLighting(ModBlocks::always).luminance(value -> 10)
    );
    public static final Block EXAMPLE_BLOCK = register("example_block", ExampleBlock::new,
            AbstractBlock.Settings.create()
    );
    public static final Block WASTEBARREL = register("wastebarrel", WasteBarrel::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)
    );
    public static final Block AGONY = register("agony", Agony::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.6F).jumpVelocityMultiplier(0.9F).emissiveLighting(ModBlocks::always).luminance(value -> 13).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block SLUDGE = register("sludge", Sludge::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.8F).jumpVelocityMultiplier(0.5F).slipperiness(0.992F).sounds(BlockSoundGroup.HONEY)
    );

    public static Block register(String path, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        settings.registryKey(blockKey);
        Block block = Registry.register(Registries.BLOCK, blockKey, function.apply(settings));

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings itemSettings = new Item.Settings()
                .useBlockPrefixedTranslationKey()
                .registryKey(itemKey);
        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, itemSettings));
        return block;
    }

    protected static boolean always(BlockState state, BlockView world, BlockPos pos){
        return true;
    }

}
