package eu.skullproject.commands;

import java.util.ArrayList;


import java.util.List;

import com.google.common.base.Joiner;

import eu.skullproject.SkullProject;
import eu.skullproject.events.ChatMSG;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ToggleCape extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "togglecape";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "togglecape";
		
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
			if(SkullProject.cape)  {
				SkullProject.cape = false;
					sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You have disabled your cape!"));
					} else { 
				SkullProject.cape = true;
					sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You have enabled your cape!"));}
					}
	   @Override
	    public boolean canCommandSenderUseCommand(ICommandSender sender) {
	        return true;
	    }

	
}