package ru.fcorecode.arcanereborn.configs;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class Rarity
{
	public static final EnumRarity _useless = EnumHelper.addRarity("_useless", EnumChatFormatting.DARK_GRAY, "[Предмет]");
	public static final EnumRarity _common = EnumHelper.addRarity("_common", EnumChatFormatting.GRAY, "[Запакованный]");
	public static final EnumRarity _uncommon = EnumHelper.addRarity("_uncommon", EnumChatFormatting.WHITE, "[Обынчый]");
	public static final EnumRarity _rare = EnumHelper.addRarity("_rare", EnumChatFormatting.BLUE, "[Редкий]");
	public static final EnumRarity _epic = EnumHelper.addRarity("_epic", EnumChatFormatting.LIGHT_PURPLE, "[Эпический]");
	public static final EnumRarity _legendary = EnumHelper.addRarity("_legendary", EnumChatFormatting.YELLOW, "[Легендарный]");
	public static final EnumRarity _awakened = EnumHelper.addRarity("_awakened", EnumChatFormatting.GOLD, "[Пробужденный]");
	public static final EnumRarity _arcoins = EnumHelper.addRarity("_awakened", EnumChatFormatting.GOLD, "[Валюта]");
}
