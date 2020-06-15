package ru.fcorecode.arcanereborn.configs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.items.item.Items;

public class ConfigInfo
	{
		//Magnanimous Material Options
		public static int MagDurability;
		public static int MagMiningLevel;
		public static int MagEnchantability;
		public static float MagEfficiency;
		public static float MagDamage;
	
		//Mag Mat Defaults
		public static int MagDurabilityDefault = 2000;
		public static int MagMiningLevelDefault = 4;
		public static int MagEnchantabilityDefault = 22;
		public static float MagEfficiencyDefault = 8.0F;
		public static float MagDamageDefault = 3.5F;
	
		//Individual Durability Overrides
		public static int MagPickDurability;
		public static int MagHammerDurability;
		public static int MagEarthMoverDurability;
		public static int MagSwordDurability;
		public static int MagAxeDurability;
	
		//Special tool options
		public static boolean EnableHammerShiftOneBlock;
		public static boolean EnableEarthMoverShiftOneBlock;
		public static boolean EnableAxeWholeTree;
		
		public static int HammerSneakMinXP;
		public static int EarthMoverSneakMinXP;
		public static int SneakXPMinDefault = 20;
	
		public static boolean EnableXPSpeed;
		public static boolean EnablePickFortune;
		public static boolean EnableSwordXPdamage;
		
		//Tool Enablement
		public static boolean EnableSword;
		public static boolean EnablePick;
		public static boolean EnableHammer;
		public static boolean EnableEarthMover;
		public static boolean EnableAxe;
		
		//WorldGen Options
		public static boolean EnableSaplingGem;
		public static boolean EnableTreeGen;
		public static boolean EnableFlatWorldTree;
		
		public static int TreeGenChance;
		public static int SaplingGemChance;
		public static int SaplingTreeGemLogChance;
		public static int WorldGenTreeGemLogChance;
		
		public static boolean CanBonemealSapling;
		public static int SaplingGrowthChanceNatural;
		public static int SaplingGrowthChanceBonemeal;
		
		//Potion ID
		public static int IDFly = 1015;
		
		//---------Не трогать XD----------
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
	    
	    public static Item _logoCreativeTabsBlocks = new Items("CreativeTabsLogoBlocks", "_logoCreativeTabsBlocks", 0);
	    public static final CreativeTabs tabAFRebornBlocks = new CreativeTabs("tabAFRebornBlocks") {
	        @Override
	        public Item getTabIconItem() {
	            return _logoCreativeTabsBlocks;
	        }
	    };
	    //--------------------------------
	}