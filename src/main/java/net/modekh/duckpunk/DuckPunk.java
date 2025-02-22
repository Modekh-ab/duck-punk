package net.modekh.duckpunk;

import net.modekh.duckpunk.registry.*;
import net.modekh.duckpunk.utils.Reference;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Reference.MOD_ID)
public class DuckPunk {
    public DuckPunk(IEventBus bus) {
        BlockRegistry.register(bus);
        ItemRegistry.register(bus);
        CreativeTabRegistry.register(bus);
        SoundRegistry.register(bus);

        bus.addListener(CreativeTabRegistry::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
