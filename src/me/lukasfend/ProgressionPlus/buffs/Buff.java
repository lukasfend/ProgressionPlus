package me.lukasfend.ProgressionPlus.buffs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.RomanNumbers;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public abstract class Buff implements Listener {
	
	protected ProgressionPlus plugin = ProgressionPlus.getInstance();

	public abstract BuffType getType();
	public abstract String getDescription(Player p);
	public abstract Rarity getRarity();
	public abstract Material getIconMaterial();
	
	public boolean isActive(Player p) {
		try {
			return plugin.getPlayerProfile(p).hasBuff(this.getType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int getLevel(Player p) {
		try {
			return plugin.getPlayerProfile(p).getBuffLevel(this.getType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setLevel(Player p, int level) {
		try {
			plugin.getPlayerProfile(p).setBuffLevel(this.getType(), level);
			if(getLevel(p) <= level) {
				postToChat(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getFormattedName(Player p) {
		return this.getRarity().getColor() + this.getType().getTitle() + " " + this.getLevel(p);
	}
	
	@SuppressWarnings("deprecation")
	public final void postToChat(Player p) {
		TextComponent message = new TextComponent( "\n§b" + p.getDisplayName() + " §7unlocked a new Buff: " + getRarity().getColor() + "[" + getType().getTitle() + " " + RomanNumbers.toRoman(getLevel(p)) + "]" );
		message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/ppshowbuffs" ) );
		message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(this.replacePlaceHolders(getDescription(p), p)).create() ) );
		
		for(Player x : Bukkit.getServer().getOnlinePlayers()) {
			x.spigot().sendMessage(message);
		}
	}
	
	public final String replacePlaceHolders(String str, Player p) {
		str = str.replace("$NAME", getType().getTitle());
		str = str.replace("$LEVEL", RomanNumbers.toRoman(this.getLevel(p)));
		return str;
	}
	
	
	public double getBuffCfg(String propertyName, double defaultValue) {
		ProgressionPlus plugin = ProgressionPlus.getInstance();
		String key = getType().getTitle()
				.replace(" ", "_")
				.replace(",", ",")
				.replace("'", "").toLowerCase();
		if(!plugin.getConfig().contains("buff." + key + "." + propertyName)) {
			plugin.getConfig().set("buff." + key + "."+propertyName, (double)defaultValue);
			plugin.saveConfig();
			return defaultValue;
		} else {
			return plugin.getConfig().getDouble("buff." + key + "."+propertyName);
		}
	}
	public boolean getBuffCfgBool(String propertyName, boolean defaultValue) {
		ProgressionPlus plugin = ProgressionPlus.getInstance();
		String key = getType().getTitle()
				.replace(" ", "_")
				.replace(",", ",")
				.replace("'", "").toLowerCase();
		if(!plugin.getConfig().contains("buff." + key + "." + propertyName)) {
			plugin.getConfig().set("buff" + key + "."+propertyName, (boolean)defaultValue);
			plugin.saveConfig();
			return defaultValue;
		} else {
			return plugin.getConfig().getBoolean("buff" + key + "."+propertyName);
		}
	}
	
	// Add @EventHandlers below
}
