package io.github.chaosawakens.client.entity.model;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.entity.GoldenCarrotPigEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GoldenCarrotPigModel extends AnimatedGeoModel<GoldenCarrotPigEntity> {
    @Override
    public ResourceLocation getModelLocation(GoldenCarrotPigEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "geo/carrot_pig.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenCarrotPigEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "textures/entity/golden_carrot_pig.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoldenCarrotPigEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "animations/carrot_pig.animation.json");
    }

    @Override
    public void setLivingAnimations(GoldenCarrotPigEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);

        IBone head = this.getAnimationProcessor().getBone("head");
        //ChaosAwakens.LOGGER.debug(entity);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX((extraData.headPitch) * ((float) Math.PI / 180F));
        head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 270F));
    }
}