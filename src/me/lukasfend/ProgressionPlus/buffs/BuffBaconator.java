package me.lukasfend.ProgressionPlus.buffs;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.PlayerHologramNotification;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class BuffBaconator extends Buff {

	private double getHealingPerLevel() {
		if(plugin.getConfig().contains("buffs." + this.getType().toString() + ".healingPerLevel")) {
			return plugin.getConfig().getDouble("buffs." + this.getType().toString() + ".healingPerLevel");
		} else {
			plugin.getConfig().set("buffs." + this.getType().toString() + ".healingPerLevel", 0.5);
			plugin.saveConfig();
			return 0.5;
		}
	}
	
	@Override
	public BuffType getType() {
		// TODO Auto-generated method stub
		return BuffType.BACONATOR;
	}

	@Override
	public String getDescription(Player p) {
		// TODO Auto-generated method stub
		double totalHealing = getBuffCfg("healingBase", 0f) + (getBuffCfg("healingPerLevel", 0.5f)*getLevel(p));
		return "When eating cooked pork, also heal for " + String.format("%.2f", totalHealing) + " HP";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.RARE;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.PORKCHOP;
	}
	
	@EventHandler
	public void onItemConsume(PlayerItemConsumeEvent e) {
		if(e.getItem().getType() == Material.COOKED_PORKCHOP) {
			Player p = (Player) e.getPlayer();
			if(this.getLevel(p) != 0) {
				double totalHealing = getBuffCfg("healingBase", 0f) + (getBuffCfg("healingPerLevel", 0.5f)*getLevel(p));
				PlayerHologramNotification.showHologram("§4+ " + String.format("%.2f", totalHealing/2) + " HP", 1.5, p);
				if((p.getHealth()+totalHealing) >= p.getMaxHealth()) {
					p.setHealth(p.getMaxHealth());
				} else {
					p.setHealth(p.getHealth() + totalHealing);
				}
			}
		}
	}

}
