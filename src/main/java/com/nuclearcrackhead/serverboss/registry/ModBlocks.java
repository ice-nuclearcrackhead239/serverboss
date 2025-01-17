package com.nuclearcrackhead.serverboss.registry;
import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.block.*;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
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
			AbstractBlock.Settings.copy(Blocks.WATER).emissiveLighting(ModBlocks::always).luminance(value -> 13)
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

	//9 hour work week
	public static final Block BLACK_WALLPAPER = register("black_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block NAVY_WALLPAPER = register("navy_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block GREEN_WALLPAPER = register("green_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block CYAN_WALLPAPER = register("cyan_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block BROWN_WALLPAPER = register("brown_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block PURPLE_WALLPAPER = register("purple_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block PINK_WALLPAPER = register("pink_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.PINK_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block SILVER_WALLPAPER = register("silver_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block ASH_WALLPAPER = register("ash_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block ORANGE_WALLPAPER = register("orange_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block YELLOW_WALLPAPER = register("yellow_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block WHITE_WALLPAPER = register("white_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block RED_WALLPAPER = register("red_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.RED_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block BLUE_WALLPAPER = register("blue_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block MAGENTA_WALLPAPER = register("magenta_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block LIME_WALLPAPER = register("lime_wallpaper", Block::new,
			AbstractBlock.Settings.copy(Blocks.LIME_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);
	public static final Block FIREBLU = register("fireblu", Block::new,
			AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).sounds(BlockSoundGroup.NETHER_WOOD)	);

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
	public static final Block DEMONIC_GATE = registerBlock("demonic_gate", settings -> new ThinDoorBlock(BlockSetType.IRON, settings),
			AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)
	);

	public static final Block LOAM = register("loam", Block::new,
			AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRAVEL)
	);
	public static final Block SILT = register("silt", Block::new,
			AbstractBlock.Settings.create().sounds(BlockSoundGroup.SAND)
	);
	public static final Block RUST = register("rust", Block::new,
			AbstractBlock.Settings.create().sounds(BlockSoundGroup.SAND)
	);
	public static final Block BLOCK_TRASH = register("block_trash", Block::new,
			AbstractBlock.Settings.create().sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)
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
	public static final Block POLISHED_BLACKSTONE_PILLAR = register("polished_blackstone_pillar", SpineBlock::new,
			AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)
	);
	public static final Block SMOOTH_BLACKSTONE = register("smooth_blackstone", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
	public static final Block POLISHED_BLACKSTONE_BRICKLETS_SLAB = register("polished_blackstone_bricklets_slab", SlabBlock::new,
			AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
	public static final Block POLISHED_BLACKSTONE_BRICKLETS_STAIRS = mojangStairsSuckMyBalls("polished_blackstone_bricklets_stairs", POLISHED_BLACKSTONE_BRICKLETS);
	public static final Block BOUNCE_PAD = register("bounce_pad", BouncePadBlock::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE).luminance(value -> 12));
	public static final Block INDENTED_POLISHED_BLACKSTONE = register("indented_polished_blackstone", Block::new, AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
	public static final Block SPEED_PAD = register("speed_pad", SpeedPadBlock::new,
			AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE).luminance(value -> 12)
	);
	public static final Block CRIMSON_STALKS = registerBlock("crimson_stalks", TallRootsBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_ROOTS));
	public static final Block WARPED_STALKS = registerBlock("warped_stalks", TallRootsBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_ROOTS));

	public static final Block CHISELED_NETHERITE = register("chiseled_netherite", Block::new, AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK));
	public static final Block POLISHED_NETHERITE = register("polished_netherite", Block::new, AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK));
	public static final Block CRYSTALLINE_DIAMOND = register("crystalline_diamond", Block::new, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.GLASS));
	public static final Block SMOOTH_IRON = register("smooth_iron", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
	public static final Block TILED_IRON = register("tiled_iron", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
	public static final Block CHECKERBOARD = register("checkerboard", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS));
	public static final Block ASPHALT = register("asphalt", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE));

	public static final Block IRON_GRATING = register("iron_grating", MeshBlock::new,
			AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque()
	);

	public static final Block SMOOTH_STONE_BRICKS = register("smooth_stone_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block SMOOTH_STONE_BRICKLETS = register("smooth_stone_bricklets", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block SMOOTH_STONE_TILES = register("smooth_stone_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block SMOOTH_STONE_QUADS = register("smooth_stone_quads", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block CRACKED_SMOOTH_STONE_BRICKS = register("cracked_smooth_stone_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block IRRADIATED_SMOOTH_STONE_BRICKS = register("irradiated_smooth_stone_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block SMOOTH_STONE_PILLAR = register("smooth_stone_pillar", SpineBlock::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block POLISHED_SMOOTH_STONE = register("polished_smooth_stone", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block CHISELED_SMOOTH_STONE = register("chiseled_smooth_stone", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
	public static final Block STONE_PATHWAY = register("stone_pathway", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));

	public static final Block LOPER_BRICKS = register("loper_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));

	public static final Block B_DEV_ORANGE = register("b_dev_orange", Block::new, AbstractBlock.Settings.copy(Blocks.STONE));
	public static final Block B_DEV_ASH = register("b_dev_ash", Block::new, AbstractBlock.Settings.copy(Blocks.STONE));
	public static final Block B_DEV_WHITE = register("b_dev_white", Block::new, AbstractBlock.Settings.copy(Blocks.STONE));


	public static final Block OBSIDIAN_LIGHT_STRIP = register("obsidian_light", PillarBlock::new,
			AbstractBlock.Settings.copy(ModBlocks.CHECKERED_OBSIDIAN).luminance(value -> 15)
	);
	public static final Block AGONIZED_GLASS = register("agonized_glass", TransparentBlock::new,
			AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
	);
	public static final Block FORCEFIELD = register("forcefield", ForcefieldBlock::new,
			AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
	);

	public static final Block PORTAL_GLASS_OPAQUE = register("portal_glass", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS));
	public static final Block PORTAL_GLASS_TRANSPARENT = register("portal_glass_trans", TransparentBlock::new,
			AbstractBlock.Settings.copy(PORTAL_GLASS_OPAQUE).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
	);
	public static final Block SPIKE_BLOCK = register("spike_block", SpikeBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL));

	public static final Block BARBED_WIRE = register("barbed_wire", BarbedWire::new, AbstractBlock.Settings.create().noCollision());

	public static final Block JELLY = register("jelly", Block::new,
			AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
	);

	public static final Block JELLY_TRANSLUCENT = register("jelly_translucent", TransparentBlock::new,
			AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).nonOpaque().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
	);

	public static final Block VOID_LAMP = register("void_lamp", Block::new,
			AbstractBlock.Settings.create().emissiveLighting(ModBlocks::always).luminance(value -> 15).sounds(BlockSoundGroup.STONE)
	);
	public static final Block WATER_SILK = registerBlock("water_silk", WaterSilk::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.DARK_GREEN).breakInstantly().sounds(BlockSoundGroup.LILY_PAD).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block DRIFTWOOD = registerBlock("prop_driftwood", PropFloating::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.WOOD).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block TRASH = registerBlock("prop_trash", PropFloating::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block TRASH_SPREAD = registerBlock("prop_trash_spread", PropFloating::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block PUDDLE = registerBlock("prop_puddle", PropPuddle::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.PUDDLE).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).slipperiness(0.998F).velocityMultiplier(1.1F));
	public static final Block GRAVEL_PATCH = registerBlock("prop_gravel_patch", Prop::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.GRAVEL).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block DUST = registerBlock("prop_dust", Prop::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.SAND).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block PEBBLES = registerBlock("prop_pebbles", Prop::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.STONE).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));

	public static final Block MYCELIA = registerBlock("mycelia", RootsBlock::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.STEM).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block MYCELIAL_EYE = registerBlock("mycelial_eye", RootsBlock::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.STEM).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block MYCELIA_STALKS = registerBlock("mycelia_stalks", TallRootsBlock::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.STEM).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block MYCELIA_BLOOM = registerBlock("mycelia_bloom", RootsBlock::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(BlockSoundGroup.STEM).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));

	public static final Block IRON_PLATING = register("iron_plating", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
	public static final Block IRON_PLATING_SLAB = register("iron_plating_slab", SlabBlock::new,
			AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
	public static final Block IRON_PLATING_STAIRS = mojangStairsSuckMyBalls("iron_plating_stairs", IRON_PLATING);

	public static final Block DARK_GLASS = register("dark_glass", TransparentBlock::new, AbstractBlock.Settings.copy(Blocks.GLASS));

	//todo shader stupid shit i stupdishi GRRRRR AAAAAAA i hate this
	public static final Block SKYBOX_SPACE = register("skybox_space", EndGatewayBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BLACK).noCollision().luminance((state) -> 15).strength(-1.0F, 3600000.0F).dropsNothing().pistonBehavior(PistonBehavior.BLOCK));

	public static final Block HUB_TORCH = registerBlock("hub_torch", (settings) -> new TorchBlock(ModParticles.HUB_FLAME, settings), AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 15).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY));
	public static final Block HUB_WALL_TORCH = registerBlock("hub_wall_torch", (settings) -> new WallTorchBlock(ModParticles.HUB_FLAME, settings), AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 15).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY));
	public static final Block HUB_BRICKS_1 = register("hub_bricks_1", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));
	public static final Block HUB_BRICKS_2 = register("hub_bricks_2", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));
	public static final Block HUB_BRICKS_3 = register("hub_bricks_3", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));
	public static final Block HUB_BRICKS_4 = register("hub_bricks_4", Block::new, AbstractBlock.Settings.copy(Blocks.STONE_BRICKS));
	public static final Block HUB_TILES = register("hub_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK));
	public static final Block HUB_TILE_YELLOW = register("hub_tile_yellow", Block::new, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK));
	public static final Block HUB_TILE_BLUE = register("hub_tile_blue", Block::new, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK));
	public static final Block HUB_GLASS = register("hub_glass", Block::new, AbstractBlock.Settings.copy(Blocks.GLASS));

	public static final Block HAZARD_MARKER = register("hazard_marker", Block::new, AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK));
	public static final Block HAZARD_MARKER_SLAB = register("hazard_marker_slab", SlabBlock::new,
			AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK));
	public static final Block HAZARD_MARKER_STAIRS = mojangStairsSuckMyBalls("hazard_marker_stairs", HAZARD_MARKER);

	public static final Block GLOWING_MUSHROOMS = registerBlock("glowing_mushrooms", Prop::new, AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.LIME).breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY).luminance(value -> 13));
	public static final Block GLOWING_MUSHROOM_BLOCK = register("glowing_mushroom_block", Block::new,
			AbstractBlock.Settings.create().emissiveLighting(ModBlocks::always).luminance(value -> 15).sounds(BlockSoundGroup.STEM)
	);
	public static final Block GLOWING_MUSHROOM_STEM = register("glowing_mushroom_stem", Block::new,
			AbstractBlock.Settings.create().emissiveLighting(ModBlocks::always).luminance(value -> 12).sounds(BlockSoundGroup.STEM)
	);

	public static final Block METAL_LADDER = register("metal_ladder", LadderBlock::new, AbstractBlock.Settings.create().notSolid().strength(0.4F).sounds(ModSoundGroups.METAL_LADDER).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));

	public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", settings -> new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), settings),
			AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE)
	);

	public static final Block BLACKSTONE_PEDESTAL = register("blackstone_pedestal", BlackstonePedestal::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE));

	//fumos from this point on
	public static final Block FUMO_HEAPONS = register("fumo_heapons", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_SOUMEH = register("fumo_soumeh", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_ICE = register("fumo_ice", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_JOSE = register("fumo_jose", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_OBI = register("fumo_obi", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_AVARITA = register("fumo_avarita", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_DERZOX = register("fumo_derzox", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_MIKII = register("fumo_mikii", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_RIKA = register("fumo_rika", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_TOBI = register("fumo_tobi", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_KAORI = register("fumo_kaori", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_SPEEDER = register("fumo_speeder", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_BERYL = register("fumo_beryl", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_ISM = register("fumo_ism", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_ILYA = register("fumo_ilya", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block FUMO_FRESHLY = register("fumo_freshly", PropFacing::new,  AbstractBlock.Settings.create().replaceable().noCollision().mapColor(MapColor.CLEAR).breakInstantly().sounds(ModSoundGroups.FUMO).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));

	public static final Block CRIMSON_VEINS = register("crimson_veins", VineBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).replaceable().noCollision().ticksRandomly().strength(0.2F).sounds(BlockSoundGroup.VINE).burnable().pistonBehavior(PistonBehavior.DESTROY));
	public static final Block WARPED_WIREFRAME = register("warped_wireframe", VineBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).replaceable().noCollision().ticksRandomly().strength(0.2F).sounds(BlockSoundGroup.VINE).burnable().pistonBehavior(PistonBehavior.DESTROY));

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

	//FUCK YOU CHICKENSHIT ADMINISTRATORS
	public static Block mojangStairsSuckMyBalls(String id, Block base){
		return register(id, (settings) -> new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copy(base));
	}

	// registers ONLY the block. because ice was having trouble with water silk -mikii/adenator
	public static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
		Identifier id = SVBCR.of(path);
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
		settings.registryKey(blockKey);
		return Registry.register(Registries.BLOCK, blockKey, function.apply(settings));
	}

	protected static boolean always(BlockState state, BlockView world, BlockPos pos){
		return true;
	}

}
