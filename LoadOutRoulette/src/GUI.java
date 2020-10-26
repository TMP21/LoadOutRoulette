import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import killer.Killer;
import survivor.Survivor;

public class GUI extends Application {

	private double fontSize = 30;
	private double vGap = 1;
	private double hGap = 50;
	private int charSizeH = 300;
	private int charSizeW = 300;
	private int iconSize = 180;
	private int addOnSize = 100;
	private double yValue = Screen.getPrimary().getVisualBounds().getHeight()/7;
	private double xValue = Screen.getPrimary().getVisualBounds().getWidth()/2.5;
	private double hight = Screen.getPrimary().getVisualBounds().getHeight()/2;
	private double width = Screen.getPrimary().getVisualBounds().getWidth()/2;
	private String fontName = "Arial Bold";
	private String windowTitle = "Load-Out Roulette";

	public GUI() {

	}

	@Override
	public void start(Stage stage) throws Exception {
		mainMenu(stage);
	}

	public void mainMenu(Stage stage) throws Exception {
		
		Button kButton = new Button("Radomize Killer");
		Button sButton = new Button("Randomize Survivor");
		GridPane gp = new GridPane();
		MenuBar mb = menuBar();		
		gp.add(mb, 0,0);
		Scene szene = new Scene(gp);
		
		sButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					survivor(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		kButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					killer(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		
		gp.add(sButton, 1, 1);
		gp.add(kButton, 2, 1);
		
		stage.setX(xValue);
		stage.setX(yValue);
		stage.setMinHeight(hight);
		stage.setMinWidth(width);
		stage.setResizable(true);
		stage.setTitle(windowTitle);
		stage.getIcons().add(new Image(new FileInputStream(".\\Icons\\Tech\\window.png")));
		stage.setScene(szene);
		stage.show();		
	}
	
	public MenuBar menuBar() {
		MenuBar mb = new MenuBar();
		Menu add = new Menu("Add");
		Menu del = new Menu("Delete");
		MenuItem kPerkAdd = new MenuItem("Add A Killer Perk");
		MenuItem sPerkAdd = new MenuItem("Add A Survivor Perk");
		MenuItem kAddOnAdd = new MenuItem("Add A Killer Add-On");
		MenuItem iAdd = new MenuItem("Add An Item");
		MenuItem kPerkDel = new MenuItem("Delete A Killer Perk");
		MenuItem sPerkDel= new MenuItem("Delete A Survivor Perk");
		add.getItems().addAll(kPerkAdd, kAddOnAdd, iAdd, sPerkAdd, new SeparatorMenuItem());
		del.getItems().addAll(kPerkDel, sPerkDel,new SeparatorMenuItem());
		mb.getMenus().addAll(add,del);
		return mb;
	}

	public void survivor(Stage stage) throws Exception {

		GridPane gp = new GridPane();

		HBox hb = new HBox();
		gp.setHgap(hGap);
		gp.setVgap(vGap);
		Survivor surv = new Survivor();

		Label name = new Label(surv.getName());
		name.setFont(new Font(fontName, fontSize));
		Image charPortirat = new Image(
				new FileInputStream(".\\Icons\\CharPortraits\\" + surv.getName().replace("\"", "") + ".png"));
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
			Image perkIcon = new Image(
					new FileInputStream(".\\Icons\\Icons\\Survivor\\Perks\\" + surv.getPerk(i) + ".png"));
			ImageView perkView = new ImageView(perkIcon);

			perkView.setFitHeight(iconSize);
			perkView.setFitWidth(iconSize);
			perkView.setPreserveRatio(true);

			gp.add(perkName, 2, i);
			gp.add(perkView, 3, i);
		}
		
		Button back = new Button("Go Back");

		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					mainMenu(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		gp.add(back, 2, 7);

		Scene szene = new Scene(gp);
		stage.setScene(szene);
		stage.show();
	}

	public void killer(Stage stage) throws Exception {

		GridPane gp = new GridPane();

		HBox hb = new HBox();
		gp.setHgap(hGap);
		gp.setVgap(vGap);
		Killer killer = new Killer();

		Label name = new Label(Killer.getName());
		name.setFont(new Font(fontName, fontSize));
		Image charPortirat = new Image(new FileInputStream(".\\Icons\\CharPortraits\\" + Killer.getName() + ".png"));
		ImageView charView = new ImageView(charPortirat);
		charView.setFitHeight(charSizeH);
		charView.setFitWidth(charSizeW);
		charView.setPreserveRatio(true);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().add(name);
		gp.add(charView, 0, 0, 2, 2);
		gp.add(hb, 0, 2);

		for (int i = 0; i < 4; i++) {
			Label perkName = new Label(killer.getPerk(i));
			perkName.setFont(new Font(fontName, fontSize));
			Image perkIcon = new Image(new FileInputStream(
					".\\Icons\\Icons\\Killer\\Perks\\" + (killer.getPerk(i).replace(":", "")) + ".png"));
			ImageView perkView = new ImageView(perkIcon);

			perkView.setFitHeight(iconSize);
			perkView.setFitWidth(iconSize);
			perkView.setPreserveRatio(true);

			gp.add(perkName, 3, i);
			gp.add(perkView, 4, i);
		}

		for (int i = 0; i < 2; i++) {
			Label addOnName = new Label(killer.getAddOn(i));
			addOnName.setFont(new Font(fontName, fontSize));
			Image addOnIcon = new Image(new FileInputStream(
					".\\Icons\\Icons\\Killer\\Add-On\\" + (killer.getAddOn(i).replace("\"", "")) + ".png"));
			ImageView addOnView = new ImageView(addOnIcon);

			addOnView.setFitHeight(addOnSize);
			addOnView.setFitWidth(addOnSize);
			addOnView.setPreserveRatio(true);

			gp.add(addOnName, 1, i + 2);
			gp.add(addOnView, 2, i + 2);
		}
		
		killer = null;
		
		Button back = new Button("Go Back");
		Button reroll = new Button("Reroll");

		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					mainMenu(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		reroll.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					killer(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		gp.add(back, 2, 7);
		gp.add(reroll, 3, 7);

		Scene szene = new Scene(gp);
		stage.setScene(szene);
		stage.show();
	}
}
