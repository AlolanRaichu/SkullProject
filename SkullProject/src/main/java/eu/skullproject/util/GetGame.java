package eu.skullproject;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;



public class GetGame {
	public static String scoreTitle = "";


	public static String getScoreTitle() {
		
		ScoreObjective scoreobjective = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
		GetGame.scoreTitle = scoreobjective.getDisplayName();
		return scoreTitle.toString();
	
		}
	

		

}
