package com.dany.itprojekt.core.init;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.block.DisplayCaseBlock;
import com.dany.itprojekt.common.block.QuarryBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ProjektMod.MOD_ID);

	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",
			() -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(5f, 1f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.CROP)));

	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3f, 3f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new QuarryBlock());
	
	public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", () -> new DisplayCaseBlock());
}
