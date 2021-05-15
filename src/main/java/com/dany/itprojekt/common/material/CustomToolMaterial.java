package com.dany.itprojekt.common.material;

import java.util.function.Supplier;

import com.dany.itprojekt.core.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * 
 * @author Daniel Fildán
 * This defines the materials derived from various materials for tools
 *
 */
public enum CustomToolMaterial implements IItemTier {
	
	// Defines the material properties
	COPPER(2, 230, 6f, 0f, 7, () -> Ingredient.of(ItemInit.COPPER_INGOT.get())),
	TIN(2, 190, 6f, 0f, 8, () -> Ingredient.of(ItemInit.TIN_INGOT.get())),
	BRONZE(2, 320, 8f, 0f, 13, () -> Ingredient.of(ItemInit.BRONZE_INGOT.get()));
	

	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Ingredient repairMaterial;

	private CustomToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial.get();

	}

	@Override
	public int getUses() {
		return this.maxUses;
	}

	@Override
	public float getSpeed() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	@Override
	public int getLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial;
	}
}
