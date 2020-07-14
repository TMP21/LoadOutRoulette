import killer.*;

public class RouletteMain {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			Wraith k = new Wraith();
			System.out.println(k.ToString());
			k = null;
		}
	}

}
