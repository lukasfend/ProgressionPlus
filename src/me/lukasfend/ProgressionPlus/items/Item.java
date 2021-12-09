package me.lukasfend.ProgressionPlus.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import me.lukasfend.ProgressionPlus.ProgressionPlus;
import me.lukasfend.ProgressionPlus.helpers.NBTTag;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public abstract class Item {
		
	ProgressionPlus plugin = ProgressionPlus.getInstance();
	public abstract String getItemName();
	public abstract List<String> getItemDescription();
	public abstract Rarity getItemRarity();
	public abstract boolean isSoulbound();
	public abstract ItemStack getItem(Player p);
	
	/**
	 * Returns the same item that was passed, but soulbound
	 * @param is The itemstack to be soulbound
	 * @param p The player to be soulbound to
	 * @return The new item
	 */
	public static ItemStack getSoulboundItem(ItemStack is, Player p) {
		NBTItem nbti = new NBTItem(is);
		
		nbti.setUUID(NBTTag.soulboundPlayerUUID.tag(), p.getUniqueId());
		nbti.setBoolean(NBTTag.soulboundEnabled.tag(), true);
		ItemStack newItem = nbti.getItem();
		ItemMeta im = newItem.getItemMeta();
		
		List<String> lore = im.getLore();
		if(lore == null) {
			lore = Arrays.asList("");
		}
		lore.add("§7Soulbound to: §a" + p.getName());
		im.setLore(lore);
		im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		newItem.setItemMeta(im);
		 
		return newItem;
	}
	
	public double getItemCfg(String propertyName, double defaultValue) {
		ProgressionPlus plugin = ProgressionPlus.getInstance();
		String key = getItemName()
				.replace(" ", "_")
				.replace(",", ",")
				.replace("'", "").toLowerCase();
		if(!plugin.getConfig().contains("items." + key + "." + propertyName)) {
			plugin.getConfig().set("items." + key + "."+propertyName, (double)defaultValue);
			plugin.saveConfig();
			return defaultValue;
		} else {
			return plugin.getConfig().getDouble("items." + key + "."+propertyName);
		}
	}
	public boolean getItemCfgBool(String propertyName, boolean defaultValue) {
		ProgressionPlus plugin = ProgressionPlus.getInstance();
		String key = getItemName()
				.replace(" ", "_")
				.replace(",", ",")
				.replace("'", "").toLowerCase();
		if(!plugin.getConfig().contains("items." + key + "." + propertyName)) {
			plugin.getConfig().set("items." + key + "."+propertyName, (boolean)defaultValue);
			plugin.saveConfig();
			return defaultValue;
		} else {
			return plugin.getConfig().getBoolean("items." + key + "."+propertyName);
		}
	}
	
	/**
	 * Returns the same item that was passed, but with soulbinding removed
	 * @param is The itemstack to be unbound
	 * @return The bind-free item
	 */
	public static ItemStack removeSoulbinding(ItemStack is) {
		NBTItem nbti = new NBTItem(is);
		if(nbti.hasKey(NBTTag.soulboundPlayerUUID.tag())) {
			nbti.removeKey(NBTTag.soulboundPlayerUUID.tag());
			nbti.removeKey(NBTTag.soulboundEnabled.tag());
		}
		return nbti.getItem();	
	}
	
	public static boolean isSoulbound(ItemStack is) {
		NBTItem nbti = new NBTItem(is);
		if(nbti.hasKey(NBTTag.soulboundEnabled.tag())) {
			return nbti.getBoolean(NBTTag.soulboundEnabled.tag());
		}
		return false;
	}
	public static boolean isSoulboundTo(ItemStack is, Player p) {
		NBTItem nbti = new NBTItem(is);
		if(Item.isSoulbound(is)) {
			return (nbti.getUUID(NBTTag.soulboundPlayerUUID.tag()).equals(p.getUniqueId()));
		}
		return false;
	}
	
	
	
	
	public static ItemStack tagItem(ItemStack is, NBTTag tagName) {
		NBTItem nbti = new NBTItem(is);
		nbti.setBoolean(tagName.tag(), true);
		return nbti.getItem();
	}
	public static ItemStack untagItem(ItemStack is, NBTTag tagName) {
		NBTItem nbti = new NBTItem(is);
		nbti.setBoolean(tagName.tag(), false);
		return nbti.getItem();
	}
	public static boolean isTagged(ItemStack is, NBTTag tagName) {
		if(is == null || is.getType() == Material.AIR)
			return false;
		
		NBTItem nbti = new NBTItem(is);
		if(nbti.hasKey(tagName.tag())) {
			return nbti.getBoolean(tagName.tag());
		}
		return false;
	}
	public static boolean hasTag(ItemStack is, NBTTag tagName) {
		NBTItem nbti = new NBTItem(is);
		return nbti.hasKey(tagName.tag());
	}
	public static ItemStack setItemTag(ItemStack is, NBTTag tagName, String value) {
		NBTItem nbti = new NBTItem(is);
		nbti.setString(tagName.tag(), value);
		return nbti.getItem();
	}
	public static ItemStack setItemTag(ItemStack is, NBTTag tagName, int value) {
		NBTItem nbti = new NBTItem(is);
		nbti.setInteger(tagName.tag(), value);
		return nbti.getItem();
	}
	public static String getItemTagString(ItemStack is, NBTTag tagName) {
		NBTItem nbti = new NBTItem(is);
		return nbti.getString(tagName.tag());
	}
	public static int getItemTagInt(ItemStack is, NBTTag tagName) {
		NBTItem nbti = new NBTItem(is);
		return nbti.getInteger(tagName.tag());
	}
	
	
	
	
	/*
	 * 
	 * Item Description Colors:
	 * 	Reserved for Rarity: White, Green, Blue, Purple, Yellow, Darkred
	 * 
	 * Passive Effects: §5§n
	 * Active Effects: §a
	 * Descriptive Text: §7
	 * 
	 */
	public static String PassivePrefix = "§5§nPassive:§r ";
	public static String ActivePrefix = "§a§nActive:§r ";
	public static String ItemLevelPrefix = "§3Item Level: §r";

}
