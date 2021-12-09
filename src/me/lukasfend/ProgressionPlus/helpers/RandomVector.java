package me.lukasfend.ProgressionPlus.helpers;

import java.util.Random;

import org.bukkit.util.Vector;

public class RandomVector {

	public static Vector randomVector(double multiplier) {
		return new Vector(Math.random()*multiplier,Math.random()*multiplier,Math.random()*multiplier);
	}
}
