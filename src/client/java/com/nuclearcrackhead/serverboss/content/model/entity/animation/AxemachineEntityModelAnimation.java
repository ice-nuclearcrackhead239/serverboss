package com.nuclearcrackhead.serverboss.content.model.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class AxemachineEntityModelAnimation {
	public static final Animation swing = Animation.Builder.create(1.25F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-192.5F, -2.5F, -92.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, -15.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -4.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(1.0F, 0.5F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(-0.25F, 0.0F, 2.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation bow_start = Animation.Builder.create(1.0F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-150.0F, 30.0F, 30.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-140.0F, 25.0F, 30.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-150.0F, 30.0F, 30.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-150.0F, 30.0F, 30.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-95.0F, 2.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(-0.25F, 0.0F, -2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation bow_loop = Animation.Builder.create(0.15F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation bow_finish = Animation.Builder.create(1.0F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-92.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(-5.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.375F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, -3.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation spinny_start = Animation.Builder.create(0.75F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-180.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-177.5F, -2.5F, -92.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-180.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-180.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-192.5F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation spinny_loop = Animation.Builder.create(0.4F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(0.0F, -75.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.2F, AnimationHelper.createRotationalVector(0.0F, -165.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(0.0F, -255.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, -345.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(-105.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.2F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(75.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createRotationalVector(165.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createTranslationalVector(3.25F, 1.0F, -6.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.2F, AnimationHelper.createTranslationalVector(11.0F, 1.0F, -1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createTranslationalVector(6.75F, 1.0F, 6.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(0.0F, -75.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.2F, AnimationHelper.createRotationalVector(0.0F, -165.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(0.0F, -255.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, -345.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createTranslationalVector(-3.75F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.2F, AnimationHelper.createTranslationalVector(-10.0F, 0.0F, 1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createTranslationalVector(-6.25F, 0.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation spinny_stop = Animation.Builder.create(1.5F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-192.5F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-195.0F, 0.0F, -90.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(1.75F, 1.0F, -4.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(2.0F, 1.0F, -5.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-0.25F, 0.0F, 1.75F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.25F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();
}