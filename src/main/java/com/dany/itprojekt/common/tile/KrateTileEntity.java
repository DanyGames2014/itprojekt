package com.dany.itprojekt.common.tile;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.container.KrateContainer;
import com.dany.itprojekt.core.init.TileEntityTypesInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;


/**
 * 
 * @author Daniel Fildán
 * This calss defines the logic for the Krate Tile Entity
 *
 */
public class KrateTileEntity extends LockableLootTileEntity{
	
public static int slots = 27;
	
	protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);
	
	protected KrateTileEntity(TileEntityType<?> type) {
		super(type);
	}
	
	public KrateTileEntity() {
		this(TileEntityTypesInit.KRATE_TILE_ENTITY_TYPE.get());
	}

	@Override
	public int getContainerSize() {
		return 27;
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIN) {
		this.items = itemsIN;
		
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container."+ProjektMod.MOD_ID+".krate");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new KrateContainer(id, player, this);
	}
	
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		if(!this.trySaveLootTable(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.items);
		}
		
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		
		this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
		if( !this.tryLoadLootTable(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}
	
}
