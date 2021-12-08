package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobCaveSpider extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Caveman";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill a total of $COUNT cave spiders.";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.UNCOMMON;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return StaticData.ACHIEVEMENT_STEPS_NORMAL;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.COBWEB;
	}

	@Override
	public void evokeRewards(Player p, int level) {
		// TODO Auto-generated method stub

	}

}
