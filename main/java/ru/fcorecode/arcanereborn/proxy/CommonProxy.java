package ru.fcorecode.arcanereborn.proxy;

import ru.fcorecode.arcanereborn.achievementPage.AchievementPage;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks; // load blocks registry class
import ru.fcorecode.arcanereborn.configs.EventHandler;
import ru.fcorecode.arcanereborn.dimension.Dimensions;
//import ru.fcorecode.arcanereborn.items.tools. //load items registry class
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import ru.fcorecode.arcanereborn.items.AFRItems;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	Dimensions.init();
        AFRBlocks.init();
        AFRItems.init();
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void init(FMLInitializationEvent e) {
    	AchievementPage.init();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
