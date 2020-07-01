package ru.fcorecode.arcanereborn.dimension;

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
import ru.fcorecode.arcanereborn.biome.DeadLand;

public class WorldProviderDeadLand extends WorldProvider {
	public void registerWorldChunkManager() { // Чанк менеджер
	    this.dimensionId = 55553; // ID мира
	    this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.0F); 
	}
    @Override
    public float getCloudHeight()
    {
        return 128.0F;
    }

    public IChunkProvider createChunkGenerator()
    {
        return terrainType.getChunkGenerator(worldObj, field_82913_c);
    }

	@Override
	public String getDimensionName() {
		return "MagicBook";
	}
	
    public String getSaveFolder()
    {
        return  ("DIM" + dimensionId);
    }
    
    public String setWelcomeMessage()
    {
        if (this instanceof WorldProviderDeadLand)
        {
            return "Земли Арканы2: возвращение приветствуют вас";
        }
        return "Земли Арканы2: возвращение приветствуют вас";
}

 
    

    	}

