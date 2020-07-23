	package ru.fcorecode.arcanereborn.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.fcorecode.arcanereborn.configs.ModToolMaterial;
import ru.fcorecode.arcanereborn.enchant.EnchantmentRegistry;
import ru.fcorecode.arcanereborn.food.littlecake;
import ru.fcorecode.arcanereborn.items.Money.Money;
import ru.fcorecode.arcanereborn.items.armor._daemonicArmor;
import ru.fcorecode.arcanereborn.items.items.DaemonicShatter;
import ru.fcorecode.arcanereborn.items.items.MagicShatter;
import ru.fcorecode.arcanereborn.items.tools.*;
import ru.fcorecode.arcanereborn.items.weapons.BaseSkana;
import ru.fcorecode.arcanereborn.items.weapons.LeatherClaws;

public final class AFRItems {

	public static Item _daemonicShatter;
	public static Item _MagicShatter;
	public static Item _MediumHammer;
	public static Item _BestHammer;
	public static Item _ZeroHammer;
	public static Item _BaseMultitool;
	public static Item _BasePickaxe;
	public static Item _IridiumDrill;
	public static Item _goldenCoin;
	public static Item _silverCoin;
	public static Item _cooperCoin;
	public static Item _Skana;
	public static Item _IceSkana;
	public static Item _LeatherClaws;
	public static Item _LittleCake;
    public static Item _daemonicHelmet;
    public static Item _daemonicBody;
    public static Item _daemonicLegs;
    public static Item _daemonicSteps;
    public static Item _magicHelmet;
    public static Item _magicBody;
    public static Item _magicLegs;
    public static Item _magicSteps;

	public static void init() {

		_daemonicShatter = new DaemonicShatter("DaemonicShatter", "items/_daemonicShatter");
		GameRegistry.registerItem(_daemonicShatter, "DaemonicShatter");
		
		_MagicShatter = new MagicShatter("MagicShatter", "items/_daemonicShatter");
		GameRegistry.registerItem(_MagicShatter, "MagicShatter");

		_Skana = new BaseSkana("BaseSkana", "weapon/_baseSkana", 1, ModToolMaterial.SKANA);
		GameRegistry.registerItem(_Skana, "BaseSkana");

		_IceSkana = new BaseSkana("IceSkana", "weapon/_IceSword", 1, ModToolMaterial.ICESCANA);
		GameRegistry.registerItem(_IceSkana, "IceSkana");

		_LeatherClaws = new LeatherClaws("LeatherClaws", "weapon/_LClaws", 1, ModToolMaterial.LClaws);
		GameRegistry.registerItem(_LeatherClaws, "LeatherClaws");

		_BasePickaxe = new BasePickaxe("BasePickaxe", "tools/_basePickaxe", 1, ModToolMaterial.baseHAMMER);
		GameRegistry.registerItem(_BasePickaxe, "BasePickaxe");

		_MediumHammer = new MediumHammer("MediumHammer", "tools/_mediumHammer", 1, ModToolMaterial.MEDIUMHAMMER);
		GameRegistry.registerItem(_MediumHammer, "MediumHammer");

		_BestHammer = new BestHammer("BestHammer", "tools/_bestHammer", 1, ModToolMaterial.BestHammer);
		GameRegistry.registerItem(_BestHammer, "BestHammer");

		_ZeroHammer = new ZeroHammer("ZeroHammer", "tools/_zeroHammer", 1, ModToolMaterial.ZeroHammer);
		GameRegistry.registerItem(_ZeroHammer, "ZeroHammer");

		_BaseMultitool = new BaseMultiTool("Multi", "tools/_baseMultiTool", 1, ModToolMaterial.BaseMultiTool);
		GameRegistry.registerItem(_BaseMultitool, "Multitool");

		_goldenCoin = new Money("GoldenCoin", "items/_goldenCoin", 64);
		GameRegistry.registerItem(_goldenCoin, "GoldenCoin");

		_silverCoin = new Money("SilverCoin", "items/_silverCoin", 64);
		GameRegistry.registerItem(_silverCoin, "SilverCoin");

		_cooperCoin = new Money("CooperCoin", "items/_cooperCoin", 64);
		GameRegistry.registerItem(_cooperCoin, "CooperCoin");
		
		_LittleCake = new littlecake("LittleCake", 1, 5F, false);
		GameRegistry.registerItem(_LittleCake, "LittleCake");

        _daemonicHelmet = new _daemonicArmor("DaemonicHelmet", "armor/daemonic/_daemonicHelmet", "DaemonicArmor_1.png", 1,0, 0);
        _daemonicBody = new _daemonicArmor("DaemonicCuirass", "armor/daemonic/_daemonicCuirass", "DaemonicArmor_1.png", 1,0, 1);
        _daemonicLegs = new _daemonicArmor("DaemonicLegs", "armor/daemonic/_daemonicLegs", "DaemonicArmor_2.png", 1,0, 2);
        _daemonicSteps = new _daemonicArmor("DaemonicSteps","armor/daemonic/_daemonicSteps", "DaemonicArmor_1.png", 1,0, 3);

        _magicHelmet = new _daemonicArmor("magicHelmet", "armor/daemonic/_daemonicHelmet", "DaemonicArmor_1.png", 1,0, 0);
        _magicBody = new _daemonicArmor("magicCuirass", "armor/daemonic/_daemonicCuirass", "DaemonicArmor_1.png", 1,0, 1);
        _magicLegs = new _daemonicArmor("magicLegs", "armor/daemonic/_daemonicLegs", "DaemonicArmor_2.png", 1,0, 2);
        _magicSteps = new _daemonicArmor("magicSteps","armor/daemonic/_daemonicSteps", "DaemonicArmor_1.png", 1,0, 3);

		ItemStack enchantmentStack = new ItemStack(_BasePickaxe);
    	ItemStack enchantmentStack1 = new ItemStack(net.minecraft.init.Items.diamond_pickaxe);
		enchantmentStack.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);
		enchantmentStack1.addEnchantment(EnchantmentRegistry.SAFE_ALL, 1);

	}
}

//public class AFRItems extends Item
//{
//
//	boolean mode = false;
//
//	public AFRItems(String name, String texture, int maxStackSize)
//	{
//		this.canRepair = false;а
//		this.setUnlocalizedName(name);
//		this.setTextureName(Main.MODID + ":" + texture);
//		this.setCreativeTab(ConfigInfo.tabAFRebornAnother);
//		GameRegistry.registerItem(this, name);
//	}
//
//	@SideOnly(Side.CLIENT)
//	public void addInformation(ItemStack stack, EntityPlayer player, List itemDescription, boolean none)
//	{
//		itemDescription.add("" + Rarity._useless.rarityName);
//	}
//
//	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
//	{
//		return false;
//	}
//
//	@Subscribe
//	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
//	{/*
//		    if(player.inventory.hasItem(Main._basepickaxe)) {
//		    	player.addChatMessage(new ChatComponentText("БЕГИ СУКА!"));
//		    }else if(player.inventory.hasItem(Main._IceSkana)) {
//		    	player.addChatMessage(new ChatComponentText("Не беги, сука!"));
//		    	player.addChatMessage(new ChatComponentText("Утомление"));
//
//		    }
//		    */
//		return stack;}
//
//	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase Entity)
//	{
//		return false;
//	}
//
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
//	{
//
//	}
//
//	public void onCreated(ItemStack stack, World world, EntityPlayer player)
//	{
//			/*if (world.isRemote)
//			 * {
//			player.addChatMessage(new ChatComponentText("� ��������!"));
//			}*/
//	}
//
//	public EnumRarity getRarity(ItemStack stack)
//	{
//		return Rarity._useless;
//	}
//}


/*
----------------------------------
        fly
----------------------------------
if (world.isRemote) {

if (!mode) {
	player.addChatMessage(new ChatComponentText("fly on"));
	player.capabilities.allowFlying = true;
	mode = true;
} else {
	player.addChatMessage(new ChatComponentText("fly off"));
	player.capabilities.allowFlying = false;
	mode = false;
}
}
itemStack.damageItem(1, player);
*/

/*
----------------------------------
        message
----------------------------------
player.addChatMessage(new ChatComponentText("� ����� ���!" + mode));
mode = !mode;
player.capabilities.disableDamage = mode;
*/

/*
----------------------------------
        potion
----------------------------------
super.onUpdate(stack, world, entity, par4, par5);
if (entity instanceof EntityPlayer) {
	EntityPlayer player = (EntityPlayer) entity;
	ItemStack equipped = player.getCurrentEquippedItem();
	if (equipped == stack) {
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 2, 2, true));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2, 1, true));
	}
}*/
