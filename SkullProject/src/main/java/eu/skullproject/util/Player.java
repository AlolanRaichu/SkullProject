package eu.skullproject.util;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;

public class Player {
	public static void Talk(String abc) {
		Minecraft.getMinecraft().thePlayer.sendChatMessage(abc);  
	}
	
	public static void DelayedTalk(final String abc, int time) {
			    new Timer().schedule(new TimerTask()
			    {
			      public void run()
			      {
		Minecraft.getMinecraft().thePlayer.sendChatMessage(abc);
			      }
			    }, time);
		  }	  
}
