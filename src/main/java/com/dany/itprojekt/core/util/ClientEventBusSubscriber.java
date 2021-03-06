package com.dany.itprojekt.core.util;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.client.screen.DisplayCaseScreen;
import com.dany.itprojekt.client.screen.KrateScreen;
import com.dany.itprojekt.core.init.ContainerTypeInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/**
 * 
 * @author Daniel Fildán
 * Registers events for certain GUI blocks
 *
 */
@Mod.EventBusSubscriber(modid = ProjektMod.MOD_ID, bus = Bus.MOD , value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) { // Registers the screen manager during the game loading
		ScreenManager.register(ContainerTypeInit.DISPLAY_CASE_CONTAINER_TYPE.get(), DisplayCaseScreen::new);
		ScreenManager.register(ContainerTypeInit.KRATE_CONTAINER_TYPE.get(), KrateScreen::new);
		
	}
	
}