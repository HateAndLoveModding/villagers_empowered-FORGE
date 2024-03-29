package com.example.villagers_empowered.block;

import com.example.villagers_empowered.villagers_empowered;
import com.example.villagers_empowered.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, villagers_empowered.MOD_ID);

    public static final RegistryObject<Block> LIFARMIAN_TABLE = registerBlock("lifarmian_table",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                    .strength(2.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FLASONIC_TABLE = registerBlock("flasonic_table",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                    .strength(2.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CREATURE_CARRIER_BLOCK = registerBlock("creature_carrier_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .strength(3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PACKED_BOOKSHELF = registerBlock("packed_bookshelf",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
