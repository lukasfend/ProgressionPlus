package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobSheep extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Beep beep i'm a Sheep";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill $COUNT sheep.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.NORMAL;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return StaticData.ACHIEVEMENT_STEPS_NORMAL;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.WHITE_WOOL;
	}

	@Override
	public void evokeRewards(Player p, int level) {
		// TODO Auto-generated method stub

	}

}
