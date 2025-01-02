package com.nuclearcrackhead.serverboss.content.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.EditBoxWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class BouncePadScreen extends Screen {

    public BouncePadScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        EditBoxWidget forcebox = new EditBoxWidget(
                this.textRenderer, 40, 40, 120, 20,
                Text.translatable("screen.svbcr.bounce_pad.force.placeholder"),
                Text.translatable("screen.svbcr.bounce_pad.force.message")
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        context.drawText(this.textRenderer, Text.translatable("screen.svbcr.bounce_pad.force.title"),
                40, 40 - this.textRenderer.fontHeight, 0xffffffff, true
        );
    }

}
