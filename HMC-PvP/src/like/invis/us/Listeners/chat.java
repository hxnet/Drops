package like.invis.us.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import like.invis.us.Main;
import like.invis.us.Managers.stats;
import me.robin.battlelevels.api.BattleLevelsAPI;

public class chat implements Listener {
  
  @EventHandler
  public void onPlayer2(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if (p.hasPermission("chatcolor")) {
      e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if (Main.getInstance().getConfig().contains("spec." + p.getName())) {
    	if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
            e.setFormat("§8❘ §7" + getRank(p) + " §8❘§7 " + p.getName() + " §8» §7" + Main.getColor(p) + Arabic.changeArabic(e.getMessage()).replace("%", ""));
    	} else {
            if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper") || p.hasPermission("H.VIP") || p.hasPermission("H.Builder") || p.hasPermission("H.Emerald") || p.hasPermission("H.Diamond") || p.hasPermission("H.Gold") || p.hasPermission("H.YouTuber")) {
                e.setFormat("§8❘ §7" + getRank(p) + " §8❘ §7" + Main.getColor(p) + Main.getPrefix(p) + " §8❘§7 " + Main.getColor(p) + p.getDisplayName() + " §8» §7" + Main.getColor(p) + Arabic.changeArabic(e.getMessage()).replace("%", ""));
            } else {
                e.setFormat("§8❘ §7" + getRank(p) + " §8❘§7 " + p.getName() + " §8» §7" + Main.getColor(p) + Arabic.changeArabic(e.getMessage()).replace("%", ""));
            }
    	}
    } else {
        if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper") || p.hasPermission("H.VIP") || p.hasPermission("H.Builder") || p.hasPermission("H.Emerald") || p.hasPermission("H.Diamond") || p.hasPermission("H.Gold") || p.hasPermission("H.YouTuber")) {
            e.setFormat("§8❘ §7" + getRank(p) + " §8❘ §7" + Main.getColor(p) + Main.getPrefix(p) + " §8❘§7 " + Main.getColor(p) + p.getDisplayName() + " §8» §7" + Main.getColor(p) + Arabic.changeArabic(e.getMessage()).replace("%", ""));
        } else {
            e.setFormat("§8❘ §7" + getRank(p) + " §8❘§7 " + p.getName() + " §8» §7" + Main.getColor(p) + Arabic.changeArabic(e.getMessage()).replace("%", ""));
        }
    }
  }
  
  public static String getRank(Player player) {
    if (BattleLevelsAPI.getTopKills().get(0).equals(player.getName())) {
      return "§4§lJohn Wick";
    }
    if (stats.getPoints(player.getName()) >= 500000) {
      return "§c§lSaitama";
    }
    if (stats.getPoints(player.getName()) >= 250000) {
      return "§6Thanos";
    }
    if (stats.getPoints(player.getName()) >= 125000) {
      return "§2Apocalypse";
    }
    if (stats.getPoints(player.getName()) >= 80000) {
      return "§6Captain Marvel";
    }
    if (stats.getPoints(player.getName()) >= 60000) {
      return "§eIron Man";
    }
    if (stats.getPoints(player.getName()) >= 45000) {
      return "§bCaptain America";
    }
    if (stats.getPoints(player.getName()) >= 35000) {
      return "§6Doctor Strange";
    }
    if (stats.getPoints(player.getName()) >= 25000) {
      return "§dBlack Panther";
    }
    if (stats.getPoints(player.getName()) >= 14500) {
      return "§cDeadpool";
    }
    if (stats.getPoints(player.getName()) >= 10500) {
      return "§aThor";
    }
    if (stats.getPoints(player.getName()) >= 9100) {
      return "§2Hulk";
    }
    if (stats.getPoints(player.getName()) >= 7800) {
      return "§4Spider Man";
    }
    if (stats.getPoints(player.getName()) >= 4500) {
      return "§cWolverine";
    }
    if (stats.getPoints(player.getName()) >= 3600) {
      return "§6Ant Man";
    }
    if (stats.getPoints(player.getName()) >= 2800) {
      return "§5Black Widow";
    }
    if (stats.getPoints(player.getName()) >= 1000) {
      return "§dVision";
    }
    if (stats.getPoints(player.getName()) >= 600) {
      return "§3Daredevil";
    }
    if (stats.getPoints(player.getName()) >= 250) {
      return "§bHawkeye";
    }
    return "§7Falcon";
  }
}