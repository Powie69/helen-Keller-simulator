package powie.helensim.mixin;
import net.minecraft.client.option.GameOptions;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
    @Inject(method = "getSoundVolume", at = @At("HEAD"), cancellable = true)
    private void overrideSoundVolume(SoundCategory category, CallbackInfoReturnable<Float> cir) {
        if (category != SoundCategory.MASTER) cir.setReturnValue(0.0F);
    }
}