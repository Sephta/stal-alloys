package net.stal.world.gen;

import net.stal.StalAlloys;

public class StalAlloysWorldGen {
  public static void generateWorldGen() {
    StalAlloys.LOGGER.info("Registering " + StalAlloys.MOD_ID + " World Gen.");

    StalAlloysOreGeneration.generateOres();
  }
}
