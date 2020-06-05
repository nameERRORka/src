package ru.fcorecode.arcanereborn.configs;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
	
	//#######Материалы для Оружия
    //=======================
    //1 - Имя
    //2 - уровень добычи
    //3 - прочка
    //4 - скорость добычи
   	//5 - урон
    //6 - шанс на гуд чар
    //=======================
    
    public static final ToolMaterial SKANA = EnumHelper.addToolMaterial("SKANA", 3, 2100, 17.0F, 9.0F, 10);
    public static final ToolMaterial ICESCANA = EnumHelper.addToolMaterial("ICESCANA", 3, 2110, 17.0F, 25.0F, 10);
    public static final ToolMaterial MEDIUMHAMMER = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    
    /*public static final ToolMaterial BESTHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    */
}
