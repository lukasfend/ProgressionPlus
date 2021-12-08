package me.lukasfend.ProgressionPlus.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.lukasfend.ProgressionPlus.ProgressionPlus;

public class EventPlayerQuit implements Listener {
	
	private ProgressionPlus main = ProgressionPlus.getInstance();
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if(main.isPlayerProfileLoaded(e.getPlayer())) {
			main.unloadPlayerProfile(e.getPlayer());
		}
	}

}
