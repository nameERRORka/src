package ru.fcorecode.arcanereborn.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentSafeall extends Enchantment {

    public EnchantmentSafeall(String enchantmentName, int enchantmentId, int weight, EnumEnchantmentType enchantmentType) {
      
        super(enchantmentId, weight, enchantmentType);
      
        this.setName(enchantmentName);
    }
        @Override
        public boolean canApplyTogether(Enchantment enchantment) {
          
            return super.canApplyTogether(enchantment) && enchantment != Enchantment.efficiency;
        }
    }