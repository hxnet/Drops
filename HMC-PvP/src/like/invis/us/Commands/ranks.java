package like.invis.us.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ranks implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    if (cmd.getName().equalsIgnoreCase("ranks")) {
    	if (args.length == 0) {
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§m-----------§a PVP (1/2) §7§m-----------");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§4§lJohn Wick §8» §d§lTOP PLAYER.");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§c§lSaitama §8» §d§lHIGHEST RANK.");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lThanos §8» §f[✪250000 - 500000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§2§lApocalypse §8» §f[✪125000 - 250000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lCaptain Marvel §8» §f[✪80000 - 125000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§e§lIron Man §8» §f[✪60000 - 80000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§bCaptain America §8» §f[✪45000 - 60000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6Doctor Strange §8» §f[✪35000 - 45000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§dBlack Panther §8» §f[✪25000 - 35000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§cDeadpool §8» §f[✪14500 - 25000]");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7More Ranks? Type: /ranks 2");
	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7§m-----------§a PVP (1/2) §7§m-----------");
    	} else {
    		if (args[0].contains("1")) {
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§m-----------§a PVP (1/2) §7§m-----------");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§4§lJohn Wick §8» §d§lTOP PLAYER.");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§c§lSaitama §8» §d§lHIGHEST RANK.");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lThanos §8» §f[✪250000 - 500000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§2§lApocalypse §8» §f[✪125000 - 250000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lCaptain Marvel §8» §f[✪80000 - 125000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§e§lIron Man §8» §f[✪60000 - 80000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§bCaptain America §8» §f[✪45000 - 60000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6Doctor Strange §8» §f[✪35000 - 45000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§dBlack Panther §8» §f[✪25000 - 35000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§cDeadpool §8» §f[✪14500 - 25000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7More Ranks? Type: /ranks 2");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7§m-----------§a PVP (1/2) §7§m-----------");
    		} else if (args[0].contains("2")) {
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7§m-----------§a PVP (2/2) §7§m-----------");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§aThor §8» §f[✪10500 - 14500]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§2Hulk §8» §f[✪9100 - 10500]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§4Spider Man §8» §f[✪7100 - 9100]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§cWolverine §8» §f[✪4500 - 7100]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6Ant Man §8» §f[✪3600 - 4500]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§5Black Widow §8» §f[✪2800 - 3600]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§dVision §8» §f[✪1000 - 2800]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§3Daredevil §8» §f[✪600 - 1000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§bHawkeye §8» §f[✪250 - 600]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7Falcon §8» §d§lFIRST RANK.");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7§m-----------§a PVP (2/2) §7§m-----------");
    		} else {
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§m-----------§a PVP (1/2) §7§m-----------");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§4§lJohn Wick §8» §d§lTOP PLAYER.");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§c§lSaitama §8» §d§lHIGHEST RANK.");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lThanos §8» §f[✪250000 - 500000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§2§lApocalypse §8» §f[✪125000 - 250000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6§lCaptain Marvel §8» §f[✪80000 - 125000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§e§lIron Man §8» §f[✪60000 - 80000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§bCaptain America §8» §f[✪45000 - 60000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§6Doctor Strange §8» §f[✪35000 - 45000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§dBlack Panther §8» §f[✪25000 - 35000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§cDeadpool §8» §f[✪14500 - 25000]");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7More Ranks? Type: /ranks 2");
    	        p.sendMessage("§8▏ §eHozexMC §8▏ §7§7§m-----------§a PVP (1/2) §7§m-----------");
    		}
    	}
    }
	return false;
  }
}
