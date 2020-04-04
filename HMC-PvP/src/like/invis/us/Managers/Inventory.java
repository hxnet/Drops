package like.invis.us.Managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.avaje.ebeaninternal.server.type.reflect.KnownImmutable;

import like.invis.us.Main;
import me.robin.battlelevels.api.BattleLevelsAPI;

public class Inventory implements Listener {
	
	static Plugin plugin;
	public Inventory(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public static void colorChange27(org.bukkit.inventory.Inventory inv) {
		ItemStack black = new ItemStack(Material.STAINED_GLASS_PANE,1,(byte) 15);
		ItemMeta mblack = black.getItemMeta();
		mblack.setDisplayName("§7PvP");
		black.setItemMeta(mblack);
		
		ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE,1,(byte) 14);
		ItemMeta mred = red.getItemMeta();
		mred.setDisplayName("§7PvP");
		red.setItemMeta(mred);

		inv.setItem(0, black);
		inv.setItem(1, black);
		inv.setItem(2, black);
		inv.setItem(3, black);
		inv.setItem(4, black);
		inv.setItem(5, black);
		inv.setItem(6, black);
		inv.setItem(7, black);
		inv.setItem(8, black);
		
		inv.setItem(9, black);
		inv.setItem(17, black);

		inv.setItem(18, black);
		inv.setItem(19, black);
		inv.setItem(20, black);
		inv.setItem(21, black);
		inv.setItem(22, black);
		inv.setItem(23, black);
		inv.setItem(24, black);
		inv.setItem(25, black);
		inv.setItem(26, black);
		//Rep\
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int i = 1;
			@Override
			public void run() {
				inv.setItem(0, red);
				inv.setItem(9, black);
				Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
					
					@Override
					public void run() {
						inv.setItem(0, black);
						inv.setItem(1, red);
						Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
							
							@Override
							public void run() {
								inv.setItem(1, black);
								inv.setItem(2, red);
								Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
									
									@Override
									public void run() {
										inv.setItem(2, black);
										inv.setItem(3, red);
										Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
											
											@Override
											public void run() {
												inv.setItem(3, black);
												inv.setItem(4, red);
												Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
													
													@Override
													public void run() {
														inv.setItem(4, black);
														inv.setItem(5, red);
														Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
															
															@Override
															public void run() {
																inv.setItem(5, black);
																inv.setItem(6, red);
																Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																	
																	@Override
																	public void run() {
																		inv.setItem(6, black);
																		inv.setItem(7, red);
																		Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																			
																			@Override
																			public void run() {
																				inv.setItem(7, black);
																				inv.setItem(8, red);
																				Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																					@Override
																					public void run() {
																						inv.setItem(8, black);
																						inv.setItem(17, red);
																						Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																							@Override
																							public void run() {
																								inv.setItem(17, black);
																								inv.setItem(26, red);
																								Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																									@Override
																									public void run() {
																										inv.setItem(26, black);
																										inv.setItem(25, red);
																										Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																											@Override
																											public void run() {
																												inv.setItem(25, black);
																												inv.setItem(24, red);
																												Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																													@Override
																													public void run() {
																														inv.setItem(24, black);
																														inv.setItem(23, red);
																														Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																															@Override
																															public void run() {
																																inv.setItem(23, black);
																																inv.setItem(22, red);
																																Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																	@Override
																																	public void run() {
																																		inv.setItem(22, black);
																																		inv.setItem(21, red);
																																		Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																			@Override
																																			public void run() {
																																				inv.setItem(21, black);
																																				inv.setItem(20, red);
																																				Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																					@Override
																																					public void run() {
																																						inv.setItem(20, black);
																																						inv.setItem(19, red);
																																						Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																							@Override
																																							public void run() {
																																								inv.setItem(19, black);
																																								inv.setItem(18, red);
																																								Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																									@Override
																																									public void run() {
																																										inv.setItem(18, black);
																																										inv.setItem(9, red);
																																										Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
																																											@Override
																																											public void run() {
																																												inv.setItem(18, black);
																																												inv.setItem(9, black);
																																											}
																																										}, 20L);
																																									}
																																								}, 20L);
																																							}
																																						}, 20L);
																																					}
																																				}, 20L);
																																			}
																																		}, 20L);
																																	}
																																}, 20L);
																															}
																														}, 20L);
																													}
																												}, 20L);
																											}
																										}, 20L);
																									}
																								}, 20L);
																							}
																						}, 20L);
																					}
																				}, 20L);
																			}
																		}, 20L);
																	}
																}, 20L);
															}
														}, 20L);
													}
												}, 20L);
											}
										}, 20L);
									}
								}, 20L);
							}
						}, 20L);
					}
				}, 20L);
			}
		}, 0L, 400L);
	}
	
	public static void openShopSelector(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 27, "PvP Shop");
		
        ItemStack stats = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta mstats = (SkullMeta) stats.getItemMeta();
        mstats.setOwner(p.getName());
		ArrayList<String> lore1 = new ArrayList();
		lore1.add("§8§m-----------------");
		lore1.add("§ePvP Rank §8» §7" + "");
		lore1.add("§eKills §8» §7" + p.getStatistic(Statistic.PLAYER_KILLS));
		lore1.add("§eDeaths §8» §7" + p.getStatistic(Statistic.DEATHS));
		lore1.add("§8§m-----------------");
	    mstats.setDisplayName("§8» §6" + p.getName() + "§7's PVP Stats");
		mstats.setLore(lore1);
        stats.setItemMeta(mstats);
		
		ItemStack cus = new ItemStack(Material.SUGAR);
		ItemMeta mcus = cus.getItemMeta();
		mcus.setDisplayName("§8» §6Customizer");
		cus.setItemMeta(mcus);
		
		ItemStack pshop = new ItemStack(Material.EMERALD);
		ItemMeta mpshop = pshop.getItemMeta();
		mpshop.setDisplayName("§8» §6PvP Shop");
		pshop.setItemMeta(mpshop);
		
		ItemStack settings = new ItemStack(Material.PAPER);
		ItemMeta msettings = settings.getItemMeta();
		msettings.setDisplayName("§8» §6Settings");
		settings.setItemMeta(msettings);
		
		inv.setItem(4, stats);
		inv.setItem(12, cus);
		inv.setItem(13, pshop);
		inv.setItem(14, settings);
		p.openInventory(inv);
	}
	
	  public void settings(Player p) {
		    org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 27, "Settings");
		    ArrayList<Integer> notset = new ArrayList();
		    notset.add(Integer.valueOf(12));
		    notset.add(Integer.valueOf(4));
		    notset.add(Integer.valueOf(13));
		    notset.add(Integer.valueOf(14));
		        ItemStack stack = new ItemStack(Material.NETHER_STAR, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§8» §6Kit Change");
		        stack.setItemMeta(smeta);
		        inv.setItem(13, stack);
		  }
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if (e.getInventory().getName().contains("PvP Shop")) {
			e.setCancelled(true);
		}
	}
	
	  public void inventory(Player player) {
		    org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 45, "Shop");
		    int Price = 0;
		    for (int i = 0; i < 54; i++) {
		      if (i == 0) {
		        ItemStack stack = new ItemStack(Material.BOOK, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.FOOTSTEP)) {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        } else {
		          Price = 250;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for enchants!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bFOOTSTEP");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      } else if (i == 1) {
		        ItemStack stack = new ItemStack(Material.REDSTONE, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.HEARTS)) {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        } else {
		          Price = 300;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bHearts");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      } else if (i == 2) {
		        ItemStack stack = new ItemStack(Material.EMERALD, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.HAPPYVILLAGER)) {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        } else {
		          Price = 700;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §6Happy Villager");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      } else if (i == 3) {
		        ItemStack stack = new ItemStack(Material.LAVA_BUCKET, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.LAVA))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        } else {
		          Price = 500;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§5§lRARE");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §5Volcano");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      } else if (i == 4) {
		        ItemStack stack = new ItemStack(Material.BANNER, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.RainbowB)) {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        } else {
		          Price = 350;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bRainbow");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      } else if (i == 5) {
		        ItemStack stack = new ItemStack(Material.SLIME_BALL, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.SlimeBall))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 150;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §aSlimeball");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 6)
		      {
		        ItemStack stack = new ItemStack(Material.POTION, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Spells))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 50;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §aSpells");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 7)
		      {
		        ItemStack stack = new ItemStack(Material.BLAZE_POWDER, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.AVillager))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 100;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §aAngry Villager");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 8)
		      {
		        ItemStack stack = new ItemStack(Material.WATER_BUCKET, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.WATER))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 600;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §6Earth");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 9)
		      {
		        ItemStack stack = new ItemStack(Material.NOTE_BLOCK, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.NoteB))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 250;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing effect for your bow!");
		          lore.add("§8» §6Bow Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bNote");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 18)
		      {
		        ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Hearts1))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 150;
		          List<String> lore = new ArrayList();
		          lore.add("§7Show off your love!");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bHearts");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 19)
		      {
		        ItemStack stack = new ItemStack(Material.NOTE_BLOCK, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.NOTE))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 250;
		          List<String> lore = new ArrayList();
		          lore.add("§7Music in air?");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bNote");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 20)
		      {
		        ItemStack stack = new ItemStack(Material.LAVA_BUCKET, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.FLAME1))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 200;
		          List<String> lore = new ArrayList();
		          lore.add("§7Lava in air?");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bLava Drip");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 21)
		      {
		        ItemStack stack = new ItemStack(Material.BANNER, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.RAINBOW))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 300;
		          List<String> lore = new ArrayList();
		          lore.add("§7Show off your love of colors!");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bRainbow");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 22)
		      {
		        ItemStack stack = new ItemStack(Material.CLAY, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Smoke))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 200;
		          List<String> lore = new ArrayList();
		          lore.add("§7Smoke?! like batman smoke?");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bSmoke");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 23)
		      {
		        ItemStack stack = new ItemStack(Material.EMERALD, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.HVillagerR))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 200;
		          List<String> lore = new ArrayList();
		          lore.add("§7Are you happy? show off you happiness");
		          lore.add("§8» §6Rod Effects");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§3Trails §8» §bHappy Villager");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 27)
		      {
		        ItemStack stack = new ItemStack(Material.ANVIL, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.ANVIL))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 350;
		          List<String> lore = new ArrayList();
		          lore.add("§7Falling anvil?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§eDeath Cry §8» §bAnvil");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 28)
		      {
		        ItemStack stack = new ItemStack(Material.REDSTONE, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.DVillagerS))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 150;
		          List<String> lore = new ArrayList();
		          lore.add("§7Villager death?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§eDeath Cry §8» §aVillager Death");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 29)
		      {
		        ItemStack stack = new ItemStack(Material.TNT, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Explosion))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 100;
		          List<String> lore = new ArrayList();
		          lore.add("§7Explosion?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§eDeath Cry §8» §aExplosion");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 30)
		      {
		        ItemStack stack = new ItemStack(Material.CHEST, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.ChestO))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 50;
		          List<String> lore = new ArrayList();
		          lore.add("§7Who has opend the chest?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§a§lCOMMON");
		          smeta.setLore(lore);
		        }
		        smeta.setDisplayName("§eDeath Cry §8» §aChest Open");
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 31)
		      {
		        ItemStack stack = new ItemStack(Material.IRON_BARDING, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§eDeath Cry §8» §6Hrose Death");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.HORSE))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 600;
		          List<String> lore = new ArrayList();
		          lore.add("§7wat horse death?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 32)
		      {
		        ItemStack stack = new ItemStack(Material.BONE, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§eDeath Cry §8» §bWolf Death");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.WDeath))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 350;
		          List<String> lore = new ArrayList();
		          lore.add("§7Wait, what? a wolf death?!");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 33)
		      {
		        ItemStack stack = new ItemStack(Material.FIREWORK, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§eDeath Cry §8» §6Firework");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.FireWorkS))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 600;
		          List<String> lore = new ArrayList();
		          lore.add("§7Do you hear this, It's a celebration?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 34)
		      {
		        ItemStack stack = new ItemStack(Material.COAL, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§eDeath Cry §8» §bBat");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.BAT))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 200;
		          List<String> lore = new ArrayList();
		          lore.add("§7Bat sound like batman?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 35)
		      {
		        ItemStack stack = new ItemStack(Material.EXP_BOTTLE, 1);
		        ItemMeta smeta = stack.getItemMeta();
		        smeta.setDisplayName("§eDeath Cry §8» §bLevel UP");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.LEVELUP))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 300;
		          List<String> lore = new ArrayList();
		          lore.add("§7New level?");
		          lore.add("§8» §6Death cry");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§b§lUNCOMMON");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 36)
		      {
		        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		        SkullMeta smeta = (SkullMeta)stack.getItemMeta();
		        smeta.setDisplayName("§aKill Message §8» §6Memed");
		        smeta.setOwner("WishingTie09120");
		        smeta.setDisplayName("§aKill Message §8» §6Evil");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.EVIL))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 2000;
		          List<String> lore = new ArrayList();
		          lore.add("§7It's an amazing kill message!");
		          lore.add("§8» §6Kill Message");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 37)
		      {
		        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		        SkullMeta smeta = (SkullMeta)stack.getItemMeta();
		        
		        smeta.setOwner("Sacha");
		        smeta.setDisplayName("§aKill Message §8» §5Party");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.PARTY))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 1500;
		          List<String> lore = new ArrayList();
		          lore.add("§7P, PA, PAAARTY TIME!");
		          lore.add("§8» §6Kill Message");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§5§lRARE+");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 38)
		      {
		        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		        SkullMeta smeta = (SkullMeta)stack.getItemMeta();
		        
		        smeta.setOwner("MHF_Redstone");
		        smeta.setDisplayName("§aKill Message §8» §5Love");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.LOVE))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 1500;
		          List<String> lore = new ArrayList();
		          lore.add("§7Love happens :)");
		          lore.add("§8» §6Kill Message");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§5§lRARE+");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 39)
		      {
		        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		        SkullMeta smeta = (SkullMeta)stack.getItemMeta();
		        smeta.setOwner("Paola");
		        smeta.setDisplayName("§aKill Message §8» §6Shocked");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.SHOCKED))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 2500;
		          List<String> lore = new ArrayList();
		          lore.add("§7OH, EM GEEEE!");
		          lore.add("§8» §6Kill Message");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		      else if (i == 40)
		      {
		        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		        SkullMeta smeta = (SkullMeta)stack.getItemMeta();
		        smeta.setDisplayName("§aKill Message §8» §6Memed");
		        smeta.setOwner("SpeedyDoge");
		        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.MEMED))
		        {
		          smeta.addEnchant(Enchantment.LUCK, 1, true);
		          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        }
		        else
		        {
		          Price = 2500;
		          List<String> lore = new ArrayList();
		          lore.add("§7GET REKT! Loser!");
		          lore.add("§7Make your enemies mad lol.");
		          lore.add("§8» §6Kill Message");
		          lore.add("");
		          lore.add("§cLocked (YOU DO NOT OWN THIS)");
		          lore.add("§8§m------------------------");
		          lore.add("§8» §aPurchase for " + Price + " Coins!");
		          lore.add("§6§lLEGENDARY");
		          smeta.setLore(lore);
		        }
		        stack.setItemMeta(smeta);
		        inventory.setItem(i, stack);
		      }
		    }
		    player.openInventory(inventory);
		  }
	  
	  public Inventory RodShop(Player player) {
	    org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Shop");
	    int Price = 0;
	    for (int i = 0; i < 54; i++) {
	    	if (i == 0) {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      } else if (i == 1) {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 2)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 3)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 4)
	      {
	        ItemStack stack = new ItemStack(Material.FISHING_ROD);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§b§lRod");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 5)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 6)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 7)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 8)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 19) {
	        ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Hearts1))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 150;
	          List<String> lore = new ArrayList();
	          lore.add("§7Some hearts in the air?");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6Hearts");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 22)
	      {
	        ItemStack stack = new ItemStack(Material.NOTE_BLOCK, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.NOTE))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 250;
	          List<String> lore = new ArrayList();
	          lore.add("§7Music in the air?!");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6Note");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 25)
	      {
	        ItemStack stack = new ItemStack(Material.LAVA_BUCKET, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.FLAME1))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 200;
	          List<String> lore = new ArrayList();
	          lore.add("§7It's an amazing effect for lava");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6Lava Drip");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 37)
	      {
	        ItemStack stack = new ItemStack(Material.BANNER, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.RAINBOW))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 300;
	          List<String> lore = new ArrayList();
	          lore.add("§7Amazing rainbow in the air with rod!");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6RainBow");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 40)
	      {
	        ItemStack stack = new ItemStack(Material.CLAY, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.Smoke))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 200;
	          List<String> lore = new ArrayList();
	          lore.add("§7FireWork in the air?");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6Smoke");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 43)
	      {
	        ItemStack stack = new ItemStack(Material.EMERALD, 1);
	        ItemMeta smeta = stack.getItemMeta();
	        if (ShopGUI.getItem(player.getName(), ShopGUI.Type.HVillagerR))
	        {
	          smeta.addEnchant(Enchantment.LUCK, 1, true);
	          smeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        }
	        else
	        {
	          Price = 200;
	          List<String> lore = new ArrayList();
	          lore.add("§7are villagers happy?");
	          lore.add("");
	          lore.add("§7§lYOU DO NOT OWN THIS!");
	          lore.add("");
	          lore.add("§8» §aPurchase for " + Price + " Coins!");
	          lore.add("");
	          smeta.setLore(lore);
	        }
	        smeta.setDisplayName("§8» §6Happy Villager");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 45)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 46)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 47)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 51)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 52)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	      else if (i == 53)
	      {
	        ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta smeta = stack.getItemMeta();
	        smeta.setDisplayName("§6");
	        stack.setItemMeta(smeta);
	        inventory.setItem(i, stack);
	      }
	    }
	    player.openInventory(inventory);
		return null;
	  }
	
	public static void openChangeKit(Player p) {
		
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 27, "Kits menu");
		colorChange27(inv);
		ItemStack defaultKit = new ItemStack(Material.WOOD_SWORD);
		ItemMeta mdefaultKit = defaultKit.getItemMeta();
		mdefaultKit.setDisplayName("§8» §eDefault Kit");
		ArrayList<String> ldefaultKit = new ArrayList<String>();
		ldefaultKit.add("§8§m----------------- §7");
		ldefaultKit.add("§8 §7Iron Armor");
		ldefaultKit.add("§8- §7Stone Sword");
		ldefaultKit.add("§8- §7Bow");
		ldefaultKit.add("§8- §7Rod");
		ldefaultKit.add("§8- §7Bow");
		ldefaultKit.add("§8- §7x10 arrows");
		ldefaultKit.add("§8§m----------------- §7");
		ldefaultKit.add("§6Price §8➟ §7Free");
		ldefaultKit.add("§6Status §8➟ §eOPENED");
		mdefaultKit.setLore(ldefaultKit);
		defaultKit.setItemMeta(mdefaultKit);
		
		ItemStack soldierKit = new ItemStack(Material.IRON_SWORD);
		ItemMeta msoldierKit = soldierKit.getItemMeta();
		msoldierKit.setDisplayName("§8» §eSoldier Kit");
		ArrayList<String> lsoldierKit = new ArrayList<String>();
		lsoldierKit.add("§8§m----------------- §7");
		lsoldierKit.add("§8 §7Iron Armor");
		lsoldierKit.add("§8- §7Iron Sword");
		lsoldierKit.add("§8- §7Bow");
		lsoldierKit.add("§8- §7Rod");
		lsoldierKit.add("§8- §7Bow");
		lsoldierKit.add("§8- §6x4 Golden Apple");
		lsoldierKit.add("§8- §7x15 arrows");
		lsoldierKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.soldier")) {
			lsoldierKit.add("§6Price §8➟ §7100 coins");
			lsoldierKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 100) {
				lsoldierKit.add("§6Price §8➟ §a100 coins");
			} else {
				lsoldierKit.add("§6Price §8➟ §c100 coins");
			}
			lsoldierKit.add("§6Status §8➟ §eCLOSED");
		}
		msoldierKit.setLore(lsoldierKit);
		soldierKit.setItemMeta(msoldierKit);
		
		ItemStack archerKit = new ItemStack(Material.BOW);
		ItemMeta marcherKit = archerKit.getItemMeta();
		marcherKit.setDisplayName("§8» §eArcher Kit");
		ArrayList<String> larcherKit = new ArrayList<String>();
		larcherKit.add("§8§m----------------- §7");
		larcherKit.add("§8 §7Iron Armor");
		larcherKit.add("§8- §7Stone Sword");
		larcherKit.add("§8- §7Bow");
		larcherKit.add("§8- §7Rod");
		larcherKit.add("§8- §7Bow: §ePower II");
		larcherKit.add("§8- §6x4 Golden Apple");
		larcherKit.add("§8- §7Infinite arrows");
		larcherKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.archer")) {
			larcherKit.add("§6Price §8➟ §7150 coins");
			larcherKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 150) {
				larcherKit.add("§6Price §8➟ §a150 coins");
			} else {
				larcherKit.add("§6Price §8➟ §c150 coins");
			}
			larcherKit.add("§6Status §8➟ §eCLOSED");
		}
		marcherKit.setLore(larcherKit);
		archerKit.setItemMeta(marcherKit);
		
		ItemStack knightKit = new ItemStack(Material.IRON_AXE);
		ItemMeta mknightKit = knightKit.getItemMeta();
		mknightKit.setDisplayName("§8» §eKnight Kit");
		ArrayList<String> lknightKit = new ArrayList<String>();
		lknightKit.add("§8§m----------------- §7");
		lknightKit.add("§8 §7Diamond Helmet, Boots");
		lknightKit.add("§8 §7Iron Chestplate, Leggings");
		lknightKit.add("§8- §7Diamond Axe");
		lknightKit.add("§8- §7Bow");
		lknightKit.add("§8- §7Rod");
		lknightKit.add("§8- §6x5 Golden Apple");
		lknightKit.add("§8- §7x32 arrows");
		lknightKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.knight")) {
			lknightKit.add("§6Price §8➟ §7250 coins");
			lknightKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 250) {
				lknightKit.add("§6Price §8➟ §a250 coins");
			} else {
				lknightKit.add("§6Price §8➟ §c250 coins");
			}
			lknightKit.add("§6Status §8➟ §eCLOSED");
		}
		mknightKit.setLore(lknightKit);
		knightKit.setItemMeta(mknightKit);
		
		ItemStack tankKit = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta mtankKit = tankKit.getItemMeta();
		mtankKit.setDisplayName("§8» §eTank Kit");
		ArrayList<String> ltankKit = new ArrayList<String>();
		ltankKit.add("§8§m----------------- §7");
		ltankKit.add("§8 §7Diamond Armor");
		ltankKit.add("§8- §7Iron Sword");
		ltankKit.add("§8- §7Bow");
		ltankKit.add("§8- §7Rod");
		ltankKit.add("§8- §6x10 Golden Apple");
		ltankKit.add("§8- §7x48 arrows");
		ltankKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.tank")) {
			ltankKit.add("§6Price §8➟ §7500 coins");
			ltankKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 500) {
				ltankKit.add("§6Price §8➟ §a500 coins");
			} else {
				ltankKit.add("§6Price §8➟ §c500 coins");
			}
			ltankKit.add("§6Status §8➟ §eCLOSED");
		}
		mtankKit.setLore(ltankKit);
		tankKit.setItemMeta(mtankKit);
		
		ItemStack mythicKit = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta mmythicKit = mythicKit.getItemMeta();
		mmythicKit.setDisplayName("§8» §eMythic Kit");
		ArrayList<String> lmythicKit = new ArrayList<String>();
		lmythicKit.add("§8§m----------------- §7");
		lknightKit.add("§8 §7Diamond Helmet, Leggings, Boots");
		lknightKit.add("§8 §7Diamond Chestplate: §eProt I");
		lmythicKit.add("§8- §7Diamond Sword");
		lmythicKit.add("§8- §7Bow");
		lmythicKit.add("§8- §7Rod");
		lmythicKit.add("§8- §6x10 Golden Apple");
		lmythicKit.add("§8- §7x64 arrows");
		lmythicKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.mythic")) {
			lmythicKit.add("§6Price §8➟ §71000 coins");
			lmythicKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 1000) {
				lmythicKit.add("§6Price §8➟ §a1000 coins");
			} else {
				lmythicKit.add("§6Price §8➟ §c1000 coins");
			}
			lmythicKit.add("§6Status §8➟ §eCLOSED");
		}
		mmythicKit.setLore(lmythicKit);
		mythicKit.setItemMeta(mmythicKit);
		
		ItemStack legendaryKit = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta mlegendaryKit = legendaryKit.getItemMeta();
		mlegendaryKit.setDisplayName("§8» §elegendary Kit");
		ArrayList<String> llegendaryKit = new ArrayList<String>();
		llegendaryKit.add("§8§m----------------- §7");
		lknightKit.add("§8 §7Diamond Armor: §ePort I");
		llegendaryKit.add("§8- §7Diamond Sword: §eSharp I");
		llegendaryKit.add("§8- §7Bow: §ePower I");
		llegendaryKit.add("§8- §7Rod");
		llegendaryKit.add("§8- §6x10 Golden Apple");
		llegendaryKit.add("§8- §7x64 arrows");
		llegendaryKit.add("§8§m----------------- §7");
		if (p.hasPermission("pvp.kitss.legendary")) {
			llegendaryKit.add("§6Price §8➟ §71800 coins");
			llegendaryKit.add("§6Status §8➟ §eOPENED");
		} else {
			if (stats.getCoins(p.getName()) >= 1800) {
				llegendaryKit.add("§6Price §8➟ §a1800 coins");
			} else {
				llegendaryKit.add("§6Price §8➟ §c1800 coins");
			}
			llegendaryKit.add("§6Status §8➟ §eCLOSED");
		}
		mlegendaryKit.setLore(llegendaryKit);
		legendaryKit.setItemMeta(mlegendaryKit);
		
		inv.setItem(10, defaultKit);
		inv.setItem(11, soldierKit);
		inv.setItem(12, archerKit);
		inv.setItem(13, knightKit);
		inv.setItem(14, tankKit);
		inv.setItem(15, mythicKit);
		inv.setItem(16, legendaryKit);
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onChangeKit1(InventoryClickEvent e) {
		org.bukkit.inventory.Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();
		if (inv.getName().contains("Kits menu")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eDefault Kit")) {
				e.setCancelled(true);
				p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
				Main.getInstance().getConfig().set("kit." + p.getName(), "default");
				Main.getInstance().saveConfig();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eSoldier Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.soldier")) {
					p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
					Main.getInstance().getConfig().set("kit." + p.getName(), "default");
					Main.getInstance().saveConfig();
				} else {
					if (stats.getCoins(p.getName()) >= 100) {
						p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
						p.closeInventory();
						stats.removeCoins(p.getName(), 100);
						Main.getInstance().getConfig().set("kit." + p.getName(), "soldier");
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.soldier");
					} else {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (100 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
						p.closeInventory();
					}
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eArcher Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.archer")) {
					p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
					Main.getInstance().getConfig().set("kit." + p.getName(), "archer");
					Main.getInstance().saveConfig();
				} else {
					if (stats.getCoins(p.getName()) >= 150) {
						p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
						p.closeInventory();
						stats.removeCoins(p.getName(), 150);
						Main.getInstance().getConfig().set("kit." + p.getName(), "archer");
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.archer");
					} else {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (150 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
						p.closeInventory();
					}
				}
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eKnight Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.knight")) {
					p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
					Main.getInstance().getConfig().set("kit." + p.getName(), "knight");
					Main.getInstance().saveConfig();
				} else {
					if (stats.getCoins(p.getName()) >= 250) {
						p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
						p.closeInventory();
						stats.removeCoins(p.getName(), 250);
						Main.getInstance().getConfig().set("kit." + p.getName(), "knight");
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.knight");
					} else {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (250 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
						p.closeInventory();
					}
				}
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eTank Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.tank")) {
					p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
					Main.getInstance().getConfig().set("kit." + p.getName(), "tank");
					Main.getInstance().saveConfig();
				} else {
					if (stats.getCoins(p.getName()) >= 500) {
						p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
						p.closeInventory();
						stats.removeCoins(p.getName(), 500);
						Main.getInstance().getConfig().set("kit." + p.getName(), "tank");
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.tank");
					} else {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (500 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
						p.closeInventory();
					}
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eMythic Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.soldier") && p.hasPermission("pvp.kits.archer") && p.hasPermission("pvp.kits.knight") && p.hasPermission("pvp.kits.tank")) {
					if (p.hasPermission("pvp.kits.mythic")) {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
						Main.getInstance().getConfig().set("kit." + p.getName(), "mythic");
						Main.getInstance().saveConfig();
					} else {
						if (stats.getCoins(p.getName()) >= 1000) {
							p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
							p.closeInventory();
							stats.removeCoins(p.getName(), 1000);
							Main.getInstance().getConfig().set("kit." + p.getName(), "mythic");
							Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.mythic");
						} else {
							p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (1000 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
							p.closeInventory();
						}
					}
				} else {
					p.sendMessage("§8❘ §aHozexMC §8❘ §7You should open all the previous kits to buy this one");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8» §eLegendary Kit")) {
				e.setCancelled(true);
				if (p.hasPermission("pvp.kits.soldier") && p.hasPermission("pvp.kits.archer") && p.hasPermission("pvp.kits.knight") && p.hasPermission("pvp.kits.tank") && p.hasPermission("pvp.kits.mythic")) {
					if (p.hasPermission("pvp.kits.legendary")) {
						p.sendMessage("§8❘ §cHozexMC §8❘ §7You have selected this kit");
						Main.getInstance().getConfig().set("kit." + p.getName(), "legendary");
						Main.getInstance().saveConfig();
					} else {
						if (stats.getCoins(p.getName()) >= 1800) {
							p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfuly bought this kit!");
							p.closeInventory();
							stats.removeCoins(p.getName(), 1800);
							Main.getInstance().getConfig().set("kit." + p.getName(), "legendary");
							Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " set pvp.kits.legendary");
						} else {
							p.sendMessage("§8❘ §cHozexMC §8❘ §7You need §e" + (1800 - stats.getCoins(p.getName()) + " §7coins to but this kit"));
							p.closeInventory();
						}
					}
				} else {
					p.sendMessage("§8❘ §aHozexMC §8❘ §7You should open all the previous kits to buy this one");
				}
			}
		}
	}
	
	public static String getKit(Player p) {
		if (Main.getInstance().getConfig().contains("kit." + p.getName())) {
			if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("emerald")) {
				return "emerald";
			} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("diamond")) {
				return "diamond";
			} else if (Main.getInstance().getConfig().getString("kit." + p.getName()).contains("gold")) {
				
			} else {
				return "gold";
			}
		} else {
			return "default";
		}
		return "default";
	}

}
