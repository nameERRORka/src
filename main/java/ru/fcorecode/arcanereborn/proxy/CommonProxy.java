package ru.fcorecode.arcanereborn.proxy;

import ru.fcorecode.arcanereborn.blocks.AFBlocks; // load blocks registry class
//import ru.fcorecode.arcanereborn.items.tools. //load items registry class
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        AFBlocks.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
