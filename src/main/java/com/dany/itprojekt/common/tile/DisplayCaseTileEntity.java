package com.dany.itprojekt.common.tile;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.container.DisplayCaseContainer;
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
 * This class defines the logic for DisplayCase Tile Entity
 *
 */
public class DisplayCaseTileEntity extends LockableLootTileEntity{
	
	// Slot count
	public static int slots = 1;
	
	// Creates an ArrayList to store the items
	protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);
	
	protected DisplayCaseTileEntity(TileEntityType<?> type) {
		super(type);
	}
	
	public DisplayCaseTileEntity() {
		this(TileEntityTypesInit.DISPLAY_CASE_TILE_ENTITY_TYPE.get());
	}

	@Override
	public int getContainerSize() {
		return 1;
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIN) {
		this.items = itemsIN;
		
	}
	
	// Gets the name of the container from the lang file
	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container."+ProjektMod.MOD_ID+".display_case");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new DisplayCaseContainer(id, player, this);
	}
	
	public CompoundNBT save(CompoundNBT nbt) { // Saves the bock nbt Data
		super.save(nbt);
		if(!this.trySaveLootTable(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.items);
		}
		
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) { // Loads the block NBT Data
		super.load(state, nbt);
		
		this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
		if( !this.tryLoadLootTable(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}

}
