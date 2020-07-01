package ru.fcorecode.arcanereborn.items.armor;

import java.awt.List;

import cpw.mods.fml.common.registry.GameRegistry;
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
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.Rarity;
import net.minecraftforge.common.util.EnumHelper;

public final class _daemonicArmor extends ItemArmor {

	private final String texturePath;

	public _daemonicArmor(String name, String iconPath, String texturePath, int maxStackSize, int id, int armorType) {
		super(ArmorMaterial.DIAMOND, id, armorType);
		this.setUnlocalizedName(name);
		this.setTextureName(String.format("%s:%s", Main.MODID, iconPath));
		this.setCreativeTab(ConfigInfo.tabAFRebornWaA);
		this.setMaxStackSize(maxStackSize);
		this.texturePath = String.format("%s:textures/model/armor/%s", Main.MODID, texturePath);
		GameRegistry.registerItem(this, name);
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
