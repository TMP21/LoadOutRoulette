package survivor;

import java.util.LinkedList;

public class Survivor {

	private String survivorName;
	private LinkedList<String> usePerkList = new LinkedList<String>();
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	public static LinkedList<String> perkList = new LinkedList<String>();
	public static LinkedList<String> survList = new LinkedList<String>();

	public Survivor() {
		survivorName = survList.get((int) (Math.random() * survList.size()));
		randomSurvivorPerks();
	}

	private LinkedList<String> randomSurvivorPerks() {
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
		String Info = "Your Survivor is: " + survivorName;
		for (int i = 0; i < 4; i++) {
			Info = Info + (i + 1) + ". Perk = " + usePerkList.get(i);
		}
		return Info;
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
		return survivorName;
	}

	public String getPerk(int i) {
		return usePerkList.get(i);
	}

}