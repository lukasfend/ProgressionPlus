package me.lukasfend.ProgressionPlus;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.lukasfend.ProgressionPlus.achievements.Achievement;
import me.lukasfend.ProgressionPlus.buffs.Buff;
import me.lukasfend.ProgressionPlus.commands.CommandAchievements;
import me.lukasfend.ProgressionPlus.commands.CommandProgressionPlus;
import me.lukasfend.ProgressionPlus.commands.CommandStats;
import me.lukasfend.ProgressionPlus.events.EventEntityDeath;
import me.lukasfend.ProgressionPlus.events.EventPlayerJoin;
import me.lukasfend.ProgressionPlus.events.EventPlayerQuit;
import me.lukasfend.ProgressionPlus.features.EventInventoryClick;
import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.PlayerProfile;
import me.lukasfend.ProgressionPlus.helpers.StaticData;
import me.lukasfend.ProgressionPlus.items.ItemIronGolemShield;

public class ProgressionPlus extends JavaPlugin {
	
	// Main instance of plugin
	private static ProgressionPlus instance;
	private ArrayList<PlayerProfile> playerProfiles = new ArrayList<PlayerProfile>();
	public HashMap<String, Achievement> achievements = new HashMap<String, Achievement>();
	public HashMap<BuffType, Buff> buffs = new HashMap<BuffType, Buff>();

	@Override
	public void onEnable() {
		instance = this;
		System.out.println("[ProgressionPlus] Loading playerdata for " + this.getServer().getOnlinePlayers().size() + " currently online players...");
		for(Player p : this.getServer().getOnlinePlayers()) {
			playerProfiles.add(new PlayerProfile(p));
		}
		
		System.out.println("[ProgressionPlus] Registering events...");
		Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new EventPlayerQuit(), this);
		Bukkit.getPluginManager().registerEvents(new EventEntityDeath(), this);
		Bukkit.getPluginManager().registerEvents(new EventInventoryClick(), this);
		// Item events
		Bukkit.getPluginManager().registerEvents(new ItemIronGolemShield(), this);

		System.out.println("[ProgressionPlus] Registering commands...");
		this.getCommand("progressionplus").setExecutor(new CommandProgressionPlus());
		this.getCommand("ppshowachievements").setExecutor(new CommandAchievements());
		this.getCommand("ppshowstats").setExecutor(new CommandStats());
		
		System.out.println("[ProgressionPlus] Registering achievements...");
		StaticData.loadAchievements(this);
		
		System.out.println("[ProgressionPlus] Registering buffs...");
		StaticData.loadBuffs(this);
		for(Buff b : buffs.values()) {
			Bukkit.getPluginManager().registerEvents(b, this);
		}
	}
	
	@Override
	public void onDisable() {
		System.out.println("[ProgressionPlus] Saving playerdata for " + playerProfiles.size() + " players...");
		for(PlayerProfile pp : playerProfiles) {
			pp.savePlayer();
		}
		playerProfiles.clear();
	}
	
	/**
	 * Returns the singleton instance
	 * @return The main instance of the plugin
	 */
	public static ProgressionPlus getInstance() {
		return instance;
	}
	

	/**
	 * Checks if a player is loaded into memory
	 * @param player - The player to be checked for
	 * @return Returns true if profile is loaded 
	 */
	public boolean isPlayerProfileLoaded(Player player) {
		boolean isLoaded = false;
		for(PlayerProfile pp : playerProfiles) {
			if(pp.getPlayer().getUniqueId() == player.getUniqueId()) {
				isLoaded = true;
			}
		}
		return isLoaded;
	}
	
	/**
	 * Loads the player's profile into memory
	 * @param player
	 */
	public void loadPlayerProfile(Player player) {
		if(!isPlayerProfileLoaded(player)) {
			playerProfiles.add(new PlayerProfile(player));
		}
	}
	
	/**
	 * Retrieves the profile of a player
	 * @param player The player to get the profile of
	 * @return The playerprofile instance
	 */
	public PlayerProfile getPlayerProfile(Player player) throws Exception {
		// Make sure profile is loaded
		this.loadPlayerProfile(player);
		PlayerProfile pp = null;
		for(PlayerProfile profile : playerProfiles) {
			if(profile.getPlayer().getUniqueId() == player.getUniqueId()) {
				pp = profile;
			}
		}
		return pp;
	}
	
	/**
	 * Unloads a player's profile from the memory
	 * @param player The player to be unloaded
	 */
	public void unloadPlayerProfile(Player player) {
		for(int i = 0; i < playerProfiles.size(); i++) {
			if(playerProfiles.get(i).getPlayer().getUniqueId() == player.getUniqueId()) {
				playerProfiles.remove(i);
				return;
			}
		}
	}
}
