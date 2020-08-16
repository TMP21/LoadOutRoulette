import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import survivor.Survivor;

public class GUI extends Application{

	private double fontSize = 30;
	private double vGap = 1;
	private double hGap = 50;
	private int charSizeH = 300;
	private int charSizeW = 300;
	private int iconSize = 180;
	private String fontName = "Arial Bold";
	private String windowTitle = "Load-Out Roulette";
	
	
	public GUI() {
		
	}
	
	
//	@Override
//	public void start(Stage stage) throws Exception {
//
//		GridPane gp = new GridPane();
//		Button killerWish = new Button("Killer");
//		Button survivorWish = new Button("Survivor");
//		
//		gp.add(killerWish, 0,1);
//		gp.add(survivorWish, 2,1);
//		
//		Scene szene = new Scene(gp);
//		stage.setTitle(windowTitle);
//		stage.getIcons().add(new Image(new FileInputStream(".\\Icons\\Tech\\window.png")));
//		stage.setScene(szene);
//		stage.show();
//
//	}
	
	
	@Override
	public void start(Stage stage) throws Exception {

		GridPane gp = new GridPane();
		
		HBox hb = new HBox();
		gp.setHgap(hGap);
		gp.setVgap(vGap);
		Survivor surv = new Survivor();
	
		Label name = new Label(surv.getName());
		name.setFont(new Font(fontName, fontSize));
		Image charPortirat = new Image(new FileInputStream(".\\Icons\\CharPortraits\\" + surv.getName().replace("\"", "") + ".png"));
		ImageView charView = new ImageView(charPortirat);
		charView.setFitHeight(charSizeH);
		charView.setFitWidth(charSizeW);
		charView.setPreserveRatio(true);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().add(name);
		gp.add(charView, 0, 0, 2, 2);
		gp.add(hb, 0, 2);
		
	
		for (int i = 0; i < 4; i++) {
			Label perkName = new Label(surv.getPerk(i));
			perkName.setFont(new Font(fontName, fontSize));
			Image perkIcon = new Image(new FileInputStream(".\\Icons\\Icons\\Survivor\\Perks\\" + surv.getPerk(i) + ".png"));
			ImageView perkView = new ImageView(perkIcon);
	
			perkView.setFitHeight(iconSize);
			perkView.setFitWidth(iconSize);
			perkView.setPreserveRatio(true);
	
			gp.add(perkName, 2, i);
			gp.add(perkView, 3, i);
		}
		
		Scene szene = new Scene(gp);
		stage.setTitle(windowTitle);
		stage.getIcons().add(new Image(new FileInputStream(".\\Icons\\Tech\\window.png")));
		stage.setScene(szene);
		stage.show();

	}
}
