package net.modekh.duckpunk;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.modekh.duckpunk.registry.*;
import net.modekh.duckpunk.utils.Reference;

@Mod(Reference.MOD_ID)
public class DuckPunk {
    public DuckPunk() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

//        bus.addListener(this::commonSetup);

        BlockRegistry.register(bus);
        ItemRegistry.register(bus);
        CreativeTabRegistry.register(bus);
        SoundRegistry.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
