package ru.fcorecode.arcanereborn.biome;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderDeadLand implements IChunkProvider {

    public class ChunkCoords {
        public final int chunkCoordX;
        public final int chunkCoordZ;

        public ChunkCoords(int X, int Z) {
            this.chunkCoordX = X;
            this.chunkCoordZ = Z;
        }

        public boolean equals(Object o) {
            if (!(o instanceof ChunkCoords)) {
                return false;
            } else {
                ChunkCoords chunkCoords = (ChunkCoords) o;
                return chunkCoords.chunkCoordX == this.chunkCoordX
                        && chunkCoords.chunkCoordZ == this.chunkCoordZ;
            }
        }

        public int hashCode() {
            return this.chunkCoordX + this.chunkCoordZ * 31;
        }
    }


    private World worldObj;
    private Random random;
    private Map chunkTileEntityMap;

    public ChunkProviderDeadLand(World world, long seed) {

        worldObj = world;
        random = new Random(seed);

    }

    @Override
    public boolean chunkExists(int i, int j) {
        return false;
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ) {
        ArcanaChunk arcanaChunk = new ArcanaChunk();

        for (int i = 4; i > 0; i--) {
            DungeonComponentBase room = (DungeonComponentBase) (Rooms.get(random.nextInt(21)));
            if (room instanceof DungeonComponent8 && i >= 3)
                room = (DungeonComponentBase) (Rooms.get(this.random.nextInt(10) + 10));

            room.generate(arcanaChunk, random, 0, i * 8, 0);
        }

        Ceiling.generate(arcanaChunk, random, 0, 40, 0);

        chunkTileEntityMap.put(new ChunkCoords(chunkX, chunkZ), arcanaChunk.chunkTileEntityPositions);

        Chunk chunk = new Chunk(this.worldObj, arcanaChunk.getChunkData(), arcanaChunk.getChunkMetadata(), chunkX, chunkZ);
        chunk.generateSkylightMap();
        BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[]) null, chunkX * 16,
                        chunkZ * 16, 16, 16);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) abiomegenbase[i].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public Chunk loadChunk(int i, int j) {
        return this.provideChunk(i, j);
    }

    @Override
	public void populate(IChunkProvider chunkProvider, int chunkX, int chunkZ) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + 16, z + 16);
		boolean flag = false;
		this.random.setSeed(this.worldObj.getSeed());
		long var8 = this.random.nextLong() / 2L * 2L + 1L;
		long var10 = this.random.nextLong() / 2L * 2L + 1L;
		this.random.setSeed(chunkX * var8 + chunkZ * var10 ^ this.worldObj.getSeed());
		int roomToGenerate;

		Random rand = random;
		Chunk chunk = this.worldObj.getChunkFromChunkCoords(chunkX, chunkZ);

		ChunkCoords chunkCoords = new ChunkCoords(chunkX, chunkZ);
		List<ChunkPosition> chunkTileEntityPositions = (List<ChunkPosition>)chunkTileEntityMap.get(chunkCoords);
		if (chunkTileEntityPositions != null) {
			for (int i = 0; i < chunkTileEntityPositions.size(); i++) {
				ChunkPosition chunkPosition = chunkTileEntityPositions.get(i);
				Block b = chunk.getBlock(chunkPosition.chunkPosX, chunkPosition.chunkPosY, chunkPosition.chunkPosZ);
				TileEntity te = b.createTileEntity(this.worldObj, 0);
				this.worldObj.setTileEntity(x + chunkPosition.chunkPosX, chunkPosition.chunkPosY, z + chunkPosition.chunkPosZ, te);
			}
			chunkTileEntityMap.remove(chunkCoords);
		}
		if ((chunkX & 1) == 1 && (chunkZ & 1) == 1) {
		    for(int i = 1; i < 4; i++) {
    			if(this.random.nextInt(30) == 0 || this.random.nextInt(30) == 0 || this.random.nextInt(30) == 0) {
    	            roomToGenerate = rand.nextInt(2);
    				((WorldGenerator)(BossRooms.get(roomToGenerate))).generate(this.worldObj, rand, x, i * 8, z);
    				this.random.setSeed(chunkX * var8 + chunkZ * var10 ^ this.worldObj.getSeed() * i << 2 | var10);
    				break;
    			}
		    }
		}
	}

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String makeString() {
        return "Arcana";
    }

    @Override
    public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(i, k);
        return biomegenbase == null ? null : biomegenbase.getSpawnableList(enumcreaturetype);
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(int i, int j) {
    }

    @Override
    public void saveExtraData() {
    }

    @Override
    public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5) {
        return null;
    }}


