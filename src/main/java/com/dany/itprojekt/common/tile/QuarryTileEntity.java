package com.dany.itprojekt.common.tile;

import com.dany.itprojekt.core.init.TileEntityTypesInit;

import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

/**
 * 
 * @author Daniel Fildán
 * This class defines the logic for Quarry Tile Entity
 *
 */
public class QuarryTileEntity extends TileEntity implements ITickableTileEntity{

	public QuarryTileEntity(TileEntityType<?> tileType) {
		super(tileType);
	}
	
	public QuarryTileEntity() {
		this(TileEntityTypesInit.QUARRY_TILE_ENTITY_TYPE.get());
	}

	@Override
	public void tick() {
		this.level.setBlock(this.worldPosition.below(), Blocks.AIR.defaultBlockState(), 0);
		//System.out.println("Quarry Tick");
	}

}
