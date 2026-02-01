package net.chloe.paintmod.block;
import net.chloe.paintmod.Paintmod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MosaicBlock {
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Paintmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }
    public static void registerMosaicBlocks(){
        Paintmod.LOGGER.info("Registering Mod blocks for "+ Paintmod.MOD_ID);
    }
}
