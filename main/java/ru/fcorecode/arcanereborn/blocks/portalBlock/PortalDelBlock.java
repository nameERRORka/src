package ru.fcorecode.arcanereborn.blocks.portalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class PortalDelBlock extends Block {
	
	
	public PortalDelBlock(String unlocalizedName, Material material, String texturePath) {
		super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setLightLevel(3.0F);
        this.setStepSound(soundTypeMetal);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
        setBlockUnbreakable();
	}
    Block block;
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if(!world.isRemote) {
			if(y >= 59 ) {
			world.setBlock(x, y + 1, z, Blocks.air);
			world.setBlock(x, y, z, Blocks.air);
			world.setBlock(x, y - 1, z, Blocks.air);
			world.setBlock(x, y - 1, z + 1, Blocks.air);
			world.setBlock(x + 1, y - 1, z, Blocks.air);
			world.setBlock(x - 1, y - 1, z, Blocks.air);
			world.setBlock(x, y - 1, z - 1, Blocks.air);
			world.setBlock(x + 1, y - 1, z + 1, Blocks.air);
			world.setBlock(x - 1, y - 1, z - 1, Blocks.air);
			world.setBlock(x + 1, y - 1, z - 1, Blocks.air);
			world.setBlock(x - 1, y - 1, z + 1, Blocks.air);
			world.setBlock(x + 0, y - 1, z + 2, Blocks.air);
			world.setBlock(x + 1, y - 1, z + 2, Blocks.air);
			world.setBlock(x - 1, y - 1, z + 2, Blocks.air);
			//
			world.setBlock(x + 2, y - 1, z - 1, Blocks.air);
			world.setBlock(x + 2, y - 1, z - 0, Blocks.air);
			world.setBlock(x + 2, y - 1, z + 1, Blocks.air);
			//
			world.setBlock(x - 2, y - 1, z - 1, Blocks.air);
			world.setBlock(x - 2, y - 1, z + 0, Blocks.air);
			world.setBlock(x - 2, y - 1, z + 1, Blocks.air);
			//
			world.setBlock(x + 1, y - 1, z - 2, Blocks.air);
			world.setBlock(x + 0, y - 1, z - 2, Blocks.air);
			world.setBlock(x - 1, y - 1, z - 2, Blocks.air);
			//
			world.setBlock(x + 0, y - 2, z + 0, Blocks.air);
			world.setBlock(x + 0, y - 2, z + 1, Blocks.air);
			world.setBlock(x + 1, y - 2, z + 1, Blocks.air);
			world.setBlock(x + 0, y - 2, z - 1, Blocks.air);
			world.setBlock(x + 1, y - 2, z + 0, Blocks.air);
			world.setBlock(x - 1, y - 2, z - 1, Blocks.air);
			world.setBlock(x + 1, y - 2, z - 1, Blocks.air);
			world.setBlock(x - 1, y - 2, z + 0, Blocks.air);
			world.setBlock(x - 1, y - 2, z + 1, Blocks.air);
			//
			world.setBlock(x - 1, y - 1, z - 3, Blocks.air);
			world.setBlock(x - 2, y - 1, z - 2, Blocks.air);
			world.setBlock(x - 3, y - 1, z - 1, Blocks.air);
			//
			world.setBlock(x + 1, y - 1, z + 3, Blocks.air);
			world.setBlock(x + 2, y - 1, z + 2, Blocks.air);
			world.setBlock(x + 3, y - 1, z + 1, Blocks.air);
			//
			world.setBlock(x + 0, y - 1, z + 3, Blocks.air);
			world.setBlock(x + 0, y - 1, z - 3, Blocks.air);
			world.setBlock(x + 3, y - 1, z + 0, Blocks.air);
			world.setBlock(x - 3, y - 1, z + 0, Blocks.air);
			//
			world.setBlock(x + 1, y - 1, z - 3, Blocks.air);
			world.setBlock(x + 2, y - 1, z - 2, Blocks.air);
			world.setBlock(x + 3, y - 1, z - 1, Blocks.air);
			//
			world.setBlock(x - 1, y - 1, z + 3, Blocks.air);
			world.setBlock(x - 2, y - 1, z + 2, Blocks.air);
			world.setBlock(x - 3, y - 1, z + 1, Blocks.air);
			//
			world.setBlock(x + 3, y - 1, z - 2, Blocks.air);
			world.setBlock(x + 2, y - 1, z - 3, Blocks.air);
			world.setBlock(x + 3, y - 0, z - 2, Blocks.air);
			world.setBlock(x + 2, y - 0, z - 3, Blocks.air);
			world.setBlock(x + 3, y + 1, z - 2, Blocks.air);
			world.setBlock(x + 2, y + 1, z - 3, Blocks.air);
			//
			world.setBlock(x - 3, y - 1, z - 2, Blocks.air);
			world.setBlock(x - 2, y - 1, z - 3, Blocks.air);
			world.setBlock(x - 3, y - 0, z - 2, Blocks.air);
			world.setBlock(x - 2, y - 0, z - 3, Blocks.air);
			world.setBlock(x - 3, y + 1, z - 2, Blocks.air);
			world.setBlock(x - 2, y + 1, z - 3, Blocks.air);
			//
			world.setBlock(x + 3, y - 1, z + 2, Blocks.air);
			world.setBlock(x + 2, y - 1, z + 3, Blocks.air);
			world.setBlock(x + 3, y - 0, z + 2, Blocks.air);
			world.setBlock(x + 2, y - 0, z + 3, Blocks.air);
			world.setBlock(x + 3, y + 1, z + 2, Blocks.air);
			world.setBlock(x + 2, y + 1, z + 3, Blocks.air);
			//
			world.setBlock(x - 3, y - 1, z + 2, Blocks.air);
			world.setBlock(x - 2, y - 1, z + 3, Blocks.air);
			world.setBlock(x - 3, y - 0, z + 2, Blocks.air);
			world.setBlock(x - 2, y - 0, z + 3, Blocks.air);
			world.setBlock(x - 3, y + 1, z + 2, Blocks.air);
			world.setBlock(x - 2, y + 1, z + 3, Blocks.air);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(AFRBlocks._PortalLastBlock)));


		}}
		return blockConstructorCalled;}}



