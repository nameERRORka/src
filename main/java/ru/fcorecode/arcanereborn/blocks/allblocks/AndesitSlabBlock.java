package ru.fcorecode.arcanereborn.blocks.allblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public final class AndesitSlabBlock extends BlockSlab {

    public AndesitSlabBlock(String unlocalizedName, Material material, String texturePath) {
        super(true, material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
        setBlockUnbreakable();
        useNeighborBrightness = true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	@Override
	public String func_150002_b(int p_150002_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess paramdgtl, int paramInt1, int paramInt2, int paramInt3) {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
	    return true;
	}
    @SideOnly(Side.CLIENT)
    private static boolean isSingleSlab(Block p_150003_0_)
    {
        return p_150003_0_ == AFRBlocks._AndesiteSlab	;
    }

    protected ItemStack createStackedBlock(int meta)
     {
    return new ItemStack(Item.getItemFromBlock(AFRBlocks._AndesiteSlab), 2, 0);
      }
    
    @Override
    public void setBlockBoundsForItemRender()
    {  
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        
    }
    }

