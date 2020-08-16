import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import survivor.*;
import killer.*;

public class RouletteMain extends Application {

	private double fontSize = 30;
	private String fontName = "HoloLens MDL2 Assets";
	private String windowTitle = "Load-Out Roulette";

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < Font.getFontNames().size(); i++) {
			System.out.println(Font.getFontNames().get(i));
		}
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		GridPane gp = new GridPane();
		Survivor surv = new Survivor();

		Label name = new Label(surv.getName());
		name.setFont(new Font(fontName, fontSize));
		Image charPortirat = new Image(
				new FileInputStream(".\\Icons\\CharPortraits\\" + surv.getName().replace("\"", "") + ".png"));
		ImageView charView = new ImageView(charPortirat);
		gp.add(charView, 0, 0);
		gp.add(name, 0, 1);

		for (int i = 0; i < 4; i++) {
			Label perkName = new Label(surv.getPerk(i));
			Image perkIcon = new Image(
					new FileInputStream(".\\Icons\\Icons\\Survivor\\Perks\\" + surv.getPerk(i) + ".png"));
			ImageView perkView = new ImageView(perkIcon);

			perkView.setFitHeight(200);
			perkView.setFitWidth(200);
			perkView.setPreserveRatio(true);

			gp.add(perkName, 1, i);
			gp.add(perkView, 2, i);
		}

		Scene szene = new Scene(gp);
		stage.setTitle(windowTitle);
		stage.setScene(szene);

		stage.show();
		surv.safe();
	}

}
