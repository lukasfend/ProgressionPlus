package me.lukasfend.ProgressionPlus.helpers;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class CooldownHandler {
	
	public static CooldownHandler instance;
	
	private HashMap<String, HashMap<Cooldown, Long>> cooldowns = new HashMap<String, HashMap<Cooldown, Long>>();
	
	private CooldownHandler() {
		instance = this;
	}
	
	public static CooldownHandler getInstance() {
		if(instance == null) {
			instance = new CooldownHandler();
		}
		return instance;
	}
	
	public boolean isOnCooldown(Player p, Cooldown cooldown) {
		String majorKey = p.getUniqueId().toString();
		if(cooldowns.containsKey(majorKey)) {
			if(cooldowns.get(majorKey).containsKey(cooldown)) {
				long cooldownExpirationTimestamp = cooldowns.get(majorKey).get(cooldown) - System.currentTimeMillis();
				if(cooldownExpirationTimestamp > 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void activateCooldown(Player p, Cooldown cooldown, long milliseconds) {
		String majorKey = p.getUniqueId().toString();
		if(cooldowns.containsKey(majorKey)) {
			cooldowns.get(majorKey).put(cooldown, System.currentTimeMillis() + milliseconds);
		} else {
			cooldowns.put(majorKey, new HashMap<Cooldown, Long>());
			activateCooldown(p, cooldown, milliseconds);
		}
	}

	public void removeCooldown(Player p, Cooldown cooldown) {
		String majorKey = p.getUniqueId().toString();
		if(cooldowns.containsKey(majorKey)) {
			if(cooldowns.get(majorKey).containsKey(cooldown))
				cooldowns.get(majorKey).remove(cooldown);
		}
	}
	
	public String getRemainingCooldown(Player p, Cooldown cooldown) {
		String majorKey = p.getUniqueId().toString();
		if(!this.isOnCooldown(p, cooldown)) {
			return "0s";
		} else {
			long cd = cooldowns.get(majorKey).get(cooldown) - System.currentTimeMillis();
			int seconds = (int) (cd / 1000) % 60 ;
			int minutes = (int) ((cd / (1000*60)) % 60);
			int hours   = (int) ((cd / (1000*60*60)) % 24);
			String text = "";
			text = (hours>0) ? text + hours + "h " : text;
			text = (minutes>0) ? text + minutes + "min " : text;
			text = (seconds>0) ? text + seconds + "s" : text;
			if( hours == 0 && minutes == 0 && seconds == 0) {
				return cd + "ms";
			}
			return text;
		}
	}
	
	
	
	

}
