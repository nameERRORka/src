package ru.fcorecode.arcanereborn.blocks.DeathBlock;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class DeathBlock extends Block {
	
    public DeathBlock(String unlocalizedName, Material material, String texturePath) {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(ConfigInfo.tabAFRebornBlocks);
        this.setHardness(5000.0F);
        this.setResistance(5000.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 50000);
        this.setStepSound(soundTypeStone);
        this.setLightOpacity(0);
        this.setBlockTextureName(Main.MODID + ":" + texturePath);
    }}

