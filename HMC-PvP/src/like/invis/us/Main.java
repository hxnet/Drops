package like.invis.us;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import de.jaxophon.mysql.sql.MySQL;
import like.invis.us.Commands.VanishIndication;
import like.invis.us.Commands.coins;
import like.invis.us.Commands.kits;
import like.invis.us.Commands.ranks;
import like.invis.us.Commands.test;
import like.invis.us.Commands.togglerank;
import like.invis.us.Listeners.Arabic;
import like.invis.us.Listeners.Basics;
import like.invis.us.Listeners.BlockDelay;
import like.invis.us.Listeners.BowListener;
import like.invis.us.Listeners.Flint;
import like.invis.us.Listeners.GoldenHead;
import like.invis.us.Listeners.JumpPad;
import like.invis.us.Listeners.KitsListener;
import like.invis.us.Listeners.chat;
import like.invis.us.Managers.Inventory;
import like.invis.us.Managers.KitsManager;
import like.invis.us.Managers.ShopGUI;
import like.invis.us.Managers.stats;

public class Main extends JavaPlugin implements Listener {
  public static MySQL mysql = new MySQL("eu.sql.titannodes.com", "s4659_utilts", "u4659_2CTFsndH3A", "mGmYpuTdCXOxh3okbmFTLSmj");
  public static Main main;
  private static Main instance;
  public static String Prefix;
  public static String PrefixError;
  public static String PrefixBigError;
  public static String PrefixSuccess;
  public static ArrayList<String> spec;
  public static ArrayList<String> list;
//  public MessageListener ml;
  public String[] servers = null;
  
  public void onEnable() {
	  
	    getConfig().addDefault("Cooldown", Integer.valueOf(2));
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    
	    main = this;
	    
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
//	    Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessageListener(this));
	    
	    getServers();
	    
//	    this.ml = new MessageListener(this);
	    
	    PluginManager pm = getServer().getPluginManager();
	    
//	    pm.registerEvents(new PreCommandListener(this), this);
	    
	    Bukkit.getServer().getPluginManager().registerEvents(new KitsManager(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Inventory(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new ShopGUI(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new VanishIndication(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Arabic(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Basics(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new BlockDelay(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new BowListener(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new chat(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Flint(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new GoldenHead(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new JumpPad(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new stats(), this);
	    getCommand("kits").setExecutor(new kits());
	    getCommand("spec").setExecutor(new VanishIndication(this));
	    getCommand("togglerank").setExecutor(new togglerank());
	    getCommand("toggle").setExecutor(new togglerank());
	    getCommand("t").setExecutor(new togglerank());
	    getCommand("test").setExecutor(new test());
	    getCommand("coins").setExecutor(new coins());
	    
	    if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
	    	throw new RuntimeException("§cCan't find PlaceholderAPI!");
	    }
	    
	  }
  
  public Main() {
    Prefix = ChatColor.translateAlternateColorCodes('&', "§8❘ §eHozexMC §8❘ §7");
    PrefixError = ChatColor.translateAlternateColorCodes('&', "§8❘ §cHozexMC §8❘ §7");
    PrefixSuccess = ChatColor.translateAlternateColorCodes('&', "§8❘ §aHozexMC §8❘ §7");
    PrefixBigError = ChatColor.translateAlternateColorCodes('&', "§8❘ §4HozexMC §8❘ §c");
    getConfig().getList("Letters");
  }
  
  public static Main getInstance() {
    return instance;
  }
  
  public static String getPrefix(Player p) {
	    String rank = "";
	    if (Main.getInstance().getConfig().contains("spec." + p.getName())) {
	    	if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
	  	      rank = "Default";
	    	}
	    }
	    if (p.hasPermission("H.Owner")) {
	      rank = "Owner";
	    } else if (p.hasPermission("H.HeadAdmin")) {
	      rank = "HeadAdmin";
	    } else if (p.hasPermission("H.Admin")) {
	      rank = "Admin";
	    } else if (p.hasPermission("H.Developer")) {
	        rank = "Dev";
	      } else if (p.hasPermission("H.Special")) {
	      rank = "Special";
	    } else if (p.hasPermission("H.SrMod")) {
	      rank = "§4Sr§cMod";
	    } else if (p.hasPermission("H.Mod")) {
	      rank = "Mod";
	    } else if (p.hasPermission("H.Helper")) {
	      rank = "Helper";
	    } else if (p.hasPermission("H.Builder")) {
	      rank = "Builder";
	    } else if (p.hasPermission("H.VIP")) {
	      rank = "VIP";
	    } else if (p.hasPermission("H.Emerald")) {
	      rank = "Emerald";
	    } else if (p.hasPermission("H.Diamond")) {
	      rank = "Diamond";
	    } else if (p.hasPermission("H.Gold")) {
	      rank = "Gold";
	    } else if (p.hasPermission("H.YouTuber")) {
	      rank = "YouTuber";
	    } else if (p.hasPermission("H.Default")) {
	      rank = "Default";
	    }
	    return rank;
	  }
	  
	  public static String getColor(Player p) {
	    String color = "";
	    if (Main.getInstance().getConfig().contains("spec." + p.getName())) {
	    	if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
	  	      color = "§7";
	    	}
	    }
	    if (p.getName().equals("InVisTeK_")) {
	      color = "§e";
	    } else if (p.hasPermission("H.HeadAdmin")) {
	      color = "§6";
	    } else if (p.hasPermission("H.Admin")) {
	      color = "§4";
	    } else if (p.hasPermission("H.Developer")) {
	        color = "§f";
	      } else if (p.hasPermission("H.Special")) {
	      color = "§f";
	    } else if (p.hasPermission("H.SrMod")) {
	      color = "§4";
	    } else if (p.hasPermission("H.Mod")) {
	      color = "§c";
	    } else if (p.hasPermission("H.Helper")) {
	      color = "§3";
	    } else if (p.hasPermission("H.Builder")) {
	      color = "§2";
	    } else if (p.hasPermission("H.VIP")) {
	      color = "§5";
	    } else if (p.hasPermission("H.Emerald")) {
	      color = "§a";
	    } else if (p.hasPermission("H.Diamond")) {
	      color = "§b";
	    } else if (p.hasPermission("H.Gold")) {
	      color = "§6";
	    } else if (p.hasPermission("H.YouTuber")) {
	      color = "§5";
	    } else if (p.hasPermission("H.Default")) {
	      color = "§7";
	    }
	    return color;
	  }
	  
	  public static String getColorC(Player p) {
	    String color = "";
	    if (Main.getInstance().getConfig().contains("spec." + p.getName())) {
	    	if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
	  	      color = "§7";
	    	}
	    }
	    if (p.getName().equals("InVisTeK_")) {
	      color = "§e";
	    } else if (p.hasPermission("H.HeadAdmin")) {
	      color = "§e";
	    } else if (p.hasPermission("H.Admin")) {
	      color = "§4";
	    } else if (p.hasPermission("H.Special")) {
	      color = "§f";
	    } else if (p.hasPermission("H.Developer")) {
	      color = "§f";
	    } else if (p.hasPermission("H.SrMod")) {
	      color = "§c";
	    } else if (p.hasPermission("H.Mod")) {
	      color = "§c";
	    } else if (p.hasPermission("H.Helper")) {
	      color = "§3";
	    } else if (p.hasPermission("H.Builder")) {
	      color = "§2";
	    } else if (p.hasPermission("H.VIP")) {
	      color = "§5";
	    } else if (p.hasPermission("H.Emerald")) {
	      color = "§a";
	    } else if (p.hasPermission("H.Diamond")) {
	      color = "§b";
	    } else if (p.hasPermission("H.Gold")) {
	      color = "§6";
	    } else if (p.hasPermission("H.YouTuber")) {
	      color = "§5";
	    } else if (p.hasPermission("H.Default")) {
	      color = "§7";
	    }
	    return color;
	  }

public static String getRankColor(Player p) {
	    if (p.hasPermission("H.Owner")) {
	        return "§e";
	      }
	      if (p.hasPermission("H.HeadAdmin")) {
		        return "§4";
		      }
	      if (p.hasPermission("H.Admin")) {
		        return "§4";
		      }
	      if (p.hasPermission("H.SrMod")) {
	        return "§4";
	      }
	      if (p.hasPermission("H.Developer")) {
		        return "§f";
		  }
	      if (p.hasPermission("H.Special")) {
		    return "§f";
		  }
	      if (p.hasPermission("H.Mod")) {
	        return "§c";
	      }
	      if (p.hasPermission("H.Helper")) {
	        return "§3";
	      }
	      if (p.hasPermission("H.VIP")) {
		        return "§5";
		      }
	      if (p.hasPermission("H.Builder")) {
	        return "§2";
	      }
	      if (p.hasPermission("H.Emerald")) {
	        return "§a";
	      }
	      if (p.hasPermission("H.Diamond")) {
	        return "§b";
	      }
	      if (p.hasPermission("H.Gold")) {
		        return "§6";
		      }
	      if (p.hasPermission("H.YouTuber")) {
		        return "§5";
		  }
	      if (p.hasPermission("H.Actor")) {
		        return "§7";
		      }
		return "§7";
}
  
  public void getServers() {
	    final ByteArrayOutputStream b = new ByteArrayOutputStream();
	    final DataOutputStream out = new DataOutputStream(b);
	    
	    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	    scheduler.scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
	      public void run() {
	        if (Bukkit.getServer().getOnlinePlayers().size() == 0) {
	          return;
	        }
	        Player player = Bukkit.getPlayer("InVisTeK_");
	        try {
	          out.writeUTF("GetServers");
	          out.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        } if (b.toByteArray().length > 32760) {
	          b.reset();
	          return;
	        }
	        player.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
	      }
	    }, 0L, 80L);
	  }
  
  public int getRandom(int lower, int upper) {
	    Random random = new Random();
	    return random.nextInt(upper - lower + 1) + lower;
	  }
  
  public void onLoad() {
    instance = this;
  }
  
  public void onPluginMessageReceived(String channel, Player player, byte[] message) {
      if (!channel.equals("BungeeCord")) {
          return;
      }
     
      ByteArrayDataInput in = ByteStreams.newDataInput(message);
      String subchannel = in.readUTF();
     
      if (subchannel.equals("PlayerCount")) {
          String server = "Hub";
          int playerCount = in.readInt();
         
          player.sendMessage("Player count on server " + server + " is equal to " + playerCount);
      }
     
  }
 
  public void getCount(Player player, String server) {
	  
      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      out.writeUTF("PlayerCount");
      out.writeUTF(server);

      player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
     
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      
      if (command.getName().equalsIgnoreCase("players")) {
         
          Player player = (Player) sender;
          onPluginMessageReceived("BungeeCord", player, "PlayerCount".getBytes());
         
      }
     
      return true;
     
  }
}
