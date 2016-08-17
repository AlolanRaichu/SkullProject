package eu.skullproject.events;

import eu.skullproject.util.Player;
import eu.skullproject.util.Randomizer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatMSG {
    public static boolean isAFK = false;
	public static String reason = "";
	public static String name = "";
    
    @SubscribeEvent
    public void onChatMSG(ClientChatReceivedEvent e) {
        String message = e.message.getUnformattedText();
		if (message.startsWith("From") && isAFK) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/r I am currently AFK. Reason: " + ChatMSG.reason);
		}
		if (message.endsWith("joined the guild!") && !message.contains(":")) {
			Player.Talk("/gchat " + Randomizer.runWelcome());
		}
    }
}
