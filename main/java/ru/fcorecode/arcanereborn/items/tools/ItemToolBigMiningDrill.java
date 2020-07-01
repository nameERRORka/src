package ru.fcorecode.arcanereborn.items.tools;

import ru.fcorecode.arcanereborn.items.ItemElectricTool;
import ic2.core.IC2;
import ic2.core.init.InternalName;
import ic2.core.item.tool.ItemDrill;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("all")
public class ItemToolBigMiningDrill extends ItemElectricTool {
    protected double operationCost;
    private Set<Object> toolProperties;

    public ItemToolBigMiningDrill(String name, int energyTier, double maxCharge, double transferLimit, boolean providesEnergy, double operationCost) {
    	super(name, energyTier, maxCharge, transferLimit, providesEnergy);
        this.operationCost = operationCost;
        this.toolProperties = new HashSet(Arrays.asList(new Object[] { Items.iron_pickaxe, Items.diamond_shovel }));
    }


    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        if ((toolClass.equals("pickaxe")) || (toolClass.equals("shovel"))) {
            return this.toolMaterial.getHarvestLevel();
        }
        return super.getHarvestLevel(stack, toolClass);
    }


}