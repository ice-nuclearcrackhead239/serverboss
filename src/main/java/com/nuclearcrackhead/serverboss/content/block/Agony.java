package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModDamageTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.damage.DamageSource;

public class Agony extends Block {
    public static final MapCodec<Agony> CODEC = createCodec(Agony::new);

    public MapCodec<Agony> getCodec() {
        return CODEC;
    }

    public Agony(AbstractBlock.Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity livingEntity) {
            //DamageSource damageSource = new DamageSource(
            //        world.getRegistryManager()
            //                .get(RegistryKeys.DAMAGE_TYPE) //incoherent as hell
            //                .entryOf(ModDamageTypes.AGONY_DAMAGE));
            livingEntity.serverDamage(entity.getDamageSources().create(ModDamageTypes.AGONY_DAMAGE, null), livingEntity.getMaxHealth() / 7);
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
