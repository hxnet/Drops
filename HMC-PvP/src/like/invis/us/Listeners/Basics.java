package like.invis.us.Listeners;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Basics implements Listener {
	
	  public static Plugin plugin;
	  
	  public Basics(Plugin plugin) {
	    this.plugin = plugin;
	  }
	  
	  public static void setBar(Player p, String msg) {
		    CraftPlayer CraftPlayer = (CraftPlayer)p;
		    IChatBaseComponent ChatComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msg.replaceAll("&", "§") + "\"}");
		    PacketPlayOutChat Packet = new PacketPlayOutChat(ChatComponent, (byte)2);
		    CraftPlayer.getHandle().playerConnection.sendPacket(Packet);
		  }
  
  @EventHandler
  public void Place(BlockPlaceEvent e) {
    if (e.getBlockPlaced().getType() == Material.TNT) {
    	e.setCancelled(true);
      e.getPlayer().getInventory().remove(Material.TNT);
      TNTPrimed tnt = (TNTPrimed)e.getPlayer().getWorld().spawn(e.getBlockPlaced().getLocation(), TNTPrimed.class);
      tnt.setFuseTicks(40);
      tnt.setFireTicks(2);
    }
  }
  
  @EventHandler
  public void Explode(EntityExplodeEvent e) {
    e.blockList().clear();
  }
  
  @EventHandler
  public void EntityDamageEvent(EntityDamageEvent e) {
    if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
      e.setDamage(18.0D);
    }
  }
  
  @EventHandler
  public void Projectile(ProjectileHitEvent e) {
      ((Arrow)e.getEntity()).remove();
  }
  
  @EventHandler
  public void Weather(WeatherChangeEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onHunger(PlayerDropItemEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onHunger(PlayerPickupItemEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void ons(BlockBurnEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onHnungerLevel(FoodLevelChangeEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onAch(PlayerAchievementAwardedEvent e) {
    e.setCancelled(true);
  }
}
