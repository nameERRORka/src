package ru.fcorecode.arcanereborn.items.Money;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.Rarity;

public class Money extends Item
{

	boolean mode = false;

	public Money(String name, String texture, int maxStackSize)
	{
		this.canRepair = false;
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + texture);
		this.setCreativeTab(ConfigInfo.tabAFRebornMoney);
		this.maxStackSize = maxStackSize;
//		GameRegistry.registerItem(this, name);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none)
	{
		itemDescription.add("" + Rarity._arcoins.rarityColor + Rarity._arcoins.rarityName);
		itemDescription.add(StatCollector.translateToLocal("item.CoinLore1.lore"));
		itemDescription.add(StatCollector.translateToLocal("item.CoinLore2.lore"));
		itemDescription.add(StatCollector.translateToLocal("item.CoinLore3.lore"));
		itemDescription.add(StatCollector.translateToLocal("item.CoinLore4.lore"));
		itemDescription.add(StatCollector.translateToLocal("item.CoinLore5.lore"));
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase player, EntityLivingBase Entity) 
	{
		stack.damageItem(1, Entity);
		return false;
	}

	public EnumRarity getRarity(ItemStack stack)
	{
		return Rarity._arcoins;
	}
}
