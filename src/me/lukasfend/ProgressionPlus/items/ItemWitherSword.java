package me.lukasfend.ProgressionPlus.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.lukasfend.ProgressionPlus.helpers.NBTTag;
import me.lukasfend.ProgressionPlus.helpers.Rarity;

public class ItemWitherSword extends Item implements Listener {

	@Override
	public String getItemName() {
		return "Wither's lost Sword";
	}

	@Override
	public List<String> getItemDescription() {
		// TODO Auto-generated method stub
		return Arrays.asList(
			"§7Withers used this sword before discovering Bows.\n\n",
			"",
			Item.PassivePrefix + "Applies the wither debuff to all targets hit."
		);
	}

	@Override
	public Rarity getItemRarity() {
		// TODO Auto-generated method stub
		return Rarity.EPIC;
	}

	@Override
	public boolean isSoulbound() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getItem(Player p) {
		// TODO Auto-generated method stub
		return this.getItem(p, 1);
	}
	
	public ItemStack getItem(Player p, int level) {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
		if(getItemCfgBool("hasFireAspect", false)) {			
			item.addEnchantment(Enchantment.FIRE_ASPECT, 1);
		}
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(getItemName());
		im.setUnbreakable(getItemCfgBool("isUnbreakable", true));
		im.setLore(Arrays.asList(
			"§7Withers used this sword before discovering Bows.\n\n",
			"",
			Item.PassivePrefix + "Applies the wither debuff to all targets hit.",
			Item.ItemLevelPrefix + ((level*10)+50)
		));
		item.setItemMeta(im);
		return Item.setItemTag(Item.tagItem(item, NBTTag.isItemWitherSword), NBTTag.itemWitherSwordLevel, level);
	}
	
	@EventHandler
	public void onEntityDamageEntity(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if(
					p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD || 
					p.getInventory().getItemInOffHand().getType() == Material.NETHERITE_SWORD) {
				
				boolean isMainhand = Item.isTagged(p.getInventory().getItemInMainHand(), NBTTag.isItemWitherSword);
				boolean isOffhand = Item.isTagged(p.getInventory().getItemInOffHand(), NBTTag.isItemWitherSword);
				if( isMainhand || isOffhand ) {
					ItemStack item = (isMainhand) ? p.getInventory().getItemInMainHand() : p.getInventory().getItemInOffHand();
					int itemLevel = Item.getItemTagInt(item, NBTTag.itemWitherSwordLevel);
					
					if(e.getEntity() instanceof LivingEntity) {
						LivingEntity target = (LivingEntity) e.getEntity();
						double tickDuration = 20 * (getItemCfg("debuffDurationBase", 5) + itemLevel*getItemCfg("debuffDurationPerLevel", 1f));
						int effectStrength = (int)(getItemCfg("debuffStrengthBase", 3) + itemLevel*getItemCfg("debuffStrengthPerLevel", 0.5f));
						target.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, (int) tickDuration, effectStrength));
					}
				}
			}
		}
	}

}
