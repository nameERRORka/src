package ru.fcorecode.arcanereborn.tabIcons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import ru.fcorecode.arcanereborn.configs.Rarity;
import cpw.mods.fml.relauncher.SideOnly;
import ru.fcorecode.arcanereborn.Main;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import java.util.List;


public class tabIcons extends Item {

    public tabIcons(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.maxStackSize = 0;
        this.canRepair = false;
        GameRegistry.registerItem(this, name);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none) {
        itemDescription.add("" + Rarity._useless.rarityName);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return false;
    }
}
