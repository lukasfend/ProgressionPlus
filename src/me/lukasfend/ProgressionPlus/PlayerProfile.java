package me.lukasfend.ProgressionPlus;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.achievements.AchievementTotalKills;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class PlayerProfile {
	
	private ProgressionPlus plugin;
	private Player player;
	private File playerDataFile;
	private FileConfiguration saveFile;
	
	public PlayerProfile(Player player) {
		plugin = ProgressionPlus.getInstance();
		this.player = player;
		playerDataFile = new File(plugin.getDataFolder() + "/players/" + player.getUniqueId().toString() + ".yml");
		saveFile = YamlConfiguration.loadConfiguration(playerDataFile);
		if(!saveFile.contains("player.name")) {
			// No file existent, create one
			System.out.println("[ProgressionPlus] Creating new player profile for " + player.getDisplayName() + "(" + player.getUniqueId().toString() + ")...");
			saveFile.set("player.name", player.getDisplayName());
			saveFile.set("player.uuid", player.getUniqueId().toString());
			saveFile.set("player.totalkills", 0);
			for(String mobName : StaticData.TRACKED_ENTITIES) {
				saveFile.set("player.entitykills." + mobName, 0);
			}
			savePlayer();
		}
	}
	
	public void addEntityKill(String entityName) {
		if(StaticData.ALIVE_ENTITIES.contains(entityName)) {
			// only increase total kills for living entities (not arrows, endereyes etc.)
			int totalKills = getTotalKills()+1;
			saveFile.set("player.totalkills", totalKills);
			// Trigger total kill achievement check
			new AchievementTotalKills().evokeConditionCheck(player, totalKills);
		}
		int entityKills = getEntityKills(entityName)+1;
		saveFile.set("player.entitykills." + entityName, entityKills);			
		
		if(plugin.achievements.containsKey(entityName)) {
			// Trigger entity achievement check
			plugin.achievements.get(entityName).evokeConditionCheck(player, entityKills);
		}
		
		this.savePlayer();
		// TODO: loop through achievements
	}
	
	public int getEntityKills(String entityName) {
		return saveFile.getInt("player.entitykills." + entityName);
	}
	
	public int getTotalKills() {
		return saveFile.getInt("player.totalkills");
	}
	
	public void savePlayer() {
		// save data
		try {
			saveFile.save(playerDataFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Player getPlayer() {
		return player;
	}

}
