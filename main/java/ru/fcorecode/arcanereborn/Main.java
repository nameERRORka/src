package ru.fcorecode.arcanereborn;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.Set;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.fcorecode.arcanereborn.items.armor._daemonicArmor;
import ru.fcorecode.arcanereborn.items.item.Items;
import ru.fcorecode.arcanereborn.items.item.MoneyClass;
import ru.fcorecode.arcanereborn.items.tools.BasePickaxe;
import ru.fcorecode.arcanereborn.items.tools.BestHammer;
import ru.fcorecode.arcanereborn.items.tools.MediumHammer;
import ru.fcorecode.arcanereborn.items.tools.ZeroHammer;
import ru.fcorecode.arcanereborn.items.weapons.BaseSkana;
import ru.fcorecode.arcanereborn.items.weapons.LeatherClaws;
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
    public static Item _mediumHammer;
    public static Item _bestHammer;
    public static Item _zeroHammer;
    public static Item _BaseSkana;
    public static Item _IceSkana;
    public static Item _BaseBow;
    public static Item _LeatherClaws;
    public static Potion _potionFly;

    public static Item _goldenCoin;
    public static Item _silverCoin;
    public static Item _cooperCoin;
    
    public static void extendPotionArray() {
        Potion[] potionTypes = null;
        for (Field f : Potion.class.getDeclaredFields()) { // получаем все поля из класса зелья
            f.setAccessible(true); // даём к ним доступ (локально убираем private)
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) { // проверка что это поле именно со списком зелий
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL); // убираем final модфикатор
                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[256]; // создаём новый массив зелий на 256 элементов
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length); // копируем старые зелья в новый массив
                    f.set(null, newPotionTypes); // и заменяем
                    return;
                }
            } catch (Exception e) {
                System.err.println(e); // на случай ошибки выводим её в лог
            }
        }
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	if(Potion.potionTypes.length < 256) extendPotionArray();
    }
    
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event) {
        _daemonicHelmet = new _daemonicArmor(0, 0).setUnlocalizedName("DaemonicHelmet").setTextureName(MODID + ":armor/_daemonicHelmet");
        _daemonicBody = new _daemonicArmor(0, 1).setUnlocalizedName("DaemonicBody").setTextureName(MODID + ":armor/_daemonicBody");
        _daemonicLegs = new _daemonicArmor(0, 2).setUnlocalizedName("DaemonicLegs").setTextureName(MODID + ":armor/_daemonicLegs");
        _daemonicSteps = new _daemonicArmor(0, 3).setUnlocalizedName("DaemonicSteps").setTextureName(MODID + ":armor/_daemonicSteps");
        _daemonicShatter = new Items("DaemonicShatter", "items/_daemonicShatter", 64);
        _basepickaxe = new BasePickaxe("BasePickaxe", "tools/_basePickaxe", 1, ModToolMaterial.baseHAMMER);
        _mediumHammer = new MediumHammer("MediumHammer", "tools/_MediumHammer", 1, ModToolMaterial.MEDIUMHAMMER);
        _bestHammer = new BestHammer("BestHammer", "tools/_besthammer", 1, ModToolMaterial.BestHammer);
        _zeroHammer = new ZeroHammer("ZeroHammer", "tools/_hammerzero", 1, ModToolMaterial.ZeroHammer);
       // _mediumHammer = new MediumHammer("MediumHammer", "tools/_hammerzero", 1, ModToolMaterial.MEDIUMHAMMER);
        _BaseSkana = new BaseSkana("BaseSkana", "weapon/_baseSkana", 1, ModToolMaterial.SKANA);
        _IceSkana = new BaseSkana("IceSkana", "weapon/_IceSword", 1, ModToolMaterial.ICESCANA);
        _LeatherClaws = new LeatherClaws("LeatherClaws", "weapon/_LClaws", 1, ModToolMaterial.LClaws);

        GameRegistry.registerItem(_daemonicSteps, "DaemonicSteps");
        GameRegistry.registerItem(_daemonicLegs, "DaemonicLegs");
        GameRegistry.registerItem(_daemonicBody, "DaemonicBody");
        GameRegistry.registerItem(_daemonicHelmet, "DaemonicHelmet");
        GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");
        GameRegistry.registerItem(_basepickaxe, "BasePickaxe");
        GameRegistry.registerItem(_bestHammer, "BestPickaxe");
        GameRegistry.registerItem(_mediumHammer, "MediumHammer");
        GameRegistry.registerItem(_zeroHammer, "ZeroHammer");
        GameRegistry.registerItem(_mediumHammer, "MediumHammer");
        GameRegistry.registerItem(_BaseSkana, "BaseSkana");
        GameRegistry.registerItem(_IceSkana, "IceSkana");
        GameRegistry.registerItem(_LeatherClaws, "LeatherClaws");
        
        _goldenCoin = new MoneyClass("GoldenCoin", "items/_goldenCoin", 64);
    	GameRegistry.registerItem(_goldenCoin, "GoldenCoin");
    	_silverCoin = new MoneyClass("SilverCoin", "items/_silverCoin", 64);
    	GameRegistry.registerItem(_silverCoin, "SilverCoin");
    	_cooperCoin = new MoneyClass("CooperCoin", "items/_cooperCoin", 64);
    	GameRegistry.registerItem(_cooperCoin, "CooperCoin");
    }
}