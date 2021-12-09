package me.lukasfend.ProgressionPlus.features;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import me.lukasfend.ProgressionPlus.items.Item;

@SuppressWarnings("deprecation")
public class EventInventoryClick implements Listener {
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		Player p = (Player) e.getPlayer();
		if(Item.isSoulbound(e.getItem().getItemStack()) && !Item.isSoulboundTo(e.getItem().getItemStack(), p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		for(ItemStack item : p.getInventory().getContents()) {
			if(item != null && item.getType() != Material.AIR) {
				if(Item.isSoulbound(item) && !Item.isSoulboundTo(item, p)) {
					// item owned by other player
					p.getInventory().removeItem(item);
					p.getWorld().dropItem(p.getLocation(), item);
					p.sendMessage("§4" + item.getItemMeta().getDisplayName() + "§c was dropped because it is soulbound to another player.");
				}
			}
		}
	}

}
