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
import ru.fcorecode.arcanereborn.items.item.MoneyClass;
import ru.fcorecode.arcanereborn.items.tools.BasePickaxe;
import ru.fcorecode.arcanereborn.items.tools.MediumHammer;
import ru.fcorecode.arcanereborn.items.weapons.BaseSkana;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)

public class Main {

    public static final String MODID = "arcanereborn";
    public static final String MODNAME = "Arcanefactory Reborn";
    public static final String VERSION = "1.10.2";
    

    public static Item _daemonicHelmet;
    public static Item _daemonicBody;
    public static Item _daemonicLegs;
    public static Item _daemonicSteps;
    public static Item _daemonicShatter;
    public static Item _basepickaxe;
    public static Item _MediumHammer;
    public static Item _BaseSkana;
    public static Item _IceSkana;
    public static Item _BaseBow;


    public static Item _goldenCoin;
    public static Item _silverCoin;
    public static Item _cooperCoin;



    public static Item _logoCreativeTabsMoney = new Items("CreativeTabsLogoMoney", "_logoCreativeTabsMoney", 0);
    public static final CreativeTabs tabAFRebornMoney = new CreativeTabs("tabAFRebornMoney") {
        @Override
        public Item getTabIconItem() {
            return _logoCreativeTabsMoney;
        }
    };
    
    public static Item _logoCreativeTabsWeaponAndArmor = new Items("CreativeTabsLogoWaA", "_logoCreativeTabsWeaponAndArmor", 0);
    public static final CreativeTabs tabAFRebornWaA = new CreativeTabs("tabAFRebornWaA") {
        @Override
        public Item getTabIconItem() {
            return _logoCreativeTabsWeaponAndArmor;
        }
    };
    
    public static Item _logoCreativeTabsTools = new Items("CreativeTabsLogoTools", "_logoCreativeTabsTools", 0);
    public static final CreativeTabs tabAFRebornTools = new CreativeTabs("tabAFRebornTools") {
        @Override
        public Item getTabIconItem() {
            return _logoCreativeTabsTools;
        }
    };
    
    public static Item _logoCreativeTabsAnother = new Items("CreativeTabsLogoAnother", "_logoCreativeTabsAnother", 0);
    public static final CreativeTabs tabAFRebornAnother = new CreativeTabs("tabAFRebornAnother") {
        @Override
        public Item getTabIconItem() {
            return _logoCreativeTabsAnother;
        }
    };
    //--------------------------------
    
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event) {
        _daemonicHelmet = new _daemonicArmor(0, 0).setUnlocalizedName("DaemonicHelmet").setTextureName(MODID + ":armor/_daemonicHelmet");
        _daemonicBody = new _daemonicArmor(0, 1).setUnlocalizedName("DaemonicBody").setTextureName(MODID + ":armor/_daemonicBody");
        _daemonicLegs = new _daemonicArmor(0, 2).setUnlocalizedName("DaemonicLegs").setTextureName(MODID + ":armor/_daemonicLegs");
        _daemonicSteps = new _daemonicArmor(0, 3).setUnlocalizedName("DaemonicSteps").setTextureName(MODID + ":armor/_daemonicSteps");
        _daemonicShatter = new Items("DaemonicShatter", "items/_daemonicShatter", 64);
        _basepickaxe = new BasePickaxe("BasePickaxe", "tools/_basePickaxe", 1, ModToolMaterial.baseHAMMER);
        _MediumHammer = new MediumHammer("MediumHammer", "tools/_MediumHammer", 1, ModToolMaterial.MEDIUMHAMMER);
       // _BaseSkana = new BaseSkana("BaseSkana", "weapon/_baseSkana", 1, ModToolMaterial.SKANA);
        _IceSkana = new BaseSkana("IceSkana", "weapon/_IceSword", 1, ModToolMaterial.ICESCANA);

        GameRegistry.registerItem(_daemonicSteps, "DaemonicSteps");
        GameRegistry.registerItem(_daemonicLegs, "DaemonicLegs");
        GameRegistry.registerItem(_daemonicBody, "DaemonicBody");
        GameRegistry.registerItem(_daemonicHelmet, "DaemonicHelmet");
        GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");
        GameRegistry.registerItem(_basepickaxe, "BasePickaxe");
        GameRegistry.registerItem(_BaseSkana, "BaseSkana");
        GameRegistry.registerItem(_IceSkana, "IceSkana");
        //GameRegistry.registerItem(_MediumHammer, "MediumHammer");
    	

    	_goldenCoin = new MoneyClass("GoldenCoin", "items/_goldenCoin", 64);
    	GameRegistry.registerItem(_goldenCoin, "GoldenCoin");
    	_silverCoin = new MoneyClass("SilverCoin", "items/_silverCoin", 64);
    	GameRegistry.registerItem(_silverCoin, "SilverCoin");
    	_cooperCoin = new MoneyClass("CooperCoin", "items/_cooperCoin", 64);
    	GameRegistry.registerItem(_cooperCoin, "CooperCoin");

    }
}