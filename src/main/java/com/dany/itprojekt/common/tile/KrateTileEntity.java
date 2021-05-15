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

// Slot count
public static int slots = 27;
	
	// Creates an ArrayList that will be containing the inventory
	protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);
	
	protected KrateTileEntity(TileEntityType<?> type) {
		super(type);
	}
	
	public KrateTileEntity() {
		this(TileEntityTypesInit.KRATE_TILE_ENTITY_TYPE.get());
	}

	@Override
	public int getContainerSize() { // Size
		return 27;
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() { // Getter for items
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIN) { // Setter for items
		this.items = itemsIN;
		
	}

	@Override
	protected ITextComponent getDefaultName() { // Gets the container name from lang file
		return new TranslationTextComponent("container."+ProjektMod.MOD_ID+".krate");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new KrateContainer(id, player, this);
	}
	
	public CompoundNBT save(CompoundNBT nbt) { // Saves the block NBT data
		super.save(nbt);
		if(!this.trySaveLootTable(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.items);
		}
		
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) { // Loads the block NBT data
		super.load(state, nbt);
		
		this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
		if( !this.tryLoadLootTable(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}
	
}
