package me.lukasfend.ProgressionPlus.helpers;

public enum BuffType {
	GLADIATORS_HONOR,
	BACONATOR;
	
	public String getTitle() {
		switch(this) {
			case GLADIATORS_HONOR:
				return "Honor of the Gladiator";
			case BACONATOR:
				return "Baconator";
			default:
				return this.toString();
		}
	}
}
