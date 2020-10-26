import javafx.application.Application;
import killer.Killer;
import survivor.Survivor;
import Persistant.*;

public class RouletteMain {

	public static void main(String[] args) throws Exception {
		new Persistant();
		Application.launch(GUI.class, args);
		
	}

}
