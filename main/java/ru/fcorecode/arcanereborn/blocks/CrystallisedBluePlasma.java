package ru.fcorecode.arcanereborn.blocks;

import ru.fcorecode.arcanereborn.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class CrystallisedBluePlasma extends Block{

    protected CrystallisedBluePlasma(String unlocalizedName, Material material) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
