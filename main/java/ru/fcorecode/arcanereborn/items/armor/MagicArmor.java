package ru.fcorecode.arcanereborn.items.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import ru.fcorecode.arcanereborn.configs.Rarity;

public abstract class MagicArmor extends ItemArmor implements ISpecialArmor
{
    private static int[] damageReductionAmountArray = new int[] { 100, 250, 200, 150 };
    private int damageReduceAmount;
	private final String texturePath;
    public MagicArmor(String name, String iconPath, String texturePath, int maxStackSize, int id, int armorType)
    {
        super(ModToolMaterial.armorMaterial, id, armorType);
        this.setUnlocalizedName(name);
		this.setTextureName(String.format("%s:%s", Main.MODID, iconPath));
		this.setCreativeTab(ConfigInfo.tabAFRebornWaA);
        this.setMaxDamage(damageReductionAmountArray[armorType]);
		this.texturePath = String.format("%s:textures/model/armor/%s", Main.MODID, texturePath);
		GameRegistry.registerItem(this, name);
        
    }
    
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
		return this.texturePath;
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
	{
		return Rarity._legendary;
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {       
	    return 10;
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
	    return new ArmorProperties(1, 100, 100);
	}

	
}
    


