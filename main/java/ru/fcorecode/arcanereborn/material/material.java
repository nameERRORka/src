
package ru.fcorecode.arcanereborn.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.material.MaterialLogic;
import net.minecraft.block.material.MaterialPortal;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraft.world.World;

public class material {
	public static Material[] materialsPick = new Material[]{ Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil };
	public static Material[] materialsShovel = new Material[]{ Material.grass, Material.ground, Material.sand, Material.snow, Material.craftedSnow, Material.clay };
	public static Material[] materialsAxe = new Material[]{ Material.coral, Material.leaves, Material.plants, Material.wood, Material.gourd };
	private static final Material[] MATERIALS = new Material[] { Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil, Material.grass, Material.ground, Material.sand, Material.snow, Material.craftedSnow, Material.clay };
	public static boolean isRightMaterial(Material material, Material[] materialsListing) {
		for(Material mat : materialsListing)
			if(material == mat)
				return true;

		return false;
	}
}
