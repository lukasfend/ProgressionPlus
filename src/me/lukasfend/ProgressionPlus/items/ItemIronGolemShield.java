package me.lukasfend.ProgressionPlus.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.lukasfend.ProgressionPlus.helpers.NBTTag;
import me.lukasfend.ProgressionPlus.helpers.PlayerHologramNotification;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class ItemIronGolemShield extends Item implements Listener {

	@Override
	public String getItemName() {
		return "Bulwark of the Mountain";
	}
	@Override
	public List<String> getItemDescription() {
		return Arrays.asList(
			"",
			"§7A heavy shield, infused with the power of",
			"§7the iron golems.\n",
			"\n",
			Item.ActivePrefix + "While blocking, returns all projectiles back to their origin.",
			Item.ItemLevelPrefix + "100",
			""
		);
	}

	@Override
	public Rarity getItemRarity() {
		// TODO Auto-generated method stub
		return Rarity.LEGENDARY;
	}

	@Override
	public boolean isSoulbound() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getItem(Player p) {
		ItemStack item = new ItemStack(Material.SHIELD);
		item.addEnchantment(Enchantment.MENDING, 1);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(this.getItemName());
		im.setUnbreakable(true);
		im.setLore(this.getItemDescription());
		item.setItemMeta(im);
		return Item.tagItem(item, NBTTag.isItemIronGolemShield);
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		// Shield effect
		if((e.getHitEntity() != null) && (e.getHitEntity() instanceof Player)) {
			Player hitPlayer = (Player) e.getHitEntity();
			if(
					hitPlayer.getInventory().getItemInMainHand() != null &&
					Item.isTagged(hitPlayer.getInventory().getItemInMainHand(), NBTTag.isItemIronGolemShield) ||
					hitPlayer.getInventory().getItemInOffHand() != null &&
					Item.isTagged(hitPlayer.getInventory().getItemInOffHand(), NBTTag.isItemIronGolemShield)
			) {
				if(hitPlayer.isBlocking()) {
					Entity shooter = (Entity) e.getEntity().getShooter();
					Vector reflectVector = shooter.getLocation().toVector().subtract(hitPlayer.getLocation().toVector());
					hitPlayer.launchProjectile(e.getEntity().getClass(), reflectVector.normalize().multiply(1.4));
					e.setCancelled(true);
					e.getEntity().remove();
					hitPlayer.playSound(hitPlayer.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 3, 1);
					hitPlayer.getWorld().playEffect(hitPlayer.getLocation(), Effect.VILLAGER_PLANT_GROW, 0,4);
					PlayerHologramNotification.showHologram("§7§oReflected", 0.5, hitPlayer);
				}
			}
		}
	}

	

}
