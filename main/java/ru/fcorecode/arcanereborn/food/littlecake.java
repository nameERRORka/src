package ru.fcorecode.arcanereborn.food;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;


 
public class littlecake extends ItemFood {
    public littlecake(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(name);
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setPotionEffect(12, 50, 5, 3F);
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
    	super.onFoodEaten(stack, worldIn, player);
     	player.addChatMessage(new ChatComponentText("ну ебанный в рот, михалыч!!"));
     	
    }
}
    
    