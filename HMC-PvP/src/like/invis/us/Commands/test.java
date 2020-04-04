package like.invis.us.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;

public class test implements CommandExecutor, Listener {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			hideNameTag((Player) sender, true);
		}
		return false;
	}
	
	  public static void hideNameTag(Player p, boolean TF) {
		    for (Player online : Bukkit.getOnlinePlayers()) {
		      org.bukkit.scoreboard.Scoreboard scoreboard = online.getScoreboard();
		      if (scoreboard == Bukkit.getScoreboardManager().getMainScoreboard()) {
		        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		      }
		      Team team = scoreboard.getTeam("Hide");
		      if (team == null) {
		        team = scoreboard.registerNewTeam("Hide");
		      }
		      team.setDisplayName("test");
		      team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
		      if (TF == true) {
			      team.addEntry(p.getName());
		      } else {
			      team.removeEntry(p.getName());
		      }
		      online.setScoreboard(scoreboard);
		    } 
		  }
}
