package arlarod.com.util;

import java.util.Random;

public class Dice {

	private static StringBuilder strBSavageDice;
	
	public static int rollSixDice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
	
	public static int rollSavageDice() {
		return rollSavageDice(null);
	}
	
	public static int rollSavageDice(String text) {
		int savageRollingDice = 0;
		strBSavageDice = new StringBuilder();
		savageRollingDice = rollSixDice();
		if (savageRollingDice == 1) {
			strBSavageDice.append("1->crit.FAIL!");
			// critic fail, do not roll any more ...
//			savageRollingDice += rollDiceWhileValue(1);
		} else if (savageRollingDice == 6) {
			strBSavageDice.append("6->crit.SUCCESS!");
			savageRollingDice += rollDiceWhileValue(6);
		} else {
			strBSavageDice.append("" + savageRollingDice);
		}
		System.out.println("Savage complete Rolling Dices" + (text!=null&&text.length()>0?(" for "+text):"") + ": " + strBSavageDice + " --> " + savageRollingDice);
		return savageRollingDice;
	}
	
	private static int rollDiceWhileValue(int value) {
		int init = 0, diceRoll = 0, totalRollingDice = 0;
		while (init == 0 || diceRoll == value) {
			diceRoll = Dice.rollSixDice();
			totalRollingDice += diceRoll;
			init++;
			strBSavageDice.append(", " + diceRoll);
		}
		return totalRollingDice;
	}
	
}