package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class AchievementMobAxolotl extends Achievement {

	@Override
	public String getTitle() {
		return "MONSTER";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "§cEarned by killing $COUNT poor axolotl. What a monster :(";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.NIGHTMARE;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(Arrays.asList(1,5,10,15,20,25,50,100,150,200,250,500,1000,1500,2000,2500,5000));
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.AXOLOTL_BUCKET;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		// TODO Auto-generated method stub
		
	}

}
