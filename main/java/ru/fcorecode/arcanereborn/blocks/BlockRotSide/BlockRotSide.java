package ru.fcorecode.arcanereborn.blocks.BlockRotSide;

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
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRotSide extends Block {
	@SideOnly(Side.CLIENT)
    private IIcon blockIcon_side;
    private IIcon blockIcon_back;
    private IIcon blockIcon_front;
    private IIcon blockIcon_top;
    private IIcon blockIcon_bottom;

    public BlockRotSide(Material material) {
        super(material);
    }

    /**Gets the block's texture. Args: side, meta**/
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconReg) {
    	blockIcon_side = iconReg.registerIcon("arcanereborn:MagicWood_right");
    	blockIcon_back = iconReg.registerIcon("arcanereborn:MagicWood_back");
    	blockIcon_front = iconReg.registerIcon("arcanereborn:MagicWood_front");
    	blockIcon_top = iconReg.registerIcon("arcanereborn:MagicWood_top");
    	blockIcon_bottom = iconReg.registerIcon("arcanereborn:MagicWood_bottom");

}
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
    	ForgeDirection dir = ForgeDirection.getOrientation(side);
    	ForgeDirection block_dir;
    	if (meta != 0)
    		block_dir = ForgeDirection.getOrientation(meta);
    	else
    		block_dir = ForgeDirection.WEST;
    		//block_dir = ForgeDirection.SOUTH;
    	if (block_dir == dir) return blockIcon_front;
    	if (block_dir.getOpposite() == dir) return blockIcon_back;
    	if (dir == ForgeDirection.UP) return blockIcon_top;
    	if (dir == ForgeDirection.DOWN) return blockIcon_bottom;
    	if (dir == ForgeDirection.EAST) return blockIcon_side;
    	if (dir == ForgeDirection.NORTH) return blockIcon_side;
    	if (dir == ForgeDirection.SOUTH) return blockIcon_side;
        return blockIcon_side;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
    		EntityLivingBase entity, ItemStack itemStack) {
    	super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        int dir = (MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        int[] r = {2, 5, 3, 4};
        world.setBlockMetadataWithNotify(x, y, z, r[dir], 3);
    }}
