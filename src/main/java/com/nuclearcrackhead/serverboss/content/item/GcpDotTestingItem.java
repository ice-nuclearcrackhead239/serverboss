package com.nuclearcrackhead.serverboss.content.item;

import com.nuclearcrackhead.serverboss.api.gcp.dot.GcpDotAPI;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GcpDotTestingItem extends Item {

    public GcpDotTestingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;
        user.sendMessage(
                Text.of(GcpDotAPI.getIndex().toString()),
                false
        );
        return ActionResult.SUCCESS;
    }

}
