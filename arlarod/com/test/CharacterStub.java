package arlarod.com.test;

import arlarod.com.model.ArlarodCharacter;
import arlarod.com.model.Weapon;
import arlarod.com.model.constants.ArmourType;
import arlarod.com.model.constants.WeaponType;

public class CharacterStub {

	// light characters
	public static ArlarodCharacter floriacDumond = new ArlarodCharacter(
			"Floriac Dumond",
			1, 2, 1,
			new Weapon("Maza", 1, WeaponType.MEDIUM), 2, ArmourType.MEDIUM, true);
	public static ArlarodCharacter darylManosSucias = new ArlarodCharacter(
			"Daryl Manos Sucias",
			1, 2, 1,
			new Weapon("Espada corta", 1, WeaponType.MEDIUM), 2, ArmourType.LIGHT, false);
	public static ArlarodCharacter stor = new ArlarodCharacter(
			"Stor Storson",
			2, 1, 1,
			new Weapon("Espada Ancha", 1, WeaponType.BIG), 3, ArmourType.MEDIUM, false);
	
	// evil characters
	public static ArlarodCharacter orcoGuerrero = new ArlarodCharacter(
			"Orco Guerrero",
			1, 1, 1,
			new Weapon("Espada Ancha", 1, WeaponType.BIG), 2, ArmourType.LIGHT, true);
	public static ArlarodCharacter orcoJefe = new ArlarodCharacter(
			"Orco Jefe",
			2, 1, 1,
			new Weapon("Espada Ancha", 1, WeaponType.BIG), 3, ArmourType.MEDIUM, true);
	public static ArlarodCharacter picaro  = new ArlarodCharacter(
			"Pícaro",
			1, 1, 1,
			new Weapon("Espada corta", 1, WeaponType.LITTLE), 1, null, false);
	public static ArlarodCharacter ladronVeterano = new ArlarodCharacter(
			"Ladrón Veterano",
			1, 2, 1,
			new Weapon("Espada Ancha", 1, WeaponType.MEDIUM), 2, ArmourType.LIGHT, false);
	public static ArlarodCharacter guardia = new ArlarodCharacter(
			"Guardia",
			1, 1, 1,
			new Weapon("Espada Bastarda", 1, WeaponType.BIG), 2, ArmourType.LIGHT, true);
	public static ArlarodCharacter guardiaJefe = new ArlarodCharacter(
			"Jefe Guardia",
			2, 1, 1,
			new Weapon("Espada Bastarda", 1, WeaponType.BIG), 3, ArmourType.MEDIUM, true);

}
