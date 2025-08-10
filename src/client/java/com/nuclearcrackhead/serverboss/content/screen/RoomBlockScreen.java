package com.nuclearcrackhead.serverboss.content.screen;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerInventory;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.BlockPos;

import com.nuclearcrackhead.serverboss.SVBCR;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockC2SPacket;
import com.nuclearcrackhead.serverboss.content.packet.UpdateRoomBlockS2CPacket;

@Environment(EnvType.CLIENT)
public class RoomBlockScreen extends HandledScreen<RoomBlockScreenHandler> {
	private static final int textColor = 0xa0a0a0;

	private TextFieldWidget nameWidget;
	private TextFieldWidget mobListWidget;
	private TextFieldWidget xPosWidget;
	private TextFieldWidget yPosWidget;
	private TextFieldWidget zPosWidget;
	private TextFieldWidget xSizeWidget;
	private TextFieldWidget ySizeWidget;
	private TextFieldWidget zSizeWidget;
	private ButtonWidget showBoundingBoxWidget;
	private ButtonWidget saveWidget;
	private ButtonWidget cancelWidget;

	private boolean showingBounds = false;

	public RoomBlockScreen(RoomBlockScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}
 
	@Override
	protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
	}

	@Override
	protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
	}

	@Override
	public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
		this.renderInGameBackground(context);
	}
 
	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		super.render(context, mouseX, mouseY, delta);

		int longWidth = this.width / 2;
		int longPos = this.width / 2 - longWidth / 2;
		int posWidth = longWidth / 3 - 8;

		context.drawTextWithShadow(this.textRenderer, "Room Name", longPos, 32, textColor);
		context.drawTextWithShadow(this.textRenderer, "Mob List", longPos, 68, textColor);
		context.drawTextWithShadow(this.textRenderer, "X Pos", longPos, 104, textColor);
		context.drawTextWithShadow(this.textRenderer, "Y Pos", longPos + posWidth + 8, 104, textColor);
		context.drawTextWithShadow(this.textRenderer, "Z Pos", longPos + posWidth * 2 + 16, 104, textColor);
		context.drawTextWithShadow(this.textRenderer, "X Size", longPos, 140, textColor);
		context.drawTextWithShadow(this.textRenderer, "Y Size", longPos + posWidth + 8, 140, textColor);
		context.drawTextWithShadow(this.textRenderer, "Z Size", longPos + posWidth * 2 + 16, 140, textColor);
	}
 
	@Override
	protected void init() {
		super.init();

		int longWidth = this.width / 2;
		int longPos = this.width / 2 - longWidth / 2;
		int posWidth = longWidth / 3 - 8;
		int zPos = posWidth * 2 + 16;

		nameWidget = new TextFieldWidget(this.textRenderer, longPos, 40, longWidth, 20, Text.empty());
		mobListWidget = new TextFieldWidget(this.textRenderer, longPos, 76, longWidth, 20, Text.empty());
		xPosWidget = new TextFieldWidget(this.textRenderer, longPos, 112, posWidth, 20, Text.empty());
		yPosWidget = new TextFieldWidget(this.textRenderer, longPos + posWidth + 8, 112, posWidth, 20, Text.empty());
		zPosWidget = new TextFieldWidget(this.textRenderer, longPos + zPos, 112, longWidth - zPos, 20, Text.empty());
		xSizeWidget = new TextFieldWidget(this.textRenderer, longPos, 148, posWidth, 20, Text.empty());
		ySizeWidget = new TextFieldWidget(this.textRenderer, longPos + posWidth + 8, 148, posWidth, 20, Text.empty());
		zSizeWidget = new TextFieldWidget(this.textRenderer, longPos + zPos, 148, longWidth - zPos, 20, Text.empty());
		saveWidget = ButtonWidget.builder(Text.literal("Save"), this::onSave).dimensions(longPos, 176, posWidth, 20).build();
		cancelWidget = ButtonWidget.builder(Text.literal("Cancel"), this::onCancel).dimensions(longPos + posWidth + 8, 176, posWidth, 20).build();
		showBoundingBoxWidget = ButtonWidget.builder(Text.literal("Show Bounding Box"), this::showBounds).dimensions(longPos + zPos, 176, longWidth - zPos, 20).build();

		this.addDrawableChild(nameWidget);
		this.addDrawableChild(mobListWidget);
		this.addDrawableChild(xPosWidget);
		this.addDrawableChild(yPosWidget);
		this.addDrawableChild(zPosWidget);
		this.addDrawableChild(xSizeWidget);
		this.addDrawableChild(ySizeWidget);
		this.addDrawableChild(zSizeWidget);
		this.addDrawableChild(saveWidget);
		this.addDrawableChild(cancelWidget);
		this.addDrawableChild(showBoundingBoxWidget);

		UpdateRoomBlockS2CPacket payload = this.getScreenHandler().getPayload();
		nameWidget.setText(payload.name());
		mobListWidget.setText(payload.mobList());
		BlockPos pos = payload.roomPos();
		xPosWidget.setText(Integer.toString(pos.getX()));
		yPosWidget.setText(Integer.toString(pos.getY()));
		zPosWidget.setText(Integer.toString(pos.getZ()));
		BlockPos size = payload.roomSize();
		xSizeWidget.setText(Integer.toString(size.getX()));
		ySizeWidget.setText(Integer.toString(size.getY()));
		zSizeWidget.setText(Integer.toString(size.getZ()));
		showingBounds = payload.showBounds();
	}

	@Override
	protected void refreshWidgetPositions() {
		int longWidth = this.width / 2;
		int longPos = this.width / 2 - longWidth / 2;
		int posWidth = longWidth / 3 - 8;
		int zPos = posWidth * 2 + 16;

		nameWidget.setDimensionsAndPosition(longWidth, 20, longPos, 40);
		mobListWidget.setDimensionsAndPosition(longWidth, 20, longPos, 76);
		xPosWidget.setDimensionsAndPosition(posWidth, 20, longPos, 112);
		yPosWidget.setDimensionsAndPosition(posWidth, 20, longPos + posWidth + 8, 112);
		zPosWidget.setDimensionsAndPosition(longWidth - zPos, 20, longPos + zPos, 112);
		xSizeWidget.setDimensionsAndPosition(posWidth, 20, longPos, 148);
		ySizeWidget.setDimensionsAndPosition(posWidth, 20, longPos + posWidth + 8, 148);
		zSizeWidget.setDimensionsAndPosition(longWidth - zPos, 20, longPos + zPos, 148);
		saveWidget.setDimensionsAndPosition(posWidth, 20, longPos, 176);
		cancelWidget.setDimensionsAndPosition(posWidth, 20, longPos + posWidth + 8, 176);
		showBoundingBoxWidget.setDimensionsAndPosition(longWidth - zPos, 20, longPos + zPos, 176);
	}

	private void onSave(ButtonWidget button) {
		BlockPos target = this.getScreenHandler().getPayload().targetPos();
		BlockPos roomPos = new BlockPos(parseInt(xPosWidget.getText()), parseInt(yPosWidget.getText()), parseInt(zPosWidget.getText()));
		BlockPos roomSize = new BlockPos(parseInt(xSizeWidget.getText()), parseInt(ySizeWidget.getText()), parseInt(zSizeWidget.getText()));
		UpdateRoomBlockC2SPacket packet = new UpdateRoomBlockC2SPacket(target, nameWidget.getText(), mobListWidget.getText(), roomPos, roomSize, this.showingBounds);
		ClientPlayNetworking.send(packet);
		this.close();
	}

	private void onCancel(ButtonWidget button) {
		this.close();
	}

	private void showBounds(ButtonWidget button) {
		showingBounds = !showingBounds;
	}

	private int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
