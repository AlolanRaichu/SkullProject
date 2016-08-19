package eu.skullproject.util;

import net.minecraft.client.Minecraft;

public class ScoreboardReader {
	
	public static String boardTitle = "o";
	public static void read() {
	if (Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(0) != null) {
        boardTitle = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(0).getDisplayName();
        } else if (Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1) != null) {
        boardTitle = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
        }
	}
}
