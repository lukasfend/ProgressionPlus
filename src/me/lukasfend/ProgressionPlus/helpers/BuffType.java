package me.lukasfend.ProgressionPlus.helpers;

public enum BuffType {
	GLADIATORS_HONOR,
	RAIN_OF_BOLTS,
	BACONATOR;
	
	public String getTitle() {
		switch(this) {
			case GLADIATORS_HONOR:
				return "Honor of the Gladiator";
			case BACONATOR:
				return "Baconator";
			case RAIN_OF_BOLTS:
				return "Rain of Bolts";
			default:
				return this.toString();
		}
	}
}
