package ru.fcorecode.arcanereborn.dimension;

import net.minecraft.world.WorldServer;
import net.minecraft.world.Teleporter;
import net.minecraft.entity.Entity;

public class FreeTeleporter extends Teleporter {

    public FreeTeleporter(WorldServer worldIn) {
        super(worldIn);
    }

    public void placeInPortal(Entity entityIn, float rotationYaw) {
    }

    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        return true;
    }

    public boolean makePortal(Entity entityIn) {
        return true;
    }
}