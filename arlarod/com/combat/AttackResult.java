package arlarod.com.combat;

public class AttackResult {
	
	private boolean hit = false, damage = false;
	private boolean failAgainstDefenseRoll = false, failAgainstEnduranceRoll = false;
	private String rollAgainstDefenseText, rollAgainstEnduranceText;
	private int rollAgainstDefenseTotal = 0, rollAgainstEnduranceTotal = 0;
	
	public AttackResult(boolean hit, boolean damage,
			boolean failAgainstDefenseRoll, boolean failAgainstEnduranceRoll,
			String rollAgainstDefenseText, String rollAgainstEnduranceText,
			int rollAgainstDefenseTotal, int rollAgainstEnduranceTotal) {
		super();
		this.hit = hit;
		this.damage = damage;
		this.failAgainstDefenseRoll = failAgainstDefenseRoll;
		this.failAgainstEnduranceRoll = failAgainstEnduranceRoll;
		this.rollAgainstDefenseText = rollAgainstDefenseText;
		this.rollAgainstEnduranceText = rollAgainstEnduranceText;
		this.rollAgainstDefenseTotal = rollAgainstDefenseTotal;
		this.rollAgainstEnduranceTotal = rollAgainstEnduranceTotal;
	}

	public boolean isHit() {
		return hit;
	}
	public boolean isDamage() {
		return damage;
	}
	public boolean isFailAgainstDefenseRoll() {
		return failAgainstDefenseRoll;
	}
	public boolean isFailAgainstEnduranceRoll() {
		return failAgainstEnduranceRoll;
	}
	public String getRollAgainstDefenseText() {
		return rollAgainstDefenseText;
	}
	public String getRollAgainstEnduranceText() {
		return rollAgainstEnduranceText;
	}
	public int getRollAgainstDefenseTotal() {
		return rollAgainstDefenseTotal;
	}
	public int getRollAgainstEnduranceTotal() {
		return rollAgainstEnduranceTotal;
	}
	
	@Override
	public String toString() {
		StringBuilder defenseResults = new StringBuilder(), enduranceResults = new StringBuilder();
		defenseResults.append("Defense --> " + (failAgainstDefenseRoll?"critFail!":"") + rollAgainstDefenseText);
		enduranceResults.append("Endurance --> " + (failAgainstDefenseRoll? "Not rolled" : (failAgainstEnduranceRoll?"critFail!":"") + (rollAgainstEnduranceText!=null&&rollAgainstEnduranceText.length()>0?rollAgainstEnduranceText:"Not rolled")));
		return "Attack results: " + defenseResults + "; " + enduranceResults;
	}

}
