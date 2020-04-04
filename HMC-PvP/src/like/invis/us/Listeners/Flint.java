package like.invis.us.Listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import like.invis.us.Main;

public class Flint implements Listener {
	
  @EventHandler
  public void flint(PlayerInteractEvent event) {
    Player p = event.getPlayer();
    
    Block b = event.getClickedBlock();
    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand().getType() == Material.FLINT_AND_STEEL) && 
      (p.getItemInHand().getType() == Material.FLINT_AND_STEEL)) {
      int d = p.getItemInHand().getDurability();
	    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
	    if (p.getItemInHand().getDurability() < 64) {
		    flint.setDurability((short) (p.getItemInHand().getDurability() + 1));
	    } else {
		    flint.setDurability((short) (p.getItemInHand().getDurability()));
	    }
	    ItemMeta mflint = flint.getItemMeta();
	    int ii = 64 - p.getItemInHand().getDurability();

	    if (p.getItemInHand().getDurability() == 64) {
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a0§8]§8·");
	    } else {
		    if (ii > 1) {
			    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - p.getItemInHand().getDurability()) + "§8]§8·");
			    Main.getInstance().getConfig().set(p.getName() + ".fire", 64 - p.getItemInHand().getDurability());
			    Main.getInstance().saveConfig();
		    } else {
			    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (63 - p.getItemInHand().getDurability()) + "§8]§8·");
			    Main.getInstance().getConfig().set(p.getName() + ".fire", 63 - p.getItemInHand().getDurability());
			    Main.getInstance().saveConfig();
		    }
	    }
	    flint.setItemMeta(mflint);
	    p.setItemInHand(flint);
      if (d >= 64) {
        event.setCancelled(true);
        
        p.sendMessage("§8┃ §cHozexMC §8┃ §7Your flint is empty, charge it by killing someone.");
        p.playEffect(p.getLocation(), Effect.TILE_DUST, 1L);
        p.playSound(p.getLocation(), Sound.LAVA_POP, 2.0F, 2.0F);
        p.updateInventory();
        return;
      }
	  int rest = Main.getInstance().getConfig().getInt(p.getName() + ".rest");
	  int fire = Main.getInstance().getConfig().getInt(p.getName() + ".fire");
	  int souls = Main.getInstance().getConfig().getInt("stats." + p.getName() + ".souls");
	  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tm amessage " + p.getName() + " &b&l➶&b " + rest + " &8&l︳ &e&l⚙&e " + fire);
      
    }
  }
}