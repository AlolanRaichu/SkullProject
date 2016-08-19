package eu.skullproject.commands;

import com.google.common.base.Joiner;

import eu.skullproject.events.ChatMSG;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class AFKCommand extends CommandBase {

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {

		return true;
	}	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) throws CommandException {
	if (args.length > 0){
		//Checks what the user enters after /afk
		if(args[0].equalsIgnoreCase("cancel"))  {
				ChatMSG.isAFK = false;
				icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You are no longer AFK!"));}
		
		
		else if (ChatMSG.isAFK == false) {
		    ChatMSG.isAFK = true;
		    icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You are now AFK!"));
		    ChatMSG.reason = Joiner.on(" ").join(args);
		    
	    }
	}
	else {
		icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_AQUA + "You must enter a reason!"));
	}

}	

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {

		return "afk <reason>";
	}

	@Override
	public String getCommandName() {

		return "afk";
	}


}
