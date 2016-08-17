package eu.skullproject.events;

import com.mojang.realmsclient.dto.PlayerInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEntity {

	@SubscribeEvent
	 public void onRenderEntity(RenderPlayerEvent.Pre event) {
	}
}
	