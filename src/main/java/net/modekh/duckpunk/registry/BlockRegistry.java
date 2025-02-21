package net.modekh.duckpunk.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.modekh.duckpunk.objects.blocks.DuckPunkBlock;
import net.modekh.duckpunk.objects.blocks.base.DuckPunkBlockItem;
import net.modekh.duckpunk.utils.Reference;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    public static final RegistryObject<Block> DUCK_PUNK = registerBlock("duck_punk",
            () -> new DuckPunkBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registerBlockReturn = BLOCKS.register(name, block);
        registerBlockItem(name, registerBlockReturn);

        return registerBlockReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemRegistry.ITEMS.register(name,
                () -> new DuckPunkBlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
