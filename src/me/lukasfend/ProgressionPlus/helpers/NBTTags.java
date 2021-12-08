package me.lukasfend.ProgressionPlus.helpers;

public enum NBTTags {
	soulboundEnabled,
	soulboundPlayerUUID;
	
	public String tag() {
		return "pp_"+this.toString();
	}
}
