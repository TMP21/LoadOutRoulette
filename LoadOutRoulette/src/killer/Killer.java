package killer;

import java.util.LinkedList;

public class Killer {
	
	private String killerName;
	private LinkedList<String> usePerkList = new LinkedList<String>();
	private LinkedList<String> useAddOnList = new LinkedList<String>();
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	public static LinkedList<String> killerList = new LinkedList<String>();
	public static LinkedList<String> perkList = new LinkedList<String>();
	public static LinkedList<String> addOnList = new LinkedList<String>();
	
	public Killer() {
		killerName = killerList.get((int) (Math.random() * killerList.size()));
		randomKillerPerks();
	}
	
	private LinkedList<String> randomKillerPerks() {		
		for (int i = 0; i < 4; i++) {
			int j = (int) (Math.random() * perkList.size());
			if (usedInt.contains(j)) {
				usePerkList.add("No Perk");
			} else {
				usePerkList.add(perkList.get(j));
				usedInt.add(j);
			}
		}			
		return usePerkList;
	}
	
	public String ToString() {
		String perks  = "";
		for (int i = 0; i < 4; i++) {
			perks=perks + (i+1) + ". Perk = " + usePerkList.get(i) + "\n"; 
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
	
	public String getName() {
		return killerName;
	}

	public String getPerk(int i) {
		return usePerkList.get(i);
	}

}
