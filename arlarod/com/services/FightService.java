package arlarod.com.services;

import arlarod.com.model.ArlarodCharacter;
import arlarod.com.util.Dice;

public class FightService {
	

	public static ArlarodCharacter fight(ArlarodCharacter char1, ArlarodCharacter char2) {
		System.out.println(char1.toString());
		System.out.println(char2.toString());
		String char1Str = "(PV: " + char1.lifePoints + ", DEF: " + char1.defense() + ", RES: " + char1.endurance() +")";
		String char2Str = "(PV: " + char2.lifePoints + ", DEF: " + char2.defense() + ", RES: " + char2.endurance() +")";
		System.out.println("'" + char1.characterName + "' " + char1Str  +" FIGHTS with '"+char2.characterName+"' " + char2Str);
		System.out.println();
		
		ArlarodCharacter firstAttacker = checkWhoAttacksfirst(char1, char2);
		ArlarodCharacter secondAttacker = firstAttacker.equals(char1)? char2 : char1;
		System.out.println();
		
		int i = 0, j = 0;
		while (char1.lifePoints > 0 && char2.lifePoints > 0) {
			if (i%2==0) {
				attack(firstAttacker, secondAttacker);
				j++;
			} else {
				attack(secondAttacker, firstAttacker);
			}
			i++;
			System.out.println("Resultados ronda " + j + " ... " + char1.characterName + " ("+char1.lifePoints+") - " + char2.characterName + " ("+char2.lifePoints+")");
			System.out.println();
		}
		
		return winner(char1, char2);
	}
	
	private static ArlarodCharacter winner(ArlarodCharacter char1, ArlarodCharacter char2) {
		ArlarodCharacter winner = char1.lifePoints > 0 ? char1 : char2;
		System.out.println("Winner " + (winner.characterName) + "!!!!!");
		return winner;
	}
	
	private static void attack(ArlarodCharacter charA, ArlarodCharacter charB) {
		charB.lifePoints = charB.lifePoints - AttackService.meleeAttack(charA, charB);
	}
	
	private static ArlarodCharacter checkWhoAttacksfirst(ArlarodCharacter charA, ArlarodCharacter charB) {
		int initiativeCharA = Dice.rollSavageDice(charA.characterName+" initiative"), initiativeCharB = Dice.rollSavageDice(charB.characterName+" initiative");
		if (initiativeCharA != 1) {
			initiativeCharA += charA.will;
		}
		if (initiativeCharB != 1) {
			initiativeCharB += charB.will;
		}
		if (initiativeCharA == 1 && initiativeCharB == 1) {
			System.out.println("Initiative rolling dices resulted on critic fail for BOTH characters !!!!! 0_o .... ");
			return checkWhoAttacksfirst(charA, charB);
		} else if (initiativeCharA == initiativeCharB) {
			System.out.println("Initiative rolling dices are the same, characters must reroll again ...");
			return checkWhoAttacksfirst(charA, charB);
		} else {
			System.out.println( (initiativeCharA > initiativeCharB? charA.characterName : charB.characterName) + " attacks first !");
			return initiativeCharA > initiativeCharB? charA : charB;
		}
	}

}
