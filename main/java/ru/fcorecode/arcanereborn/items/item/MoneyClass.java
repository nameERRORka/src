package ru.fcorecode.arcanereborn.items.item;

import java.util.List;

import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.Rarity;

public class MoneyClass extends Item 
{

	boolean mode = false;

	public MoneyClass(String name, String texture, int maxStackSize) 
	{
		this.canRepair = false;
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + texture);
		this.setCreativeTab(Main.tabAFRebornMoney);
		this.maxStackSize = maxStackSize;
		GameRegistry.registerItem(this, name);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		par3List.add("" + Rarity._arcoins.rarityColor + Rarity._arcoins.rarityName);
		par3List.add(StatCollector.translateToLocal("item.Coin1.lore"));
		par3List.add(StatCollector.translateToLocal("item.Coin2.lore"));
		par3List.add(StatCollector.translateToLocal("item.Coin3.lore"));
		par3List.add(StatCollector.translateToLocal("item.CoinEmpty.lore"));
		par3List.add(StatCollector.translateToLocal("item.Coin4.lore"));
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase player, EntityLivingBase Entity) 
	{
		par1ItemStack.damageItem(1, Entity);
		return false;
	}

	public EnumRarity getRarity(ItemStack itemStack) 
	{
		return Rarity._arcoins;
	}
}
