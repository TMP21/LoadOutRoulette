import javafx.application.Application;
import killer.Killer;
import survivor.Survivor;
import Persistant.*;

public class RouletteMain {

	public static void main(String[] args) throws Exception {
		new Persistant();
		
		Survivor s = new Survivor();
		String str = s.getClass().getSimpleName();
		Persistant.save(s.survList, s.perkList, s.getClass().getSimpleName());
		
		Killer k  = new Killer();
		String strk = k.getClass().getSimpleName();
		Persistant.save(k.killerList, k.perkList, k.getClass().getSimpleName());
		
		Application.launch(GUI.class, args);
		
	}

}
