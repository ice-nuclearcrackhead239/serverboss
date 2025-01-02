package com.nuclearcrackhead.serverboss.content.block;

import com.nuclearcrackhead.serverboss.registry.ModBlockEntityTypes;
import com.nuclearcrackhead.serverboss.registry.ModParticles;
import com.nuclearcrackhead.serverboss.registry.ModSounds;
import com.nuclearcrackhead.serverboss.registry.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.DustColorTransitionParticleEffect;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BouncePadBlockEntity extends BlockEntity {
    public BouncePadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BOUNCE_PAD, pos, state);
    }

    public static final int BOUNCE_COOLDOWN = 15; //tick amount to make the bounce pad not bounce again for
    protected int cooldown = 0;
    private float force = 1.5f;

    public void tryBounce(World world, BlockPos pos, BlockState state, Entity entity) {
        if (cooldown == 0) {
            entity.setVelocity(entity.getVelocity().add(0, force, 0));
            world.playSound(null, pos, ModSounds.BLOCK_BOUNCE_PAD, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (world instanceof ServerWorld serverWorld) {
                Vec3d center = pos.toCenterPos();
                serverWorld.spawnParticles(ModParticles.BOUNCE, center.getX(), center.getY() + 0.5, center.getZ(), 1, 0, 0, 0, 0);
            }
            if (entity instanceof LivingEntity livingEntity && !world.isClient()) {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SOARING, 200, 0));
            }
            world.setBlockState(pos, state.with(BouncePadBlock.ACTIVE, false));
            cooldown = BOUNCE_COOLDOWN;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, BouncePadBlockEntity blockEntity) {
        if (blockEntity.cooldown > 0) {
            blockEntity.cooldown--;
            if (blockEntity.cooldown == 0) {
                world.setBlockState(pos, state.with(BouncePadBlock.ACTIVE, true));
            }
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        nbt.putFloat("bounceForce", force);
        super.writeNbt(nbt, wrapper);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.readNbt(nbt, wrapper);
        force = nbt.getFloat("bounceForce");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup wrapper) {
        return createNbt(wrapper);
    }

    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    public void setForce(float newForce) {
        this.force = newForce;
        this.markDirty();
        BlockState state = world.getBlockState(this.pos);
        world.updateListeners(this.pos, state, state, 0);
    }

}
