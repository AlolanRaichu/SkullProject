package eu.skullproject.events;

import eu.skullproject.cosmetics.LayerCape;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEntity {
	 
	@SubscribeEvent
	 public void onRenderEntity(RenderPlayerEvent.Pre event) {
	 
	 if(event.entity instanceof EntityPlayer) {
		 EntityPlayer player = (EntityPlayer)event.entity;
		 
		 event.renderer.addLayer(new LayerCape(event.renderer, event.entity.getName()));
		 
		 }
	}
}
	