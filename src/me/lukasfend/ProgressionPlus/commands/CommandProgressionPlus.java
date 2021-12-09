package me.lukasfend.ProgressionPlus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.items.ItemIronGolemShield;

public class CommandProgressionPlus implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("give")) {
				if(args[1].equalsIgnoreCase("irongolemshield")) {
					ItemIronGolemShield item = new ItemIronGolemShield();
					p.getInventory().addItem(ItemIronGolemShield.getSoulboundItem(item.getItem(p), p));
					p.sendMessage("Item Added: " + item.getItem(p).getItemMeta().getDisplayName());
				}
			}
			if(args[0].equalsIgnoreCase("fp")) {
				p.setFoodLevel(0);
			}
		}
		return true;
	}

}
