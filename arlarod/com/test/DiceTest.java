package arlarod.com.test;

import arlarod.com.util.Dice;

public class DiceTest {
	
	public static void main(String args []) {
		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
		int maxIterations = 10000;
	 	int d6roll;
		for (int i = 0; i < maxIterations; i++) {
			d6roll = Dice.rollSixDice();
			switch (d6roll) {
			case 1: one++; break; case 2: two++; break; case 3: three++; break;
			case 4: four++; break; case 5: five++; break; case 6: six++; break;
			}
		}
		System.out.println("Total rolls: " + maxIterations);
		int perc1 = (one*100)/maxIterations, perc2 = (two*100)/maxIterations, perc3 = (three*100)/maxIterations, perc4 = (four*100)/maxIterations, perc5 = (five*100)/maxIterations, perc6 = (six*100)/maxIterations;
		System.out.println("one: " + one + "; two: " + two + ", three: " + three + "; four: " + four + "; five: " + five + "; six: " + six);
		System.out.println("%one: " + perc1 + "; %two: " + perc2 + ", %three: " + perc3 + "; %four: " + perc4 + "; %five: " + perc5 + "; %six: " + perc6);
	}
	
}
