package arlarod.com.model;

import arlarod.com.model.constants.ArmourType;
import arlarod.com.services.CharacterService;

public class ArlarodCharacter {

	public String characterName, playerName;
	public int mind, fortress, will;
	
	public Weapon weapon;
	public ArmourType armourType;
	public boolean shield = false;
	public int lifePoints;
	
	public int meleeAtackNumberOfDices = 0;
	
	public ArlarodCharacter(String charName,
			int charFortress, int charWill, int charMind,
			Weapon charWeapon, int meleeAttack, ArmourType charArmourType,
			boolean charShield) {
		characterName = charName;
		mind = charMind;
		fortress = charFortress;
		will = charWill;
		weapon = charWeapon;
		meleeAtackNumberOfDices = meleeAttack;
		armourType = charArmourType;
		shield = charShield;
		lifePoints = calculateLifePoints();
	}
	
	private int calculateLifePoints() {
		return CharacterService.getMaxFortress(this);
	}
	
	public int getCounterAtack() {
		return 0;
	}
	
	public int defense() {
		return CharacterService.calculateDefenseValue(this);
	}
	
	public int endurance() {
		return CharacterService.calculateEnduranceValue(this);
	}
	
	@Override
	public String toString() {
		String str = "'" + characterName + "': [C" + fortress + "], [V" + will + "], [M" + mind
		+ "], [Def " + defense() + ", Res " + endurance()
		+ "]; PV: " + lifePoints + "; arma: " + weapon.toString() + "; Hab Armas: " + meleeAtackNumberOfDices;
		return str;
	}
	
}
