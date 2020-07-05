package ru.fcorecode.arcanereborn.dimension;

import net.minecraft.world.WorldServer;
import net.minecraft.world.Teleporter;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FreeTeleporter extends Teleporter {

    public FreeTeleporter(WorldServer worldIn) {
        super(worldIn);
    }
    EntityPlayer player;
	    public void placeInPortal(Entity entityIn, float rotationYaw) {
	    	    player.setPosition(255.0D, 255.0D, 255.0D);
	    	    
	    	}

			
	    

    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
		return true;
    }

    public boolean makePortal(Entity entityIn) {
        return true;
    }
}