package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.PlayerProfile;
import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;
import me.lukasfend.ProgressionPlus.items.Item;
import me.lukasfend.ProgressionPlus.items.ItemIronGolemShield;

public class AchievementMobIronGolem extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Dictatorship";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill $COUNT iron golems.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.EPIC;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return StaticData.ACHIEVEMENT_STEPS_EPIC;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.POPPY;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		PlayerProfile pp = null;
		try {
			pp = ProgressionPlus.getInstance().getPlayerProfile(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count >= 100 && !pp.hasReceivedReward("irongolemshield")) {

			ItemIronGolemShield item = new ItemIronGolemShield();
			ItemStack is = Item.getSoulboundItem(item.getItem(p), p);
			p.getInventory().addItem(is);
			
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("irongolemshield");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
	}

}
