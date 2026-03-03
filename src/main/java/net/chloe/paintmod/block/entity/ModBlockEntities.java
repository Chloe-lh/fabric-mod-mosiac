package net.chloe.paintmod.block.entity;

import net.chloe.paintmod.Paintmod;
import net.chloe.paintmod.block.ModBlocks;
import net.chloe.paintmod.block.entity.custom.CeramicTileEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


import static net.minecraft.client.render.entity.EntityRendererFactories.register;

/*
Registers Block Entity Types
    - connects block to block Entity class
 */
public class ModBlockEntities {
    // create BlockEntityType
    public static final BlockEntityType<CeramicTileEntity> CERAMIC_TILE_ENTITY =
            register("ceramic_tile", CeramicTileEntity::new, ModBlocks.CERAMIC_TILE);


    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(Paintmod.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerBlockEntities(){
        
        Paintmod.LOGGER.info("Registering Block Entities for " + Paintmod.MOD_ID);
    }
}
