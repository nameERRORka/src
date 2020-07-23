package ru.fcorecode.arcanereborn.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import ru.fcorecode.arcanereborn.blocks.BluePlasma.CrystallisedBluePlasma;
import ru.fcorecode.arcanereborn.blocks.GrassTrable.GrassTrable;
import ru.fcorecode.arcanereborn.blocks.MagicRock.MagicRock;
import ru.fcorecode.arcanereborn.blocks.MagickWood.MagicWood;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalBlock;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalDelBlock;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalFrame1;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalFrame2;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalLastBlock;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalLastDelBlock;
import ru.fcorecode.arcanereborn.blocks.portalBlock.PortalLightBlock;
import ru.fcorecode.arcanereborn.blocks.portalBlock.portal2;


public final class AFRBlocks {

    public static Block _CrystallisedBluePlasma;
    public static Block _MagicWood;
    public static Block _MagicRock;
    public static Block _GrassTrable;
    public static Block _portal2;
    public static Block _PortalBlock;
    public static Block _PortalDelBlock;
    public static Block _PortalLastBlock;
    public static Block _PortalLastDelBlock;
    public static Block _Sapling;
    public static Block _PortFrame1;
    public static Block _PortFrame2;
    public static Block _PortalLightBlock;


    
    public static void init() {

        _CrystallisedBluePlasma = new CrystallisedBluePlasma("CrystallisedBluePlasma", Material.iron, "CrystallisedBluePlasma/CrystallisedBluePlasma");
        GameRegistry.registerBlock(_CrystallisedBluePlasma, "CrystallisedBluePlasma");

        _MagicWood = new MagicWood("MagicWood", Material.wood);
        GameRegistry.registerBlock(_MagicWood, "MagicWood");
        
        _GrassTrable = new GrassTrable("GrassTrable", Material.grass);
        GameRegistry.registerBlock(_GrassTrable, "MagicGrass");
        
        _MagicRock = new MagicRock("MagicRock", Material.rock, "MagicRock/_MagicRock");
        GameRegistry.registerBlock(_MagicRock, "MagicRock");

        _portal2 = new portal2("Portal2", Material.portal, "Portal/_portal");
        GameRegistry.registerBlock(_portal2, "Portal2");
        
        _PortalBlock = new PortalBlock("PortalBlock", Material.iron, "Portal/_portal");
        GameRegistry.registerBlock(_PortalBlock, "Portal_Block");
        
        _PortalLastBlock = new PortalLastBlock("PortalLastBlock", Material.iron, "Portal/_portallast");
        GameRegistry.registerBlock(_PortalLastBlock, "Portal_LastBlock");
        
        _PortalDelBlock = new PortalDelBlock("PortalDelBlock", Material.iron, "PortalDel/_portal");
        GameRegistry.registerBlock(_PortalDelBlock, "Portal_DelBlock"); 
        
        _PortalLastDelBlock = new PortalLastDelBlock("PortalLastDelBlock", Material.iron, "PortalDel/_portalLast");
        GameRegistry.registerBlock(_PortalLastDelBlock, "Portal_LastDelBlock"); 
        
        _PortFrame1 = new PortalFrame1("PortalFrameBlock", Material.rock);
        GameRegistry.registerBlock(_PortFrame1, "PortalFrame1");
        
        _PortFrame2 = new PortalFrame2("PortalFrameBlock2", Material.rock);
        GameRegistry.registerBlock(_PortFrame2, "PortalFrame2");
        
        _PortalLightBlock = new PortalLightBlock("PortalLightBlock", Material.redstoneLight, "PortalLightBlock/PortalLightBlock");
        GameRegistry.registerBlock(_PortalLightBlock, "PortalLightBlock");
        
       
    }
}
