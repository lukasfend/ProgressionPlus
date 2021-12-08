package me.lukasfend.ProgressionPlus.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.lukasfend.ProgressionPlus.ProgressionPlus;

public class EventPlayerJoin implements Listener {
	
	private ProgressionPlus main = ProgressionPlus.getInstance();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(!main.isPlayerProfileLoaded(e.getPlayer())) {
			main.loadPlayerProfile(e.getPlayer());
		}
	}

}
