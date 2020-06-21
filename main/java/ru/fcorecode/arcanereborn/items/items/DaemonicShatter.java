package ru.fcorecode.arcanereborn.items.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.Rarity;

import java.util.List;

public final class DaemonicShatter extends Item {

    public DaemonicShatter(String unlocalizedName, String texture) {
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
