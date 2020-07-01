package ru.fcorecode.arcanereborn.blocks.portalBlock;

import java.awt.List;

import javax.annotation.Nonnull;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.PlayerListComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.server.management.UserList;
import net.minecraftforge.common.DimensionManager;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.dimension.FreeTeleporter;
//import net.minecraft.server.management.PlayerList;


public final class portal2 extends Block {
    public portal2(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
    }
   // public static List<EntityPlayerMP> getAllPlayers() {
   //     return FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().playerEntityList;
   // }
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f0, float f1, float f2){
        if (!world.isRemote) {
            if ((player.ridingEntity == null) && (player.riddenByEntity == null)
                    && ((player instanceof EntityPlayerMP))) { //
                EntityPlayerMP playerMP = (EntityPlayerMP) player;
                if (playerMP.dimension != 55553) {
                    MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)player, 55553, new FreeTeleporter(DimensionManager.getWorld(55553)));
                } else if (playerMP.dimension == 55553) {
                	MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)player, 0, new FreeTeleporter(DimensionManager.getWorld(0)));
                }
                
            }
    
    }
		return blockConstructorCalled;
}
}