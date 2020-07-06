package ru.fcorecode.arcanereborn.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import ru.fcorecode.arcanereborn.blocks.BluePlasma.CrystallisedBluePlasma;
import ru.fcorecode.arcanereborn.blocks.GrassTrable.GrassTrable;
import ru.fcorecode.arcanereborn.blocks.MagicRock.MagicRock;
import ru.fcorecode.arcanereborn.blocks.MagickWood.MagicWood;
import ru.fcorecode.arcanereborn.blocks.portalBlock.portal2;


public final class AFRBlocks {

    public static Block _CrystallisedBluePlasma;
    public static Block _MagicWood;
    public static Block _MagicRock;
    public static Block _GrassTrable;
    public static Block _portal2;
    public static Block _Sapling;

    
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
       
    }
}
