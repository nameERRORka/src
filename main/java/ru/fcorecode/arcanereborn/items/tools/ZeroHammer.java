package ru.fcorecode.arcanereborn.items.tools;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Direction;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import ru.fcorecode.arcanereborn.configs.Rarity;
import ru.fcorecode.arcanereborn.enchant.EnchantmentRegistry;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import net.minecraft.util.StatCollector;

public class ZeroHammer extends ItemPickaxe {
    public int mode = 4;	
    public String namemode = "none";
    public ZeroHammer(String name, String texture, int maxStackSize, ToolMaterial ZeroHammer) {
        super(ZeroHammer);
        this.canRepair = false;
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornTools);
        this.maxStackSize = 1;
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return Rarity._legendary;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
        par3List.add(" " + " ");
        par3List.add(StatCollector.translateToLocal("item.efficiency.lore") + " " + ModToolMaterial.digSpeedZeroHAMMER);
        par3List.add(" " + " ");
		par3List.add(StatCollector.translateToLocal("item.par2zero1.lore"));
		par3List.add(StatCollector.translateToLocal("item.par2zero2.lore"));
		par3List.add(StatCollector.translateToLocal("item.par2zero3.lore"));
		par3List.add(StatCollector.translateToLocal("item.par2zero4.lore"));
		par3List.add(StatCollector.translateToLocal("item.par2zero5.lore"));
	    par3List.add(" " + " ");
		par3List.add(StatCollector.translateToLocal("item.par3mode.lore")+ " " + namemode);
        int a, b, c;
        a = this.getMaxDamage();
        b = this.getDamage(par1ItemStack);
        c = a - b;

        par3List.add(" " + " ");
        par3List.add(StatCollector.translateToLocal("item.GetDamage.lore") + " " + c + " " + StatCollector.translateToLocal("item.GetDamageL.lore"));
        if( par1ItemStack.stackTagCompound == null ) {
        par1ItemStack.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);
        }
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }


    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote) {
            if (mode == 1) {

                player.addChatMessage(new ChatComponentText("Ночное видение"));
                mode = 2;
                namemode = "NightVision";
            } else if (mode == 2) {
                player.addChatMessage(new ChatComponentText("Увеличение урона"));
                mode = 3;
                namemode = "DamageBoost";
            } else if (mode == 3) {
                player.addChatMessage(new ChatComponentText("Без эффектов"));
                mode = 4;
                namemode = "none";
            } else if (mode == 4) {
                player.addChatMessage(new ChatComponentText("Утомление"));
                mode = 1;
                namemode = "digSlowDown";
            }
        }
        
        itemStack.damageItem(1, player);
        return itemStack;
    }
    public void onUpdate (ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(stack, world, entity, par4, par5);
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack && mode == 1){
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2, 2, true));
            } else if (equipped == stack && mode == 2) {
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2, 2, true));
            } else if (equipped == stack && mode == 3) {
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2, 2, true));
            } else if (equipped == stack && mode == 0) {
            	player.removePotionEffect(Potion.damageBoost.id);
            }
        

}}

}