package com.dany.itprojekt.core.itemgroup;

import com.dany.itprojekt.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ITProjektItemGroup extends ItemGroup{
	
	public static final ITProjektItemGroup ITPROJEKT = new ITProjektItemGroup(ItemGroup.TABS.length, "itprojekt");
	
	public ITProjektItemGroup(int index, String Label) {
		super(index, Label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.TEST_ITEM.get());
	}

}
