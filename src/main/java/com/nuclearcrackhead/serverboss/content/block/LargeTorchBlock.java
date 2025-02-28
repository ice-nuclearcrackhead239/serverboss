//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.nuclearcrackhead.serverboss.content.block;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LargeTorchBlock extends AbstractTorchBlock {
    protected static final MapCodec<SimpleParticleType> PARTICLE_TYPE_CODEC;
    public static final MapCodec<LargeTorchBlock> CODEC;
    protected final SimpleParticleType particle;

    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)6.0F, (double)0.0F, (double)6.0F, (double)10.0F, (double)26.0F, (double)10.0F);
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    public MapCodec<? extends LargeTorchBlock> getCodec() {
        return CODEC;
    }

    public LargeTorchBlock(SimpleParticleType particle, AbstractBlock.Settings settings) {
        super(settings);
        this.particle = particle;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + (double)0.5F;
        double e = (double)pos.getY() + (double)1.6875F;
        double f = (double)pos.getZ() + (double)0.5F;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
        world.addParticle(this.particle, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
    }

    static {
        PARTICLE_TYPE_CODEC = Registries.PARTICLE_TYPE.getCodec().comapFlatMap((particleType) -> {
            DataResult var10000;
            if (particleType instanceof SimpleParticleType simpleParticleType) {
                var10000 = DataResult.success(simpleParticleType);
            } else {
                var10000 = DataResult.error(() -> "Not a SimpleParticleType: " + String.valueOf(particleType));
            }

            return var10000;
        }, (particleType) -> (net.minecraft.particle.ParticleType<?>) particleType).fieldOf("particle_options");
        CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(PARTICLE_TYPE_CODEC.forGetter((block) -> block.particle), createSettingsCodec()).apply(instance, LargeTorchBlock::new));
    }
}
