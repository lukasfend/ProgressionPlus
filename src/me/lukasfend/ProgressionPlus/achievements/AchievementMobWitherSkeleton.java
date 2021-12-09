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
import me.lukasfend.ProgressionPlus.items.Item;
import me.lukasfend.ProgressionPlus.items.ItemWitherSword;

public class AchievementMobWitherSkeleton extends Achievement {

	@Override
	public String getTitle() {
		return "Netherophobia";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Kill $COUNT wither skeletons";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.EPIC;
	}

	@Override
	public ArrayList<Integer> getCountRequirements() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(Arrays.asList(
			25, 50, 100, 150, 200, 250, 500, 1000, 1500, 2000, 2500, 5000, 7500, 10000
		));
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.WITHER_SKELETON_SKULL;
	}

	@Override
	public void evokeRewards(Player p, int count, int level) {
		PlayerProfile pp = null;
		try {
			pp = ProgressionPlus.getInstance().getPlayerProfile(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// level 1 sword
		if(count >= 250 && !pp.hasReceivedReward("withersword1")) {
			ItemWitherSword item = new ItemWitherSword();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 1), p);

			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("withersword1");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// level 2 sword
		if(count >= 500 && !pp.hasReceivedReward("withersword2")) {
			ItemWitherSword item = new ItemWitherSword();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 2), p);

			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("withersword2");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// level 3 sword
		if(count >= 1000 && !pp.hasReceivedReward("withersword3")) {
			ItemWitherSword item = new ItemWitherSword();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 3), p);

			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("withersword3");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		// level 4 sword
		if(count >= 2500 && !pp.hasReceivedReward("withersword4")) {
			ItemWitherSword item = new ItemWitherSword();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 4), p);

			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("withersword4");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
		
		
		// level 5 sword
		if(count >= 1000 && !pp.hasReceivedReward("withersword5")) {
			ItemWitherSword item = new ItemWitherSword();
			ItemStack is = Item.getSoulboundItem(item.getItem(p, 5), p);

			Bukkit.broadcastMessage("§a" + p.getDisplayName() + " just obtained " + item.getItemRarity().getColor() + item.getItemName());
			
			pp.setReceivedReward("withersword5");
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage("§4An item was dropped on the ground!");
				p.getWorld().dropItem(p.getLocation(), is);
			} else {
				p.getInventory().addItem(is);
			}
		}
	}

}
