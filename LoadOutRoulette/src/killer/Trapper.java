package killer;

import java.util.LinkedList;

public class Trapper extends KillerParameters {

	private static int ini = 0;
	private static String name = "Trapper";
	private static String[] useAddOnList = new String[2];
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<String> addOnList = new LinkedList<String>();

	public Trapper() {
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
		return ("Name: " + name + "\n" + "\n1. Add-On: " + useAddOnList[0] + "\n2. Add-On: " + useAddOnList[1] + "\n\n"
				+ super.ToString());
	}
	
	public void addAddOn(String a) {
		addOnList.add(a);
	}
	
	public void deletePerk(String a) {
		addOnList.remove(a);
	}
	
	public void addOnList(String old, String updatet) {
		addOnList.remove(old);
		addOnList.add(updatet);
	}

	private void iniAddOn() {
		if (ini != 1) {
			addOnList.add("Trapper Sack");
			addOnList.add("Trapper Gloves");
			addOnList.add("Strong Coil Spring");
			addOnList.add("Trapper Bag");
			addOnList.add("Padded Jaws");
			addOnList.add("Trap Setters");
			addOnList.add("Serrated Jaws");
			addOnList.add("Logwood Dye");
			addOnList.add("4-Coil Spring Kit");
			addOnList.add("Wax Brick");
			addOnList.add("Tar Bottle");
			addOnList.add("Setting Tools");
			addOnList.add("Secondary Coil");
			addOnList.add("Rusted Jaws");
			addOnList.add("Stitched Bag");
			addOnList.add("Oily Coil");
			addOnList.add("Honing Stone");
			addOnList.add("Fastening Tools");
			addOnList.add("Iridescent Stone");
			addOnList.add("Bloody Coil");
			ini = 1;
		}
	}

}