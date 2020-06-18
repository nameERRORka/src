package ru.fcorecode.arcanereborn.proxy;

import ru.fcorecode.arcanereborn.blocks.AFRBlocks; // load blocks registry class
//import ru.fcorecode.arcanereborn.items.tools. //load items registry class
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ru.fcorecode.arcanereborn.items.AFRItems;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        AFRBlocks.init();
        AFRItems.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
