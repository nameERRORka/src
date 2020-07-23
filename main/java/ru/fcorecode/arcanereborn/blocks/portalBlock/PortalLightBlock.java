package ru.fcorecode.arcanereborn.blocks.portalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public final class PortalLightBlock extends Block {

    public PortalLightBlock(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeGlass);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
        setBlockUnbreakable();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

