package me.lukasfend.ProgressionPlus.buffs;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

/**
 * Reduces damage taken from all sources by a quarter heart per level
 *
 */
public class BuffGladiator extends Buff {
	
	private double getReductionPerLevel() {
		if(plugin.getConfig().contains("buffs." + this.getType().toString() + ".damageReductionPerLevel")) {
			return plugin.getConfig().getDouble("buffs." + this.getType().toString() + ".damageReductionPerLevel");
		} else {
			plugin.getConfig().set("buffs." + this.getType().toString() + ".damageReductionPerLevel", 0.5);
			plugin.saveConfig();
			return 0.5;
		}
	}

	@Override
	public BuffType getType() {
		return BuffType.GLADIATORS_HONOR;
	}

	@Override
	public String getDescription(Player p) {
		double totalReduction = this.getLevel(p) * this.getReductionPerLevel(); 
		return "Reduces all incoming damage by " + String.format("%.2f", totalReduction/2) + " hearts.";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.LEGENDARY;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.CHAINMAIL_CHESTPLATE;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player)e.getEntity();
			if(this.isActive(p)) {				
				double damage = e.getDamage();
				damage = (damage > (this.getReductionPerLevel()*this.getLevel(p))) ? damage-(this.getReductionPerLevel()*this.getLevel(p)) : damage;
				e.setDamage(damage);
			}
		}
	}
	

}
