package me.lukasfend.ProgressionPlus.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.lukasfend.ProgressionPlus.helpers.Cooldown;
import me.lukasfend.ProgressionPlus.helpers.CooldownHandler;
import me.lukasfend.ProgressionPlus.helpers.NBTTag;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class ItemHotRod extends Item implements Listener {

	@Override
	public String getItemName() {
		return "Hot Rod";
	}

	@Override
	public List<String> getItemDescription() {
		// TODO Auto-generated method stub
		return Arrays.asList(""
				+ "\n§7Is that an arm of a blaze?"
				+ "\n"
				+ ActivePrefix + "Right click to fire a fireball."
				+ "\n"
				+ "");
	}

	@Override
	public Rarity getItemRarity() {
		// TODO Auto-generated method stub
		return Rarity.RARE;
	}

	@Override
	public boolean isSoulbound() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public ItemStack getItem(Player p, int level) {
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		item.addUnsafeEnchantment(Enchantment.MENDING, 1);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(getItemName());
		im.setLore(
		Arrays.asList(""
			+ "\n§7Is that an arm of a blaze?"
			+ "\n"
			+ ActivePrefix + "Right click to fire a fireball."
			+ "\n"
			+ Item.ItemLevelPrefix + ((level*10)+50)
		));
		item.setItemMeta(im);
		return Item.setItemTag(Item.tagItem(item, NBTTag.isItemHotRod), NBTTag.itemHotRodLevel, level);
	}

	@Override
	public ItemStack getItem(Player p) {
		return this.getItem(p, 1);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if( e.getAction() == Action.RIGHT_CLICK_AIR ||
			e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(	Item.isTagged(e.getItem(), NBTTag.isItemHotRod) &&
				Item.isSoulboundTo(e.getItem(), p)) {
				
				if(CooldownHandler.getInstance().isOnCooldown(p, Cooldown.ITEM_HOT_ROD)) {
					p.sendMessage(
							getItemRarity().getColor() 
							+getItemName()
							+ "§r is on cooldown. (§c" 
							+ CooldownHandler.getInstance().getRemainingCooldown(p, Cooldown.ITEM_HOT_ROD)
							+ "§r)");
					return;
				}
				
				int itemLevel = Item.getItemTagInt(e.getItem(), NBTTag.itemHotRodLevel);
				double cooldown = getItemCfg("cooldownBase", 10f) - (getItemCfg("cooldownReductionPerLevel", 1f)*itemLevel);
				CooldownHandler.getInstance().activateCooldown(p, Cooldown.ITEM_HOT_ROD, (long) cooldown*1000);
				
				SmallFireball proj = p.launchProjectile(SmallFireball.class);
				proj.setShooter(p);
				proj.setVelocity(p.getLocation().getDirection().multiply(getItemCfg("fireballSpeed", 1.0f)));
				
			}
		}
	}

}
