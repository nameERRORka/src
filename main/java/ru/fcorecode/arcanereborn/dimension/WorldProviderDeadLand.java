package ru.fcorecode.arcanereborn.dimension;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;


public class WorldProviderDeadLand extends WorldProvider {
	@Override
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.5F);
        this.dimensionId = 55553;
    }

    @Override
    protected void generateLightBrightnessTable()
    {
        float var1 = 0.1F;

        for (int var2 = 0; var2 <= 15; ++var2)
        {
            float var3 = 1.0F - var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    @Override
    public float getCloudHeight()
    {
        return 128.0F;
    }



    @Override
    public boolean isSurfaceWorld()
    {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3)
    {
        return 0F;
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public String getSaveFolder() {
    	return "Arcana";
    }

    @Override
    public String getDimensionName()
    {
        return "Arcana";
    }
    @Override
    public boolean canCoordinateBeSpawn(int p_76566_1_, int p_76566_2_)
    {
        return this.worldObj.getTopBlock(p_76566_1_, p_76566_2_) == Blocks.grass;
        
    }
    	
    @Override
    public void setSpawnPoint(int x, int y, int z)
    {
        y = 100;
        while(worldObj.getBlock(x, y--, z) == Blocks.air ){
        	System.out.println("Y = " + y);
        	continue;
        	}
        worldObj.getWorldInfo().setSpawnPosition(x, y, z);
    }
}