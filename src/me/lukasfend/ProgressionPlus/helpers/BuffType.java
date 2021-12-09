package me.lukasfend.ProgressionPlus.helpers;

public enum BuffType {
	GLADIATORS_HONOR;
	
	public String getTitle() {
		switch(this) {
			case GLADIATORS_HONOR:
				return "Honor of the Gladiator";
			default:
				return this.toString();
		}
	}
}
