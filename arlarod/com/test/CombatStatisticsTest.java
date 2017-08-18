package arlarod.com.test;

import arlarod.com.model.ArlarodCharacter;
import arlarod.com.services.CharacterService;
import arlarod.com.services.FightService;
import arlarod.com.test.CharacterStub;

public class CombatStatisticsTest {

	static int maxIterations = 1000;
	static int totalIterations = maxIterations*3;static int nF = 0, nD = 0, nS = 0, nG = 0, nGJ = 0, nO = 0, nOJ = 0, nP = 0, nLJ = 0;
	
	public static void main(String args []) {
		
		System.out.println(CharacterStub.floriacDumond.toString());
		System.out.println(CharacterStub.darylManosSucias.toString());
		System.out.println(CharacterStub.stor.toString());
		
		System.out.println();
		
		for (int i = 0; i < maxIterations; i++) {
			ArlarodCharacter contestWinner = FightService.fight(CharacterStub.orcoJefe, CharacterStub.stor);
			updateStatistics(contestWinner);
			resetLifePoints();
		}
		maxIterations = 1000;
		for (int i = 0; i < maxIterations; i++) {
			ArlarodCharacter contestWinner = FightService.fight(CharacterStub.orcoJefe, CharacterStub.stor);
			updateStatistics(contestWinner);
			resetLifePoints();
		}
		maxIterations = 1000;
		for (int i = 0; i < maxIterations; i++) {
			ArlarodCharacter contestWinner = FightService.fight(CharacterStub.orcoJefe, CharacterStub.stor);
			updateStatistics(contestWinner);
			resetLifePoints();
		}
		
		// set statistics
		int percF = (nF*100)/(totalIterations), percD = (nD*100)/(totalIterations), percS = (nS*100)/(totalIterations), percG = (nG*100)/totalIterations, percGJ = (nGJ*100)/totalIterations, percO = (nO*100)/totalIterations, percOJ = (nOJ*100)/totalIterations, percP = (nP*100)/totalIterations, percLJ = (nLJ*100)/totalIterations;
		System.out.println("Floriac: " + nF + "; Daryl: " + nD + ", Stor: " + nS + ", Guardia: " + nG + ", GuardiaJefe: " + nGJ + ", Orco Guerrero: " + nO + ", OrcoJefe: " + nOJ + ", Pícaro: " + nP + ", LadrónJefe: " + nLJ);
		System.out.println("%Floriac: " + percF + "; %Daryl: " + percD + ", %Stor: " + percS + "; %Guardia: " + percG + "; %GuardiaJefe: " + percGJ + "; %OrcoGuerrero: " + percO + "; %OrcoJefe: " + percOJ + "; %Picaro: " + percP + "; %LadrónJefe: " + percLJ);
		
	}
	
	private static void updateStatistics(ArlarodCharacter contestWinner) {
		if (contestWinner.equals(CharacterStub.stor)) { nS++; }
		if (contestWinner.equals(CharacterStub.floriacDumond)) { nF++; }
		if (contestWinner.equals(CharacterStub.darylManosSucias)) { nD++; }
		if (contestWinner.equals(CharacterStub.orcoGuerrero)) { nO++; }
		if (contestWinner.equals(CharacterStub.orcoJefe)) { nOJ++; }
		if (contestWinner.equals(CharacterStub.picaro)) { nP++; }
		if (contestWinner.equals(CharacterStub.ladronVeterano)) { nLJ++; }
		if (contestWinner.equals(CharacterStub.guardia)) { nG++; }
		if (contestWinner.equals(CharacterStub.guardiaJefe)) { nGJ++; }
	}
	
	private static void resetLifePoints() {
		CharacterService.resetLifePoints(CharacterStub.floriacDumond);
		CharacterService.resetLifePoints(CharacterStub.darylManosSucias);
		CharacterService.resetLifePoints(CharacterStub.stor);
		CharacterService.resetLifePoints(CharacterStub.guardiaJefe);
		CharacterService.resetLifePoints(CharacterStub.guardia);
		CharacterService.resetLifePoints(CharacterStub.orcoGuerrero);
		CharacterService.resetLifePoints(CharacterStub.orcoJefe);
		CharacterService.resetLifePoints(CharacterStub.picaro);
		CharacterService.resetLifePoints(CharacterStub.ladronVeterano);
	}
	
}
