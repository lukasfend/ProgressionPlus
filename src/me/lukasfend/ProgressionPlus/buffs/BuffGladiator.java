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


	@Override
	public BuffType getType() {
		return BuffType.GLADIATORS_HONOR;
	}

	@Override
	public String getDescription(Player p) {
		double totalReduction = (getLevel(p) * getBuffCfg("damageReductionPerLevel", 0.5f)) + getBuffCfg("damageReductionBase",0); 
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
				double totalReduction = (getLevel(p) * getBuffCfg("damageReductionPerLevel", 0.5f)) + getBuffCfg("damageReductionBase",0); 
				damage = (damage > totalReduction) ? damage-totalReduction : damage;
				e.setDamage(damage);
			}
		}
	}
	

}
