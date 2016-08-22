package eu.skullproject;

import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import net.minecraftforge.client.ClientCommandHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.dto.PlayerInfo;

import eu.skullproject.commands.*;
import eu.skullproject.cosmetics.LayerCape;
import eu.skullproject.events.*;
import eu.skullproject.util.CheckPlayer;

@Mod(name = Source.mod_Name,
     modid = Source.modid,
     version = Source.mod_VersionName)
public class SkullProject
{
	public static final String guildLeader = "CoalOres";
    public static Collection<String> guildMembers = new ArrayList<String>();
    public static Map<UUID, String> stringCache = new HashMap<java.util.UUID, String>();
	public static boolean cape = true;
//================ INITIALIZATION ================ //
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
        /*
         *  CODE
         */	
        } catch(Exception e) {
            this.logWarn("error found during preInit.");
            e.printStackTrace();
        }
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    // Player Loader //
//    CheckPlayer.run();
    guildMembers.add("AlolanRaichu");
    guildMembers.add("UUUUUU");
    guildMembers.add("Lxtten");
    guildMembers.add("CoalOres");
    guildMembers.add("Simbae");
    guildMembers.add("ShimkyBabexox");
    System.out.println("Loaded leader: " + guildLeader);
    for (String Members: guildMembers) {
        System.out.println("Loaded member: " + Members);
     }
    // Event Handles //
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    // Register Events //
        MinecraftForge.EVENT_BUS.register(new TickTock());
        MinecraftForge.EVENT_BUS.register(new ChatMSG());
        MinecraftForge.EVENT_BUS.register(new ServerDetector());
        MinecraftForge.EVENT_BUS.register(new RenderTag());
        MinecraftForge.EVENT_BUS.register(new Keybinds());
    // Register Commands //  
        ClientCommandHandler.instance.registerCommand(new ToggleCape());
        ClientCommandHandler.instance.registerCommand(new AFKCommand());
        ClientCommandHandler.instance.registerCommand(new PingCommand());
        ClientCommandHandler.instance.registerCommand(new SkywarsJoin());
        ClientCommandHandler.instance.registerCommand(new WtfGameCommand());
    // Keybinds //
		Keybinds.killKey = new KeyBinding("/kill", Keyboard.KEY_K, "Team Skull");
		ClientRegistry.registerKeyBinding(Keybinds.killKey);
    }    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
      for (RenderPlayer render : Minecraft.getMinecraft().getRenderManager().getSkinMap().values())
      {
          render.addLayer(new LayerCape(render));
      }
    }
    
//================ INSTANCE ================ //
    private static SkullProject instance;
    
    public static SkullProject instance()
    {
      return instance;
    }
    
//================ LOGGER ================ //
    private Logger LOGGER;
    
    public Logger getLOGGER() {
        return LOGGER;
    }

    public void logInfo(String abc) {
    this.LOGGER.info(Source.logTag + abc);
    }
    
    public void logWarn(String abc) {
        this.LOGGER.warn(Source.logTag + abc);
    }

    public void logError(String abc) {
        this.LOGGER.error(Source.logTag + abc);
    }
    
//================ END ================ //

}
