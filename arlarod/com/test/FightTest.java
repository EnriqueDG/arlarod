package arlarod.com.test;

import arlarod.com.services.FightService;

public class FightTest {

	static int maxIterations = 1000;
	static int totalIterations = maxIterations*3;static int nF = 0, nD = 0, nS = 0, nG = 0, nGJ = 0, nO = 0, nOJ = 0, nP = 0, nLJ = 0;
	
	public static void main(String args []) {
		
		FightService.fight(CharacterStub.stor, CharacterStub.orcoGuerrero);
		
	}
}
