package eu.skullproject.events;

import eu.skullproject.util.Player;
import eu.skullproject.util.Randomizer;
import eu.skullproject.util.ScoreboardReader;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatMSG {
    public static boolean isAFK = false;
	public static String reason = "";
	public static String name = "";
	public static String mwteam = "";
    
    @SubscribeEvent
    public void onChatMSG(ClientChatReceivedEvent e) {
        String message = e.message.getUnformattedText();
        // AFK helper. //
		if (message.startsWith("From") && isAFK) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/r I am currently AFK. Reason: " + ChatMSG.reason);
		}
		// Guild welcome! //
		if (message.endsWith("joined the guild!") && !message.contains(":")) {
			Player.Talk("/gchat " + Randomizer.runWelcome());
		}
	//MEGAWALLS
        if(message.contains("The game has started! You are on") && message.endsWith("Team, the walls will fall down in 10 minutes.")) {
        	if(message.contains("Green")){
        		mwteam = "green";
        } else if(message.contains("Blue")){
    		mwteam = "blue";
    } else if(message.contains("Yellow")){
		mwteam = "yellow";
    } else if(message.contains("Red")){
		mwteam = "red";
}
        	System.out.println(mwteam);
        }
    }
}
