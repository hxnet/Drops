package like.invis.us.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import like.invis.us.Main;

public class togglerank implements CommandExecutor {
	
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("togglerank") || cmd.getName().equalsIgnoreCase("toggle") || cmd.getName().equalsIgnoreCase("t")) {
    	 if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper") || p.hasPermission("H.VIP") || p.hasPermission("H.Builder") || p.hasPermission("H.Emerald") || p.hasPermission("H.Diamond") || p.hasPermission("H.Gold") || p.hasPermission("H.YouTuber")) {
	    	  if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
      	          p.sendMessage("§8▏ §cHozexMC §8▏ §7Please leave spectator mode to use this command");
	    	  } else {
	    	      if (Main.getInstance().getConfig().getBoolean("IsToggled." + p.getName()) == false) {
	      	          p.sendMessage("§8▏ §aHozexMC §8▏ §7ToggleRank §8» §aON");
	      	          Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " prefix &7");
	      	          Main.getInstance().getConfig().set("IsToggled." + p.getName(), true);
	      	          Main.getInstance().saveConfig();
	    	        } else {
	      	          p.sendMessage("§8▏ §aHozexMC §8▏ §7ToggleRank §8» §cOFF");
	      	          Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " clear");
	      	          Main.getInstance().getConfig().set("IsToggled." + p.getName(), false);
	      	          Main.getInstance().saveConfig();
	    	        }
	    	  }
    	} else {
    		p.sendMessage("§8▏ §cHozexMC §8▏ §7You can't use that command");
    	}
    }
    return false;
  }
}
