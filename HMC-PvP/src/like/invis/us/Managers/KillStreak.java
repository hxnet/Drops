package like.invis.us.Managers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KillStreak implements Listener {
  @EventHandler
  public void onKillstreak(PlayerLevelChangeEvent e) {
    Player p = e.getPlayer();
    
    ItemStack tnt = new ItemStack(Material.TNT, 1);
    ItemMeta tntmeta = tnt.getItemMeta();
    tntmeta.setDisplayName("§b· §4T§fN§4T §b·");
    tnt.setItemMeta(tntmeta);
    
    ItemStack cobweb = new ItemStack(Material.WEB, 1);
    ItemMeta mcobweb = cobweb.getItemMeta();
    mcobweb.setDisplayName("§b· §fCobweb §b·");
    cobweb.setItemMeta(mcobweb);
    
    int l = e.getNewLevel();
    if (l == 3 || l == 5 || l == 10 || l == 15 || l == 20 || l == 25 || l == 30 || l == 35 || l == 40 || l == 50 || l == 60 || l == 70 || l == 80 || l == 90 || l == 100 || l == 110 || l == 120 || l == 130 || l == 140 || l == 150 || l == 160 || l == 170 || l == 180 || l == 190 || l == 200 || l == 210 || l == 220 || l == 230 || l == 240 || l == 250 || l == 260 || l == 270 || l == 280 || l == 290 || l == 300){
      if (p.hasPermission("pvp.perks.cobweb")) {
        p.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(cobweb) });
      } else {
        p.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(tnt) });
      }
    }
  }
}