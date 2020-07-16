package killer;

import java.util.LinkedList;

public class Wraith extends Killer {

	private static int ini = 0;
	private static String name = "Wraith";
	private static String[] useAddOnList = new String[2];
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	public static LinkedList<String> addOnList = new LinkedList<String>();

	public Wraith() {
		super();
		iniAddOn();
		randomKillerAddOn();
	}

	private String[] randomKillerAddOn() {

		for (int i = 0; i < 2; i++) {
			int j = (int) (Math.random() * addOnList.size());
			if (usedInt.contains(j)) {
				useAddOnList[i] = "No Add-On";
			} else {
				useAddOnList[i] = addOnList.get(j);
				usedInt.add(j);
			}
		}

		return useAddOnList;
	}

	public String ToString() {
		return ("Name: " + name +"\n" + "\n1. Add-On: " + useAddOnList[0] + "\n2. Add-On: " + useAddOnList[1] + "\n\n"
				+ super.ToString());
	}

	private void iniAddOn() {
		if (ini != 1) {
			addOnList.add("\"The Serpent\" - Soot");
			addOnList.add("\"The Hound\" - Soot");
			addOnList.add("\"The Ghost\" - Soot");
			addOnList.add("\"The Beast\" - Soot");
			addOnList.add("Bone Clapper");
			addOnList.add("\"Blink\" - Mud");
			addOnList.add("\"Windstorm\" - Mud");
			addOnList.add("\"Swift Hunt\" - Mud");
			addOnList.add("\"Blind Warrior\" - Mud");
			addOnList.add("\"Windstorm\" - White");
			addOnList.add("\"Swift Hunt\" - White");
			addOnList.add("\"Shadow Dance\" - White");
			addOnList.add("\"Blink\" - White");
			addOnList.add("\"Blind Warrior\" - White");
			addOnList.add("\"Windstorm\" - Blood");
			addOnList.add("\"Swift Hunt\" - Blood");
			addOnList.add("\"Shadow Dance\" - Blood");
			addOnList.add("\"All Seeing\" - Blood");
			addOnList.add("Coxcombed Clapper");
			addOnList.add("\"All Seeing\" - Spirit");
			ini = 1;
		}
	}

}
