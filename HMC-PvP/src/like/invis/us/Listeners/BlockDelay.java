package like.invis.us.Listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockDelay
  implements Listener {
	  public static Plugin plugin;
	  
	  public BlockDelay(Plugin plugin) {
	    this.plugin = plugin;
	  }
  
  @EventHandler
  public void onPlace(BlockPlaceEvent e) {
    final Block b = e.getBlock();
    Block bt = Bukkit.getWorld(e.getBlock().getWorld().getName()).getBlockAt(e.getBlock().getLocation().getBlockX(), e.getBlock().getLocation().getBlockY() - 1, e.getBlock().getLocation().getBlockZ());
    ArrayList<Material> mm = new ArrayList<>();
    mm.add(bt.getType());
    Block bu = Bukkit.getWorld(e.getBlock().getWorld().getName()).getBlockAt(e.getBlock().getLocation().getBlockX(), e.getBlock().getLocation().getBlockY() - 1, e.getBlock().getLocation().getBlockZ());
    
    if (e.getBlock().getType() == Material.FIRE) {
    	
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            public void run() {
            }
          }, 1L);
    	
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            public void run() {
              b.setType(Material.AIR);
              for (Player all : Bukkit.getOnlinePlayers()) {
                all.playEffect(b.getLocation(), Effect.LAVA_POP, 2);
                bu.setType(mm.get(0));
              }
            }
          }, 9*20L);
    } else {
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            public void run() {
              b.setType(Material.AIR);
              for (Player all : Bukkit.getOnlinePlayers()) {
                all.playEffect(b.getLocation(), Effect.CRIT, 2);
              }
            }
          }, 14*20L);
    }
  }
}
