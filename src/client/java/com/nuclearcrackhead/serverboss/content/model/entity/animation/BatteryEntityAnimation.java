package com.nuclearcrackhead.serverboss.content.model.entity.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 4.11.2
 * Exported for Minecraft version 1.19 or later with Yarn mappings
 * @author Author
 */
public class BatteryEntityAnimation {
	public static final Animation speen = Animation.Builder.create(0.75F).looping()
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.1824F, 0.0F, 3.9927F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0603F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("top", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -180.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("top", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.2234F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("bottom", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("bottom", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.4793F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();
}