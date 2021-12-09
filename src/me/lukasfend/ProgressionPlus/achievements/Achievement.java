package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.RomanNumbers;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public abstract class Achievement {
	
	protected ProgressionPlus plugin = ProgressionPlus.getInstance();
	
	public abstract String getTitle(); // eg. "Cow Killer $LEVEL"
	public abstract String getDescription(); // eg. "Kill a total of $COUNT cows."
	public abstract Rarity getRarity();
	public abstract ArrayList<Integer> getCountRequirements(); // eg. [10, 25, 50, 100, 250] - count at which the achievement level is reached
	public abstract Material getIconMaterial();
	
	
	@SuppressWarnings("deprecation")
	public final void postToChat(Player p, int count) {
		TextComponent message = new TextComponent( "\n§b" + p.getDisplayName() + " §7unlocked a new Achievement: " + getRarity().getColor() + "[" + this.replacePlaceHolders(getTitle() + " $LEVEL", count) + "]" );
		message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/ppshowachievements" ) );
		message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(this.replacePlaceHolders(getDescription(), count)).create() ) );
		
		for(Player x : Bukkit.getServer().getOnlinePlayers()) {
			x.spigot().sendMessage(message);
		}
	}
	
	public final String replacePlaceHolders(String str, int count) {
		str = str.replace("$COUNT", count+"");
		str = str.replace("$LEVEL", RomanNumbers.toRoman(this.getLevel(count)));
		return str;
	}
	
	public final int getLevel(int count) {
		int level = 0;
		for(int i = 0; i < getCountRequirements().size(); i++) {
			if(count >= getCountRequirements().get(i)) {
				level = i+1;
			}
		}
		return level;
	}
	
	private final void sendAchievementSound(Player p) {
		p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 4, 1);
	}
	
	public final void evokeConditionCheck(Player p, int count) {
		// Checks if a new achievement is reached
		for(int countForLevel : getCountRequirements()) {
			if(countForLevel == count) {
				// Achievement unlocked!
				this.postToChat(p, count);
				this.evokeRewards(p, count, this.getLevel(count));
				this.sendAchievementSound(p);
			}
		}
	}
	
	// To be implemented in instance
	public abstract void evokeRewards(Player p, int count, int level);

	
	
}
