package com.dany.itprojekt.core.init;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.tile.DisplayCaseTileEntity;
import com.dany.itprojekt.common.tile.KrateTileEntity;
import com.dany.itprojekt.common.tile.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 
 * @author Daniel Fildán
 * Registers Tile Entities using the DeferredRegister
 *
 */
public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, ProjektMod.MOD_ID); // Creates the DeferreRegister to register all the tile entities

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("quarry", () -> TileEntityType.Builder.of(QuarryTileEntity::new, BlockInit.QUARRY.get()).build(null));
	
	public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_CASE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("display_case", () -> TileEntityType.Builder.of(DisplayCaseTileEntity::new, BlockInit.DISPLAY_CASE.get()).build(null));
	
	public static final RegistryObject<TileEntityType<KrateTileEntity>> KRATE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("krate", () -> TileEntityType.Builder.of(KrateTileEntity::new, BlockInit.KRATE.get()).build(null));
}
