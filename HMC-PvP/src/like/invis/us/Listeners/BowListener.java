package like.invis.us.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import like.invis.us.Main;

public class BowListener implements Listener {
	
	@EventHandler
	public void onShootArrows(EntityShootBowEvent e) {
		Player p = Bukkit.getPlayer(e.getEntity().getName());
		String ii = e.getBow().getItemMeta().getDisplayName().replace("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a", "").replace("§8]§8·", "");
		int rest = Integer.valueOf(ii) - 1;
		if (rest <= 0) {
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
			p.getInventory().remove(arrows);
			arrows.setAmount(arrows.getAmount() - 1);
		} else {
		}
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
	    ItemMeta mbow = bow.getItemMeta();
	    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a" + rest + "§8]§8·");
	    bow.setItemMeta(mbow);
	    Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
			    p.getInventory().setItem(p.getInventory().getHeldItemSlot(), bow);
			}
		}, 3L);
	    Main.getInstance().getConfig().set(p.getName() + ".rest", rest);
	    Main.getInstance().saveConfig();
		  int fire = Main.getInstance().getConfig().getInt(p.getName() + ".fire");
		  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tm amessage " + p.getName() + " &b&l➶&b " + rest + " &8&l︳ &e&l⚙&e " + fire);
	}

}
