package me.lukasfend.ProgressionPlus.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import me.lukasfend.ProgressionPlus.helpers.NBTTags;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public abstract class Item {
	
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
		
		nbti.setUUID(NBTTags.soulboundPlayerUUID.tag(), p.getUniqueId());
		nbti.setBoolean(NBTTags.soulboundEnabled.tag(), true);
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
	
	/**
	 * Returns the same item that was passed, but with soulbinding removed
	 * @param is The itemstack to be unbound
	 * @return The bind-free item
	 */
	public static ItemStack removeSoulbinding(ItemStack is) {
		NBTItem nbti = new NBTItem(is);
		if(nbti.hasKey(NBTTags.soulboundPlayerUUID.tag())) {
			nbti.removeKey(NBTTags.soulboundPlayerUUID.tag());
			nbti.removeKey(NBTTags.soulboundEnabled.tag());
		}
		return nbti.getItem();	
	}
	
	public static boolean isSoulbound(ItemStack is) {
		NBTItem nbti = new NBTItem(is);
		if(nbti.hasKey(NBTTags.soulboundEnabled.tag())) {
			return nbti.getBoolean(NBTTags.soulboundEnabled.tag());
		}
		return false;
	}
	public static boolean isSoulboundTo(ItemStack is, Player p) {
		NBTItem nbti = new NBTItem(is);
		if(Item.isSoulbound(is)) {
			return (nbti.getUUID(NBTTags.soulboundPlayerUUID.tag()).equals(p.getUniqueId()));
		}
		return false;
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

}
