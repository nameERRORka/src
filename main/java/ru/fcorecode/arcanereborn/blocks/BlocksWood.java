package ru.fcorecode.arcanereborn.blocks;

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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import ru.fcorecode.arcanereborn.configs.Rarity;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlocksWood extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public final String[] name = new String[] {
            "bottom",
            "top",
            "back",
            "front",
            "left",
            "right"
    };

    public BlocksWood(Material material) {
        super(material);
    }

    /**Called when the block is placed in the world.**/
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    /**Gets the block's texture. Args: side, meta**/
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch(side) {
        case 0:return icons[0];
        case 1:return icons[1];
        /*
        case 2:return icons[2];
        case 3:return icons[3];
        case 4:return icons[4];
        case 5:return icons[5];
         */

        case 2:
            switch(meta) {
            case 0:return icons[3];
            case 1:return icons[5];
            case 2:return icons[2];
            case 3:return icons[4];
            }
            break;

        case 3:
            switch(meta) {
            case 0:return icons[2];
            case 1:return icons[4];
            case 2:return icons[3];
            case 3:return icons[5];
            }
            break;

        case 4:
            switch(meta) {
            case 0:return icons[5];
            case 1:return icons[2];
            case 2:return icons[4];
            case 3:return icons[3];
            }
            break;

        case 5:
            switch(meta) {
            case 0:return icons[4];
            case 1:return icons[3];
            case 2:return icons[5];
            case 3:return icons[2];
            }
            break;

        }
        return super.getIcon(side, meta);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icons = new IIcon[6];
        for (int i = 0; i < icons.length; ++i)
            icons[i] = ir.registerIcon(this.getTextureName() + "_" + name[i]);
    }

}