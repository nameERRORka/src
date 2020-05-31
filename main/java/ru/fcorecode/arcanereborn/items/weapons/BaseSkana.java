package ru.fcorecode.arcanereborn.items.weapons;

import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import ru.fcorecode.arcanereborn.configs.Rarity;

public class BaseSkana extends ItemSword
{		
		TickEvent.ServerTickEvent evt;
		EntityPlayer player;
		int mode = 1;
		public static final ToolMaterial BASESKANAMAT = EnumHelper.addToolMaterial("BASESKANAMAT", 3, 274564, 17.0F, 4.0F, 50);
				
		public BaseSkana(String name, String texture, int maxStackSize)
		{
		    super(BASESKANAMAT);
			this.canRepair = false;
			this.setUnlocalizedName(name);
			this.setTextureName(Main.MODID + ":" + texture);
			this.setCreativeTab(Main.tabAFReborn);
			this.setMaxDamage(10000);
			this.maxStackSize = 1;
			GameRegistry.registerItem(this, name);
		}
		
		public EnumRarity getRarity(ItemStack itemStack) 
		{
			return Rarity._legendary;
		}
			  
		@SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
			par3List.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
	        par3List.add("Описание предмета");
		    int a, b, c;
			  a = this.getMaxDamage();
			  b = this.getDamage(par1ItemStack);
			  c = a - b;
			par3List.add("Прочности осталось " + c);
	    }
		}
