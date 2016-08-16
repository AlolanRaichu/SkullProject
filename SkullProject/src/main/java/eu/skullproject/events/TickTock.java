package eu.skullproject.events;

import eu.skullproject.SkullProject;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TickTock {
    int updates = 0;
    int justJoined = 1;
    private int tickCount = 0;
    long waitUntil = System.currentTimeMillis();
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = false)
    public void tick(TickEvent.ClientTickEvent event) {
        // fire once per tick
        if(event.phase == TickEvent.Phase.START) return;
        Minecraft mc = Minecraft.getMinecraft();
        if(!mc.isGamePaused() && mc.thePlayer  != null && mc.theWorld != null) {

            if(System.currentTimeMillis() < waitUntil) {
                if(updates > 0) {
                    updates = 0;
                }
                return;
            }

            if (SkullProject.guildMembers.isEmpty()) return;
                for (EntityPlayer entityPlayer : mc.theWorld.playerEntities) {
                    final String name = entityPlayer.getName();

                    if (SkullProject.guildMembers.contains(name)) {
                        boolean isMaster = false;
                        if (name.equals(SkullProject.guildLeader)) isMaster = true;
                        String displayMessage;
                        if (isMaster) {
                            displayMessage = "" + EnumChatFormatting.WHITE + "[SKULL LEADER]";
                        } else {
                            displayMessage = "" + EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD "[SKULL MEMBER]";
                        }
                        SkullProject.stringCache.put(entityPlayer.getUniqueID(), displayMessage);
                    }
                }
        	}
    }
}
