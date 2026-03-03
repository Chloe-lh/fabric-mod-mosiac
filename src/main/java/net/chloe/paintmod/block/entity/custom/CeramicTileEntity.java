package net.chloe.paintmod.block.entity.custom;

import net.chloe.paintmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

/*
    stores data
    NBT saving/loading
        - binary name tag (data storage format)
        - saves data when game restarts
 */
public class CeramicTileEntity extends BlockEntity {
    private int[] paintColors = new int[4];

    public CeramicTileEntity(BlockEntityType<CeramicTileEntity> type, BlockPos pos, BlockState state) {
        super(ModBlockEntities.CERAMIC_TILE_ENTITY, pos, state);
    }
    public int[] getPaintColors(){
        return this.paintColors;
    }
    public void setPaintColors(int[] paintColors){
        this.paintColors = paintColors;
    }

    @Override
    protected void writeData(WriteView view){
        super.writeData(view);
        view.putIntArray("paintColors",paintColors);
    }

    @Override
    protected void readData(ReadView view){
        super.readData(view);
        paintColors = view.getOptionalIntArray("paintColors").orElse(new int[4]);
    }

}
