package arlarod.com.services;

import arlarod.com.model.ArlarodCharacter;

public class CharacterService {
	
	public static int BASE_MULTIPLIER = 6;
	public static int HALF_MULTIPLIER = BASE_MULTIPLIER/2;
	
	public static int getMaxWill(ArlarodCharacter arlarodChar) { return arlarodChar.will * BASE_MULTIPLIER; }
	public static int getMaxFortress(ArlarodCharacter arlarodChar) { return arlarodChar.fortress * BASE_MULTIPLIER; }
	public static int getMaxMind(ArlarodCharacter arlarodChar) { return arlarodChar.mind * BASE_MULTIPLIER; }
	
	public static int calculateDefenseValue(ArlarodCharacter arlarodChar) {
		return getMaxWill(arlarodChar) + ArmourService.getArmourDefenseBonus(arlarodChar.armourType) + (arlarodChar.shield?1:0);
	}
	
	public static int calculateEnduranceValue(ArlarodCharacter arlarodChar) {
		return (HALF_MULTIPLIER + ((HALF_MULTIPLIER)*arlarodChar.fortress)) + ArmourService.getArmourEnduranceBonus(arlarodChar.armourType);
	}
	
	public static void resetLifePoints(ArlarodCharacter arlarodChar) {
		arlarodChar.lifePoints = getMaxFortress(arlarodChar);
	}
	
}
