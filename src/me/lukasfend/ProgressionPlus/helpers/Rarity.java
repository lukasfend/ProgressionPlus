package me.lukasfend.ProgressionPlus.helpers;

import org.bukkit.ChatColor;

public enum Rarity {
	NORMAL,
	UNCOMMON,
	RARE,
	EPIC,
	LEGENDARY,
	NIGHTMARE;

	public String getColor() {
		switch(this) {
			case NORMAL:
				return ChatColor.WHITE.toString();
			case UNCOMMON:
				return ChatColor.DARK_GREEN.toString();
			case RARE:
				return ChatColor.BLUE.toString();
			case EPIC:
				return ChatColor.DARK_PURPLE.toString();
			case LEGENDARY:
				return ChatColor.BOLD.toString() + ChatColor.GOLD.toString();
			case NIGHTMARE:
				return ChatColor.DARK_RED.toString();
			default:
				return ChatColor.RESET.toString();
		}
	}
}