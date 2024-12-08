package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.enums.Orientation;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.RecipeCache;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

import net.minecraft.block.enums.Orientation;

import static net.minecraft.state.property.Properties.ORIENTATION;

public class WasteBarrel extends Block {
    private static final EnumProperty<Orientation> ORIENTATION;

    public WasteBarrel(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(ORIENTATION, Orientation.NORTH_UP))));
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
