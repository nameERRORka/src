package ru.fcorecode.arcanereborn.blocks.BluePlasma;

import ru.fcorecode.arcanereborn.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public final class CrystallisedBluePlasma extends Block {

    public CrystallisedBluePlasma(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
