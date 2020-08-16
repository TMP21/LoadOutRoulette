package killer;

import java.util.LinkedList;

public class Killer {
	
	private static String killerName;
	private static LinkedList<String> usePerkList = new LinkedList<String>();
	private static LinkedList<String> useAddOnList = new LinkedList<String>();
	private static LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<Integer> usedIntAddOn = new LinkedList<Integer>();
	public static LinkedList<String> killerList = new LinkedList<String>();
	public static LinkedList<String> perkList = new LinkedList<String>();
	public static LinkedList<String> addOnList = new LinkedList<String>();
	
	public Killer() {
//		killerName = killerList.get((int) (Math.random() * killerList.size()));
		killerName = "Trapper";
		randomKillerAddOn();
		randomKillerPerks();
	}
	
	private void randomKillerPerks() {		
		for (int i = 0; i < 4; i++) {
			int j = (int) (Math.random() * perkList.size());
			if (usedInt.contains(j)) {
				usePerkList.add("No Perk");
			} else {
				usePerkList.add(perkList.get(j));
				usedInt.add(j);
			}
		}
	}
	
	private void randomKillerAddOn() {		
		for (int i = 0; i < 2; i++) {
			int j = (int) (Math.random() * addOnList.size());
			if (usedIntAddOn.contains(j)) {
				useAddOnList.add("No Add-On");
			} else {
				useAddOnList.add(addOnList.get(j));
				usedIntAddOn.add(j);
			}
		}
	}
	
	public String ToString() {			//Bearbeiten!!
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
	
	public static String getName() {
		return killerName;
	}

	public static String getPerk(int i) {
		return usePerkList.get(i);
	}
	
	public static String getAddOn(int i) {
		return useAddOnList.get(i);
	}

}
