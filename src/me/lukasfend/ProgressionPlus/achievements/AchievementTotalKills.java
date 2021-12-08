package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class AchievementTotalKills extends Achievement {

	@Override
	public String getTitle() {
		return "Hunter";
	}

	@Override
	public String getDescription() {
		return "Kill a total of $COUNT creatures.";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.NORMAL;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return new ArrayList<Integer>(Arrays.asList(
				10, 25, 50, 100, 250, 500, 1000,
				2000, 2500, 3000, 4000, 5000, 7500,
				10000, 12500, 15000, 20000, 25000
			)
		);
	}

	@Override
	public void evokeRewards(Player p, int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Material getIconMaterial() {
		return Material.ENDER_EYE;
	}
	

}
