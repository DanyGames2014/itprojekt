package com.dany.itprojekt.core.init;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.container.DisplayCaseContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, ProjektMod.MOD_ID);
	
	public static final RegistryObject<ContainerType<DisplayCaseContainer>> DISPLAY_CASE_CONTAINER_TYPE = CONTAINER_TYPE.register("display_case", () -> IForgeContainerType.create(DisplayCaseContainer::new));
}