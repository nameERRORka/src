package ru.fcorecode.arcanereborn.configs;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.items.AFRItems;

public class EventHandler {
	EntityPlayer pl;
    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void onDeath(LivingDeathEvent e)
    {
        if (e.isCanceled()) return;
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
}