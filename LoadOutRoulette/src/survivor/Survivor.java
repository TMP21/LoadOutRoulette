package survivor;

import java.util.LinkedList;

public class Survivor {

	private static int ini = 0;
	private String[] usePerkList = new String[4];
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<String> perkList = new LinkedList<String>();
	private static LinkedList<String> survList = new LinkedList<String>();

	protected Survivor() {
		iniStuff();
		randomSurvivorPerks();
	}

	private String[] randomSurvivorPerks() {

		for (int i = 0; i < 4; i++) {
			int j = (int) (Math.random() * perkList.size());
			if (usedInt.contains(j)) {
				usePerkList[i] = "No Perk";
			} else {
				usePerkList[i] = perkList.get(j);
				usedInt.add(j);
			}
		}

		return usePerkList;
	}

	public String ToString() {
		String perks = "";
		for (int i = 0; i < 4; i++) {
			perks = perks + (i + 1) + ". Perk = " + usePerkList[i] + "\n";
		}
		return perks;
	}

	public void addPerk(String p) {
		perkList.add(p);
	}

	public void deletePerk(String p) {
		perkList.remove(p);
	}

	public void updatePerk(String old, String updatet) {
		perkList.remove(old);
		perkList.add(updatet);
	}

	private void iniStuff() {
		if (ini != 1) {
			iniPerk();
			iniSurv();
			ini = 1;
		}
	}
	
	private void iniSurv() {
		survList.add("Dwight Fairfield");
		survList.add("Meg Thomas");
		survList.add("Claudette Morel");
		survList.add("Jake Park");
		survList.add("Nea Karlsson");
		survList.add("Laurie Strode");
		survList.add("Ace Visconti");
		survList.add("William \"Bill\" Overbeck");
		survList.add("Feng Min");
		survList.add("David King");
		survList.add("Quentin Smith");
		survList.add("David Tapp");
		survList.add("Kate Denson");
		survList.add("Adam Francis");
		survList.add("Jeffrey \"Jeff\" Johansen");
		survList.add("Jane Romero");
		survList.add("Ashley \"Ash\" Williams");
		survList.add("Nancy Wheeler");
		survList.add("Steve Harrington");
		survList.add("Yui Kimura");
		survList.add("Zarina Kassir");
		survList.add("Cheryl Mason");
	}

	private void iniPerk() {
		perkList.add("Ace in the Hole");
		perkList.add("Adrenaline");
		perkList.add("Aftercare");
		perkList.add("Alert");
		perkList.add("Any Means Necessary");
		perkList.add("Autodidact");
		perkList.add("Babysitter");
		perkList.add("Balanced Landing");
		perkList.add("Better Together");
		perkList.add("Blood Pact");
		perkList.add("Boil Over");
		perkList.add("Bond");
		perkList.add("Borrowed Time");
		perkList.add("Botany Knowledge");
		perkList.add("Breakdown");
		perkList.add("Breakout");
		perkList.add("Buckle Up");
		perkList.add("Calm Spirit");
		perkList.add("Camaraderie");
		perkList.add("Dance With Me");
		perkList.add("Dark Sense");
		perkList.add("Dead Hard");
		perkList.add("Decisive Strike");
		perkList.add("Déjà Vu");
		perkList.add("Deliverance");
		perkList.add("Detective's Hunch");
		perkList.add("Distortion");
		perkList.add("Diversion");
		perkList.add("Empathy");
		perkList.add("Fixated");
		perkList.add("Flip-Flop");
		perkList.add("For the People");
		perkList.add("Head On");
		perkList.add("Hope");
		perkList.add("Inner Strength");
		perkList.add("Iron Will");
		perkList.add("Kindred");
		perkList.add("Leader");
		perkList.add("Left Behind");
		perkList.add("Lightweight");
		perkList.add("Lithe");
		perkList.add("Lucky Break");
		perkList.add("Mettle of Man");
		perkList.add("No Mither");
		perkList.add("No One Left Behind");
		perkList.add("Object of Obsession");
		perkList.add("Off the Record");
		perkList.add("Open-Handed");
		perkList.add("Pharmacy");
		perkList.add("Plunderer's Instinct");
		perkList.add("Poised");
		perkList.add("Premonition");
		perkList.add("Prove Thyself");
		perkList.add("Quick & Quiet");
		perkList.add("Red Herring");
		perkList.add("Repressed Alliance");
		perkList.add("Resilience");
		perkList.add("Saboteur");
		perkList.add("Second Wind");
		perkList.add("Self-Care");
		perkList.add("Slippery Meat");
		perkList.add("Small Game");
		perkList.add("Sole Survivor");
		perkList.add("Solidarity");
		perkList.add("Soul Guard");
		perkList.add("Spine Chill");
		perkList.add("Sprint Burst");
		perkList.add("Stake Out");
		perkList.add("Streetwise");
		perkList.add("This Is Not Happening");
		perkList.add("Technician");
		perkList.add("Tenacity");
		perkList.add("Up the Ante");
		perkList.add("Unbreakable");
		perkList.add("Urban Evasion");
		perkList.add("Vigil");
		perkList.add("Wake Up!");
		perkList.add("We'll Make It");
		perkList.add("We're Gonna Live Forever");
		perkList.add("Windows of Opportunity");
	}

}
