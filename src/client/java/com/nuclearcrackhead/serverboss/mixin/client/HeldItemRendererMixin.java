package com.nuclearcrackhead.serverboss.mixin.client;

import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderDispatcher;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;

import com.nuclearcrackhead.serverboss.registry.ModItemRenderers;
import com.nuclearcrackhead.serverboss.content.render.item.ISvbItemRenderer;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {
	@Shadow ItemRenderer itemRenderer;

	@Inject(at = @At("RETURN"), method = "<init>")
	private void onNew(MinecraftClient client, EntityRenderDispatcher entityRenderDispatcher, ItemRenderer itemRenderer, ItemModelManager itemModelManager, CallbackInfo ci) {
		ModItemRenderers.init();
	}

	@Inject(at = @At("HEAD"), method = "renderFirstPersonItem", cancellable = true)
	private void renderGun(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		ISvbItemRenderer renderer = ModItemRenderers.get(item.getItem());
		if (renderer != null) {
			renderer.render(matrices, vertexConsumers, player, item, swingProgress, equipProgress, hand, light);
			ci.cancel();
		}
	}
}
