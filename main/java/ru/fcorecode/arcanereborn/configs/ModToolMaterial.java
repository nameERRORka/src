package ru.fcorecode.arcanereborn.configs;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
	
	//#######Materials for guns
    //=======================
    //1 - name
    //2 - level dig
    //3 - MaxDamagt
    //4 - digSpeed
   	//5 - damage
    //6 - enchant
    //=======================
    public static final ToolMaterial SKANA = EnumHelper.addToolMaterial("SKANA", 3, 2100, 17.0F, 9.0F, 10);
    public static final ToolMaterial ICESCANA = EnumHelper.addToolMaterial("ICESCANA", 3, 2110, 17.0F, 25.0F, 10);
	public static float digSpeedbaseHAMMER = 12.0F;
	public static float digSpeedMEDIUMHAMMER = 15.0F;
    public static final ToolMaterial baseHAMMER = EnumHelper.addToolMaterial("baseHAMMER", 4, 1500, digSpeedbaseHAMMER , 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 2000, digSpeedMEDIUMHAMMER , 4.0F, 5);
    /*public static final ToolMaterial BESTHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    */
}
