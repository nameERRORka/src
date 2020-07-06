package ru.fcorecode.arcanereborn.items.tools;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.ForgeDirection;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import ru.fcorecode.arcanereborn.configs.Rarity;
import ru.fcorecode.arcanereborn.enchant.EnchantmentRegistry;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import ru.fcorecode.arcanereborn.items.AFRItems;
import ru.fcorecode.arcanereborn.items.ToolHandler;


public class BasePickaxe extends ItemPickaxe {
    public int mode = 0;   
    public String namemode = "1 x 1";
    
    public BasePickaxe(String name, String texture, int maxStackSize, ToolMaterial baseHAMMER) {
        super(baseHAMMER);
        this.canRepair = false;
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornTools);
        this.maxStackSize = 1;
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return Rarity._legendary;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none) {
        itemDescription.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
        itemDescription.add(" " + " ");
        itemDescription.add(StatCollector.translateToLocal("item.efficiency.lore") + " " + ModToolMaterial.digSpeedbaseHAMMER);
        itemDescription.add(" " + " ");
		itemDescription.add(StatCollector.translateToLocal("item.BaseHammerLore1.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.BaseHammerLore2.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.BaseHammerLore3.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.BaseHammerLore4.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.BaseHammerLore5.lore"));
	    itemDescription.add(" " + " ");
		itemDescription.add(StatCollector.translateToLocal("item.HammerMode.lore")+ " " + namemode);
        int a, b, c;
        a = this.getMaxDamage();
        b = this.getDamage(stack);
        c = a - b;
        itemDescription.add(" " + " ");
        itemDescription.add(StatCollector.translateToLocal("item.GetDamage.lore") + " " + c + " " + StatCollector.translateToLocal("item.GetDamageL.lore"));

        if(stack.stackTagCompound == null ) {
            stack.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);}
        }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par2World.isRemote) {
			if (namemode == "1 x 1" && mode == 0) {
				namemode = "3 x 3";
				mode = 1;
				par3EntityPlayer.addChatMessage(new ChatComponentText(namemode));
			} else if (namemode == "3 x 3" && mode == 1) {
				namemode = "1 x 1";
				mode = 0;
				par3EntityPlayer.addChatMessage(new ChatComponentText(namemode));
		}}
		return par1ItemStack;
		}
	
	

        
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack && namemode == "3 x 3") {
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2, 2, true));
            } else if (equipped == stack && namemode == "1 x 1") {
                player.removePotionEffect(Potion.digSlowdown.id);
        }}
    }
    
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		World world = player.worldObj;
		Material mat = world.getBlock(x, y, z).getMaterial();
		if (!ToolHandler.isRightMaterial(mat, ToolHandler.materialsPick))
			return false;

		MovingObjectPosition block = ToolHandler.raytraceFromEntity(world, player, true, 4.5);
		if (block == null)
			return false;

		Block blk = world.getBlock(x, y, z);

		ForgeDirection direction = ForgeDirection.getOrientation(block.sideHit);
		int fortune = EnchantmentHelper.getFortuneModifier(player);
		boolean silk = EnchantmentHelper.getSilkTouchModifier(player);
		
		switch (mode) {
			case 0:
				break;
				
			case 1: {
				boolean doX = direction.offsetX == 0;
				boolean doY = direction.offsetY == 0;
				boolean doZ = direction.offsetZ == 0;
             if(mode == 1) {
				ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -1 : 0, doY ? -1 : 0, doZ ? -1 : 0, doX ? 2 : 1, doY ? 2 : 1, doZ ? 2 : 1, null, ToolHandler.materialsPick, silk, fortune);
				stack.damageItem(9, player); } else if(mode == 0) {
				ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -1 : 0, doY ? -1 : 0, doZ ? -1 : 0, doX ? 2 : 1, doY ? 2 : 1, doZ ? 2 : 1, null, ToolHandler.materialsPick, silk, fortune);
				stack.damageItem(1, player);}
				break;
			}

		}
		return false;
	}}
