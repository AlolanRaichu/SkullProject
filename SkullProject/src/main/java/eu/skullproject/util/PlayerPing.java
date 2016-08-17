package eu.skullproject.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.EnumChatFormatting;

public class PlayerPing {
	 public static String getPingInformation()
	   {
	      NetHandlerPlayClient handler = Minecraft.getMinecraft().thePlayer.sendQueue;
	      List list = new ArrayList(handler.getPlayerInfoMap());
	      Iterator iterator = list.iterator();

	      while (iterator.hasNext())
	      {
	         NetworkPlayerInfo networkplayerinfo = (NetworkPlayerInfo) iterator.next();
	         EnumChatFormatting enumchatformatting;
	         if (networkplayerinfo.getResponseTime() <= 0) enumchatformatting = EnumChatFormatting.RED;
	         else if (networkplayerinfo.getResponseTime() < 150) enumchatformatting = EnumChatFormatting.GREEN;
	         else if (networkplayerinfo.getResponseTime() < 300) enumchatformatting = EnumChatFormatting.YELLOW;
	         else if (networkplayerinfo.getResponseTime() < 600) enumchatformatting = EnumChatFormatting.GOLD;
	         else if (networkplayerinfo.getResponseTime() < 1000) enumchatformatting = EnumChatFormatting.RED;
	         else enumchatformatting = EnumChatFormatting.DARK_RED;
	         return "Ping: " + enumchatformatting + (networkplayerinfo.getResponseTime() <= 0 ? "Unavailable" : networkplayerinfo.getResponseTime());
	      }

	      return "Ping: Unavailable";
	   }

}
