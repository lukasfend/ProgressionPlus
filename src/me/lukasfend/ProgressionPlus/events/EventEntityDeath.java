package me.lukasfend.ProgressionPlus.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.lukasfend.ProgressionPlus.PlayerProfile;
import me.lukasfend.ProgressionPlus.ProgressionPlus;

public class EventEntityDeath implements Listener {
	
	private ProgressionPlus plugin = ProgressionPlus.getInstance();
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) throws Exception {
		
		// Check if killer is player
		if(e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			PlayerProfile pp = plugin.getPlayerProfile(p);
			pp.addEntityKill(e.getEntityType().toString());
		}
	}

}
