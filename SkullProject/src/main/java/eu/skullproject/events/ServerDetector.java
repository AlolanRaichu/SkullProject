package eu.skullproject.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;

public class ServerDetector {
	
    public static boolean onHypixel = false;
    public static boolean onBadlion = false;
    
    @SubscribeEvent
    public void playerLoggedIn(ClientConnectedToServerEvent event) {
        if (event.manager.getRemoteAddress().toString().toLowerCase().contains(".hypixel.net")) { 
        onHypixel = true;
        }
        
        if (event.manager.getRemoteAddress().toString().toLowerCase().contains(".badlion.net")) { 
        	onBadlion = true;
        }
    }

    
    @SubscribeEvent
    public void playerLoggedOut(ClientDisconnectionFromServerEvent event) {
        	onHypixel = false; 
        	onBadlion = false; 
    }
}
