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

public class YourWorldProvider extends WorldProvider {
	public void registerWorldChunkManager() { // Чанк менеджер
	    this.dimensionId = 55553; // ID мира
	    this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.jungle, 0.0F); // Чанк менеджер, например тут генерация будет как замёрзший океан
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
        return  ("DIMA" + dimensionId);
    }
    
    public String getWelcomeMessage()
    {
        if (this instanceof YourWorldProvider)
        {
            return "Вы входите в пиздец какую опасную зону";
        }
        return null;
}
    public boolean canCoordinateBeSpawn(int p_76566_1_, int p_76566_2_)
    {
        return this.worldObj.getTopBlock(p_76566_1_, p_76566_2_) == Blocks.grass;
    }
    public ChunkCoordinates getEntrancePortalLocation()
    {
        return null;
    }

    	}

