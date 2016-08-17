package eu.skullproject.commands;



import eu.skullproject.util.PlayerPing;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PingCommand extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "ping";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "ping";
		
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		String x = PlayerPing.getPingInformation();
		sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BOLD + x));
	}
		
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

}


