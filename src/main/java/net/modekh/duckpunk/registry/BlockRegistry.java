package net.modekh.duckpunk.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.modekh.duckpunk.objects.blocks.DuckPunkBlock;
import net.modekh.duckpunk.utils.Reference;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    // blocks
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);

    public static final DeferredHolder<Block, DuckPunkBlock> DUCK_PUNK =
            BLOCKS.register("duck_punk", () -> new DuckPunkBlock(BlockBehaviour.Properties.of()));

    // registry
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);

        for (DeferredHolder<? extends Block, ? extends Block> block : BLOCKS.getEntries()) {
            ItemRegistry.ITEMS.register(block.getId().getPath(),
                    () -> new BlockItem(block.get(), new Item.Properties()))    ;
        }
    }
}
