package ru.fcorecode.arcanereborn.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenJungle;

public class DeadLand extends BiomeGenBase {

	public DeadLand() {
		super(37);
		this.topBlock = Blocks.bedrock;
		this.fillerBlock = Blocks.cobblestone;
	}}