package arlarod.com.services;

import arlarod.com.combat.AttackResult;
import arlarod.com.model.ArlarodCharacter;
import arlarod.com.util.Dice;

public class AttackService {
	
	private static String DEFENSE = "DEFENSE";
	private static String ENDURANCE = "ENDURANCE";
	
	private static StringBuilder strBDefenseSavageDice;
	private static StringBuilder rollAgainstDefenseText;
	private static StringBuilder rollAgainstEnduranceText;
	private static boolean hit = false;
	private static boolean damaged = false;
	private static boolean savageDiceOnDefenseRollFail = false;
	private static boolean savageDiceOnEnduranceRollFail = false;
	private static int hitRollingDices = 0;
	private static int damageRollingDices = 0;
	private static int damageLifePoints = 0;
	
	private static void resetService() {
		strBDefenseSavageDice = new StringBuilder();
		hit = false;
		damaged = false;
		savageDiceOnDefenseRollFail = false;
		savageDiceOnEnduranceRollFail = false;
		damageRollingDices = 0;
		hitRollingDices = 0;
		damageLifePoints = 0;
		rollAgainstDefenseText = new StringBuilder();
		rollAgainstEnduranceText = new StringBuilder();
	}

	public static int meleeAttack(ArlarodCharacter char1, ArlarodCharacter char2) {
		String char1Str = "(PV: " + char1.lifePoints + ", DEF: " + char1.defense() + ", RES: " + char1.endurance() +")";
		String char2Str = "(PV: " + char2.lifePoints + ", DEF: " + char2.defense() + ", RES: " + char2.endurance() +")";
		System.out.println(char1.characterName + " " + char1Str +" ATTACKS " + char2.characterName + " " + char2Str +" with " + char1.weapon.toString()
		+ " VS. " + char2.defense());

		resetService();
		int attackDamageResult = 0;
		
		// check if char1 hits char2
		rollAgainstDefense(char1, char2);
		if (savageDiceOnDefenseRollFail) {
			System.out.println("Critical Fail for '"+char1.characterName+"' on Savage Dice against defense ... ask Master for consecuences ... 0_o ... " + rollAgainstDefenseText);
		} else {
			if (hit) {
				System.out.println(char1.characterName + " attacking hits " + char2.characterName + " ("+hitRollingDices+"vs"+char2.defense()+") !!! " + rollAgainstDefenseText);
				
				// check if char1 damages char2
				rollAgainstEndurance(char1, char2);
				
				if (savageDiceOnEnduranceRollFail) {
					System.out.println("Critical Fail for '"+char1.characterName+"' on Savage Dice against endurance ... ask Master for consecuences ... 0_o ... " + rollAgainstEnduranceText);
				} else {
					if (damaged) {
						System.out.println(char1.characterName + " attacking damages " + char2.characterName + " ("+damageRollingDices+"vs"+char2.endurance()+") causing "+damageLifePoints+" points damage !!! " + rollAgainstEnduranceText);
						attackDamageResult = damageLifePoints;
					} else {
						System.out.println(char1.characterName + " attacking did not damage " + char2.characterName + " ("+damageRollingDices+"vs"+char2.endurance()+") ... " + rollAgainstEnduranceText);
					}
				}
				
			} else {
				System.out.println(char1.characterName + " attacking did not hit " + char2.characterName + " ("+hitRollingDices+"vs"+char2.defense()+") ... " + rollAgainstDefenseText);
			}
		}
		
		// fill Attack Result data
		AttackResult attackResult = new AttackResult(hit, damaged,
				savageDiceOnDefenseRollFail, savageDiceOnEnduranceRollFail,
				rollAgainstDefenseText.toString(),
				(!savageDiceOnDefenseRollFail&&rollAgainstEnduranceText!=null?rollAgainstEnduranceText.toString():""),
				hitRollingDices, damageRollingDices);
		System.out.println(attackResult.toString());
		
		return attackDamageResult;
	}
	
	private static void rollAgainstDefense(ArlarodCharacter char1, ArlarodCharacter char2) {
		hitRollingDices = rollAttack(char1.meleeAtackNumberOfDices, 0, DEFENSE);
		hit = hitRollingDices >= char2.defense();
	}
	
	private static void rollAgainstEndurance(ArlarodCharacter char1, ArlarodCharacter char2) {
		damageRollingDices = rollAttack(char1.weapon.numberOfDices, char1.weapon.getBonus(), ENDURANCE);
		damageLifePoints = damageRollingDices  - char2.endurance();
		damaged = damageLifePoints > 0;
	}
	
	private static int rollAttack(int initialNDices, int bonus, String attackPhase) {
		int nDices = initialNDices - 1;
		int savageDiceRoll = 0, normalDicesResult = 0;
		int diceRoll = 0;
		int attackTotalResult = 0;
		
		StringBuilder sBnormalDices = new StringBuilder();
		for (int i = nDices; i > 0; i--) {
			diceRoll = Dice.rollSixDice();
			normalDicesResult += diceRoll;
			sBnormalDices.append(diceRoll+(i>1?",":""));
		}
		
		// savage roll
		savageDiceRoll = calculateSavageRollingDice(attackPhase);
		// calculate and add savage roll
		attackTotalResult += savageDiceRoll;
		// add weapon bonus
		attackTotalResult = normalDicesResult + bonus + savageDiceRoll;
		
		StringBuilder strB = new StringBuilder();
		strB.append("(Rolling dices for "+attackPhase+": [normal rolling dices"+"("+sBnormalDices+")"+": "+normalDicesResult+" + savage rolling dice: "+savageDiceRoll+" ("+strBDefenseSavageDice+") + bonus: "+bonus+"]: " +  attackTotalResult + ")");
		if (DEFENSE.equalsIgnoreCase(attackPhase)) {
			rollAgainstDefenseText = new StringBuilder();
			rollAgainstDefenseText.append(strB);
		} else if (ENDURANCE.equalsIgnoreCase(attackPhase)) {
			rollAgainstEnduranceText = new StringBuilder();
			rollAgainstEnduranceText.append(strB);
		}
		
		return attackTotalResult;
	}
	
	private static int calculateSavageRollingDice(String attackPhase) {
		int savageRollingDice = 0;
		savageRollingDice = Dice.rollSixDice();
		strBDefenseSavageDice = new StringBuilder();
		if (savageRollingDice == 1) {
			strBDefenseSavageDice.append("1->crit.fail!");
			if (DEFENSE.equalsIgnoreCase(attackPhase)) {
				savageDiceOnDefenseRollFail = true;
			} else if (ENDURANCE.equalsIgnoreCase(attackPhase)) {
				savageDiceOnEnduranceRollFail = true;
			}
			
			savageRollingDice = 1;
			// critic fail, do not roll any more ...
//			savageRollingDice += rollDiceWhileValue(1);
		} else if (savageRollingDice == 6) {
			strBDefenseSavageDice.append("6->crit.success!");
			savageRollingDice = 6;
			savageRollingDice += rollDiceWhileValue(6);
		} else {
			strBDefenseSavageDice.append("" + savageRollingDice);
		}
//		System.out.println("Savage complete Rolling Dices: " + strBTemp);
		return savageRollingDice;
	}
	
	private static int rollDiceWhileValue(int value) {
		int init = 0, diceRoll = 0, totalRollingDice = 0;
		while (init == 0 || diceRoll == value) {
			diceRoll = Dice.rollSixDice();
			totalRollingDice += diceRoll;
			init++;
//			System.out.println("savage dice other result: " + diceRoll + ", total: " + totalRollingDice);
			strBDefenseSavageDice.append("," + diceRoll);
		}
		return totalRollingDice;
	}
	
}
