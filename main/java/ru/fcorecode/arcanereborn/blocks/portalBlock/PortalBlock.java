package ru.fcorecode.arcanereborn.blocks.portalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class PortalBlock extends Block {
	
	
	public PortalBlock(String unlocalizedName, Material material, String texturePath) {
		super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
	}
    Block block;
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if(!world.isRemote) {
			if(y >= 59 ) {
			world.setBlock(x, y + 1, z, AFRBlocks._PortFrame1);
			world.setBlock(x, y, z, AFRBlocks._PortalDelBlock);
			world.setBlock(x, y - 1, z, AFRBlocks._PortFrame1);
			world.setBlock(x, y - 1, z + 1, AFRBlocks._portal2);
			world.setBlock(x + 1, y - 1, z, AFRBlocks._portal2);
			world.setBlock(x - 1, y - 1, z, AFRBlocks._portal2);
			world.setBlock(x, y - 1, z - 1, AFRBlocks._portal2);
			world.setBlock(x + 1, y - 1, z + 1, AFRBlocks._portal2);
			world.setBlock(x - 1, y - 1, z - 1, AFRBlocks._portal2);
			world.setBlock(x + 1, y - 1, z - 1, AFRBlocks._portal2);
			world.setBlock(x - 1, y - 1, z + 1, AFRBlocks._portal2);
			world.setBlock(x + 0, y - 1, z + 2, AFRBlocks._PortFrame2);
			world.setBlock(x + 1, y - 1, z + 2, AFRBlocks._PortFrame2);
			world.setBlock(x - 1, y - 1, z + 2, AFRBlocks._PortFrame2);
			//
			world.setBlock(x + 2, y - 1, z - 1, AFRBlocks._PortFrame2);
			world.setBlock(x + 2, y - 1, z - 0, AFRBlocks._PortFrame2);
			world.setBlock(x + 2, y - 1, z + 1, AFRBlocks._PortFrame2);
			//
			world.setBlock(x - 2, y - 1, z - 1, AFRBlocks._PortFrame2);
			world.setBlock(x - 2, y - 1, z + 0, AFRBlocks._PortFrame2);
			world.setBlock(x - 2, y - 1, z + 1, AFRBlocks._PortFrame2);
			//
			world.setBlock(x + 1, y - 1, z - 2, AFRBlocks._PortFrame2);
			world.setBlock(x + 0, y - 1, z - 2, AFRBlocks._PortFrame2);
			world.setBlock(x - 1, y - 1, z - 2, AFRBlocks._PortFrame2);
			//
			world.setBlock(x + 0, y - 2, z + 0, AFRBlocks._PortFrame2);
			world.setBlock(x + 0, y - 2, z + 1, AFRBlocks._PortFrame2);
			world.setBlock(x + 1, y - 2, z + 1, AFRBlocks._PortFrame2);
			world.setBlock(x + 0, y - 2, z - 1, AFRBlocks._PortFrame2);
			world.setBlock(x + 1, y - 2, z + 0, AFRBlocks._PortFrame2);
			world.setBlock(x - 1, y - 2, z - 1, AFRBlocks._PortFrame2);
			world.setBlock(x + 1, y - 2, z - 1, AFRBlocks._PortFrame2);
			world.setBlock(x - 1, y - 2, z + 0, AFRBlocks._PortFrame2);
			world.setBlock(x - 1, y - 2, z + 1, AFRBlocks._PortFrame2);
			//
			world.setBlock(x - 1, y - 1, z - 3, AFRBlocks._PortalLightBlock);
			world.setBlock(x - 2, y - 1, z - 2, AFRBlocks._PortalLightBlock);
			world.setBlock(x - 3, y - 1, z - 1, AFRBlocks._PortalLightBlock);
			//
			world.setBlock(x + 1, y - 1, z + 3, AFRBlocks._PortalLightBlock);
			world.setBlock(x + 2, y - 1, z + 2, AFRBlocks._PortalLightBlock);
			world.setBlock(x + 3, y - 1, z + 1, AFRBlocks._PortalLightBlock);
			//
			world.setBlock(x + 0, y - 1, z + 3, AFRBlocks._PortFrame2);
			world.setBlock(x + 0, y - 1, z - 3, AFRBlocks._PortFrame2);
			world.setBlock(x + 3, y - 1, z + 0, AFRBlocks._PortFrame2);
			world.setBlock(x - 3, y - 1, z + 0, AFRBlocks._PortFrame2);
			//
			world.setBlock(x + 1, y - 1, z - 3, AFRBlocks._PortalLightBlock);
			world.setBlock(x + 2, y - 1, z - 2, AFRBlocks._PortalLightBlock);
			world.setBlock(x + 3, y - 1, z - 1, AFRBlocks._PortalLightBlock);
			//
			world.setBlock(x - 1, y - 1, z + 3, AFRBlocks._PortalLightBlock);
			world.setBlock(x - 2, y - 1, z + 2, AFRBlocks._PortalLightBlock);
			world.setBlock(x - 3, y - 1, z + 1, AFRBlocks._PortalLightBlock);
			//
			world.setBlock(x + 3, y - 1, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y - 1, z - 3, AFRBlocks._PortFrame1);
			world.setBlock(x + 3, y - 0, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y - 0, z - 3, AFRBlocks._PortFrame1);
			world.setBlock(x + 3, y + 1, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y + 1, z - 3, AFRBlocks._PortFrame1);
			//
			world.setBlock(x - 3, y - 1, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y - 1, z - 3, AFRBlocks._PortFrame1);
			world.setBlock(x - 3, y - 0, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y - 0, z - 3, AFRBlocks._PortFrame1);
			world.setBlock(x - 3, y + 1, z - 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y + 1, z - 3, AFRBlocks._PortFrame1);
			//
			world.setBlock(x + 3, y - 1, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y - 1, z + 3, AFRBlocks._PortFrame1);
			world.setBlock(x + 3, y - 0, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y - 0, z + 3, AFRBlocks._PortFrame1);
			world.setBlock(x + 3, y + 1, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x + 2, y + 1, z + 3, AFRBlocks._PortFrame1);
			//
			world.setBlock(x - 3, y - 1, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y - 1, z + 3, AFRBlocks._PortFrame1);
			world.setBlock(x - 3, y - 0, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y - 0, z + 3, AFRBlocks._PortFrame1);
			world.setBlock(x - 3, y + 1, z + 2, AFRBlocks._PortFrame1);
			world.setBlock(x - 2, y + 1, z + 3, AFRBlocks._PortFrame1);
			}else {
				player.addChatMessage(new ChatComponentText("Древняя сила запрещает поставить этот блок на высоте ниже 60 блоков."));
			}

		}
		return blockConstructorCalled;}

}
