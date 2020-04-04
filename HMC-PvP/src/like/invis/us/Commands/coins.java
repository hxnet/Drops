package like.invis.us.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import like.invis.us.Managers.stats;

public class coins implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("coins")) {
			if (args.length == 0 || args.length == 1) {
				p.sendMessage("§7/coins add <player> <int>");
				p.sendMessage("§7/coins remove <player> <int>");
				p.sendMessage("§7/coins set <player> <int>");
				p.sendMessage("§7/coins reset <player>");
			} else if (args.length == 2) {
				Player t = Bukkit.getPlayer(args[1]);
				if (args[0].contains("reset")) {
					if (t != null) {
						stats.setCoins(p.getName(), 0);
						p.sendMessage("Reset " + t.getName() + "'s coins");
					} else {
						p.sendMessage("That player isn't here");
					}
				} else {
					p.sendMessage("§7/coins add <player> <int>");
					p.sendMessage("§7/coins remove <player> <int>");
					p.sendMessage("§7/coins set <player> <int>");
					p.sendMessage("§7/coins reset <player>");
				}
			} else {
				Player t = Bukkit.getPlayer(args[1]);
				if (t != null) {
					if (args[0].contains("add")) {
						stats.addCoins(t.getName(), Integer.valueOf(args[2]));
						p.sendMessage("Add " + Integer.valueOf(args[2]) + " to " + t.getName());
					} else if (args[0].contains("remove")) {
						stats.removeCoins(t.getName(), Integer.valueOf(args[2]));
						p.sendMessage("Remove " + Integer.valueOf(args[2]) + " from " + t.getName());
					} else if (args[0].contains("set")) {
						stats.setCoins(t.getName(), Integer.valueOf(args[2]));
						p.sendMessage("Set " + t.getName() + "'s coins to " + Integer.valueOf(args[2]));
					} else if (args[0].contains("reset")) {
						stats.setCoins(t.getName(), 0);
						p.sendMessage("Reset " + t.getName() + "'s coins");
					}
				} else {
					p.sendMessage("That player isn't here");
				}
			}
		}
		return false;
	}

}
