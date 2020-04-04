package like.invis.us.Managers;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import like.invis.us.Main;

public class ShopGUI implements Listener {
  public static boolean exists(String playername) {
	  if (Main.getInstance().getConfig().contains(playername)) {
		  return true;
	  } else {
		  return false;
	  }
}
  
  @EventHandler
  public void onPCMD(PlayerCommandPreprocessEvent e) {
	  if (e.getMessage().contains("tost")) {
		  addItem(e.getPlayer().getName(), Type.RAINBOW);
	  }
  }
  
  public static void addItem(String playername, Type type) {
    if (type == Type.GOLD) {
      Main.getInstance().getConfig().set(playername + ".GoldKit", true);
      Main.getInstance().saveConfig();
    } else if (type == Type.WDeath) {
      Main.getInstance().getConfig().set(playername + ".WDeath", true);
      Main.getInstance().saveConfig();
    } else if (type == Type.LOVE) {
      Main.getInstance().getConfig().set(playername + ".LOVE", true);
      Main.getInstance().saveConfig();
    } else if (type == Type.EVIL) {
      Main.getInstance().getConfig().set(playername + ".EVIL", true);
      Main.getInstance().saveConfig();
    } else if (type == Type.SHOCKED) {
        Main.getInstance().getConfig().set(playername + ".SHOCKED", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.MEMED) {
        Main.getInstance().getConfig().set(playername + ".MEMED", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.PARTY) {
        Main.getInstance().getConfig().set(playername + ".PARTY", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.HEARTS) {
        Main.getInstance().getConfig().set(playername + ".Hearts", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.ChestO) {
        Main.getInstance().getConfig().set(playername + ".ChestO", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.WATER) {
        Main.getInstance().getConfig().set(playername + ".Gold", true);
        Main.getInstance().saveConfig();
    } else if (type == Type.DVillagerS) {
      Main.getInstance().getConfig().set(playername + ".DVillagerS", true);
    } else if (type == Type.LAVA) {
      Main.getInstance().getConfig().set(playername + ".LAVA", true);
    } else if (type == Type.HAPPYVILLAGER) {
      Main.getInstance().getConfig().set(playername + ".HappyVillager", true);
    } else if (type == Type.ANVIL) {
      Main.getInstance().getConfig().set(playername + ".ANVIL", true);
    } else if (type == Type.AVillager) {
      Main.getInstance().getConfig().set(playername + ".AVillager", true);
    } else if (type == Type.NoteB) {
      Main.getInstance().getConfig().set(playername + ".NoteB", true);
    } else if (type == Type.HVillagerR) {
      Main.getInstance().getConfig().set(playername + ".HVillagerR", true);
    } else if (type == Type.RainbowB) {
      Main.getInstance().getConfig().set(playername + ".RainbowB", true);
    } else if (type == Type.SlimeBall) {
      Main.getInstance().getConfig().set(playername + ".SlimeBall", true);
    } else if (type == Type.Spells) {
      Main.getInstance().getConfig().set(playername + ".Spells", true);
    } else if (type == Type.FOOTSTEP) {
      Main.getInstance().getConfig().set(playername + ".FOOTSTEP", true);
    } else if (type == Type.RAINBOW) {
      Main.getInstance().getConfig().set(playername + ".RainBow", true);
    } else if (type == Type.Explosion) {
      Main.getInstance().getConfig().set(playername + ".Explosion", true);
    } else if (type == Type.Smoke) {
      Main.getInstance().getConfig().set(playername + ".Smoke", true);
    } else if (type == Type.FLAME1) {
      Main.getInstance().getConfig().set(playername + ".FLAME1", true);
    } else if (type == Type.Hearts1) {
      Main.getInstance().getConfig().set(playername + ".Hearts1", true);
    } else if (type == Type.NOTE) {
      Main.getInstance().getConfig().set(playername + ".NOTE", true);
    } else if (type == Type.FireWorkS) {
      Main.getInstance().getConfig().set(playername + ".FireWorkS", true);
    } else if (type == Type.ENDERDEATH) {
      Main.getInstance().getConfig().set(playername + ".DragonDeath", true);
    } else if (type == Type.LEVELUP) {
      Main.getInstance().getConfig().set(playername + ".LevelUP", true);
    } else if (type == Type.BAT) {
      Main.getInstance().getConfig().set(playername + ".BAT", true);
    } else if (type == Type.HORSE) {
      Main.getInstance().getConfig().set(playername + ".Horse", true);
    }
  }
  
  public static boolean chkItem(String playername, String item) {
		if (Main.getInstance().getConfig().contains(playername + "." + item)) {
			if (Main.getInstance().getConfig().getBoolean(playername + "." + item) == true) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
  }
  
  public static boolean getItem(String playername, Type type) {
	    	if (chkItem(playername, "GoldKit")) {
	    		return true;
	    	}
	    	
	    	if (chkItem(playername, "LOVE")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "PARTY")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "SHOCKED")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "EVIL")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "MEMED")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "Hearts")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "WDeath")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "HappyVillager")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "ChestO")) {
	    		return true;
	    	}
	
	    	if (chkItem(playername, "AVillager")) {
	    		return true;
	    	}
	
    	if (chkItem(playername, "Explosion")) {
    		return true;
    	}

    	if (chkItem(playername, "DVillagerS")) {
    		return true;
    	}

    	if (chkItem(playername, "NoteB")) {
    		return true;
    	}

    	if (chkItem(playername, "HVillagerR")) {
    		return true;
    	}

    	if (chkItem(playername, "RainbowB")) {
    		return true;
    	}

    	if (chkItem(playername, "ANVIL")) {
    		return true;
    	}

    	if (chkItem(playername, "SlimeBall")) {
    		return true;
    	}

    	if (chkItem(playername, "Spells")) {
    		return true;
    	}

    	if (chkItem(playername, "FOOTSTEP")) {
    		return true;
    	}

    	if (chkItem(playername, "LAVA")) {
    		return true;
    	}

    	if (chkItem(playername, "WATER")) {
    		return true;
    	}

    	if (chkItem(playername, "RainBow")) {
    		return true;
    	}

    	if (chkItem(playername, "Smoke")) {
    		return true;
    	}

    	if (chkItem(playername, "FLAME1")) {
    		return true;
    	}

    	if (chkItem(playername, "Note")) {
    		return true;
    	}

    	if (chkItem(playername, "FireWorkS")) {
    		return true;
    	}

    	if (chkItem(playername, "BAT")) {
    		return true;
    	}

    	if (chkItem(playername, "DragonDeath")) {
    		return true;
    	}

    	if (chkItem(playername, "LevelUP")) {
    		return true;
    	}
	    return false;
}
  
  public static enum Type {
    GOLD("GOLD", 0, "GOLD", 0),  LAVA("LAVA", 1, "LAVA", 1),  HEARTS("HEARTS", 2, "HEARTS", 2),  WATER("WATER", 3, "WATER", 3),  HAPPYVILLAGER("HAPPYVILLAGER", 4, "HAPPYVILLAGER", 4),  AVillager("AVillager", 5, "AVillager", 5),  FOOTSTEP("FOOTSTEP", 6, "FOOTSTEP", 6),  RainbowB("RainbowB", 7, "RainbowB", 7),  SlimeBall("SlimeBall", 8, "SlimeBall", 8),  Spells("Spells", 9, "Spells", 9),  NoteB("NoteB", 10, "NoteB", 10),  RAINBOW("RAINBOW", 11, "RAINBOW", 11),  Smoke("Smoke", 12, "Smoke", 12),  FLAME1("FLAME1", 13, "FLAME1", 13),  Hearts1("Hearts1", 14, "Hearts1", 14),  NOTE("NOTE", 15, "NOTE", 15),  HVillagerR("HVillagerR", 16, "HVillagerR", 16),  FireWorkS("FireWorkS", 17, "FireWorkS", 17),  HORSE("HORSE", 18, "HORSE", 18),  LEVELUP("LEVELUP", 19, "LEVELUP", 19),  ENDERDEATH("ENDERDEATH", 20, "ENDERDEATH", 20),  BAT("BAT", 21, "BAT", 21),  ANVIL("ANVIL", 22, "ANVIL", 22),  DVillagerS("DVillagerS", 23, "DVillagerS", 23),  Explosion("Explosion", 24, "Explosion", 24),  ChestO("ChestO", 25, "ChestO", 25),  WDeath("WDeath", 26, "WDeath", 26),  EVIL("EVIL", 27, "EVIL", 27),  PARTY("PARTY", 28, "PARTY", 28),  LOVE("LOVE", 29, "LOVE", 29),  SHOCKED("SHOCKED", 30, "SHOCKED", 30),  MEMED("MEMED", 31, "MEMED", 31);
    
    private Type(String s2, int n2, String s, int n) {}
  }
}
