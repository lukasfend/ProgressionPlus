package me.lukasfend.ProgressionPlus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandAchievements implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String args, String[] label) {
		cs.sendMessage("This command is under construction!");
		return true;
	}

}
