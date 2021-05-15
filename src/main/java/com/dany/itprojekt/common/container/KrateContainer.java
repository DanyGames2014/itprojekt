package com.dany.itprojekt.common.container;

import java.util.Objects;

import com.dany.itprojekt.common.tile.KrateTileEntity;
import com.dany.itprojekt.core.init.ContainerTypeInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

/**
 * 
 * @author Daniel Fildán
 * This creates container of Krate
 *
 */
public class KrateContainer extends Container{
	
	public final KrateTileEntity tile;
	private final IWorldPosCallable canInteractWithCallable;
	
	public KrateContainer(final int windowId, final PlayerInventory playerInv, final KrateTileEntity tile) {
		super(ContainerTypeInit.KRATE_CONTAINER_TYPE.get(), windowId);
		this.tile = tile;
		this.canInteractWithCallable = IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos());
		
		// Tile Entity
		// addSlot(Slot,TileEntita,SlotId,X,Y)
		this.addSlot(new Slot((IInventory) tile, 0, 8, 14));
		
		/*for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				this.addSlot(new Slot((IInventory) tile, col + row * 9 + 9, 8 + col * 18, 166 - (4-row) * 18 - 10)); // Adding Slots to the inventory
			}
		}*/
		
		// Player Inventory
		// col - column in inventory
		// row - row in inventory
		// 9 - amount of slots in one row
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4-row) * 18 - 10));
			}
		}
		
		// Player Hotbar
		for(int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInv,col, 8 + col * 18, 142));
		}
	}
	
	public KrateContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}
	
	private static KrateTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory can't be null");
		Objects.requireNonNull(data, "Packet Buffer can't be null");
		final TileEntity tile = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tile instanceof KrateTileEntity) {
			return (KrateTileEntity) tile;
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
			if (index < KrateTileEntity.slots && !this.moveItemStackTo(stack1, KrateTileEntity.slots, this.slots.size(), true)) {
				return ItemStack.EMPTY;
			}
			
			if(!this.moveItemStackTo(stack1, 0, KrateTileEntity.slots, false)) {
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
