package com.nuclearcrackhead.serverboss.content.item.dev;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class WrenchItem extends Item {

    public WrenchItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("item.svbcr.wrench.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.svbcr.wrench.tooltip2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.svbcr.wrench.tooltip3").formatted(Formatting.GRAY));
    }

}
