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
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.fcorecode.arcanereborn.items.armor._daemonicArmor;
import ru.fcorecode.arcanereborn.items.item.Items;
import ru.fcorecode.arcanereborn.items.tools.BasePickaxe;
import ru.fcorecode.arcanereborn.items.weapons.BaseBow;
import ru.fcorecode.arcanereborn.items.weapons.BaseSkana;

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
	public static Item _BaseSkana;
	public static Item _IceSkana;
	public static Item _BaseBow;
	
	//Нехуй трогать, и так заебись
	public static Item _logoCreativeTabs = new Items("CreativeTabsLogo" , "_logoCreativeTabs" , 0);
	public static final CreativeTabs tabAFReborn = new CreativeTabs("tabAFReborn") {	
		@Override
		public Item getTabIconItem() {
			return _logoCreativeTabs;
		}
	};
	//--------------------------------
	// 1 - Имя, 2 - уровень добычи, 3 - прочка, 4 - скорость добычи, 5 - урон, 6 - шанс на гуд чар
	public static ToolMaterial SKANA = EnumHelper.addToolMaterial("Skana", 3, 2100, 17.0F, 9.0F, 10);
	public static ToolMaterial IceSkana = EnumHelper.addToolMaterial("IceSkana", 3, 2110, 17.0F, 25.0F, 10);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	/*public static final ToolMaterial BESTHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
	*/
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		_daemonicHelmet = new _daemonicArmor(0, 0).setUnlocalizedName("DaemonicHelmet").setTextureName(MODID + ":armor/_daemonicHelmet");
		_daemonicBody = new _daemonicArmor(0, 1).setUnlocalizedName("DaemonicBody").setTextureName(MODID + ":armor/_daemonicBody");
		_daemonicLegs = new _daemonicArmor(0, 2).setUnlocalizedName("DaemonicLegs").setTextureName(MODID + ":armor/_daemonicLegs");
		_daemonicSteps = new _daemonicArmor(0, 3).setUnlocalizedName("DaemonicSteps").setTextureName(MODID + ":armor/_daemonicSteps");
		_daemonicShatter = new Items("DaemonicShatter", "items/_daemonicShatter", 64);
		_basepickaxe = new BasePickaxe("BasePickaxe", "tools/_basePickaxe", 1, MEDIUMHAMMER);	
		_BaseSkana = new BaseSkana("BaseSkana", "weapon/_baseSkana", 1, SKANA);
		_IceSkana = new BaseSkana("IceSkana", "weapon/_IceSword", 1, IceSkana);
		_BaseBow = new BaseBow("BaseBow", "weapon/_BaseBow", 1);

		GameRegistry.registerItem(_daemonicSteps, "DaemonicSteps");
		GameRegistry.registerItem(_daemonicLegs, "DaemonicLegs");
		GameRegistry.registerItem(_daemonicBody, "DaemonicBody");
		GameRegistry.registerItem(_daemonicHelmet, "DaemonicHelmet");
		GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");
		GameRegistry.registerItem(_basepickaxe, "BasePickaxe");
		GameRegistry.registerItem(_BaseSkana, "BaseSkana");
		GameRegistry.registerItem(_IceSkana, "IceSkana");
		GameRegistry.registerItem(_BaseBow, "BaseBow");
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

