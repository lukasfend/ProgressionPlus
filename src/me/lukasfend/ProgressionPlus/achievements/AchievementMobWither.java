package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobWither extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Withering away";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill the wither $COUNT times";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.LEGENDARY;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return StaticData.ACHIEVEMENT_STEPS_LEGENDARY;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.NETHER_STAR;
	}


	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		
	}

}
