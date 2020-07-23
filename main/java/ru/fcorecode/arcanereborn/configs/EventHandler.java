package ru.fcorecode.arcanereborn.configs;

import java.util.Map;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.items.AFRItems;

public class EventHandler {
	EntityPlayer pl;
    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void onDeath(LivingDeathEvent e)
    {
        if (e.entityLiving instanceof EntityPlayer) {
    		System.out.println("НАМ ПИЗДА");
    		/*
			int spawnX = MathHelper.floor_double(pl.serverPosX); 
			int spawnY = MathHelper.floor_double(pl.serverPosY); 
			int spawnZ = MathHelper.floor_double(pl.serverPosZ);	
			System.out.println(spawnX);
			System.out.println(spawnY);
			System.out.println(spawnZ);
	        world.setBlock(spawnX, spawnY, spawnZ, AFRBlocks._MagicWood);
    	*/
    		World world = pl.getEntityWorld();
    	}
        
}
    boolean isPlace(World world, int x, int z) {

        int solar = 0;
      
        boolean flag = false;
          
            Map<ChunkPosition, TileEntity> map = world.getChunkFromBlockCoords(x, z).chunkTileEntityMap;
            for (Map.Entry<ChunkPosition, TileEntity> entry : map.entrySet()) {
                if (entry.getValue() instanceof TileEntityChest) ++solar;
                if (solar >= 11) flag = true;
                if (flag) break;
            }
          
        return flag;
    }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onBlockPlacement(BlockEvent.PlaceEvent event) {
        if (isPlace(event.world, event.x, event.z)) event.setCanceled(true);
        if (event.isCanceled() == true) {
            event.player.addChatMessage(new ChatComponentText("§8<§cКисочка§8> §8Настя §8: " + "§aВы §aпривысили §aлимит §aданных §aмеханизмов §aв §aэтом §aчанке."));
        }
        }
}
