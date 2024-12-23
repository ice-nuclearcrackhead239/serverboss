package com.nuclearcrackhead.serverboss.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.Shadow;
import org.jetbrains.annotations.Nullable;

import com.nuclearcrackhead.serverboss.content.item.IAttackItem;
import com.nuclearcrackhead.serverboss.content.packet.AttackItemPacket;

@Mixin(MinecraftClient.class)
public class ExampleClientMixin {
	@Shadow @Nullable public ClientPlayerEntity player;

	@Inject(method = "doAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/hit/HitResult;getType()Lnet/minecraft/util/hit/HitResult$Type;"), locals = LocalCapture.CAPTURE_FAILHARD)
	private void attackItemHandler(CallbackInfoReturnable<Boolean> cir) {
		if (player == null) return;
		ItemStack stack = player.getMainHandStack();
		if (stack.getItem() instanceof IAttackItem attackItem) {
			ClientPlayNetworking.send(new AttackItemPacket(stack)); // send to server
			attackItem.onPrimaryFire(player.getWorld(), player, stack); // send to client
			return;
		}
	}

	@Inject(at = @At("HEAD"), method = "run")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftClient.run()V
	}
}
