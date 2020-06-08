package ru.fcorecode.arcanereborn.items.armor;

import java.awt.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.item.ItemStack;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.Rarity;
import net.minecraftforge.common.util.EnumHelper;

public class _daemonicArmor extends ItemArmor {
	//=====================kostili=============================
	private String texturePath = Main.MODID + ":textures/model/armor/";
	//=================================================================
	public _daemonicArmor(int id, int armorType) {
	  super(ArmorMaterial.DIAMOND, id, armorType);
	  this.setCreativeTab(Main.tabAFRebornWaA);
	  this.setMaxStackSize(1);
	  this.setTextureName();
	}

	public void setTextureName ()
	{
	  if(armorType == 0||armorType == 1||armorType == 3){
	    this.texturePath += "DaemonicArmor_1.png";
	  }
	  else {
	    this.texturePath += "DaemonicArmor_2.png";
	  }
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
	  return this.texturePath;
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
	{
		return Rarity._legendary;
	}
}
