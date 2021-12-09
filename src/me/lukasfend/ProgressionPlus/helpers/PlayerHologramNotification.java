package me.lukasfend.ProgressionPlus.helpers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

import me.lukasfend.ProgressionPlus.ProgressionPlus;

public class PlayerHologramNotification {
	
	public static void showHologram(String text, double durationInSeconds, Player p) {
		Location loc = p.getLocation();
		final Hologram hg = HologramsAPI.createHologram(ProgressionPlus.getInstance(), loc);
		hg.appendTextLine(text);
		
		new BukkitRunnable() {
			
			int totalTicksToRun = (int) durationInSeconds*20;
			
			@Override
			public void run() {
				totalTicksToRun--;
				hg.teleport(getRelativeNotificationLocation(p, (int)(durationInSeconds*20)-totalTicksToRun));
				
				if(totalTicksToRun <= 0) {
					hg.delete();
					cancel();
				}
			}
			
		}.runTaskTimer(ProgressionPlus.getInstance(), 1L, 1L);
	}
	
	private static Location getRelativeNotificationLocation(Player p, int ticksAfterStart) {
		Location pLookLocation = p.getTargetBlock(null, 200).getLocation();
		Vector eyeVector = pLookLocation.toVector().subtract(p.getLocation().toVector());
		eyeVector = eyeVector.normalize();
		eyeVector.multiply(3);
		eyeVector.add(new Vector(0,1+0.04*ticksAfterStart,0));
		Location loc = p.getLocation();
		loc.add(eyeVector);

		return loc;
		
	}

}
