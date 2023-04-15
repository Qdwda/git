import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        MenuBar menuBar = new MenuBar();
        Menu gitMenu = new Menu("Git");
        MenuItem cleanMenuItem = new MenuItem("Clean");
        cleanMenuItem.setOnAction(event -> showGitCleanDialog(primaryStage));
        gitMenu.getItems().add(cleanMenuItem);
        menuBar.getMenus().add(gitMenu);
        root.getChildren().addAll(menuBar);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showGitCleanDialog(Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GitCleanDialog.fxml"));
            Parent root = loader.load();
            GitCleanController controller = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(root));
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
