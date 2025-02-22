package net.modekh.duckpunk.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.modekh.duckpunk.utils.Reference;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS
            = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Reference.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> PUNK_ROCK =
            registerSoundEvents("punk_rock");

    public static final DeferredHolder<SoundEvent, SoundEvent> HOI =
            registerSoundEvents("hoi");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name)));
    }

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
