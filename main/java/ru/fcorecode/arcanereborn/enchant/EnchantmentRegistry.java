package ru.fcorecode.arcanereborn.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;


	public class EnchantmentRegistry {

		//Name, ID, Rarity, digger\armor
	    public static final Enchantment
	    SAFE_ALL = new EnchantmentSafeall("safe_all", 111, 0, EnumEnchantmentType.digger);
	  
	    public static void register() {}
	}

