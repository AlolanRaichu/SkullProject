package eu.skullproject.util;

import java.util.UUID;

import eu.skullproject.Source;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.FMLClientHandler;

public class CheckPlayer {
    public static UUID UUID;
    private boolean allowed = false;
	public static void run(){
    Minecraft minecraft = FMLClientHandler.instance().getClient();
    UUID = minecraft.getSession().getProfile().getId();
    String stringUUID = UUID.toString();
    if(!Source.memberUUIDs.contains(stringUUID)){
    	Minecraft.getMinecraft().shutdown();
    }
  }
}
