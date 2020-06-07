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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.items.armor._daemonicArmor;
import ru.fcorecode.arcanereborn.configs.Rarity;

public class Items extends Item 
{

		boolean mode = false;

		public Items(String name, String texture, int maxStackSize) 
		{
			this.canRepair = false;
			this.setUnlocalizedName(name);
			this.setTextureName(Main.MODID + ":" + texture);
			this.setCreativeTab(Main.tabAFRebornAnother);
			GameRegistry.registerItem(this, name);
		}

		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
		{
			par3List.add("" + Rarity._useless.rarityName);
		}

		public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
		{
			return false;
		}

		@Subscribe
		public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
		{
			return itemStack;
		}

		public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase Entity) 
		{
			return false;
		}

		public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) 
		{
			
		}

		public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
		{
			/*if (world.isRemote) 
			 * {
			player.addChatMessage(new ChatComponentText("� ��������!"));
			}*/
		}

		public EnumRarity getRarity(ItemStack itemStack) 
		{
			return Rarity._useless;
		}
}



/*
----------------------------------
        Штуки для полёта
----------------------------------
if (world.isRemote) {

if (!mode) {
	player.addChatMessage(new ChatComponentText("Врубаем полет"));
	player.capabilities.allowFlying = true;
	mode = true;
} else {
	player.addChatMessage(new ChatComponentText("Вырубаем"));
	player.capabilities.allowFlying = false;
	mode = false;
}
}
itemStack.damageItem(1, player);
*/

/*
----------------------------------
        Штуки вывода сообщений
----------------------------------
player.addChatMessage(new ChatComponentText("� ����� ���!" + mode));
mode = !mode;
player.capabilities.disableDamage = mode;
*/

/*
----------------------------------
        Штуки для бафов
----------------------------------
super.onUpdate(stack, world, entity, par4, par5);
if (entity instanceof EntityPlayer) {
	EntityPlayer player = (EntityPlayer) entity;
	ItemStack equipped = player.getCurrentEquippedItem();
	if (equipped == stack) {
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 2, 2, true));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2, 1, true));
	}
}*/
