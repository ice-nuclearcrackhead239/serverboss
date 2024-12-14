package com.nuclearcrackhead.serverboss.content.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class White extends Block {

    public White(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.svbcr.white.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("block.svbcr.white.tooltip2").formatted(Formatting.GRAY));
    }

}
