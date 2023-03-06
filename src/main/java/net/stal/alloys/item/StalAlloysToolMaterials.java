package net.stal.alloys.item;

import java.util.function.Supplier;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.fabricmc.yarn.constants.MiningLevels;

public enum StalAlloysToolMaterials implements ToolMaterial {
  STEEL_ALLOY(5, 350, 6.0f, 2.0f, 14, () -> Ingredient.ofItems(StalAlloysItems.STEEL_INGOT));

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
