package ru.fcorecode.arcanereborn.blocks.portalBlock;

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
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class PortalFrame2 extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public final String[] name = new String[] {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5"
    };
	public PortalFrame2(String unlocalizedName, Material material) {
		super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(0F);
        this.setResistance(0F);
        this.setLightLevel(0F);
        this.setStepSound(soundTypeStone);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + unlocalizedName + "/_" + unlocalizedName);
        setBlockUnbreakable();
	}

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
