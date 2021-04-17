package com.dany.itprojekt.core.init;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.tile.DisplayCaseTileEntity;
import com.dany.itprojekt.common.tile.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, ProjektMod.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("quarry", () -> TileEntityType.Builder.of(QuarryTileEntity::new, BlockInit.QUARRY.get()).build(null));
	
	public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_CASE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("display_case", () -> TileEntityType.Builder.of(DisplayCaseTileEntity::new, BlockInit.DISPLAY_CASE.get()).build(null));
}
