package com.dany.itprojekt.client.screen;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.container.KrateContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KrateScreen extends ContainerScreen<KrateContainer>{
		
	private static final ResourceLocation KRATE_GUI = new ResourceLocation(ProjektMod.MOD_ID,"textures/gui/krate.png");

	public KrateScreen(KrateContainer screenContainer, PlayerInventory playerInv, ITextComponent title) {
		super(screenContainer, playerInv, title);

		this.inventoryLabelX = 0;
		this.inventoryLabelY = 0;
		this.width = 550;
		this.height = 550;
	}

	@Override
	public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, x, y, partialTicks);
		this.renderLabels(matrixStack, x, y);
	}

	@Override
	protected void renderLabels(MatrixStack matrixStack, int x, int y) {
		this.font.draw(matrixStack, title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mx, int my) {
		RenderSystem.color4f(1f, 1f, 1f, 1f);
		this.minecraft.textureManager.bind(KRATE_GUI);
		int x = (this.width - this.getXSize()) / 2;
		int y = (this.height - this.getYSize()) / 2;
		this.blit(matrixStack, x, y, 0, 0, this.getXSize(), this.getYSize());
	}
}
