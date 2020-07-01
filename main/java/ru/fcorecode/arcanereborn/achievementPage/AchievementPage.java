package ru.fcorecode.arcanereborn.achievementPage;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import ru.fcorecode.arcanereborn.blocks.AFRBlocks;
import ru.fcorecode.arcanereborn.items.AFRItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class AchievementPage extends net.minecraftforge.common.AchievementPage {
	public static Achievement DeadPortal;
	public static Achievement DeadBattle;
	public static Achievement DeadRunner;
	public static Achievement DeadSaller;
	public static Achievement DeadBuffer;
	public AchievementPage() {
		super("DeadLand", DeadPortal, DeadBattle, DeadRunner, DeadSaller, DeadBuffer);
	
	}
    public static void init() {
    	  DeadPortal = (new Achievement("DeadSquad", "DeadLand", 0, 0, AFRBlocks._portal2, (Achievement)null)).registerStat();
    	  DeadBattle = (new Achievement("55553" + 2, "DeadBattle", 1, 1, Blocks.anvil, DeadPortal)).registerStat();
    	  DeadRunner = (new Achievement("55553" + 3, "DeadRunner", 2, 2, Blocks.anvil, DeadBattle)).registerStat();
    	  DeadSaller = (new Achievement("55553" + 4, "DeadSaller", 3, 3, Blocks.anvil, DeadRunner)).registerStat();
    	  DeadBuffer = (new Achievement("55553" + 5, "DeadBuffer", 4, 4, Blocks.anvil, DeadSaller)).registerStat();
    	  AchievementPage.registerAchievementPage(new AchievementPage());
    }
}

