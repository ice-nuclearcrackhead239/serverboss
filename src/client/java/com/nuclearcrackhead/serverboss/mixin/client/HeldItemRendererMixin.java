package com.nuclearcrackhead.serverboss.mixin.client;

import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.item.ItemStack;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;

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
	@Inject(at = @At("HEAD"), method = "renderFirstPersonItem", cancellable = true)
	private void renderGun(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (item.getItem() instanceof IGun gun) {
			// todo render
			ci.cancel();
		}
	}
}
