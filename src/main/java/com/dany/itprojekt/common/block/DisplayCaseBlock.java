package com.dany.itprojekt.common.block;

import com.dany.itprojekt.common.tile.DisplayCaseTileEntity;
import com.dany.itprojekt.core.init.TileEntityTypesInit;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.network.NetworkHooks;

public class DisplayCaseBlock extends Block {
	
	public DisplayCaseBlock() {
		super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(5f, 20f).sound(SoundType.METAL));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypesInit.DISPLAY_CASE_TILE_ENTITY_TYPE.get().create();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos,PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
		
		if(!world.isClientSide) {
			
			
			TileEntity te = world.getBlockEntity(pos);
			if (te instanceof DisplayCaseTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (DisplayCaseTileEntity) te, pos);
				return ActionResultType.SUCCESS;
			}
			
			
			
		}
		
		return ActionResultType.SUCCESS;
		//return super.use(state, world, pos, player, hand, rayTrace);
	}
	
	@Override
	public void onRemove(BlockState state, World level, BlockPos pos, BlockState stateNew,boolean p_196243_5_) {
		InventoryHelper.dropContents(level, pos, (IInventory) level.getBlockEntity(pos));
	}
	
	
	
	
}
