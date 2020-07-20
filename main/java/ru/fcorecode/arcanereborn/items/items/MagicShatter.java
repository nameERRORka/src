package ru.fcorecode.arcanereborn.items.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.Rarity;

public final class MagicShatter extends Item {

    public MagicShatter(String unlocalizedName, String texture) {
        this.canRepair = false;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornAnother);
    }

    @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none)
	{
		itemDescription.add("" + Rarity._useless.rarityName);
	}
    }
    
