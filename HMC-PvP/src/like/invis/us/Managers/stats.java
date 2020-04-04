package like.invis.us.Managers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import like.invis.us.Main;


public class stats implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().contains("hello")) {
			addCoins(e.getPlayer().getName(), 300);
			addPoints(e.getPlayer().getName(), 1000);
		}
	}
	
	  public static Integer getCoins(String str) {
		    int money = Main.getInstance().getConfig().getInt(str + ".coins");
		    return money;
		  }
	  
	  public static Integer getPoints(String str) {
		    int money = Main.getInstance().getConfig().getInt(str + ".points");
		    return money;
		  }
	  
	  public static void addCoins(String str, int num) {
		    int money = Main.getInstance().getConfig().getInt(str + ".coins");
		    Main.getInstance().getConfig().set(str + ".coins", money + num);
		    Main.getInstance().saveConfig();
		  }
	  
	  public static void addPoints(String str, int num) {
		    int money = Main.getInstance().getConfig().getInt(str + ".points");
		    Main.getInstance().getConfig().set(str + ".points", money + num);
		    Main.getInstance().saveConfig();
		  }
	  
	  
	  public static void removeCoins(String str, int num) {
		    int money = Main.getInstance().getConfig().getInt(str + ".coins");
		    int fin = money - num;
		    if (fin <= 0) {
			    Main.getInstance().getConfig().set(str + ".coins", 0);
			    Main.getInstance().saveConfig();
		    } else {
			    Main.getInstance().getConfig().set(str + ".coins", fin);
			    Main.getInstance().saveConfig();
		    }
		  }
	  
	  public static void removePoints(String str, int num) {
		    int money = Main.getInstance().getConfig().getInt(str + ".points");
		    int fin = money - num;
		    if (fin <= 0) {
			    Main.getInstance().getConfig().set(str + ".points", 0);
			    Main.getInstance().saveConfig();
		    } else {
			    Main.getInstance().getConfig().set(str + ".points", fin);
			    Main.getInstance().saveConfig();
		    }
		  }
	  
	  public static void setCoins(String str, int num) {
		    Main.getInstance().getConfig().set(str + ".coins", num);
		    Main.getInstance().saveConfig();
	}
	  
	  public static void setPoints(String str, int num) {
		    Main.getInstance().getConfig().set(str + ".points", num);
		    Main.getInstance().saveConfig();
	}
	  
	  public static boolean isValid(String str) {
		  if (Main.getInstance().getConfig().contains(str + ".coins")) {
			  return true;
		  } else {
			  return false;
		  }
	  }

}
