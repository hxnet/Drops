package like.invis.us.Managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import like.invis.us.Main;

public class KitsManager implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		giveKit(p.getName());
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		giveKit(p.getName());
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		giveKit(p.getName());
	}
	
	public void saveInv(Player p, int i) {
		ItemStack s1 = p.getInventory().getItem(i);
		if (s1 != null) {
			if (s1.getType() == Material.DIAMOND_SWORD || s1.getType() == Material.IRON_SWORD || s1.getType() == Material.STONE_SWORD || s1.getType() == Material.DIAMOND_AXE) {
				Main.getInstance().getConfig().set("sword." + p.getName(), i);
				Main.getInstance().saveConfig();
			} else if (s1.getType() == Material.GOLDEN_APPLE) {
				Main.getInstance().getConfig().set("gapple." + p.getName(), i);
				Main.getInstance().saveConfig();
			} else if (s1.getType() == Material.BOW) {
				Main.getInstance().getConfig().set("bow." + p.getName(), i);
				Main.getInstance().saveConfig();
			} else if (s1.getType() == Material.FISHING_ROD) {
				Main.getInstance().getConfig().set("rod." + p.getName(), i);
				Main.getInstance().saveConfig();
			} else if (s1.getType() == Material.FLINT) {
				Main.getInstance().getConfig().set("flint." + p.getName(), i);
				Main.getInstance().saveConfig();
			} else {}
		} else {}
	}
	
	public void giveKit(String name) {
		Player p = Bukkit.getPlayer(name);
		if (p != null) {
			if (Main.getInstance().getConfig().contains("kit." + p.getName())) {
				if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("default")) {
					setDefaultKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("soldier")) {
					setSoldierKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("archer")) {
					setArcherKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("knight")) {
					setKnightKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("tank")) {
					setTankKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("mythic")) {
					setMythicKit(p.getName());
				} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("legendary")) {
					setLegendaryKit(p.getName());
				} else {
					setDefaultKit(p.getName());
				}
			} else {
				setDefaultKit(p.getName());
			}
		} else {
			System.out.println("The player is offline, So can't give him the kit");
		}
	}
	
	  public static void setDefaultKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		    ItemStack sword = new ItemStack(Material.STONE_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a10§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword.default." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword.default." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod.default." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod.default." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow.default." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow.default." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint.default." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint.default." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setSoldierKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		    ItemStack sword = new ItemStack(Material.IRON_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 4);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a15§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setArcherKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		    ItemStack sword = new ItemStack(Material.STONE_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 4);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		  //Power 1
		  //Power 2
		  //Punch 1
		  //Flame 1
	    	bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
		    flint.setDurability((short)63);
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
			 mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a∞§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setKnightKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		    ItemStack sword = new ItemStack(Material.DIAMOND_AXE);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 5);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a32§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setTankKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		    ItemStack sword = new ItemStack(Material.IRON_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 10);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a48§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setMythicKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 10);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a64§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}
	  
	  public static void setLegendaryKit(String name) {
		  Player p = Bukkit.getPlayer(name);
		    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		    ItemStack bow = new ItemStack(Material.BOW);
		    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 10);
		    ItemStack rod = new ItemStack(Material.FISHING_ROD);
		    ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL, 1);
		    ItemStack arrows = new ItemStack(Material.ARROW, 1);
		    
		    flint.setDurability((short)63);
		    helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		    chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		    leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		    boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		    sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		    bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		    
		    ItemMeta mhelmet = helmet.getItemMeta();
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    mhelmet.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Helmet§8·");
		    helmet.setItemMeta(mhelmet);
		    
		    ItemMeta mchestplate = chestplate.getItemMeta();
		    mchestplate.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Chestplate§8·");
		    chestplate.setItemMeta(mchestplate);
		    
		    ItemMeta mleggings = leggings.getItemMeta();
		    mleggings.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Leggings§8·");
		    leggings.setItemMeta(mleggings);
		    
		    ItemMeta bootst = boots.getItemMeta();
		    bootst.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Boots§8·");
		    boots.setItemMeta(bootst);
		    
		    ItemMeta mgapple = gapple.getItemMeta();
		    mgapple.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Golden Apple§8·");
		    gapple.setItemMeta(mgapple);
		    
		    ItemMeta msword = sword.getItemMeta();
		    msword.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Sword§8·");
		    sword.setItemMeta(msword);
		    
		    ItemMeta mbow = bow.getItemMeta();
		    mbow.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Bow §8[§a64§8]§8·");
		    bow.setItemMeta(mbow);
		    
		    ItemMeta mflint = flint.getItemMeta();
		    mflint.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Flint §8[§a" + (64 - flint.getDurability()) + "§8]§8·");
		    flint.setItemMeta(mflint);
		    
		    ItemMeta mrod = rod.getItemMeta();
		    mrod.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Rod§8·");
		    rod.setItemMeta(mrod);
		    
		    ItemMeta marrows = arrows.getItemMeta();
		    marrows.setDisplayName("§8· " + Main.getInstance().getRankColor(p) + "Arrows§8·");
		    arrows.setItemMeta(marrows);
		    
		    mhelmet.spigot().setUnbreakable(true);
		    mchestplate.spigot().setUnbreakable(true);
		    mleggings.spigot().setUnbreakable(true);
		    bootst.spigot().setUnbreakable(true);
		    msword.spigot().setUnbreakable(true);
		    mbow.spigot().setUnbreakable(true);
		    mflint.spigot().setUnbreakable(true);
		    mrod.spigot().setUnbreakable(true);
		    marrows.spigot().setUnbreakable(true);
		    if (Main.getInstance().getConfig().contains("sword." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("sword." + p.getName());
		    	p.getInventory().setItem(place, sword);
		    } else {
			    p.getInventory().setItem(0, sword);
		    }
		    if (Main.getInstance().getConfig().contains("rod." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("rod." + p.getName());
		    	p.getInventory().setItem(place, rod);
		    } else {
			    p.getInventory().setItem(1, rod);
		    }
		    if (Main.getInstance().getConfig().contains("bow." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("bow." + p.getName());
		    	p.getInventory().setItem(place, bow);
		    } else {
			    p.getInventory().setItem(2, bow);
		    }
		    if (Main.getInstance().getConfig().contains("flint." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("flint." + p.getName());
		    	p.getInventory().setItem(place, flint);
		    } else {
			    p.getInventory().setItem(3, flint);
		    }
		    
		    if (Main.getInstance().getConfig().contains("gapple." + p.getName())) {
		    	int place = Main.getInstance().getConfig().getInt("gapple." + p.getName());
		    	p.getInventory().setItem(place, gapple);
		    } else {
			    p.getInventory().setItem(4, gapple);
		    }
		    p.getInventory().setHelmet(helmet);
		    p.getInventory().setChestplate(chestplate);
		    p.getInventory().setLeggings(leggings);
		    p.getInventory().setBoots(boots);
	}

}
