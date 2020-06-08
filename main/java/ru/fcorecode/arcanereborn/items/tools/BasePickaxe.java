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
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import net.minecraft.util.StatCollector;

public class BasePickaxe extends ItemPickaxe {
    TickEvent.ServerTickEvent evt;
    EntityPlayer player;
    int mode = 1;


    public BasePickaxe(String name, String texture, int maxStackSize, ToolMaterial baseHAMMER) {
        super(baseHAMMER);
        this.canRepair = false;
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(Main.tabAFRebornTools);
        this.maxStackSize = 1;
        GameRegistry.registerItem(this, name);
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return Rarity._legendary;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
<<<<<<< HEAD
        par3List.add(" " + " ");
        par3List.add(StatCollector.translateToLocal("item.effency.lore") + " " + ModToolMaterial.digSpeedbaseHAMMER);
        par3List.add(" " + " ");
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM1.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM2.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM3.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM4.lore"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM5.lore"));
=======
        par3List.add("" + "");
        par3List.add(StatCollector.translateToLocal("item.effency.name") + " " + ModToolMaterial.digSpeedMEDIUMHAMMER);
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM1.name"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM2.name"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM3.name"));
		par3List.add(StatCollector.translateToLocal("item.par3MEDIUM4.name"));
>>>>>>> master
        int a, b, c;
        a = this.getMaxDamage();
        b = this.getDamage(par1ItemStack);
        c = a - b;
<<<<<<< HEAD
        par3List.add(" " + " ");
        par3List.add(StatCollector.translateToLocal("item.GetDamage.lore") + " " + c + " " + StatCollector.translateToLocal("item.GetDamageL.lore"));
=======
        par3List.add(StatCollector.translateToLocal("item.GetDamage.name") + " " + c + " " + StatCollector.translateToLocal("item.GetDamageL.name"));
>>>>>>> master

    }


    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote) {
            if (mode == 1) {
                player.addChatMessage(new ChatComponentText("Включен режим ночного видения"));
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10000000, 1, true));
                player.removePotionEffect(Potion.blindness.id);
                mode = 2;
            } else if (mode == 2) {
<<<<<<< HEAD
                player.addChatMessage(new ChatComponentText("Р’РєР»СЋС‡РµРЅРѕ СѓСЃРєРѕСЂРµРЅРЅРѕРµ РєРѕРїР°РЅРёРµ"));
=======
                player.addChatMessage(new ChatComponentText("Увеличена скорость копания"));
>>>>>>> master
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10000000, 1, true));
                player.removePotionEffect(Potion.nightVision.id);
                mode = 3;
            } else if (mode == 3) {
<<<<<<< HEAD
                player.addChatMessage(new ChatComponentText("Р’Р°Рј РїСЂРёС€Р»Р° РїРёР·РґР°."));
=======
                player.addChatMessage(new ChatComponentText("Вам пришла пизда"));
>>>>>>> master
                player.addPotionEffect(new PotionEffect(Potion.blindness.id, 10000000, 1, true));
                player.removePotionEffect(Potion.digSpeed.id);
                mode = 0;
            } else if (mode == 0) {
<<<<<<< HEAD
                player.addChatMessage(new ChatComponentText("Р’СЃРµ Р±С‹Р»Рѕ РІС‹РєР»СЋС‡РµРЅРѕ."));
=======
                player.addChatMessage(new ChatComponentText("Все режимы были выключены"));
>>>>>>> master
                player.removePotionEffect(Potion.blindness.id);
                mode = 1;
            }
        }
        itemStack.damageItem(1, player);
        return itemStack;
    }

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