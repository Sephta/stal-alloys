package net.stal.alloys.item;

import java.util.function.Supplier;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.stal.alloys.StalAlloys;

public enum StalAlloysArmorMaterials implements ArmorMaterial {

  BRASS("brass", 12, new int[]{1, 4, 5, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, 0.1f, () -> Ingredient.ofItems(StalAlloysItems.BRASS_INGOT)),
  STAINLESS_STEEL("stainless_steel", 48, new int[]{4, 7, 9, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0f, 0.2f, () -> Ingredient.ofItems(StalAlloysItems.STAINLESS_STEEL_INGOT));

  private static final int[] BASE_DURABILITY;
  private final String name;
  private final int durabilityMultiplier;
  private final int[] protectionAmounts;
  private final int enchantability;
  private final SoundEvent equipSound;
  private final float toughness;
  private final float knockbackResistance;
  private final Supplier<Ingredient> repairIngredientSupplier;

  private StalAlloysArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
    this.name = name;
    this.durabilityMultiplier = durabilityMultiplier;
    this.protectionAmounts = protectionAmounts;
    this.enchantability = enchantability;
    this.equipSound = equipSound;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredientSupplier = repairIngredientSupplier;
  }

  @Override
  public int getDurability(EquipmentSlot slot) {
    return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
    return this.protectionAmounts[slot.getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return this.enchantability;
  }

  @Override
  public SoundEvent getEquipSound() {
    return this.equipSound;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return this.repairIngredientSupplier.get();
  }

  @Override
  public String getName() {
    return StalAlloys.MOD_ID + ":" + this.name;
  }

  @Override
  public float getToughness() {
    return this.toughness;
  }

  @Override
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }

  static {
    BASE_DURABILITY = new int[]{13, 15, 16, 11};
  }

  
}
