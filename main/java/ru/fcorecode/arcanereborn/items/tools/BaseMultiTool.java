package ru.fcorecode.arcanereborn.items.tools;

import net.minecraft.item.ItemSpade;
import ru.fcorecode.arcanereborn.Main;
import ru.fcorecode.arcanereborn.configs.ConfigInfo;

public class BaseMultiTool extends ItemSpade {
    public int mode = 4;
    public String namemode = "none";
    public BaseMultiTool(String name, String texture, int maxStackSize, ToolMaterial BaseMultiTool) {
        super(BaseMultiTool);
        this.canRepair = false;
        this.setUnlocalizedName(name);
        this.setTextureName(Main.MODID + ":" + texture);
        this.setCreativeTab(ConfigInfo.tabAFRebornTools);
        this.maxStackSize = 1;
    }
}
	