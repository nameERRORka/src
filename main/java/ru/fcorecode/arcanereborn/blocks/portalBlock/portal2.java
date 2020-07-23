package ru.fcorecode.arcanereborn.blocks.portalBlock;

import java.awt.List;
import java.util.Random;

import javax.annotation.Nonnull;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.PlayerListComponent;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.server.management.UserList;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Tick;
import net.minecraft.stats.StatFileWriter;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.achievementPage.AchievementPage;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.dimension.Dimensions;
import ru.fcorecode.arcanereborn.dimension.FreeTeleporter;
//import net.minecraft.server.management.PlayerList;


public final class portal2 extends Block {
	public long ARK = 1;
	protected WorldServer myWorld;
    public portal2(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
        setBlockUnbreakable();
    }
    @Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
    @Override
    public int getRenderBlockPass()
        {
        return 1;
        }
    
    @Override
	public IIcon getIcon(int side, int meta)
    {
    	return Blocks.portal.getIcon(side, meta);
    }
    
    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
            setBlockBounds( 0F, 0F, 0F, 1.0F, 0.75F, 1.0F);

    }

    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }


    @Override
	public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
    


    
    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        ; // don't load anything
    }
    
    @Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity){
    	    if(entity.ridingEntity == null && entity.riddenByEntity == null && entity.timeUntilPortal <= 0)
    	    	
    	{
    		if (entity instanceof EntityPlayerMP)
    		{  
    			EntityPlayerMP playerMP = (EntityPlayerMP) entity;
                
    			if (playerMP.timeUntilPortal > 0)
    			{
    				
    				playerMP.timeUntilPortal = 10;
    			}
    			else {

    				
    				if (playerMP.dimension != 55553) {
    					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 55553, new FreeTeleporter(playerMP.mcServer.worldServerForDimension(55553)));
    					
    					playerMP.addExperienceLevel(0);
    					int spawnX = MathHelper.floor_double(playerMP.posX); 
    					int spawnY = MathHelper.floor_double(playerMP.posY); 
    					int spawnZ = MathHelper.floor_double(playerMP.posZ); 
    					
    					playerMP.setSpawnChunk(new ChunkCoordinates(spawnX, spawnY, spawnZ), true, 55553);
    					playerMP.triggerAchievement(AchievementPage.DeadPortal);
    					if (!world.isRemote)
    					    if (playerMP.dimension == 55553) {
    					    	    world = playerMP.getEntityWorld();
    					    	    
		
    					    }} else {
    		    				
    					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new FreeTeleporter(playerMP.mcServer.worldServerForDimension(0)));	       
    					playerMP.addExperienceLevel(0);
    				}
    			}
    		}

    		}
    	}
    public boolean tryCreatePortal(World world, int x, int y, int z) {
        byte size1 = 0;
        byte size2 = 0;
        if (world.getBlock(x - 1, y, z) == AFRBlocks._MagicRock || world.getBlock(x + 1, y, z) == AFRBlocks._MagicRock) size1 = 1;
        if (world.getBlock(x, y, z - 1) == AFRBlocks._MagicRock || world.getBlock(x, y, z + 1) == AFRBlocks._MagicRock) size2 = 1;
        if (size1 == size2) return false;
        if (world.isAirBlock(x - size1, y, z - size2)) {
            x -= size1;
            z -= size2;
        }

        for (int i = -1; i <= 2; i++) {
            for (int j = -1; j <= 3; j++) {
                boolean flag = i == -1 || i == 2 || j == -1 || j == 3;
                if (i != -1 && i != 2 || j != -1 && j != 3) {
                    Block b1 = world.getBlock(x + size1 * i, y + j, z + size2 * i);
                    boolean isAir = world.isAirBlock(x + size1 * i, y + j, z + size2 * i);
                    if (flag) {
                        if (b1 != AFRBlocks._MagicRock) return false;
                    } else if (!isAir && b1 != Blocks.fire) return false;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                world.setBlock(x + size1 * i, y + j, z + size2 * i, this, 0, 2);
            }
        }

        return true;
    }



}