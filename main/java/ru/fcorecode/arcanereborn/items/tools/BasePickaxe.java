package ru.fcorecode.arcanereborn.items.tools;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import java.text.DecimalFormat;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasePickaxe extends ItemPickaxe 
{
		boolean mode = false;
		
		public BasePickaxe(String name, String texture, int maxStackSize)
		{
			super(BASEPICKAXEMAT);
			this.canRepair = false;
			this.setUnlocalizedName(name);
			this.setTextureName(Main.MODID + ":" + texture);
			this.setCreativeTab(Main.tabAFReborn);
			this.setMaxDamage(100);
			this.maxStackSize = 1;
			GameRegistry.registerItem(this, name);
		}
			  
		@SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	        par3List.add("Описание предмета");
		    int a, b, c;
			  a = this.getMaxDamage();
			  b = this.getDamage(par1ItemStack);
			  c = a - b;
	        par3List.add("�2��������� :" + c);
	    }
			 
				
		public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		    if (world.isRemote) {
		        if (!mode) {
		            player.addChatMessage(new ChatComponentText("Включено 3X3"));
		            player.capabilities.allowFlying = true;
		            mode = true;
		        } else {
		            player.addChatMessage(new ChatComponentText("Выключено 3X3"));
		            player.capabilities.allowFlying = false;
		            mode = false;
		        }
		    }
		    itemStack.damageItem(1, player);
		    return itemStack;
		}
		@Override
		public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
		{
			World world = player.worldObj;
			Block block = world.getBlock(x, y, z);
		
			MovingObjectPosition object = RandomUtils.raytraceFromEntity(world, player, false, 4.5D);
		
			if (object == null)
			{
				return super.onBlockDestroyed(stack, world, block, x, y, z, player);
			}
		
			int side = object.sideHit;
			int xmove = 0;
			int ymove = 0;
			int zmove = 0;
		
			if (side == 0 || side == 1)
			{
				xmove = 1;
				zmove = 1;
			}
			else
			{
				ymove = 1;
				if (side == 4 || side == 5)
				{
					zmove = 1;
				}
				else
				{
					xmove = 1;
				}
			}
		
			float strength = ForgeHooks.blockStrength(block, player, world, x, y, z);
		
			if (player.isSneaking() && ConfigInfo.EnableHammerShiftOneBlock
					&& (player.experienceLevel >= 20 || player.capabilities.isCreativeMode))
			{
				checkBlockBreak(world, player, x, y, z, stack, strength, block, side);
			}
		
			else
			{
				for (int i = -xmove; i <= xmove; i++)
				{
					for (int j = -ymove; j <= ymove; j++)
					{
						for (int k = -zmove; k <= zmove; k++)
						{
							if (i != x && j != y && k != z)
							{
								checkBlockBreak(world, player, x + i, y + j, z + k, stack, strength, block, side);
							}
						}
					}
				}
			}
		
			return false;
		}
		
		public void checkBlockBreak(World world, EntityPlayer player, int x, int y, int z, ItemStack stack, float strength,
				Block originalBlock, int side)
		{
			Block breakBlock = world.getBlock(x, y, z);
		
			if (this.canHarvestBlock(breakBlock, stack))
			{
				float newStrength = ForgeHooks.blockStrength(breakBlock, player, world, x, y, z);
				Material material = originalBlock.getMaterial();
		
				if (newStrength > 0f && strength / newStrength <= 10f && breakBlock.getMaterial() == material)
				{
					RandomUtils.breakBlock(world, breakBlock, x, y, z, side, player);
		
					if ((double) breakBlock.getBlockHardness(world, x, y, z) != 0.0D)
					{
						stack.damageItem(1, player);
					}
				}
			}
		}
		
		public EnumRarity getRarity(ItemStack itemStack) 
		{
			return EnumRarity.epic;
		}
		public static final ToolMaterial BASEPICKAXEMAT = EnumHelper.addToolMaterial("BASEPICKAXEMAT", 3, 274564, 17.0F, 4.0F, 50);
}
