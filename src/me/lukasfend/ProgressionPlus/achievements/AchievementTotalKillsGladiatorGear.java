package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class AchievementTotalKillsGladiatorGear extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Gladiator";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Earned by killing a total of 1000 enemies!";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.LEGENDARY;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return new ArrayList<Integer>(Arrays.asList(500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000));
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.DIAMOND_AXE;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// BUFF: Reduces damage taken by 0.5hearts each time
		if(level <= 6) {
			plugin.buffs.get(BuffType.GLADIATORS_HONOR).setLevel(p, level);
		}
		
	}

}
