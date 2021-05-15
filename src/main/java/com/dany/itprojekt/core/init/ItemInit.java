package com.dany.itprojekt.core.init;

import com.dany.itprojekt.ProjektMod;
import com.dany.itprojekt.common.material.CustomArmorMaterial;
import com.dany.itprojekt.common.material.CustomToolMaterial;
import com.dany.itprojekt.core.itemgroup.ITProjektItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 
 * @author Daniel Fildán
 * This class registers all the items using the new DeferredRegister
 *
 */

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjektMod.MOD_ID); // Creating the Deferred Register to register all the items
	
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_PICKAXE = ITEMS.register("tin_pickaxe", () -> new PickaxeItem(CustomToolMaterial.TIN, 1, -2.8f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_AXE = ITEMS.register("tin_axe", () -> new AxeItem(CustomToolMaterial.TIN, 7, -3.2f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_SHOVEL = ITEMS.register("tin_shovel", () -> new ShovelItem(CustomToolMaterial.TIN, 1, -3f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_SWORD = ITEMS.register("tin_sword", () -> new SwordItem(CustomToolMaterial.TIN, 5, -2.5f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_HOE = ITEMS.register("tin_hoe", () -> new HoeItem(CustomToolMaterial.TIN, 0, -2f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_HELMET = ITEMS.register("tin_helmet", () -> new ArmorItem(CustomArmorMaterial.TIN, EquipmentSlotType.HEAD, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_CHESTPLATE = ITEMS.register("tin_chestplate", () -> new ArmorItem(CustomArmorMaterial.TIN, EquipmentSlotType.CHEST, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_LEGGINGS = ITEMS.register("tin_leggings", () -> new ArmorItem(CustomArmorMaterial.TIN, EquipmentSlotType.LEGS, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> TIN_BOOTS = ITEMS.register("tin_boots", () -> new ArmorItem(CustomArmorMaterial.TIN, EquipmentSlotType.FEET, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CustomToolMaterial.COPPER, 1, -2.8f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CustomToolMaterial.COPPER, 7, -3.2f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CustomToolMaterial.COPPER, 1, -3f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CustomToolMaterial.COPPER, 5, -2.5f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(CustomToolMaterial.COPPER, 0, -2f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));

	public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(CustomToolMaterial.BRONZE, 1, -2.6f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new AxeItem(CustomToolMaterial.BRONZE, 8, -3.0f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new ShovelItem(CustomToolMaterial.BRONZE, 1, -2.9f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(CustomToolMaterial.BRONZE, 6, -2.1f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () -> new HoeItem(CustomToolMaterial.BRONZE, 0, -2f, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new ArmorItem(CustomArmorMaterial.BRONZE, EquipmentSlotType.HEAD, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new ArmorItem(CustomArmorMaterial.BRONZE, EquipmentSlotType.CHEST, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new ArmorItem(CustomArmorMaterial.BRONZE, EquipmentSlotType.LEGS, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new ArmorItem(CustomArmorMaterial.BRONZE, EquipmentSlotType.FEET, new Item.Properties().tab(ITProjektItemGroup.ITPROJEKT)));
	
	
}
