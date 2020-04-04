	package like.invis.us.Utilts;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.google.common.collect.Lists;

import like.invis.us.Main;

public class GhostMaker extends PacketAdapter implements Listener {
	public static final ProtocolManager pm = ProtocolLibrary.getProtocolManager(); //Hooks into ProtocolLib
	public static Set<UUID> ghosts = new HashSet<UUID>();
	
	
	public GhostMaker(Main plugin) {
		  super(plugin, new PacketType[] {
				  PacketType.Play.Server.PLAYER_INFO 
				  }); 
	    pm.addPacketListener(new PacketAdapter(plugin, PacketType.Play.Server.SPAWN_ENTITY) { //Listen for anytime a player may see another entity
	        @Override
	        public void onPacketSending(PacketEvent event) {
	            Entity entity = event.getPacket().getEntityModifier(event).read(0);
	            if (entity != null
	                    && entity instanceof Player
	                    && ghosts.contains(entity.getUniqueId())) { //Player can potentially see a ghost
	                showAsGhost(event.getPlayer(), (Player) entity); //Render the ghost as semi-transparent
	            }
	        }
	    });
	}

	public static void addGhost(Player player) {
	    if (ghosts.add(player.getUniqueId())) {
	        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 2), true); //Apply invisibility to the ghost
	        showAsGhost(player, player); //Let ghost see themselves as a ghost
	        for (Player viewer : pm.getEntityTrackers(player)) { //Send a packet to anyone who can "see" the ghost
	            showAsGhost(viewer, player);
	        }
	    }
	}

	public static void removeGhost(Player player) {
	    if (ghosts.remove(player.getUniqueId())) {
	        player.removePotionEffect(PotionEffectType.INVISIBILITY); //Remove invisibility
	        for (Player viewer : Bukkit.getServer().getOnlinePlayers()) { //Send removal packets to every player (some that recv'd the addGhost packet may no longer be in range)
	            PacketContainer packet = pm.createPacket(PacketType.Play.Server.SCOREBOARD_TEAM, true);
	            packet.getStrings().write(0, viewer.getEntityId() + "." + player.getEntityId()); //Make the team name unique to both the viewer and the ghost
	            packet.getIntegers().write(1, 1); //We are removing this team
	            try {
	                pm.sendServerPacket(viewer, packet); //Only the viewer needs to be sent the packet
	            } catch (InvocationTargetException e) {
	                e.printStackTrace();;
	            }
	        }
	    }
	}

	public static void showAsGhost(Player viewer, Player player) {
	    PacketContainer packet = pm.createPacket(PacketType.Play.Server.SCOREBOARD_TEAM, true);
	    packet.getStrings().write(0, viewer.getEntityId() + "." + player.getEntityId()); //Make the team name unique to both the viewer and the ghost
	    packet.getIntegers().write(1, 0); //We are creating a new team
	    packet.getModifier().write(6, Lists.newArrayList(viewer.getName(), player.getName())); //Team only consists of the ghost and the viewer
	    packet.getIntegers().write(2, 3); //Ghost can be seen and attacked by the viewer
	    try {
	        pm.sendServerPacket(viewer, packet); //Only the viewer needs to be sent the packet
	    } catch (InvocationTargetException e) {
	        e.printStackTrace();;
	    }
	}

}
