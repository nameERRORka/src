package ru.fcorecode.arcanereborn.items.tools;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.ForgeDirection;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.configs.RandomUtils;
import ru.fcorecode.arcanereborn.configs.Rarity;
import ru.fcorecode.arcanereborn.enchant.EnchantmentRegistry;
import ru.fcorecode.arcanereborn.items.AFRItems;
import ru.fcorecode.arcanereborn.items.ToolHandler;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;

public class ZeroHammer extends ItemPickaxe {
    public int mode = 0;	
    public String namemode = "";
    public ZeroHammer(String name, String texture, int maxStackSize, ToolMaterial ZeroHammer) {
        super(ZeroHammer);
        this.canRepair = false;
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornTools);
        this.maxStackSize = 1;
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return Rarity._legendary;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none) {
        itemDescription.add("" + Rarity._legendary.rarityColor + Rarity._legendary.rarityName);
        itemDescription.add(" " + " ");
        itemDescription.add(StatCollector.translateToLocal("item.efficiency.lore") + " " + ModToolMaterial.digSpeedZeroHAMMER);
        itemDescription.add(" " + " ");
		itemDescription.add(StatCollector.translateToLocal("item.ZeroHammerLore1.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.ZeroHammerLore2.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.ZeroHammerLore3.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.ZeroHammerLore4.lore"));
//		itemDescription.add(StatCollector.translateToLocal("item.ZeroHammerLore5.lore"));
	    itemDescription.add(" " + " ");
		itemDescription.add(StatCollector.translateToLocal("item.HammerMode.lore")+ " " + mode);
        int a, b, c;
        a = this.getMaxDamage();
        b = this.getDamage(stack);
        c = a - b;

        itemDescription.add(" " + " ");
        itemDescription.add(StatCollector.translateToLocal("item.GetDamage.lore") + " " + c + " " + StatCollector.translateToLocal("item.GetDamageL.lore"));
        if( stack.stackTagCompound == null ) {
        stack.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }



    public void onUpdate (ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(stack, world, entity, par4, par5);
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if(player.inventory.hasItem(AFRItems._goldenCoin)) {
            	mode = 1;
            } else {
            	mode = 0;
            }
        

}}	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
	World world = player.worldObj;
	Material mat = world.getBlock(x, y, z).getMaterial();
	if (!ToolHandler.isRightMaterial(mat, ToolHandler.materialsPick))
		return false;

	MovingObjectPosition block = ToolHandler.raytraceFromEntity(world, player, true, 4.5);
	if (block == null)
		return false;

	Block blk = world.getBlock(x, y, z);

	ForgeDirection direction = ForgeDirection.getOrientation(block.sideHit);
	int fortune = EnchantmentHelper.getFortuneModifier(player);
	boolean silk = EnchantmentHelper.getSilkTouchModifier(player);
	
	switch (mode) {
		case 0:
			break;
			
		case 1: {
			boolean doX = direction.offsetX == 0;
			boolean doY = direction.offsetY == 0;
			boolean doZ = direction.offsetZ == 0;
         if(mode == 1) {
			ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -1 : 0, doY ? -1 : 0, doZ ? -1 : 0, doX ? 1 : 1, doY ? 2 : 1, doZ ? 1 : 1, null, ToolHandler.materialsPick, silk, fortune);
			stack.damageItem(3, player); } else if(mode == 0) {
			break;
		}

	
	
}}
	return false;}
}