package like.invis.us.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import like.invis.us.Managers.Inventory;

public class kits implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kits") || cmd.getName().equalsIgnoreCase("kit") || cmd.getName().equalsIgnoreCase("k")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Inventory.openChangeKit(p);
			} else {
				if (args[0].toLowerCase().equals("emerald")) {
					//Emerald
				} else if (args[0].toLowerCase().equals("diamond")) {
					//Diamond
				} else if (args[0].toLowerCase().equals("gold")) {
					//Gold
				} else if (args[0].toLowerCase().equals("youtuber") || args[0].toLowerCase().equals("yt")) {
					//YouTuber
				} else if (args[0].toLowerCase().equals("default") || args[0].toLowerCase().equals("member")) {
					//Default
				}
			}
		}
		return false;
	}

}