package arlarod.com.services;

import arlarod.com.model.constants.ArmourType;

public class ArmourService {

	public static int getArmourDefenseBonus(ArmourType armourType) {
		if (armourType == null) { return 0; }
		switch (armourType) {
		case HEAVY: 	return 1;
		case MEDIUM: 	return 2;
		case LIGHT: 	return 3;
		default: 		return 3;
		}
	}
	
	public static int getArmourEnduranceBonus(ArmourType armourType) {
		if (armourType == null) { return 0; }
		switch (armourType) {
		case HEAVY: 	return 3;
		case MEDIUM: 	return 2;
		case LIGHT: 	return 1;
		default: 		return 0;
		}
	}
}
