package ru.fcorecode.arcanereborn.dimension;

import net.minecraftforge.common.DimensionManager;

public class Dimensions {
    public static void init() {
    	DimensionManager.registerProviderType(55553, YourWorldProvider.class, false);
    	DimensionManager.registerDimension(55553, 55553); 

}
}