package ru.fcorecode.arcanereborn.potion;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class potionFly extends PotionMod {
	

    public potionFly() {
        super(ConfigInfo.IDFly, "flight", false, 0xFFFFEE, 2);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent e) {
        if (e.entityLiving instanceof EntityPlayer) {
            if (e.entityLiving.getActivePotionEffect(this) != null && e.entityLiving.getActivePotionEffect(this).getDuration() > 0) {
                ((EntityPlayer) e.entityLiving).capabilities.allowFlying =
                ((EntityPlayer) e.entityLiving).capabilities.isFlying = true;
            } else {
                ((EntityPlayer) e.entityLiving).capabilities.allowFlying =
                ((EntityPlayer) e.entityLiving).capabilities.isFlying = false;
            }
        }
}
}