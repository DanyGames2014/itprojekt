package com.dany.itprojekt.core.itemgroup;

import com.dany.itprojekt.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author Daniel Fildán
 * Creates the Creative Inventory Tab
 *
 */
public class ITProjektItemGroup extends ItemGroup{
	
	public static final ITProjektItemGroup ITPROJEKT = new ITProjektItemGroup(ItemGroup.TABS.length, "itprojekt"); // Creates new Creative Inventory Tabs
	
	public ITProjektItemGroup(int index, String Label) { 
		super(index, Label);
	}

	@Override
	public ItemStack makeIcon() { // Sets the icon
		return new ItemStack(ItemInit.TEST_ITEM.get());
	}

}
