package survivor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Survivor {

	private static int ini = 0;
	private File nameFile = new File(".\\Strings\\Survivor\\Name.txt");
	private File perkFile = new File(".\\Strings\\Survivor\\Perk.txt");
	private static String name;
	private String[] usePerkList = new String[4];
	private LinkedList<Integer> usedInt = new LinkedList<Integer>();
	private static LinkedList<String> perkList = new LinkedList<String>();
	private static LinkedList<String> survList = new LinkedList<String>();

	public Survivor() {
		iniStuff();
		name = survList.get((int) (Math.random() * survList.size()));
		randomSurvivorPerks();
	}

	private String[] randomSurvivorPerks() {

		for (int i = 0; i < 4; i++) {
			int j = (int) (Math.random() * perkList.size());
			if (usedInt.contains(j)) {
				usePerkList[i] = "No Perk\n";
			} else {
				usePerkList[i] = perkList.get(j);
				usedInt.add(j);
			}
		}
		return usePerkList;
	}

	public String ToString() {
		String Info = "Your Survivor is: " + name;
		for (int i = 0; i < 4; i++) {
			Info = Info + (i + 1) + ". Perk = " + usePerkList[i];
		}
		return Info;
	}

	public void addPerk(String p) {
		perkList.add(p);
	}
	
	public String getName() {
		return name;
	}
	
	public String getPerk(int i) {
		return usePerkList[i];
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
			readOut();
			ini = 1;
		}
	}

	public void safe() {
		try (FileWriter fw = new FileWriter(nameFile)) {
			Collections.sort(survList);
			for (int i = 0; i < survList.size(); i++) {
				fw.write((survList.get(i)+"\n").toCharArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileWriter fw = new FileWriter(perkFile)) {
			Collections.sort(perkList);
			for (int i = 0; i < perkList.size(); i++) {
				fw.write((perkList.get(i)+"\n").toCharArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void readOut() {		
		try {
			Scanner sc = new Scanner(nameFile);
			while (sc.hasNextLine()) {
				survList.add(sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Scanner sc = new Scanner(perkFile);
			while (sc.hasNextLine()) {
				perkList.add(sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	private void iniSurv() {
//		survList.add("Dwight Fairfield\n");
//		survList.add("Meg Thomas\n");
//		survList.add("Claudette Morel\n");
//		survList.add("Jake Park\n");
//		survList.add("Nea Karlsson\n");
//		survList.add("Laurie Strode\n");
//		survList.add("Ace Visconti\n");
//		survList.add("William \"Bill\" Overbeck\n");
//		survList.add("Feng Min\n");
//		survList.add("David King\n");
//		survList.add("Quentin Smith\n");
//		survList.add("David Tapp\n");
//		survList.add("Kate Denson\n");
//		survList.add("Adam Francis\n");
//		survList.add("Jeffrey \"Jeff\" Johansen\n");
//		survList.add("Jane Romero\n");
//		survList.add("Ashley \"Ash\" Williams\n");
//		survList.add("Nancy Wheeler\n");
//		survList.add("Steve Harrington\n");
//		survList.add("Yui Kimura\n");
//		survList.add("Zarina Kassir\n");
//		survList.add("Cheryl Mason\n");
//	}
//
//	private void iniPerk() {
//		perkList.add("Ace in the Hole\n");
//		perkList.add("Adrenaline\n");
//		perkList.add("Aftercare\n");
//		perkList.add("Alert\n");
//		perkList.add("Any Means Necessary\n");
//		perkList.add("Autodidact\n");
//		perkList.add("Babysitter\n");
//		perkList.add("Balanced Landing\n");
//		perkList.add("Better Together\n");
//		perkList.add("Blood Pact\n");
//		perkList.add("Boil Over\n");
//		perkList.add("Bond\n");
//		perkList.add("Borrowed Time\n");
//		perkList.add("Botany Knowledge\n");
//		perkList.add("Breakdown\n");
//		perkList.add("Breakout\n");
//		perkList.add("Buckle Up\n");
//		perkList.add("Calm Spirit\n");
//		perkList.add("Camaraderie\n");
//		perkList.add("Dance With Me\n");
//		perkList.add("Dark Sense\n");
//		perkList.add("Dead Hard\n");
//		perkList.add("Decisive Strike\n");
//		perkList.add("Déjà Vu\n");
//		perkList.add("Deliverance\n");
//		perkList.add("Detective's Hunch\n");
//		perkList.add("Distortion\n");
//		perkList.add("Diversion\n");
//		perkList.add("Empathy\n");
//		perkList.add("Fixated\n");
//		perkList.add("Flip-Flop\n");
//		perkList.add("For the People\n");
//		perkList.add("Head On\n");
//		perkList.add("Hope\n");
//		perkList.add("Inner Strength\n");
//		perkList.add("Iron Will\n");
//		perkList.add("Kindred\n");
//		perkList.add("Leader\n");
//		perkList.add("Left Behind\n");
//		perkList.add("Lightweight\n");
//		perkList.add("Lithe\n");
//		perkList.add("Lucky Break\n");
//		perkList.add("Mettle of Man\n");
//		perkList.add("No Mither\n");
//		perkList.add("No One Left Behind\n");
//		perkList.add("Object of Obsession\n");
//		perkList.add("Off the Record\n");
//		perkList.add("Open-Handed\n");
//		perkList.add("Pharmacy\n");
//		perkList.add("Plunderer's Instinct\n");
//		perkList.add("Poised\n");
//		perkList.add("Premonition\n");
//		perkList.add("Prove Thyself\n");
//		perkList.add("Quick & Quiet\n");
//		perkList.add("Red Herring\n");
//		perkList.add("Repressed Alliance\n");
//		perkList.add("Resilience\n");
//		perkList.add("Saboteur\n");
//		perkList.add("Second Wind\n");
//		perkList.add("Self-Care\n");
//		perkList.add("Slippery Meat\n");
//		perkList.add("Small Game\n");
//		perkList.add("Sole Survivor\n");
//		perkList.add("Solidarity\n");
//		perkList.add("Soul Guard\n");
//		perkList.add("Spine Chill\n");
//		perkList.add("Sprint Burst\n");
//		perkList.add("Stake Out\n");
//		perkList.add("Streetwise\n");
//		perkList.add("This Is Not Happening\n");
//		perkList.add("Technician\n");
//		perkList.add("Tenacity\n");
//		perkList.add("Up the Ante\n");
//		perkList.add("Unbreakable\n");
//		perkList.add("Urban Evasion\n");
//		perkList.add("Vigil\n");
//		perkList.add("Wake Up!\n");
//		perkList.add("We'll Make It\n");
//		perkList.add("We're Gonna Live Forever\n");
//		perkList.add("Windows of Opportunity\n");
//	}

}
