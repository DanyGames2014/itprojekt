package com.dany.itprojekt.client.screen;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.container.DisplayCaseContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * 
 * @author Daniel Fildán
 * This makes the screen renderer for Display Case
 *
 */
@OnlyIn(Dist.CLIENT) // This will only run on client side
public class DisplayCaseScreen extends ContainerScreen<DisplayCaseContainer> {

	private static final ResourceLocation DISPLAY_CASE_GUI = new ResourceLocation(ProjektMod.MOD_ID,"textures/gui/display_case.png"); //This assigns the Texture of the background 

	public DisplayCaseScreen(DisplayCaseContainer screenContainer, PlayerInventory playerInv, ITextComponent title) {
		super(screenContainer, playerInv, title);
		// Defining width and height of the GUI
		this.inventoryLabelX = 0;
		this.inventoryLabelY = 0;
		this.width = 175;
		this.height = 201;
	}

	@Override
	public void render(MatrixStack matrixStack, int x, int y, float partialTicks) { //Renders the overlay on screen
		this.renderBackground(matrixStack);
		super.render(matrixStack, x, y, partialTicks);
		this.renderLabels(matrixStack, x, y);
	}

	@Override
	protected void renderLabels(MatrixStack matrixStack, int x, int y) { //Renders the name of container
		this.font.draw(matrixStack, title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mx, int my) { //Renders the background texture
		RenderSystem.color4f(1f, 1f, 1f, 1f);
		this.minecraft.textureManager.bind(DISPLAY_CASE_GUI);
		int x = (this.width - this.getXSize()) / 2;
		int y = (this.height - this.getYSize()) / 2;
		this.blit(matrixStack, x, y, 0, 0, this.getXSize(), this.getYSize());
	}

}
