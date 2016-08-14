package eu.skullproject;

import net.minecraftforge.client.ClientCommandHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.skullproject.commands.*;
import eu.skullproject.events.ChatMSG;
import eu.skullproject.events.ServerDetector;
@Mod(name = Source.mod_Name,
     modid = Source.modid,
     version = Source.mod_VersionName)
public class SkullProject
{
//================ INITIALIZATION ================ //
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
        /*
         *  CODE
         */	
        } catch(Exception e) {
            this.logWarn("[" + Source.mod_Name + "] error found during preInit.");
            e.printStackTrace();
        }
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    // Event Handles //
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    // Register Events //
        MinecraftForge.EVENT_BUS.register(new ChatMSG());
        MinecraftForge.EVENT_BUS.register(new ServerDetector());
    // Register Commands //  
        ClientCommandHandler.instance.registerCommand(new Test());
        ClientCommandHandler.instance.registerCommand(new AFKCommand());
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
