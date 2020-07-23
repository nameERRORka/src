package ru.fcorecode.arcanereborn.blocks.portalBlock;

import java.util.List;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import ru.fcorecode.arcanereborn.configs.Rarity;

public class PortalLastBlock extends Block {
	
	
	public PortalLastBlock(String unlocalizedName, Material material, String texturePath) {
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
    Event event;
    

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if(!world.isRemote) {
			if(y >= 59 ) {
			player.addChatMessage(new ChatComponentText("Ты потратил свой последний шанс, если сейчас ты свернешь портал - то больше не сможешь его использовать."));
			world.setBlock(x, y + 1, z, AFRBlocks._PortFrame1);
			world.setBlock(x, y, z, AFRBlocks._PortalLastDelBlock);
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

