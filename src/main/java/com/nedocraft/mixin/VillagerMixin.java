package com.nedocraft.mixin;

import com.nedocraft.events.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.VillagerDataContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public class NedoCraftMixin {
//	protected SoundEvent getHurtSound(DamageSource source) {
//		return SoundEvents.ENTITY_VILLAGER_HURT;
//	}
	@Inject(at = @At("HEAD"), method = "getHurtSound", cancellable = true)
	private void init(CallbackInfoReturnable<SoundEvent> cir) {
		cir.setReturnValue(ModSounds.VILLAGER_SOUND_EVENT);
		// This code is injected into the start of MinecraftServer.loadWorld()V
	}
}