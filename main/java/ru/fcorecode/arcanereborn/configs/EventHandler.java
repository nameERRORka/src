package ru.fcorecode.arcanereborn.configs;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;

public class EventHandler {
	EntityPlayerMP pl;
    @SubscribeEvent
    public void onDeath(LivingDeathEvent e)
    {
        if (e.isCanceled()) return;
        if (e.entityLiving instanceof EntityPlayer) {
    		System.out.println("АМ ПИЗДА");
			int spawnX = MathHelper.floor_double(pl.posX); 
			int spawnY = MathHelper.floor_double(pl.posY); 
			int spawnZ = MathHelper.floor_double(pl.posZ);	
			System.out.println(spawnX);
			System.out.println(spawnY);
			System.out.println(spawnZ);
			World world = pl.getEntityWorld();
			world.setBlock(spawnX, spawnY, spawnZ, AFRBlocks._MagicWood);
    	}
}
}