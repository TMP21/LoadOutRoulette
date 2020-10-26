package survivor;

import java.util.LinkedList;

public class Survivor {

	private String survivorName;
	private static LinkedList<String> usePerkList = new LinkedList<String>();
	private static LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<String> perkList = new LinkedList<String>();
	private static LinkedList<String> survList = new LinkedList<String>();

	public Survivor() {
		survivorName = survList.get((int) (Math.random() * survList.size()));
		randomSurvivorPerks();
	}

	private void randomSurvivorPerks() {
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

	public String ToString() {
		String Info = "Your Survivor is: " + survivorName;
		for (int i = 0; i < 4; i++) {
			Info = Info + (i + 1) + ". Perk = " + usePerkList.get(i);
		}
		return Info;
	}

	public static void addPerk(String p) {
		perkList.add(p);
	}

	public static void deletePerk(String p) {
		perkList.remove(p);
	}

	public static void updatePerk(String old, String updatet) {
		perkList.remove(old);
		perkList.add(updatet);
	}
	
	public static void addName(String n) {
		survList.add(n);
	}

	public static void deleteName(String n) {
		survList.remove(n);
	}

	public static void updateName(String old, String updatet) {
		survList.remove(old);
		survList.add(updatet);
	}
	
	public String getName() {
		return survivorName;
	}

	public String getPerk(int i) {
		return usePerkList.get(i);
	}

}