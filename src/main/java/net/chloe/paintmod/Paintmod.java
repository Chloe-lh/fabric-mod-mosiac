package net.chloe.paintmod;

import net.chloe.paintmod.block.ModBlocks;
import net.chloe.paintmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Paintmod implements ModInitializer {
	public static final String MOD_ID = "paintmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

//		MosaicBlock.registerMosaicBlocks();
	}
}