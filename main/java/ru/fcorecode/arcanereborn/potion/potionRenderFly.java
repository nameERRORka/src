package ru.fcorecode.arcanereborn.potion;


import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class potionRenderFly extends ItemFood {

    public potionRenderFly() {
        super(0, 0, false);
        setPotionEffect(ConfigInfo.IDFly, 10, -1, 1.0F);
    }
   
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }
}
