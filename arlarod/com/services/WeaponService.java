package arlarod.com.services;

import arlarod.com.model.constants.WeaponType;

public class WeaponService {

	public static int getBonus(WeaponType weaponType) {
		switch (weaponType) {
		case BIG: 		return 4;//3;
		case MEDIUM: 	return 3;//2;
		case LITTLE: 	return 2;//1;
		case NATURAL: 	return 1;//0;
		default: 		return 0;
		}
	}
	
}
