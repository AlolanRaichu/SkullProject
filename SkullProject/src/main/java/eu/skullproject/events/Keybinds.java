package eu.skullproject.events;

import eu.skullproject.util.Player;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class Keybinds {
    public static KeyBinding killKey;
    
    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent e) {
        if(this.killKey.isPressed()) {
            Player.Talk("/kill");
        }
   }
}
