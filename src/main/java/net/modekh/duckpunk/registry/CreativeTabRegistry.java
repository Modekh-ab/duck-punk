package net.modekh.duckpunk.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.modekh.duckpunk.utils.Reference;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DUCK_PUNK_TAB =
            CREATIVE_TABS.register("duckpunk", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.duckpunk"))
                    .icon(() -> BlockRegistry.DUCK_PUNK.get().asItem().getDefaultInstance())
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_TABS.register(bus);
        bus.addListener(CreativeTabRegistry::addCreative);
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeTabRegistry.DUCK_PUNK_TAB.getKey()) {
            event.accept(BlockRegistry.DUCK_PUNK.get());
        }
    }
}
