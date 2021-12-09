package me.lukasfend.ProgressionPlus.helpers;

public enum NBTTag {
	soulboundEnabled,
	soulboundPlayerUUID,
	isItemIronGolemShield,
	isItemWitherSword,
	itemWitherSwordLevel,
	
	;
	
	public String tag() {
		return "pp_"+this.toString();
	}
}
