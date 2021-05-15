package com.dany.itprojekt.common.block;

import com.dany.itprojekt.core.init.TileEntityTypesInit;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

/**
 * 
 * @author Daniel Fildán
 * This makes the Quarry Block an Tile Entity
 *
 */
public class QuarryBlock extends Block{

	public QuarryBlock() {
		super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(5f, 20f).sound(SoundType.METAL)); // Assigns the properties
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) { // Tels minecraft its Tile Entity
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) { // Creates the Tile Entity
		return TileEntityTypesInit.QUARRY_TILE_ENTITY_TYPE.get().create();
	}
	
}
