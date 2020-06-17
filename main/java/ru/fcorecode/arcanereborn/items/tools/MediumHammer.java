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

public class MediumHammer extends ItemPickaxe {
    public int mode = 4;
    public String namemode = "none";
    public MediumHammer(String name, String texture, int maxStackSize, ToolMaterial MediumHammer) {
        super(MediumHammer);
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
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
        par3List.add(" " + " ");
        par3List.add(StatCollector.translateToLocal("item.effency.lore") + " " + ModToolMaterial.digSpeedMEDIUMHAMMER);
        par3List.add(" " + " ");
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM1.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM2.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM3.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM4.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM5.lore"));
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
    @Override
    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
        World world = player.worldObj;
        Block block = world.getBlock(x, y, z);

        MovingObjectPosition object = RandomUtils.raytraceFromEntity(world, player, false, 4.5D);

        if (object == null) {
            return super.onBlockDestroyed(stack, world, block, x, y, z, player);
        }

        int side = object.sideHit;
        int xmove = 0;
        int ymove = 0;
        int zmove = 0;

        if (side == 0 || side == 1) {
            xmove = 1;
            zmove = 1;
        } else {
            ymove = 1;
            if (side == 4 || side == 5) {
                zmove = 1;
            } else {
                xmove = 1;
            }
        }

        float strength = ForgeHooks.blockStrength(block, player, world, x, y, z);

        if (player.isSneaking() && ConfigInfo.EnableHammerShiftOneBlock &&
            (player.experienceLevel >= 20 || player.capabilities.isCreativeMode)) {
            checkBlockBreak(world, player, x, y, z, stack, strength, block, side);
        } else {
            for (int i = -xmove; i <= xmove; i++) {
                for (int j = -ymove; j <= ymove; j++) {
                    for (int k = -zmove; k <= zmove; k++) {
                        if (i != x && j != y && k != z) {
                            checkBlockBreak(world, player, x + i, y + j, z + k, stack, strength, block, side);
                        }
                    }
                }
            }
        }
        return false;
    }

    public void checkBlockBreak(World world, EntityPlayer player, int x, int y, int z, ItemStack stack, float strength, Block originalBlock, int side) {
        Block breakBlock = world.getBlock(x, y, z);

        if (this.canHarvestBlock(breakBlock, stack)) {
            float newStrength = ForgeHooks.blockStrength(breakBlock, player, world, x, y, z);
            Material material = originalBlock.getMaterial();

            if (newStrength > 0f && strength / newStrength <= 10f && breakBlock.getMaterial() == material) {
                RandomUtils.breakBlock(world, breakBlock, x, y, z, side, player);

                if ((double) breakBlock.getBlockHardness(world, x, y, z) != 0.0D) {
                    stack.damageItem(1, player);
                }
            }
        }
    }
}