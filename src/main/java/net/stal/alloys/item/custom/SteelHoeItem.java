package net.stal.alloys.item.custom;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class SteelHoeItem extends HoeItem {

  /** This exists to make the constructor of HoeItem accessible... cuz its private ????
   * @param material
   * @param attackDamage
   * @param attackSpeed
   * @param settings
   */
  public SteelHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
    super(material, attackDamage, attackSpeed, settings);
  }
}
