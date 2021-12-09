package me.lukasfend.ProgressionPlus.buffs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import me.lukasfend.ProgressionPlus.helpers.BuffType;
import me.lukasfend.ProgressionPlus.helpers.Cooldown;
import me.lukasfend.ProgressionPlus.helpers.CooldownHandler;
import me.lukasfend.ProgressionPlus.helpers.PdcKey;
import me.lukasfend.ProgressionPlus.helpers.PlayerHologramNotification;
import me.lukasfend.ProgressionPlus.helpers.RandomVector;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class BuffRainOfBolts extends Buff {

	@Override
	public BuffType getType() {
		// TODO Auto-generated method stub
		return BuffType.RAIN_OF_BOLTS;
	}

	@Override
	public String getDescription(Player p) {
		// TODO Auto-generated method stub
		double arrowCount = getBuffCfg("arrowCountBase", 10f) + (getLevel(p)*getBuffCfg("arrowCountPerLevel", 3f));
		return "§5§nActive§r - §fFires a volley of §6"+arrowCount+"§f bolts at the bolt's impact location."
				+ "\n§7§oHold down shift while shooting to activate.\n\n"
				+ "§9Cooldown: §r" + ((int)getBuffCfg("cooldown", 60f)) + "s";
	}

	@Override
	public Rarity getRarity() {
		// TODO Auto-generated method stub
		return Rarity.RARE;
	}

	@Override
	public Material getIconMaterial() {
		// TODO Auto-generated method stub
		return Material.CROSSBOW;
	}
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent e) {
		if(e.getEntity().getShooter() instanceof Player) {
			Player p = (Player) e.getEntity().getShooter();
			if(p.isSneaking() && (getLevel(p)>0)) {
				if(CooldownHandler.getInstance().isOnCooldown(p, Cooldown.BUFF_RAIN_OF_BOLTS)) {
					p.sendMessage(
							getRarity().getColor() 
							+getType().getTitle() 
							+ "§r is on cooldown. (§c" 
							+ CooldownHandler.getInstance().getRemainingCooldown(p, Cooldown.BUFF_RAIN_OF_BOLTS)
							+ "§r)");
					return;
				} else {
					long cooldown = (long) (getBuffCfg("cooldownAbsoluteBase", 90f) - (getLevel(p)*getBuffCfg("cooldownAbsoluteReductionPerLevel", 10f)));
					CooldownHandler.getInstance().activateCooldown(p, Cooldown.BUFF_RAIN_OF_BOLTS, cooldown*1000);
				}
				Projectile proj = e.getEntity();
				proj.getPersistentDataContainer().set(plugin.pdcKeys.get(PdcKey.BUFF_RAIN_OF_BOLTS.key()), PersistentDataType.SHORT, (short)1);
				PlayerHologramNotification.showHologram("§a"+getType().getTitle(), 1.5, p);
				// TODO: cooldown
			}
		}
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if(e.getEntityType() == EntityType.ARROW) {
			Projectile proj = e.getEntity();
			if(proj.getPersistentDataContainer().has(plugin.pdcKeys.get(PdcKey.BUFF_RAIN_OF_BOLTS.key()), PersistentDataType.SHORT)) {
				if(proj.getPersistentDataContainer().get(plugin.pdcKeys.get(PdcKey.BUFF_RAIN_OF_BOLTS.key()), PersistentDataType.SHORT) == 1) {
					
					Player p = (Player) proj.getShooter();
					// shoot rain
					World w = p.getWorld();
					Location locStart = p.getLocation().add(new Vector(0,12,0));
					Location locTarget;
					if(e.getHitBlock() != null) {
						locTarget = e.getHitBlock().getLocation();
					} else if(e.getHitEntity() != null) {
						locTarget = e.getHitEntity().getLocation();
					} else {
						// arrow did not hit anything?
						return;
					}
					
					double arrowCount = getBuffCfg("arrowCountBase", 10f) + (getLevel(p)*getBuffCfg("arrowCountPerLevel", 2f));
					double dist = 3;
					ArrayList<Vector> startLocations = new ArrayList<Vector>();
					ArrayList<Vector> velocityVectors = new ArrayList<Vector>();
					double arrowAngleOffset = 360 / arrowCount;
					for(int i = 0; i < (int)arrowCount; i++) {
						Vector position = new Vector(
								locStart.getX() + Math.cos(i*arrowAngleOffset)*dist,
								locStart.getY(),
								locStart.getZ() + Math.sin(i*arrowAngleOffset)*dist
							);
						startLocations.add(position);
						velocityVectors.add(locTarget.toVector().subtract(position).add(RandomVector.randomVector(getBuffCfg("arrowSpreadFactor", 6f))));
					}
					
					for(int i = 0; i < startLocations.size(); i++) {
						Location l = p.getLocation().multiply(0);
						l.add(startLocations.get(i));
						Arrow a = w.spawnArrow(l, new Vector(0,0,0), 0.6f, 2f);
						a.setShooter(p);
						a.setVelocity(velocityVectors.get(i).normalize().multiply(1.6f));
						a.setPickupStatus(PickupStatus.DISALLOWED);
					}
					
					
				}
			}
		}
	}

}
