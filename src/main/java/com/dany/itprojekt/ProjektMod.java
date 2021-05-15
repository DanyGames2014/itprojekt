package com.dany.itprojekt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dany.itprojekt.core.init.BlockInit;
import com.dany.itprojekt.core.init.ContainerTypeInit;
import com.dany.itprojekt.core.init.FeatureInit;
import com.dany.itprojekt.core.init.ItemInit;
import com.dany.itprojekt.core.init.TileEntityTypesInit;
import com.dany.itprojekt.core.itemgroup.ITProjektItemGroup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 
 * @author Daniel Fildán
 * This is the main class, it defines the modid and registers all the initializers onto the bus and adds listener for certain events such as ore gen
 * It also automatically Reigsters all the block items so it doesnt have to be done manually
 *
 */
@Mod("itprojekt")
@Mod.EventBusSubscriber(modid = ProjektMod.MOD_ID, bus = Bus.MOD)
public class ProjektMod {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "itprojekt";

	public ProjektMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
		BlockInit.BLOCKS.register(bus);
		ContainerTypeInit.CONTAINER_TYPE.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
		
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)).setRegistryName(block.getRegistryName()));
		});
		
	}
}