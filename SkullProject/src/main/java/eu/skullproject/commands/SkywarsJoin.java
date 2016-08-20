package eu.skullproject.commands;

import java.util.ArrayList;

import java.util.Math.*;
import java.util.List;

import com.google.common.base.Joiner;

import eu.skullproject.SkullProject;
import eu.skullproject.events.ServerDetector;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SkywarsJoin extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "sw";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "sw <solo/team/mega/ranked> <normal/insane>";
		
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		int value = (int)(Math.random() * 6 + 1);
		while (true) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("I LIKE MEN!" + value );	
		}
		if (ServerDetector.onHypixel){
            if (args[0].equalsIgnoreCase("solo")) {
            	//Solo
            	if(args[1].equalsIgnoreCase("normal")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_normal");	
            	} else if(args[1].equalsIgnoreCase("insane") ){
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_insane");	
            	}      //Teams
                }else if (args[0].equalsIgnoreCase("teams")) {
            	       if(args[1].equalsIgnoreCase("normal")) {
                       Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_normal");	
                	   } else if(args[1].equalsIgnoreCase("insane") ){
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_insane");	
                	   } //Ranked
                } else if(args[0].equalsIgnoreCase("ranked") ){
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/play ranked_normal");	
                } else if(args[0].equalsIgnoreCase("mega")){ //Mega
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/play mega_normal");	                 
                }else{
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "Please use /sw <solo/teams/mega/ranked> <normal/insane>"));
                }
        } else {
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You are not on hypixel!"));
	}
	}
	   @Override
	    public boolean canCommandSenderUseCommand(ICommandSender sender) {
	        return true;
	    }

	
}
