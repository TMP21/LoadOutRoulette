import killer.*;

public class RouletteMain {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			Trapper t = new Trapper();
			System.out.println(t.ToString());
			t = null;
		}
	}

}
