package com.nuclearcrackhead.serverboss.mixin.client;

import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.item.ItemStack;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.client.render.OverlayTexture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.Shadow;
import org.jetbrains.annotations.Nullable;

import com.nuclearcrackhead.serverboss.content.item.IGun;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {
	@Shadow ItemRenderer itemRenderer;

	@Inject(at = @At("HEAD"), method = "renderFirstPersonItem", cancellable = true)
	private void renderGun(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (item.getItem() instanceof IGun gun) {
			matrices.push();
			matrices.translate(0.5, -0.5, -0.5);
			matrices.translate(0, swingProgress, 0);
			itemRenderer.renderItem(player, item, ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, false, matrices, vertexConsumers, player.getWorld(), light, OverlayTexture.DEFAULT_UV, 2);
			matrices.pop();
			ci.cancel();
		}
	}
}
