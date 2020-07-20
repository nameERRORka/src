package ru.fcorecode.arcanereborn.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ToolHandler extends MiningCore {

	public static Material[] materialsPick = new Material[]{ Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil };
	public static Material[] materialShov = new Material[] { Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil, Material.grass, Material.ground, Material.sand, Material.snow, Material.craftedSnow, Material.clay };

	
	public static boolean isRightMaterial(Material material, Material[] materialsListing) {
		for (Material mat : materialsListing)
			if (material == mat)
				return true;

		return false;
	}
	
	public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean par3, double range) {
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
		double d1 = player.prevPosY + (player.posY - player.prevPosY) * f;
		if (!world.isRemote && player instanceof EntityPlayer)
			d1 += 1.62D;
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
		Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
		float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
		float f5 = -MathHelper.cos(-f1 * 0.017453292F);
		float f6 = MathHelper.sin(-f1 * 0.017453292F);
		float f7 = f4 * f5;
		float f8 = f3 * f5;
		double d3 = range;
		if (player instanceof EntityPlayerMP)
			d3 = ((EntityPlayerMP) player).theItemInWorldManager.getBlockReachDistance();
		Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
		return world.rayTraceBlocks(vec3, vec31, par3);
	}




public static void removeBlocksInIteration(EntityPlayer player, World world, int x, int y, int z, int xs, int ys, int zs, int xe, int ye, int ze, Block block, Material[] materialsListing, boolean silk, int fortune) {
	float blockHardness = (block == null) ? 1.0f : block.getBlockHardness(world, x, y, z);
	for (int x1 = xs; x1 < xe; x1++) {
		for (int y1 = ys; y1 < ye; y1++) {
			for (int z1 = zs; z1 < ze; z1++) {
				if (x != x1 && y != y1 && z != z1) {
					ToolHandler.removeBlockWithDrops(player, world, x1 + x, y1 + y, z1 + z, x, y, z, block, materialsListing, silk, fortune, blockHardness);

				}
			}
		}
	}
}

public static void removeBlockWithDrops(EntityPlayer player, World world, int x, int y, int z, int bx, int by, int bz, Block block, Material[] materialsListing, boolean silk, int fortune, float blockHardness) {
	if (!world.blockExists(x, y, z))
		return;

	Block blk = world.getBlock(x, y, z);

	if (block != null && blk != block)
		return;

	int meta = world.getBlockMetadata(x, y, z);
	Material mat = world.getBlock(x, y, z).getMaterial();
		if (!blk.canHarvestBlock(player, meta) || !isRightMaterial(mat, materialsListing))
			return;

		if (!player.capabilities.isCreativeMode && blk != Blocks.bedrock) {
			int localMeta = world.getBlockMetadata(x, y, z);
			if (blk.removedByPlayer(world, player, x, y, z)) {
				blk.onBlockDestroyedByPlayer(world, x, y, z, localMeta);
			}
			blk.harvestBlock(world, player, x, y, z, localMeta);
			blk.onBlockHarvested(world, x, y, z, localMeta, player);
		} else {
			world.setBlockToAir(x, y, z);
		}
	}
}




