package ru.fcorecode.arcanereborn.configs;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.items.AFRItems;

public class EventHandler {
	EntityPlayer pl;
    @SubscribeEvent
    public void onDeath(LivingDeathEvent e)
    {
        if (e.isCanceled()) return;
        if (e.entityLiving instanceof EntityPlayer) {
    		System.out.println("НАМ ПИЗДА");
    		
			//int spawnX = MathHelper.floor_double(pl.serverPosX); 
			//int spawnY = MathHelper.floor_double(pl.serverPosY); 
			//int spawnZ = MathHelper.floor_double(pl.serverPosZ);	
			//System.out.println(spawnX);
			//System.out.println(spawnY);
			//System.out.println(spawnZ);
		//	World world = pl.getEntityWorld();
			//world.spawnParticle(EntitySmokeFX, p_72869_2_, p_72869_4_, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_);
	        //world.setBlock(spawnX, spawnY, spawnZ, AFRBlocks._MagicWood);
    	}
}
}