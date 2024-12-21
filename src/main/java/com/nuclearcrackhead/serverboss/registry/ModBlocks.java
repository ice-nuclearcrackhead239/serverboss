package com.nuclearcrackhead.serverboss.registry;
import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
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

    public static final Block WHITE = register("white", White::new,
            AbstractBlock.Settings.create().emissiveLighting(ModBlocks::always).luminance(value -> 15).sounds(BlockSoundGroup.GLASS)
    );

    public static final Block BLACK = register("black", Black::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS)
    );

    public static final Block AGONY = register("agony", Agony::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.6F).jumpVelocityMultiplier(0.9F).emissiveLighting(ModBlocks::always).luminance(value -> 13).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH = register("flesh", Block::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH_EYES = register("flesh_eyes", Block::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH_HOLES = register("flesh_holes", Block::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH_MESH = register("flesh_mesh", MeshBlock::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY).nonOpaque()
    );
    public static final Block FLESH_SPINE = register("flesh_spine", SpineBlock::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH_GUTS = register("flesh_guts", Block::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block FLESH_GUTS_ROTTEN = register("flesh_guts_rot", Block::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.9F).jumpVelocityMultiplier(0.9F).sounds(BlockSoundGroup.HONEY)
    );
    public static final Block SLUDGE = register("sludge", Sludge::new,
            AbstractBlock.Settings.create().velocityMultiplier(0.8F).jumpVelocityMultiplier(0.5F).slipperiness(0.992F).sounds(BlockSoundGroup.HONEY).nonOpaque()
    );
    public static final Block DEMONIC_GATE = registerBlock("demonic_gate", settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CHECKERED_OBSIDIAN = register("checkered_obsidian", Block::new, AbstractBlock.Settings.copy(Blocks.OBSIDIAN));
    public static final Block CHISELED_OBSIDIAN = register("chiseled_obsidian", Block::new, AbstractBlock.Settings.copy(ModBlocks.CHECKERED_OBSIDIAN));
    public static final Block RIVERBRICKS = register("river_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block RIVERBRICKLETS = register("river_bricklets", Block::new, AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block RIVERLAMP = register("river_lamp", Block::new, AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE).luminance(value -> 15));
    public static final Block RIVERTILES = register("river_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE));
    public static final Block RIVEREYES = register("river_eyes", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
    public static final Block DEMONIC_BOOKSHELF = register("demonic_bookshelf", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
    public static final Block RIVERSTONE = register("river_stone", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block AGONY_LANTERN = register("agony_lantern", LanternBlock::new, AbstractBlock.Settings.copy(Blocks.LANTERN));
    public static final Block NETHERITE_CHAIN = register("netherite_chain", ChainBlock::new, AbstractBlock.Settings.copy(Blocks.CHAIN));
    public static final Block ROPE = register("rope", ChainBlock::new, AbstractBlock.Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.WOOL));
    public static final Block CHISELED_POLISHED_BLACKSTONE_EYES = register("chiseled_polished_blackstone_eyes", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE).luminance(value -> 8));
    public static final Block POLISHED_BLACKSTONE_BRICKLETS = register("polished_blackstone_bricklets", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
    public static final Block DEMONIC_POLISHED_CHISELED_BLACKSTONE = register("demonic_chiseled_polished_blackstone", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
    public static final Block OBSIDIAN_LIGHT_STRIP = register("obsidian_light", PillarBlock::new,
            AbstractBlock.Settings.copy(ModBlocks.CHECKERED_OBSIDIAN).luminance(value -> 15)
    );
    public static final Block AGONIZED_GLASS = register("agonized_glass", TransparentBlock::new,
            AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
    );
    public static final Block FORCEFIELD = register("forcefield", ForcefieldBlock::new,
            AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
    );
    //public static final Block FORCEFIELD_WATER = register("forcefield_water", TransparentBlock::new,
    //        AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
    //);

    public static final Block PORTAL_GLASS_OPAQUE = register("portal_glass", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS));
    public static final Block PORTAL_GLASS_TRANSPARENT = register("portal_glass_trans", TransparentBlock::new,
            AbstractBlock.Settings.copy(PORTAL_GLASS_OPAQUE).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
    );
	public static final Block SPIKE_BLOCK = register("spike_block", SpikeBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)); // finxx todo sounds

    public static final Block VOID_LAMP = register("void_lamp", Block::new,
            AbstractBlock.Settings.create().emissiveLighting(ModBlocks::always).luminance(value -> 15).sounds(BlockSoundGroup.STONE)
    );
    public static final Block WATER_SILK = registerBlock("water_silk", WaterSilk::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.DARK_GREEN).breakInstantly().sounds(BlockSoundGroup.LILY_PAD).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", settings -> new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE)
    );

    public static Block register(String path, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
        Block block = registerBlock(path, function, settings);

        Identifier id = SVBCR.of(path);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings itemSettings = new Item.Settings()
                .useBlockPrefixedTranslationKey()
                .registryKey(itemKey);
        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, itemSettings));
        return block;
    }

    // registers ONLY the block. because ice was having trouble with water silk -mikii/adenator
    public static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
        Identifier id = SVBCR.of(path);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        settings.registryKey(blockKey);
        Block block = Registry.register(Registries.BLOCK, blockKey, function.apply(settings));
        return block;
    }

    protected static boolean always(BlockState state, BlockView world, BlockPos pos){
        return true;
    }

}
