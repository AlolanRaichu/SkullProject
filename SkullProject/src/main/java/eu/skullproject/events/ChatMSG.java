package eu.skullproject.events;

import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatMSG {
    public static boolean isAFK = false;
	public static String reason = "";
    
    @SubscribeEvent
    public void onChatMSG(ClientChatReceivedEvent e) {
        String message = e.message.getUnformattedText();
		if (message.contains("From") && isAFK) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/r I am currently AFK. Reason: " + ChatMSG.reason);
		}
	

			

		
    
    }
}
