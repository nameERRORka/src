package ru.fcorecode.arcanereborn.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;


public final class AFBlocks {

    public static Block CrystallisedBluePlasma;
    public static void init() {
        GameRegistry.registerBlock(CrystallisedBluePlasma = new CrystallisedBluePlasma("CrystallisedBluePlasma", Material.iron, "CrystallisedBluePlasma/CrystallisedBluePlasma"), "CrystallisedBluePlasma");
    }
}
