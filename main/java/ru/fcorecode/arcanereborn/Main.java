package ru.fcorecode.arcanereborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.DimensionManager;
import ru.fcorecode.arcanereborn.dimension.YourWorldProvider;
import ru.fcorecode.arcanereborn.proxy.CommonProxy;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, dependencies = "required-after:IC2;")

public class Main {

    public static final String MODID = "arcanereborn";
    public static final String MODNAME = "Arcanefactory Reborn";
    public static final String VERSION = "1.10.2";
    
//    public static Item _daemonicHelmet;
//    public static Item _daemonicBody;
//    public static Item _daemonicLegs;
//    public static Item _daemonicSteps;
//    public static Item _daemonicShatter;

//    public static Item _BaseSkana;
//    public static Item _IceSkana;
//    public static Item _BaseBow;
//    public static Item _LeatherClaws;
//    public static Potion _potionFly;

    @Instance
    public static Main instance = new Main();

    @SidedProxy(clientSide = "ru.fcorecode.arcanereborn.proxy.ClientProxy", serverSide = "ru.fcorecode.arcanereborn.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
//        _daemonicHelmet = new _daemonicArmor(0, 0).setUnlocalizedName("DaemonicHelmet").setTextureName(MODID + ":armor/_daemonicHelmet");
//        _daemonicBody = new _daemonicArmor(0, 1).setUnlocalizedName("DaemonicBody").setTextureName(MODID + ":armor/_daemonicBody");
//        _daemonicLegs = new _daemonicArmor(0, 2).setUnlocalizedName("DaemonicLegs").setTextureName(MODID + ":armor/_daemonicLegs");
//        _daemonicSteps = new _daemonicArmor(0, 3).setUnlocalizedName("DaemonicSteps").setTextureName(MODID + ":armor/_daemonicSteps");
//        _daemonicShatter = new AFRItems("DaemonicShatter", "items/_daemonicShatter", 64);

       // _mediumHammer = new MediumHammer("MediumHammer", "tools/_hammerzero", 1, ModToolMaterial.MEDIUMHAMMER);
//        _BaseSkana = new BaseSkana("BaseSkana", "weapon/_baseSkana", 1, ModToolMaterial.SKANA);
//        _IceSkana = new BaseSkana("IceSkana", "weapon/_IceSword", 1, ModToolMaterial.ICESCANA);
//        _LeatherClaws = new LeatherClaws("LeatherClaws", "weapon/_LClaws", 1, ModToolMaterial.LClaws);
//        _MagicRock = new AFRBlocks("MagicRock", Material.rock, 3, 15, "pickaxe", 4, "MagicRock/_MagicRock");
//        _MagicWood = new AFRBlocks("MagicWood", Material.wood, 3, 15, "axe", 4, "_MagicWood");

//        GameRegistry.registerItem(_daemonicSteps, "DaemonicSteps");
//        GameRegistry.registerItem(_daemonicLegs, "DaemonicLegs");
//        GameRegistry.registerItem(_daemonicBody, "DaemonicBody");
//        GameRegistry.registerItem(_daemonicHelmet, "DaemonicHelmet");
//        GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");

//        GameRegistry.registerItem(_BaseSkana, "BaseSkana");
//        GameRegistry.registerItem(_IceSkana, "IceSkana");
//        GameRegistry.registerItem(_LeatherClaws, "LeatherClaws");
//        GameRegistry.registerBlock(_MagicRock, "MagicRock");
//        GameRegistry.registerBlock(_MagicWood, "MagicWood");
    	
//    	ItemStack enchStack = new ItemStack(Main._basepickaxe);
//    	ItemStack enchStack1 = new ItemStack(net.minecraft.init.Items.diamond_pickaxe);
//    	enchStack.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);
//    	enchStack1.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}