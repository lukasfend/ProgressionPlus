package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobEnderman extends Achievement {

	@Override
	public String getTitle() {
		return "Businessman";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill a total of $COUNT enderman.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.EPIC;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return StaticData.ACHIEVEMENT_STEPS_NORMAL;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.ENDER_PEARL;
	}

	@Override
	public void evokeRewards(Player p, int level) {
		// TODO Auto-generated method stub
		
	}

}
