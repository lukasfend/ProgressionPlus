package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobBat extends Achievement {

	@Override
	public String getTitle() {
		return "Bat-man";
	}

	@Override
	public String getDescription() {
		return "Kill a total of $COUNT bats.";
	}

	@Override
	public Rarity getRarity() {
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
		return Material.POINTED_DRIPSTONE;
	}


	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		
	}

}
