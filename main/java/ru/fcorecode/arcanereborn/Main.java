package ru.fcorecode.arcanereborn;

import java.util.TimerTask;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ibxm.Player;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.fcorecode.arcanereborn.items.armor._daemonicArmor;
import ru.fcorecode.arcanereborn.items.item.Items;
import ru.fcorecode.arcanereborn.items.tools.BasePickaxe;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)

public class Main {

	public static final String MODID = "arcanereborn";
	public static final String MODNAME = "Arcanefactory Reborn";
	public static final String VERSION = "1.1.0";
	
	public static Item _daemonicHelmet;
	public static Item _daemonicBody;
	public static Item _daemonicLegs;
	public static Item _daemonicSteps;
	public static Item _daemonicShatter;
	public static Item _basepickaxe;
	
	//Нехуй трогать, и так заебись
	public static Item _logoCreativeTabs = new Items("CreativeTabsLogo" , "_logoCreativeTabs" , 0);
	public static final CreativeTabs tabAFReborn = new CreativeTabs("tabAFReborn") {	
		@Override
		public Item getTabIconItem() {
			return _logoCreativeTabs;
		}
	};
	//--------------------------------

	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		_daemonicHelmet = new _daemonicArmor(0, 0).setUnlocalizedName("DaemonicHelmet").setTextureName(MODID + ":armor/_daemonicHelmet");
		_daemonicBody = new _daemonicArmor(0, 1).setUnlocalizedName("DaemonicBody").setTextureName(MODID + ":armor/_daemonicBody");
		_daemonicLegs = new _daemonicArmor(0, 2).setUnlocalizedName("DaemonicLegs").setTextureName(MODID + ":armor/_daemonicLegs");
		_daemonicSteps = new _daemonicArmor(0, 3).setUnlocalizedName("DaemonicSteps").setTextureName(MODID + ":armor/_daemonicSteps");
		_daemonicShatter = new Items("DaemonicShatter", "items/_daemonicShatter", 64);
		_basepickaxe = new BasePickaxe("BasePickaxe", "tools/_basePickaxe", 1);	

		GameRegistry.registerItem(_daemonicSteps, "DaemonicSteps");
		GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");
		GameRegistry.registerItem(_daemonicHelmet, "DaemonicHelmet");
		GameRegistry.registerItem(_daemonicBody, "DaemonicBody");
		GameRegistry.registerItem(_daemonicLegs, "DaemonicLegs");
		GameRegistry.registerItem(_basepickaxe, "BasePickaxe");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event, PlayerEvent e) {
		EntityPlayer player = e.entityPlayer;
		ItemStack heldItem = player.getHeldItem();
		for (;;) {
			if (heldItem == null)
			{
				player.addChatMessage(new ChatComponentText("Ебац тестики"));
			}
			else {
				player.addChatMessage(new ChatComponentText("Включено ночное зрение"));
			}
		}
	}
}

