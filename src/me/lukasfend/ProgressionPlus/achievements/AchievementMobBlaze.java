package me.lukasfend.ProgressionPlus.achievements;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.PlayerProfile;
import me.lukasfend.ProgressionPlus.helpers.Rarity;
import me.lukasfend.ProgressionPlus.helpers.StaticData;
import me.lukasfend.ProgressionPlus.items.Item;
import me.lukasfend.ProgressionPlus.items.ItemHotRod;

public class AchievementMobBlaze extends Achievement {

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Hot Rod";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill a total of $COUNT blazes.";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.RARE;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		return new ArrayList<Integer>(Arrays.asList(
			25,50,100,150,250,500,
			1000,1500,2500,5000,7500,10000
		));
	}

	@Override
	public Material getIconMaterial() {
		return Material.BLAZE_ROD;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {

		PlayerProfile pp = null;
		try {
			pp = ProgressionPlus.getInstance().getPlayerProfile(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Level 1 rod
		if( count >= 250 && !pp.hasReceivedReward("hotrod1")) {
			ItemHotRod item = new ItemHotRod();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 1), p);
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			pp.setReceivedReward("hotrod1");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// Level 2 rod
		if( count >= 500 && !pp.hasReceivedReward("hotrod2")) {
			ItemHotRod item = new ItemHotRod();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 2), p);
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			pp.setReceivedReward("hotrod2");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// Level 3 rod
		if( count >= 1000 && !pp.hasReceivedReward("hotrod3")) {
			ItemHotRod item = new ItemHotRod();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 3), p);
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			pp.setReceivedReward("hotrod3");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// Level 4 rod
		if( count >= 2500 && !pp.hasReceivedReward("hotrod4")) {
			ItemHotRod item = new ItemHotRod();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 4), p);
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			pp.setReceivedReward("hotrod4");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// Level 5 rod
		if( count >= 2500 && !pp.hasReceivedReward("hotrod4")) {
			ItemHotRod item = new ItemHotRod();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 5), p);
			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			pp.setReceivedReward("hotrod4");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
	}

}
