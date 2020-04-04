package like.invis.us.Listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class JumpPad implements Listener {
  @EventHandler
  public void onMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (p.getLocation().subtract(0.0D, 0.0D, 0.0D).getBlock().getType() == Material.STONE_PLATE)
    {
      p.setVelocity(p.getLocation().getDirection().multiply(3));
      p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    if (p.getLocation().subtract(0.0D, 0.0D, 0.0D).getBlock().getType() == Material.GOLD_PLATE)
    {
      p.setVelocity(p.getLocation().getDirection().multiply(3));
      p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    if (p.getLocation().subtract(0.0D, 0.0D, 0.0D).getBlock().getType() == Material.IRON_PLATE)
    {
      p.setVelocity(p.getLocation().getDirection().multiply(3));
      p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
  }
}
