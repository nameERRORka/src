package ru.fcorecode.arcanereborn.configs;

import net.minecraft.util.EnumChatFormatting;

public enum Rarity {
	
	_useless(EnumChatFormatting.DARK_GRAY, "Предмет"),
	_common(EnumChatFormatting.GRAY, "Запечатанный"),
    _uncommon(EnumChatFormatting.WHITE, "Обынчый"),
    _rare(EnumChatFormatting.BLUE, "Редкий"),
    _epic(EnumChatFormatting.LIGHT_PURPLE, "Эпический"),
	_legendary(EnumChatFormatting.GOLD, "Легендарный"),
	_awakened(EnumChatFormatting.GOLD, "Пробужденный");
	
    public final EnumChatFormatting rarityColor;
    
    public final String rarityName;

    private static final String __OBFID = "CL_00000056";

    private Rarity(EnumChatFormatting p_i45349_3_, String p_i45349_4_)
    {
        this.rarityColor = p_i45349_3_;
        this.rarityName = p_i45349_4_;
    }
}
