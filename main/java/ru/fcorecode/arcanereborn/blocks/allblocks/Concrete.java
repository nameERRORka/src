package ru.fcorecode.arcanereborn.blocks.allblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public final class Concrete extends Block {
	public final String[] name = new String[] {
	        "concrete_0",
	        "concrete_1",
	        "concrete_2",
	        "concrete_3",
	        "concrete_4",
	        "concrete_5",
	        "concrete_6",
	        "concrete_7",
	        "concrete_8",
	        "concrete_9",
	        "concrete_10",
	        "concrete_11",
	        "concrete_12",
	        "concrete_13",
	        "concrete_14",
	        "concrete_15",
	};
    public Concrete(String unlocalizedName, String texturePath) {
        super(Material.rock);
        this.setBlockName("concrete" + unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
        this.setLightOpacity(0);
        setBlockUnbreakable();
        for (int i = 0; i < name.length; i++)
            GameRegistry.registerBlock(this, name[i]);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

