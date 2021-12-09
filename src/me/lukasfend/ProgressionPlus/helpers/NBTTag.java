package me.lukasfend.ProgressionPlus.helpers;

public enum NBTTag {
	soulboundEnabled,
	soulboundPlayerUUID,
	isItemIronGolemShield,
	isItemWitherSword,
	itemWitherSwordLevel,
	isItemHotRod,
	itemHotRodLevel
	;
	
	public String tag() {
		return "pp_"+this.toString();
	}
}
