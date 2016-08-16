package eu.skullproject.events;

import eu.skullproject.util.Player;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class Keybinds {
    public static String PP_KEY_CAT = "Pixel+ Keys";
    public static KeyBinding killKey;
    public static KeyBinding hubKey;
    
    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent e) {
        if(this.killKey.isPressed()) {
            Player.Talk("/kill");
        }
        if (this.hubKey.isPressed()) {
            Player.Talk("/hub");
            Player.Talk("I like men!");
            
            
        }
     if (this.hubKey.isPressed()) {
            Player.Talk("I like men!");
            
}
}
