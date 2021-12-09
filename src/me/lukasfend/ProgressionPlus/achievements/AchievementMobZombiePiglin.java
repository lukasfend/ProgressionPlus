package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class AchievementMobZombiePiglin extends Achievement {

	@Override
	public String getTitle() {
		return "Oink no more";
	}

	@Override
	public String getDescription() {
		return "Kill a total of $COUNT zombie piglins.";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.UNCOMMON;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return new ArrayList<Integer>(Arrays.asList(
			25, 50, 75, 100, 150, 200,
			250, 500, 750, 1000, 1500,
			2000, 2500, 3000, 3500, 4000,
			5000, 7500, 10000
		));
	}


	@Override
	public Material getIconMaterial() {
		return Material.GOLDEN_SWORD;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		
	}

}
