package net.chloe.paintmod.item;

import net.chloe.paintmod.Paintmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // paint brush is registered as an item, not a tool yet
    // needs custom PaintBrush class
    public static final Item PAINT_BRUSH = registerItem("paint_brush", Item::new);

    public static Item registerItem(String name, Function<Item.Settings, Item> function){
        return Registry.register(Registries.ITEM, Identifier.of(Paintmod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Paintmod.MOD_ID, name)))));
    }
    /*
    ItemGroups.BUILDING_BLOCKS
    ItemGroups.COLORED_BLOCKS
    ItemGroups.NATURAL
    ItemGroups.FUNCTIONAL
    ItemGroups.REDSTONE
    ItemGroups.TOOLS
    ItemGroups.COMBAT
    ItemGroups.FOOD_AND_DRINK
    ItemGroups.INGREDIENTS
    ItemGroups.SPAWN_EGGS
    *
    * */
    public static void registerModItems(){
        Paintmod.LOGGER.info("Registering mod items for "+ Paintmod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.addAfter(Items.BRUSH, PAINT_BRUSH));
    }
}
