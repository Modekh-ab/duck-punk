package net.modekh.duckpunk.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.modekh.duckpunk.utils.Reference;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS
            = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

    public static final RegistryObject<SoundEvent> PUNK_ROCK =
            registerSoundEvents("punk_rock");

    public static final RegistryObject<SoundEvent> HOI =
            registerSoundEvents("hoi");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID, name)));
    }

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
