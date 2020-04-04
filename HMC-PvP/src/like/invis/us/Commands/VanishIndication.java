package like.invis.us.Commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import like.invis.us.Main;
import me.kazzababe.bukkit.NoNameTags;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeamBase.EnumNameTagVisibility;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;

public class VanishIndication implements Listener, CommandExecutor {
	Plugin plugin;
	public VanishIndication(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spec")) {
			Player p = (Player) sender;
			p.removePotionEffect(PotionEffectType.SPEED);
			if (Main.getInstance().getConfig().getBoolean("spec." + p.getName()) == true) {
				hideNameTag(p, false);
				Main.getInstance().getConfig().set("spec." + p.getName(), false);
				Main.getInstance().saveConfig();
				p.sendMessage("§8❘ §aHozexMC §8❘ §7You have disabled spectator mode");
				p.removePotionEffect(PotionEffectType.INVISIBILITY);
				p.removePotionEffect(PotionEffectType.BLINDNESS);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 1));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fly off " + p.getName());
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "espawn " + p.getName());
				if (Main.getInstance().getConfig().getBoolean("IsToggled." + p.getName()) == true) {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " clear");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " prefix &7");
				} else {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " clear");
					if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvpr.tabrl false");
					} else {
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " unset pvpr.tabrl");
					}
				}
				for (Player all : Bukkit.getOnlinePlayers()) {
					sendPlayerInfoChangeGameModePacket(all, p, false);
				}
			} else {
				Main.getInstance().getConfig().set("spec." + p.getName(), true);
				Main.getInstance().saveConfig();
				p.sendMessage("§8❘ §aHozexMC §8❘ §7You have entered in spectator mode");
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fly on" + p.getName());
				
				if (p.getLocation().add(0, 3, 0).getBlock().getType() == Material.AIR) {
					p.teleport(p.getLocation().add(0, 3, 0));
					//p.setAllowFlight(true);
					;
				} else if (p.getLocation().add(0, 3, 0).getBlock().getType() == Material.AIR) {
					p.teleport(p.getLocation().add(0, 2, 0));
					//p.setAllowFlight(true);
					;
				} else if (p.getLocation().add(0, 3, 0).getBlock().getType() == Material.AIR) {
					p.teleport(p.getLocation().add(0, 1, 0));
					//p.setAllowFlight(true);
					;
				} else {
					p.teleport(p.getLocation().add(0, 0, 0));
					p.setAllowFlight(true);
					;
				}
				p.setAllowFlight(true);
				p.setFlying(true);
				hideNameTag(p, true);
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (all != p) {
						sendPlayerInfoChangeGameModePacket(all, p, true);
					}
				}
			}

		}
	return false;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvpr.tabrl false");
		} else {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " unset pvpr.tabrl");
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " clear");
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (Main.getInstance().getConfig().getBoolean("spec." + all.getName()) == true) {
				sendPlayerInfoChangeGameModePacket(p, all, true);
			} else {
				sendPlayerInfoChangeGameModePacket(p, all, false);
			}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Main.getInstance().getConfig().set("spec." + p.getName(), false);
		Main.getInstance().saveConfig();
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fly off " + p.getName());
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "espawn " + p.getName());
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "nte player " + p.getName() + " clear");
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvpr.tabrl false");
		} else {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " unset pvpr.tabrl");
		}
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
		      team.setNameTagVisibility(NameTagVisibility.NEVER);
		      if (TF == true) {
			      team.addEntry(p.getName());
		      } else {
			      team.removeEntry(p.getName());
		      }
		      online.setScoreboard(scoreboard);
		    } 
		  }
  @EventHandler
  public void onVanish(PlayerChatEvent e) {
	  if (e.getMessage().contains("hi")) {
		    Player p = e.getPlayer();
		    for (Player all : Bukkit.getOnlinePlayers()) {
		    	if (all != p) {
			        sendPlayerInfoChangeGameModePacket(all, p, true);
		    	}
		    } 
	  }
  }
  
  public void onEnable() {
    ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this.plugin, ListenerPriority.NORMAL, new PacketType[] { PacketType.Play.Server.PLAYER_INFO })
        {
          
          public void onPacketSending(PacketEvent event) {
            event.setPacket(event.getPacket().shallowClone());
            
            List<PlayerInfoData> infoDataList = new ArrayList<PlayerInfoData>((Collection)event.getPacket().getPlayerInfoDataLists().read(0));
            Player receiver = event.getPlayer();
            for (UnmodifiableIterator unmodifiableIterator = ImmutableList.copyOf(infoDataList).iterator(); unmodifiableIterator.hasNext(); ) { PlayerInfoData infoData = (PlayerInfoData)unmodifiableIterator.next();
              
              if (!receiver.getUniqueId().equals(infoData.getProfile().getUUID()) && 
                infoData.getGameMode() != EnumWrappers.NativeGameMode.SPECTATOR) {
                int latency;
                try {
                  latency = infoData.getLatency();
                } catch (NoSuchMethodError e) {
                  latency = 21;
                } 
                if (event.getPacket().getPlayerInfoAction().read(0) != EnumWrappers.PlayerInfoAction.UPDATE_GAME_MODE) {
                	
                }


                
                PlayerInfoData newData = new PlayerInfoData(infoData.getProfile(), latency, EnumWrappers.NativeGameMode.SPECTATOR, infoData.getDisplayName());
                infoDataList.remove(infoData);
                infoDataList.add(newData);
              }  }

            
            event.getPacket().getPlayerInfoDataLists().write(0, infoDataList);
          }
        });
  }
  
  public static void sendPlayerInfoChangeGameModePacket(Player p, Player change, boolean spectator) {
    PacketContainer packet = new PacketContainer(PacketType.Play.Server.PLAYER_INFO);
    packet.getPlayerInfoAction().write(0, EnumWrappers.PlayerInfoAction.UPDATE_GAME_MODE);
    List<PlayerInfoData> data = new ArrayList<PlayerInfoData>();
    int ping = ThreadLocalRandom.current().nextInt(20) + 15;
    data.add(new PlayerInfoData(WrappedGameProfile.fromPlayer(change), ping, spectator ? EnumWrappers.NativeGameMode.SPECTATOR : 
          
          EnumWrappers.NativeGameMode.fromBukkit(change.getGameMode()), 
          WrappedChatComponent.fromText(change.getPlayerListName())));
    packet.getPlayerInfoDataLists().write(0, data);
    try {
      ProtocolLibrary.getProtocolManager().sendServerPacket(p, packet);
    } catch (InvocationTargetException e) {
      throw new RuntimeException("Cannot send packet", e);
    } 
  }
}
