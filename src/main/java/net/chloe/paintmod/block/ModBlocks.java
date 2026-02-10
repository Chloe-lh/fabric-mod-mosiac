package net.chloe.paintmod.block;
import net.chloe.paintmod.Paintmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModBlocks {

    public static final Block CERAMIC_BLOCK = registerBlock("ceramic_block",
            properties -> new Block(properties
                    .strength(4f)
                    .sounds(BlockSoundGroup.GLASS)));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function){
        Block registering = function.apply(AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Paintmod.MOD_ID, name))));
        registerBlockItem(name, registering);
        return Registry.register(Registries.BLOCK, Identifier.of(Paintmod.MOD_ID, name), registering);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Paintmod.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Paintmod.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Paintmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Paintmod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Paintmod.LOGGER.info("Registering Mod blocks for " + Paintmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> entries.add(CERAMIC_BLOCK));
    }
}

