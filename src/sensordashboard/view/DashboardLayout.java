package sensordashboard.view;
//Layout-panes
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

//Kontroller
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ProgressBar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.List;

public class DashboardLayout{
    
    private final BorderPane root = new BorderPane();

    public DashboardLayout(List<Sensor> sensors) {
        Label title = new Label("Sensor Monitor Dashboard");
        root.setTop(title);
        root.setPadding(new Insets(20));

        

    }

    public borderPane getRoot() {
        return root;
    }



}
