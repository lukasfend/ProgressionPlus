package me.lukasfend.ProgressionPlus.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobAxolotl;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobBat;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobBee;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobBlaze;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobCaveSpider;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobChicken;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobCow;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobCreeper;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobEnderman;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobIronGolem;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobPig;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobPillager;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobSheep;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobSkeleton;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobSpider;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobWither;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobZombie;
import me.lukasfend.ProgressionPlus.achievements.AchievementMobZombiePiglin;

public class StaticData {

	/**
	 * The list of entites that are tracked
	 */
	public static ArrayList<String> TRACKED_ENTITIES = new ArrayList<String>(Arrays.asList("ARROW", "AXOLOTL", "BAT",
			"BEE", "BLAZE", "BOAT", "CAT", "CAVE_SPIDER", "CHICKEN", "COD", "COW", "CREEPER", "DOLPHIN", "DONKEY",
			"DROWNED", "EGG", "ELDER_GUARDIAN", "ENDER_DRAGON", "ENDER_PEARL", "ENDERMAN", "ENDERMITE", "EVOKER",
			"FIREWORK_ROCKET", "FOX", "GHAST", "GIANT", "GLOW_SQUID", "GOAT", "GUARDIAN", "HOGLIN", "HORSE", "HUSK",
			"ILLUSIONER", "IRON_GOLEM", "LLAMA", "MAGMA_CUBE", "MOOSHROOM", "MULE", "OCELOT", "PANDA", "PARROT",
			"PHANTOM", "PIG", "PIGLIN", "PIGLIN_BRUTE", "PILLAGER", "POLAR_BEAR", "PUFFERFISH", "RABBIT", "RAVAGER",
			"SALMON", "SHEEP", "SHULKER", "SILVERFISH", "SKELETON", "SKELETON_HORSE", "SLIME", "SNOW_GOLEM", "SNOWBALL",
			"SPIDER", "SQUID", "STRAY", "STRIDER", "TNT", "TRIDENT", "TROPICAL_FISH", "TURTLE", "VEX", "VILLAGER",
			"VINDICATOR", "WANDERING_TRADER", "WITCH", "WITHER", "WITHER_SKELETON", "WOLF", "ZOGLIN", "ZOMBIE",
			"ZOMBIE_VILLAGER", "ZOMBIFIED_PIGLIN"));
	
	public static ArrayList<String> ALIVE_ENTITIES = new ArrayList<String>(Arrays.asList("AXOLOTL", "BAT",
			"BEE", "BLAZE", "CAT", "CAVE_SPIDER", "CHICKEN", "COD", "COW", "CREEPER", "DOLPHIN", "DONKEY",
			"DROWNED", "EGG", "ELDER_GUARDIAN", "ENDER_DRAGON", "ENDERMAN", "ENDERMITE", "EVOKER",
			"FOX", "GHAST", "GIANT", "GLOW_SQUID", "GOAT", "GUARDIAN", "HOGLIN", "HORSE", "HUSK",
			"ILLUSIONER", "IRON_GOLEM", "LLAMA", "MAGMA_CUBE", "MOOSHROOM", "MULE", "OCELOT", "PANDA", "PARROT",
			"PHANTOM", "PIG", "PIGLIN", "PIGLIN_BRUTE", "PILLAGER", "POLAR_BEAR", "PUFFERFISH", "RABBIT", "RAVAGER",
			"SALMON", "SHEEP", "SHULKER", "SILVERFISH", "SKELETON", "SKELETON_HORSE", "SLIME", "SNOW_GOLEM", "SNOWBALL",
			"SPIDER", "SQUID", "STRAY", "STRIDER", "TNT", "TRIDENT", "TROPICAL_FISH", "TURTLE", "VEX", "VILLAGER",
			"VINDICATOR", "WANDERING_TRADER", "WITCH", "WITHER", "WITHER_SKELETON", "WOLF", "ZOGLIN", "ZOMBIE",
			"ZOMBIE_VILLAGER", "ZOMBIFIED_PIGLIN"));
	
	public static void loadAchievements(ProgressionPlus instance) {

		instance.achievements.put("AXOLOTL", new AchievementMobAxolotl());
		instance.achievements.put("BAT", new AchievementMobBat());
		instance.achievements.put("BEE", new AchievementMobBee());
		instance.achievements.put("BLAZE", new AchievementMobBlaze());
		instance.achievements.put("CAVE_SPIDER", new AchievementMobCaveSpider());
		instance.achievements.put("CHICKEN", new AchievementMobChicken());
		instance.achievements.put("COW", new AchievementMobCow());
		instance.achievements.put("CREEPER", new AchievementMobCreeper());
		instance.achievements.put("ENDERMAN", new AchievementMobEnderman());
		instance.achievements.put("IRON_GOLEM", new AchievementMobIronGolem());
		instance.achievements.put("PIG", new AchievementMobPig());
		instance.achievements.put("PILLAGER", new AchievementMobPillager());
		instance.achievements.put("SHEEP", new AchievementMobSheep());
		instance.achievements.put("SKELETON", new AchievementMobSkeleton());
		instance.achievements.put("PIG", new AchievementMobPig());
		instance.achievements.put("SPIDER", new AchievementMobSpider());
		instance.achievements.put("WITHER", new AchievementMobWither());
		instance.achievements.put("ZOMBIFIED_PIGLIN", new AchievementMobZombiePiglin());
		instance.achievements.put("ZOMBIE", new AchievementMobZombie());
	}
	
	public static ArrayList<Integer> ACHIEVEMENT_STEPS_NORMAL = new ArrayList<Integer>(Arrays.asList(
			25, 50, 75, 100,
			150, 250, 500, 750,
			1000, 1250, 1500, 1750, 2000,
			2500, 3000, 4000, 5000,
			7500, 10000, 12500, 15000
		)
	);
	
	public static ArrayList<Integer> ACHIEVEMENT_STEPS_EPIC = new ArrayList<Integer>(Arrays.asList(
			10,20,30,40,50,75,100,
			250,500,750,1000,1500,2500,5000,10000
		)
	);
	
	public static ArrayList<Integer> ACHIEVEMENT_STEPS_LEGENDARY = new ArrayList<Integer>(Arrays.asList(
			1,2,3,4,5,10,20,30,40,50,75,100,
			250,500,750,1000,1500,2500,5000,10000
		)
	);
}
