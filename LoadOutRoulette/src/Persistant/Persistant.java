package Persistant;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import killer.Killer;
import survivor.Survivor;

public class Persistant {

	public Persistant() {
		readOut("Survivor");
		readOut("Killer");
	}

	public static void save(LinkedList<String> nameList, LinkedList<String> perkList, String c) {
		File nameFile = new File(".\\Strings\\" + c + "\\Name.txt");
		File perkFile = new File(".\\Strings\\" + c + "\\Perk.txt");

		try (FileWriter fw = new FileWriter(nameFile)) {
			Collections.sort(nameList);
			for (String str : nameList) {
				fw.write((str + "\n").toCharArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (FileWriter fw = new FileWriter(perkFile)) {
			Collections.sort(perkList);
			for (String str : perkList) {
				if (!str.equals("No Perk")) {
					fw.write((str + "\n").toCharArray());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void readOut(String c) {
		File nameFile = new File(".\\Strings\\" + c + "\\Name.txt");
		File perkFile = new File(".\\Strings\\" + c + "\\Perk.txt");

		try {
			if (c.equals("Survivor")) {
				Scanner nsc = new Scanner(nameFile);
				while (nsc.hasNextLine()) {
					Survivor.addName(nsc.nextLine());
				}
				
				Scanner psc = new Scanner(perkFile);
				while (psc.hasNextLine()) {
					Survivor.addPerk(psc.nextLine());
				}
				
			} else {
				Scanner sc = new Scanner(nameFile);
				while (sc.hasNextLine()) {
					Killer.killerList.add(sc.nextLine());
				}
				
				Scanner psc = new Scanner(perkFile);
				while (psc.hasNextLine()) {
					Killer.perkList.add(psc.nextLine());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static void readOutAddOn(String k) {
		File addOnFile = new File(".\\Strings\\Killer\\Add-On-" + k + ".txt");
		Killer.addOnList.clear();
		try {
				Scanner sc = new Scanner(addOnFile);
				while (sc.hasNextLine()) {
					Killer.addOnList.add(sc.nextLine());
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void iniSurv() {
//	survList.add("Dwight Fairfield");
//	survList.add("Meg Thomas");
//	survList.add("Claudette Morel");
//	survList.add("Jake Park");
//	survList.add("Nea Karlsson");
//	survList.add("Laurie Strode");
//	survList.add("Ace Visconti");
//	survList.add("William \"Bill\" Overbeck");
//	survList.add("Feng Min");
//	survList.add("David King");
//	survList.add("Quentin Smith");
//	survList.add("David Tapp");
//	survList.add("Kate Denson");
//	survList.add("Adam Francis");
//	survList.add("Jeffrey \"Jeff\" Johansen");
//	survList.add("Jane Romero");
//	survList.add("Ashley \"Ash\" Williams");
//	survList.add("Nancy Wheeler");
//	survList.add("Steve Harrington");
//	survList.add("Yui Kimura");
//	survList.add("Zarina Kassir");
//	survList.add("Cheryl Mason");
//}
//
//private void iniPerk() {
//	perkList.add("Ace in the Hole\n");
//	perkList.add("Adrenaline\n");
//	perkList.add("Aftercare\n");
//	perkList.add("Alert\n");
//	perkList.add("Any Means Necessary\n");
//	perkList.add("Autodidact\n");
//	perkList.add("Babysitter\n");
//	perkList.add("Balanced Landing\n");
//	perkList.add("Better Together\n");
//	perkList.add("Blood Pact\n");
//	perkList.add("Boil Over\n");
//	perkList.add("Bond\n");
//	perkList.add("Borrowed Time\n");
//	perkList.add("Botany Knowledge\n");
//	perkList.add("Breakdown\n");
//	perkList.add("Breakout\n");
//	perkList.add("Buckle Up\n");
//	perkList.add("Calm Spirit\n");
//	perkList.add("Camaraderie\n");
//	perkList.add("Dance With Me\n");
//	perkList.add("Dark Sense\n");
//	perkList.add("Dead Hard\n");
//	perkList.add("Decisive Strike\n");
//	perkList.add("Déjà Vu\n");
//	perkList.add("Deliverance\n");
//	perkList.add("Detective's Hunch\n");
//	perkList.add("Distortion\n");
//	perkList.add("Diversion\n");
//	perkList.add("Empathy\n");
//	perkList.add("Fixated\n");
//	perkList.add("Flip-Flop\n");
//	perkList.add("For the People\n");
//	perkList.add("Head On\n");
//	perkList.add("Hope\n");
//	perkList.add("Inner Strength\n");
//	perkList.add("Iron Will\n");
//	perkList.add("Kindred\n");
//	perkList.add("Leader\n");
//	perkList.add("Left Behind\n");
//	perkList.add("Lightweight\n");
//	perkList.add("Lithe\n");
//	perkList.add("Lucky Break\n");
//	perkList.add("Mettle of Man\n");
//	perkList.add("No Mither\n");
//	perkList.add("No One Left Behind\n");
//	perkList.add("Object of Obsession\n");
//	perkList.add("Off the Record\n");
//	perkList.add("Open-Handed\n");
//	perkList.add("Pharmacy\n");
//	perkList.add("Plunderer's Instinct\n");
//	perkList.add("Poised\n");
//	perkList.add("Premonition\n");
//	perkList.add("Prove Thyself\n");
//	perkList.add("Quick & Quiet\n");
//	perkList.add("Red Herring\n");
//	perkList.add("Repressed Alliance\n");
//	perkList.add("Resilience\n");
//	perkList.add("Saboteur\n");
//	perkList.add("Second Wind\n");
//	perkList.add("Self-Care\n");
//	perkList.add("Slippery Meat\n");
//	perkList.add("Small Game\n");
//	perkList.add("Sole Survivor\n");
//	perkList.add("Solidarity\n");
//	perkList.add("Soul Guard\n");
//	perkList.add("Spine Chill\n");
//	perkList.add("Sprint Burst\n");
//	perkList.add("Stake Out\n");
//	perkList.add("Streetwise\n");
//	perkList.add("This Is Not Happening\n");
//	perkList.add("Technician\n");
//	perkList.add("Tenacity\n");
//	perkList.add("Up the Ante\n");
//	perkList.add("Unbreakable\n");
//	perkList.add("Urban Evasion\n");
//	perkList.add("Vigil\n");
//	perkList.add("Wake Up!\n");
//	perkList.add("We'll Make It\n");
//	perkList.add("We're Gonna Live Forever\n");
//	perkList.add("Windows of Opportunity\n");
//}


//	private void iniPerk() {
//		if(ini!=1) {
//			perkList.add("A Nurse's Calling");
//			perkList.add("Agitation");
//			perkList.add("Bamboozle");
//			perkList.add("Barbecue & Chilli");
//			perkList.add("Beast of Prey");
//			perkList.add("Bitter Murmur");
//			perkList.add("Blood Echo");
//			perkList.add("Blood Warden");
//			perkList.add("Bloodhound");
//			perkList.add("Brutal Strength");
//			perkList.add("Corrupt Intervention");
//			perkList.add("Coulrophobia");
//			perkList.add("Cruel Limits");
//			perkList.add("Dark Devotion");
//			perkList.add("Dead Man's Switch");
//			perkList.add("Deathbound");
//			perkList.add("Deerstalker");
//			perkList.add("Discordance");
//			perkList.add("Distressing");
//			perkList.add("Dying Light");
//			perkList.add("Enduring");
//			perkList.add("Fire Up");
//			perkList.add("Forced Penance");
//			perkList.add("Franklin's Demise");
//			perkList.add("Furtive Chase");
//			perkList.add("Gearhead");
//			perkList.add("Hangman's Trick");
//			perkList.add("Hex: Devour Hope");
//			perkList.add("Hex: Haunted Ground");
//			perkList.add("Hex: Huntress Lullaby");
//			perkList.add("Hex: No One Escapes Death");
//			perkList.add("Hex: Retribution");
//			perkList.add("Hex: Ruin");
//			perkList.add("Hex: The Third Seal");
//			perkList.add("Hex: Thrill of the Hunt");
//			perkList.add("I'm All Ears");
//			perkList.add("Infectious Fright");
//			perkList.add("Insidious");
//			perkList.add("Iron Grasp");
//			perkList.add("Iron Maiden");
//			perkList.add("Knock Out");
//			perkList.add("Lightborn");
//			perkList.add("Mad Grit");
//			perkList.add("Make Your Choice");
//			perkList.add("Mindbreaker");
//			perkList.add("Monitor & Abuse");
//			perkList.add("Monstrous Shrine");
//			perkList.add("Nemesis");
//			perkList.add("Overcharge");
//			perkList.add("Overwhelming Presence");
//			perkList.add("Play with Your Food");
//			perkList.add("Pop Goes the Weasel");
//			perkList.add("Predator");
//			perkList.add("Rancor");
//			perkList.add("Remember Me");
//			perkList.add("Save the Best for Last");
//			perkList.add("Shadowborn");
//			perkList.add("Sloppy Butcher");
//			perkList.add("Spies from the Shadows");
//			perkList.add("Spirit Fury");
//			perkList.add("Stridor");
//			perkList.add("Surge");
//			perkList.add("Surveillance");
//			perkList.add("Territorial Imperative");
//			perkList.add("Tinkerer");
//			perkList.add("Thanatophobia");
//			perkList.add("Thrilling Tremors");
//			perkList.add("Trail of Torment");
//			perkList.add("Unnerving Presence");
//			perkList.add("Unrelenting");
//			perkList.add("Whispers");
//			perkList.add("Zanshin Tactics");
//			ini=1;
//		}		
//	}
}
