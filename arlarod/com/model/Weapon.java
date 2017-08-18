package arlarod.com.model;

import arlarod.com.model.constants.WeaponType;
import arlarod.com.services.WeaponService;

public class Weapon {

	public String name;
	public WeaponType weaponType;
	public int numberOfDices;
	
	public Weapon(String n, int nD, WeaponType wType) {
		name = n;
		numberOfDices = nD;
		weaponType = wType;
	}
	
	public int getBonus() {
		return WeaponService.getBonus(weaponType);
	}
	
	@Override
	public String toString() {
		return name + " (nºDados: " + numberOfDices + ", bonus: +" + getBonus() + ", tipo: " + weaponType.toString() + ")";
	}
	
}
