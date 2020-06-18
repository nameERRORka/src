package ru.fcorecode.arcanereborn.blocks.MagicRock;

import ru.fcorecode.arcanereborn.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public final class MagicRock extends Block {

    public MagicRock(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(3.0F);
        this.setResistance(15.0F);
        this.setLightLevel(3.0F);
        this.setHarvestLevel("pickaxe", 4);
        this.setStepSound(soundTypeStone);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
