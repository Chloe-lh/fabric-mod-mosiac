package net.chloe.paintmod.block;
import net.chloe.paintmod.Paintmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CERAMIC_BLOCK = registerBlock("ceramic_block",
        new Block(AbstractBlock.Settings.create()
                .strength(2f)
                .sounds(BlockSoundGroup.GLASS)));
    // need loot table in order to drop resources when broken

    private static Block registerBlock(String name, Block block){
        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(Paintmod.MOD_ID, name), block);
        registerBlockItem(name, registeredBlock);
        return registeredBlock;
    }
    // register block as an item
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Paintmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    // for onInitializer
    public static void registerModBlocks(){
        Paintmod.LOGGER.info("Registering Mod blocks for "+ Paintmod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries->{
            entries.add(ModBlocks.CERAMIC_BLOCK);
        });
    }
}
