package net.stal.alloys.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.*;
import net.stal.alloys.StalAlloys;
import net.stal.alloys.util.IEntityDataSaver;

@Mixin(Entity.class)
public abstract class StalAlloysEntityDataSaverMixin implements IEntityDataSaver {
  private final String EXAMPLE_DATA_ID = "example_data";

  private NbtCompound mPersistantData;
  
  @Override
  public NbtCompound getPersistantData() {
    if (mPersistantData == null) {
      mPersistantData = new NbtCompound();
    }
    
    return mPersistantData;
  }

  @Inject(at = @At("HEAD"), method = "writeNbt")
  protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<?> info) {
    if (mPersistantData != null) {
      nbt.put(StalAlloys.MOD_ID + "." + EXAMPLE_DATA_ID, mPersistantData);
    }
  }

  @Inject(at = @At("HEAD"), method = "readNbt")
  protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
    if (nbt.contains(StalAlloys.MOD_ID + EXAMPLE_DATA_ID, 10)) {
      mPersistantData = nbt.getCompound(StalAlloys.MOD_ID + "." + EXAMPLE_DATA_ID);
    }
  }
  
}
