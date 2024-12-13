package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.Orientation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.state.property.Properties.ORIENTATION;

public class Agony extends Block {
    private static final EnumProperty<Orientation> ORIENTATION;
    public static final MapCodec<Agony> CODEC = createCodec(Agony::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)16.0F, (double)15.0F, (double)16.0F);

    public MapCodec<Agony> getCodec() {
        return CODEC;
    }

    public Agony(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.svbcr.agony.tooltip").formatted(Formatting.GRAY));
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) { //bypass check removed since i don't think it's supposed to not agony you if you sneak
            livingEntity.serverDamage(entity.getDamageSources().create(ModDamageTypes.AGONY_DAMAGE, null), livingEntity.getMaxHealth() / 7);
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(new DustParticleEffect(ColorHelper.fromFloats(1, 1, 0, 0), 2), livingEntity.getPos().getX(), livingEntity.getPos().getY(), livingEntity.getPos().getZ(), 4, 0.2, 0, 0.2, 0);
            }
            if (!world.isClient && (livingEntity.hurtTime == 10)) {
                world.playSound(null, pos, ModSounds.BLOCK_AGONY_ACTIVATE_FANGSNAP, SoundCategory.BLOCKS);
                world.playSound(null, pos, ModSounds.BLOCK_AGONY_ACTIVATE_ZOMBIESTEP, SoundCategory.BLOCKS);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerLookDirection().getOpposite();
        Direction var10000;
        switch (direction) {
            case DOWN:
                var10000 = ctx.getHorizontalPlayerFacing().getOpposite();
                break;
            case UP:
                var10000 = ctx.getHorizontalPlayerFacing();
                break;
            case NORTH:
            case SOUTH:
            case WEST:
            case EAST:
                var10000 = Direction.UP;
                break;
            default:
                throw new MatchException((String)null, (Throwable)null);
        }

        Direction direction2 = var10000;
        return (BlockState)((BlockState)this.getDefaultState().with(ORIENTATION, Orientation.byDirections(direction, direction2)));
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(ORIENTATION, rotation.getDirectionTransformation().mapJigsawOrientation((Orientation)state.get(ORIENTATION)));
    }

    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return (BlockState)state.with(ORIENTATION, mirror.getDirectionTransformation().mapJigsawOrientation((Orientation)state.get(ORIENTATION)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ORIENTATION});
    }

    static {
        ORIENTATION = Properties.ORIENTATION;
    }
}
