package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class AchievementMobPillager extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "No thank you";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill $COUNT pillagers.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.RARE;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(Arrays.asList(
			100, 200, 300, 400, 500, 750, 1000,
			2500, 5000, 7500, 10000
		));
	}

	@Override
	public Material getIconMaterial() {
		return Material.CROSSBOW;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		if(count >= 5000) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 6);
		} else if(count >= 2500) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 5);
		} else if(count >= 1000) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 4);
		} else if(count >= 500) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 3);
		} else if(count >= 200) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 2);
		} else if(count >= 100) {
			plugin.buffs.get(BuffType.RAIN_OF_BOLTS).setLevel(p, 1);
		}
		
	}

}
