package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;

public class AchievementMobPig extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Butcher";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill a total of $COUNT pigs.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.NORMAL;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(Arrays.asList(250,500,1000,2000,3000,4000,5000,7500,10000));
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.COOKED_PORKCHOP;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		if(count >= 5000) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 6);
		} else if(count >= 3000) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 5);
		} else if(count >= 2000) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 4);
		} else if(count >= 1000) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 3);
		} else if(count >= 500) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 2);
		} else if(count >= 250) {
			plugin.buffs.get(BuffType.BACONATOR).setLevel(p, 1);
		}
		
	}

}
