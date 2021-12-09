package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobZombie extends Achievement {

	@Override
	public String getTitle() {
		return "Braaaaaaains";
	}

	@Override
	public String getDescription() {
		return "Kill a total of $COUNT zombies";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.NORMAL;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return StaticData.ACHIEVEMENT_STEPS_NORMAL;
	}

	@Override
	public Material getIconMaterial() {
		return Material.ZOMBIE_HEAD;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		
	}

}
