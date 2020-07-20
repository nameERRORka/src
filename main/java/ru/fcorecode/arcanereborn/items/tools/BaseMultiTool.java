package ru.fcorecode.arcanereborn.items.tools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;
import ru.fcorecode.arcanereborn.items.ToolHandler;
import ru.fcorecode.arcanereborn.items.tools.toolsbase.MultiToolBase;

public class BaseMultiTool extends MultiToolBase {
    public int mode = 1;
    public String namemode = "none";
    public BaseMultiTool(String name, String texture, int maxStackSize, ToolMaterial BaseMultiTool) {
        super(BaseMultiTool);
        this.canRepair = false;
        this.setHarvestLevel("pickaxe", 10);
        this.setHarvestLevel("shovel", 10);
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornTools);
        this.maxStackSize = 1;
    }
    
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		World world = player.worldObj;
		Material mat = world.getBlock(x, y, z).getMaterial();
		if (!ToolHandler.isRightMaterial(mat, ToolHandler.materialShov))
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
				ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -1 : 0, doY ? -1 : 0, doZ ? -1 : 0, doX ? 2 : 1, doY ? 2 : 1, doZ ? 2 : 1, null, ToolHandler.materialShov, silk, fortune);
				stack.damageItem(9, player); } else if(mode == 0) {
				ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -1 : 0, doY ? -1 : 0, doZ ? -1 : 0, doX ? 2 : 1, doY ? 2 : 1, doZ ? 2 : 1, null, ToolHandler.materialsPick, silk, fortune);
				stack.damageItem(1, player);}
				break;
			}

		}
		return false;
	}
    @Override
    public float func_150893_a(ItemStack stack, Block block) {
        return super.getEfficiency(stack);
    }

}


	