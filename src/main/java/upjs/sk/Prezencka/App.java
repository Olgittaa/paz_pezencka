package upjs.sk.Prezencka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import upjs.sk.Prezencka.gui.MainController;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainController controller=new MainController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		fxmlLoader.setController(controller);
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}