package com.dany.itprojekt.common.container;

import java.util.Objects;

import com.dany.itprojekt.common.tile.DisplayCaseTileEntity;
import com.dany.itprojekt.core.init.ContainerTypeInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class DisplayCaseContainer extends Container{
	
	public final DisplayCaseTileEntity tile;
	private final IWorldPosCallable canInteractWithCallable;
	
	public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final DisplayCaseTileEntity tile) {
		super(ContainerTypeInit.DISPLAY_CASE_CONTAINER_TYPE.get(), windowId);
		this.tile = tile;
		this.canInteractWithCallable = IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos());
		
		// Tile Entity
		this.addSlot(new Slot((IInventory) tile, 0, 80, 35));
		
		// Player Inventory
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4-row) * 18 - 10));
			}
		}
		
		// Player Inventory
		for(int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInv,col, 8 + col * 18, 142));
		}
	}
	
	public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}
	
	private static DisplayCaseTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory can't be null");
		Objects.requireNonNull(data, "Packet Buffer can't be null");
		final TileEntity tile = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tile instanceof DisplayCaseTileEntity) {
			return (DisplayCaseTileEntity) tile;
		}
		
		throw new IllegalStateException("Wrong Tile Entity");
	}
	
	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}
	
	
	@Override
	public ItemStack quickMoveStack(PlayerEntity player, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		
		if(slot != null && slot.hasItem()) {
			ItemStack stack1 = slot.getItem();
			stack = stack1.copy();
			if (index < DisplayCaseTileEntity.slots && !this.moveItemStackTo(stack1, DisplayCaseTileEntity.slots, this.slots.size(), true)) {
				return ItemStack.EMPTY;
			}
			
			if(!this.moveItemStackTo(stack1, 0, DisplayCaseTileEntity.slots, false)) {
				return ItemStack.EMPTY;
			}
			
			if (stack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}
		
		return stack;
		
	}
	
	
	
	
	

}
