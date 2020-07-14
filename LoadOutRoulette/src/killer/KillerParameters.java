package killer;

import java.util.LinkedList;

public class KillerParameters {
	
	private static int ini = 0;
	private String [] usePerkList = new String[4];
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<String> perkList = new LinkedList<String>();
	
	protected KillerParameters() {
		iniPerk();
		randomKillerPerks();
	}
	
	private String[] randomKillerPerks() {
		
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
		String perks  = "";
		for (int i = 0; i < 4; i++) {
			perks=perks + (i+1) + ". Perk = " + usePerkList[i] + "\n"; 
		}
		return perks;
	}
	
	private void iniPerk() {
		if(ini!=1) {
			perkList.add("A Nurse's Calling");
			perkList.add("Agitation");
			perkList.add("Bamboozle");
			perkList.add("Barbecue & Chilli");
			perkList.add("Beast of Prey");
			perkList.add("Bitter Murmur");
			perkList.add("Blood Echo");
			perkList.add("Blood Warden");
			perkList.add("Bloodhound");
			perkList.add("Brutal Strength");
			perkList.add("Corrupt Intervention");
			perkList.add("Coulrophobia");
			perkList.add("Cruel Limits");
			perkList.add("Dark Devotion");
			perkList.add("Dead Man's Switch");
			perkList.add("Deathbound");
			perkList.add("Deerstalker");
			perkList.add("Discordance");
			perkList.add("Distressing");
			perkList.add("Dying Light");
			perkList.add("Enduring");
			perkList.add("Fire Up");
			perkList.add("Forced Penance");
			perkList.add("Franklin's Demise");
			perkList.add("Furtive Chase");
			perkList.add("Gearhead");
			perkList.add("Hangman's Trick");
			perkList.add("Hex: Devour Hope");
			perkList.add("Hex: Haunted Ground");
			perkList.add("Hex: Huntress Lullaby");
			ini=1;
		}		
	}

}
