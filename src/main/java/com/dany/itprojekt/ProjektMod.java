package com.dany.itprojekt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("itprojekt")
public class ProjektMod {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "itprojekt";

	public ProjektMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
	}
}