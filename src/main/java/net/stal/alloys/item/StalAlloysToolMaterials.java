package net.stal.alloys.item;

import java.util.function.Supplier;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public enum StalAlloysToolMaterials implements ToolMaterial {
  STEEL_ALLOY(MiningLevels.DIAMOND, 1600, 9.0f, 3.0f, 12, () -> Ingredient.ofItems(StalAlloysItems.STEEL_INGOT)),
  BRONZE_ALLOY(MiningLevels.IRON, 1024, 6.0f, 2.0f, 16, () -> Ingredient.ofItems(StalAlloysItems.BRONZE_INGOT)),
  BRASS_ALLOY(MiningLevels.STONE, 768, 12.0f, 0.0f, 22, () -> Ingredient.ofItems(StalAlloysItems.BRASS_INGOT)),
  FERROCHROME_ALLOY(MiningLevels.DIAMOND, 1600, 8.0f, 3.0f, 10, () -> Ingredient.ofItems(StalAlloysItems.CHROMIUM_INGOT)),
  STAINLESS_STEEL_ALLOY(MiningLevels.NETHERITE, 2048, 9.0f, 4.0f, 15, () -> Ingredient.ofItems(StalAlloysItems.STEEL_INGOT));

  private final int mMiningLevel;
  private final int mItemDurability;
  private final float mMiningSpeed;
  private final float mAttackDamage;
  private final int mEnchantability;
  private final Supplier<Ingredient> mRepairIngredient;

  private StalAlloysToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
    mMiningLevel = miningLevel;
    mItemDurability = itemDurability;
    mMiningSpeed = miningSpeed;
    mAttackDamage = attackDamage;
    mEnchantability = enchantability;
    mRepairIngredient = repairIngredient;
  }

  @Override
  public int getDurability() {
    return mItemDurability;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return mMiningSpeed;
  }

  @Override
  public float getAttackDamage() {
    return mAttackDamage;
  }

  @Override
  public int getMiningLevel() {
    return mMiningLevel;
  }

  @Override
  public int getEnchantability() {
    return mEnchantability;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return mRepairIngredient.get();
  }
  
}
