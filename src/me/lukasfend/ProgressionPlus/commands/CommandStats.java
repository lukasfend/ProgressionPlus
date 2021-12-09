package me.lukasfend.ProgressionPlus.commands;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.PlayerProfile;

public class CommandStats implements CommandExecutor {
	
	private ProgressionPlus plugin = ProgressionPlus.getInstance();

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player target;
		int page;
		
		if(args.length == 0) {
			target = (Player)cs;
			page = 1;
		} else if(args.length == 1) {
			target = (Player)cs;
			page = Integer.parseInt(args[0]);
		} else {
			target = Bukkit.getServer().getPlayer(args[1]);
			page = Integer.parseInt(args[0]);
		}

		PlayerProfile pp = new PlayerProfile(target);
		HashMap<String, Integer> mobs = pp.getEntityKills();
		cs.sendMessage("\n\n§7§l======= §a[ ProgressionPlus ] §7§l=======");
		int i = 0;
		for (Entry<String, Integer> entry : mobs.entrySet()) {
			if( i >= 8*(page-1) && i < 8*page) {
				Object value = entry.getValue();
				String key = entry.getKey();	
				key = key.toLowerCase();
				key = key.substring(0,1).toUpperCase() + key.substring(1);
				key = key.replace("_", " ");
				cs.sendMessage("- §5" + key + ":§r " + value);
			}
		    i++;
		}
		cs.sendMessage("§6Total Mob Kills: §r" + pp.getTotalKills());
		cs.sendMessage("§7§l========== §a[ Page " + page + "/"+((int)(mobs.size()/8))+" ] §7§l==========");
		
		return true;
		
	}

}
