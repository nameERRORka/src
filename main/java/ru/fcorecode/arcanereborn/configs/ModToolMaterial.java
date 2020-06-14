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
    public static final ToolMaterial SKANA = EnumHelper.addToolMaterial("SKANA", 0, 2100, 0.0F, 9.0F, 10);
    public static final ToolMaterial ICESCANA = EnumHelper.addToolMaterial("ICESCANA", 3, 2110, 17.0F, 25.0F, 10);
	public static float digSpeedbaseHAMMER = 7.0F;
	public static float digSpeedMEDIUMHAMMER = 12.0F;
	public static float digSpeedBestHAMMER = 25.0F;
	public static float digSpeedZeroHAMMER = 2.0F;
	public static float digSpeedBaseMulti = 12.0F;
    public static final ToolMaterial baseHAMMER = EnumHelper.addToolMaterial("baseHAMMER", 4, 1500, digSpeedbaseHAMMER , 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 2000, digSpeedMEDIUMHAMMER , 4.0F, 5);
    public static final ToolMaterial BestHammer = EnumHelper.addToolMaterial("BestHammer", 4, 2542, digSpeedBestHAMMER , 4.0F, 5);
    public static final ToolMaterial ZeroHammer = EnumHelper.addToolMaterial("BestHammer", 4, 1605, digSpeedZeroHAMMER , 4.0F, 5);
    public static final ToolMaterial BaseMultiTool = EnumHelper.addToolMaterial("BaseMultiTool", 4, 1605, digSpeedBaseMulti , 4.0F, 5);
    public static final ToolMaterial LClaws = EnumHelper.addToolMaterial("ICESCANA", 3, 2110, 17.0F, 5.0F, 10);
    
    /*public static final ToolMaterial BESTHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    public static final ToolMaterial MEDIUMHAMMER  = EnumHelper.addToolMaterial("MEDIUMHAMMER", 4, 4500, 12.0F, 4.0F, 5);
    */
}
