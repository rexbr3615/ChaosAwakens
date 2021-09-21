package io.github.chaosawakens.common.entity;

import io.github.chaosawakens.common.registry.CAEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AppleCowEntity extends AnimalEntity {
    public AppleCowEntity(EntityType<? extends AppleCowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.FOLLOW_RANGE, 10);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if (itemstack.getItem() == Items.BUCKET && !this.isBaby()) {
            playerIn.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = DrinkHelper.createFilledResult(itemstack, playerIn, Items.MILK_BUCKET.getDefaultInstance());
            playerIn.setItemInHand(hand, itemstack1);
            return ActionResultType.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(playerIn, hand);
        }
    }

    @Override
    public AppleCowEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
        return CAEntityTypes.APPLE_COW.get().create(world);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isBaby() ? sizeIn.height * 0.95F : 1.3F;
    }

    public void thunderHit(ServerWorld serverWorld, LightningBoltEntity lightningBoltEntity) {
        if (net.minecraftforge.event.ForgeEventFactory.canLivingConvert(this, CAEntityTypes.CARROT_PIG.get(), (timer) -> {})) {
            CarrotPigEntity carrotPigEntity = CAEntityTypes.CARROT_PIG.get().create(serverWorld);
            assert carrotPigEntity != null;
            carrotPigEntity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
            carrotPigEntity.setNoAi(this.isNoAi());
            carrotPigEntity.setBaby(false);
            if (this.hasCustomName()) {
                carrotPigEntity.setCustomName(this.getCustomName());
                carrotPigEntity.setCustomNameVisible(this.isCustomNameVisible());
            }

            carrotPigEntity.setPersistenceRequired();
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, carrotPigEntity);
            serverWorld.addFreshEntity(carrotPigEntity);
            this.remove();
        } else {
            super.thunderHit(serverWorld, lightningBoltEntity);
        }
    }
}
