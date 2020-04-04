package like.invis.us.Listeners;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GoldenHead implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity().getKiller();
	    ItemStack apple = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
	    SkullMeta applemeta = (SkullMeta) apple.getItemMeta();
	    applemeta.setOwner("GoldenApple");
	    applemeta.setDisplayName("§b· §6Golden Head §b·");
	    apple.setItemMeta(applemeta);
	    e.getEntity().getKiller().getInventory().addItem(apple);
	}
	
	@EventHandler
	public void onClick2(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack ss = p.getItemInHand();
		if (ss.getItemMeta().getDisplayName().contains("§b· §6Golden Head §b·")) {
			
			if (p.getHealth() >= 16) {
				p.setHealth(p.getHealth() + 4);
				p.setMaxHealth(p.getHealth());
			} else {
				p.setHealth(p.getHealth() + 4);
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
			
			if (ss.getAmount() > 1) {
				p.getInventory().getItemInHand().setAmount((p.getInventory().getItemInHand().getAmount() - 1));
				ss.setAmount(ss.getAmount() - 1);
			} else {
				p.getItemInHand().setType(Material.AIR);
				p.getInventory().removeItem(p.getItemInHand());
				ss.setType(Material.AIR);
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.getHealth() >= 20) {
				p.setMaxHealth(p.getHealth());
			}
		}
	}
}
