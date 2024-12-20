package com.nuclearcrackhead.serverboss.content.item.dev;

import com.nuclearcrackhead.serverboss.api.gcp.dot.GcpDotAPI;
import com.nuclearcrackhead.serverboss.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import static com.nuclearcrackhead.serverboss.content.block.ForcefieldBlock.OPEN;

public class ForcefieldBellItem extends Item {

    public ForcefieldBellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("item.svbcr.forcefield_bell.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.svbcr.forcefield_bell.tooltip2").formatted(Formatting.GRAY));
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.playSound(user, user.getBlockPos(), SoundEvents.BLOCK_BELL_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
        world.playSound(user, user.getBlockPos(), SoundEvents.BLOCK_BELL_RESONATE, SoundCategory.PLAYERS, 1.0F, 1.0F);

        if (world instanceof ServerWorld serverWorld) {
            BlockPos.iterateOutwards(user.getBlockPos(), 15, 15, 15).forEach(blockPos -> {
                BlockState blockState = serverWorld.getBlockState(blockPos);
                if (blockState.getBlock() == ModBlocks.FORCEFIELD) {
                    serverWorld.setBlockState(blockPos, blockState.with(OPEN, false));
                }
            });
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return ActionResult.SUCCESS;
    }

}
