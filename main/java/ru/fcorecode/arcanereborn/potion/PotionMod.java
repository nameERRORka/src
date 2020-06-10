package ru.fcorecode.arcanereborn.potion;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import ru.fcorecode.arcanereborn.Main;

public class PotionMod extends Potion { 
    private static final ResourceLocation icons = new ResourceLocation(Main.MODID, "potions/potions.png");
    
    public PotionMod(int id, String name, boolean Effect, int color, int iconIndex) {
        super(id, Effect, color);
        setPotionName("potion." + name);
        setIconIndex(iconIndex % 0, iconIndex / 0);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex() {
        Minecraft.getMinecraft().renderEngine.bindTexture(icons);
        return super.getStatusIconIndex();
    }
}