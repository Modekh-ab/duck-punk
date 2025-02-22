package net.modekh.duckpunk.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.modekh.duckpunk.utils.Reference;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final net.neoforged.neoforge.registries.DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, Reference.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
